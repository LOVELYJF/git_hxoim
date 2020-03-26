package com.hxoim.full.search.utils;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.full.search.entity.PersonInfoIndex;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.util.ResourceUtils;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class IndexUtils {
    public static void main(String[] args) {
        new IndexUtils();
    }

    private static String baseDir = "E:/lucene";

    public IndexUtils() {
        try {
            File file = ResourceUtils.getFile("classpath:hx-lucene.properties");
            InputStream inputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(inputStream);
            String property = properties.getProperty("lucene.baseDir");
            if (StringUtils.isBlank(property)) {
                throw new ParameterNullException("请检查hx-lucene.properties中的配置参数");
            } else {
                baseDir = property;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 公共方法,获取indexWriter
     *
     * @author sunqian
     * @date 2019/11/7 11:06
     */
    private IndexWriter getIndexWriter(String tabCode) throws Exception {
        File file = new File(baseDir + File.separator + tabCode);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (!mkdirs) {
                throw new Exception("文件或者文件夹创建失败");
            }
        }
        IndexWriter indexWriter;
        Directory directory = FSDirectory.open(file);
        Analyzer analyzer = new IKAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_4_10_3, analyzer);
        indexWriter = new IndexWriter(directory, indexWriterConfig);
        return indexWriter;
    }

    /**
     * 删除索引
     *
     * @author sunqian
     * @date 2019/11/7 11:06
     */
    public void deleteIndex(String tabCode) {
        IndexWriter indexWriter = null;
        try {
            indexWriter = getIndexWriter(tabCode);
            if (indexWriter != null) {
                indexWriter.deleteAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (indexWriter != null) {
                    indexWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建索引
     *
     * @author sunqian
     * @date 2019/11/7 11:09
     */
    public void creatIndex(List<PersonInfoIndex> personInfoIndexList, String tabCode) {
        IndexWriter indexWriter = null;
        try {
            indexWriter = getIndexWriter(tabCode);
            if (personInfoIndexList == null || personInfoIndexList.isEmpty()) {
                return;
            }
            for (int i = 0; i < personInfoIndexList.size(); i++) {
                PersonInfoIndex personInfoIndex = personInfoIndexList.get(i);
                Document document = new Document();
                document.add(new StringField("personId", personInfoIndex.getPersonId(), Field.Store.YES));
                document.add(new TextField("content", personInfoIndex.getContent(), Field.Store.YES));
                document.add(new StringField("columnCode", personInfoIndex.getColumnCode(), Field.Store.YES));
                document.add(new StringField("description", personInfoIndex.getDescription(), Field.Store.YES));
                indexWriter.addDocument(document);
            }
            indexWriter.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (indexWriter != null) {
                    indexWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据关键词查询
     *
     * @author sunqian
     * @date 2019/11/7 11:09
     */
    public List<PersonInfoIndex> queryIndex(String keyword, String[] tableCodes) {
        List<PersonInfoIndex> list = new ArrayList<>();
        List<IndexReader> indexReaders = new ArrayList<>();
        if (tableCodes == null || tableCodes.length == 0) {
            return list;
        }
        MultiReader multiReader = null;
        IndexSearcher indexSearcher;
        try {
            for (int i = 0; i < tableCodes.length; i++) {
                String tableCode = tableCodes[i];
                IndexReader indexReader = getIndexReader(tableCode);
                if (indexReader != null) {
                    indexReaders.add(indexReader);
                }
            }
            multiReader = new MultiReader(indexReaders.toArray(new IndexReader[indexReaders.size()]));
            indexSearcher = new IndexSearcher(multiReader);

            String field = "content";
            IKAnalyzer analyzer = new IKAnalyzer();
            Query query = new QueryParser(field, analyzer).parse(keyword);

            //设置高亮
            QueryScorer scorer = new QueryScorer(query, field);
            SimpleHTMLFormatter fors = new SimpleHTMLFormatter("<span style=\"color:red;\">", "</span>");
            Highlighter highlighter = new Highlighter(fors, scorer);

            TopDocs search = indexSearcher.search(query, Integer.MAX_VALUE);
            ScoreDoc[] scoreDocs = search.scoreDocs;
            for (ScoreDoc scoreDoc : scoreDocs) {
                int doc = scoreDoc.doc;
                Document document = indexSearcher.doc(doc);
                TokenStream tokenStream = TokenSources.getAnyTokenStream(indexSearcher.getIndexReader(), doc, field, analyzer);
                Fragmenter fragment = new SimpleSpanFragmenter(scorer);
                highlighter.setTextFragmenter(fragment);
                //获取高亮的片段，可以对其数量进行限制，高亮content
                String str = highlighter.getBestFragment(tokenStream, document.get(field));

                PersonInfoIndex personInfoIndex = document2PersonInfoIndex(document);
                personInfoIndex.setContent(str);
                personInfoIndex.setScore(scoreDoc.score);
                list.add(personInfoIndex);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } catch (InvalidTokenOffsetsException e) {
            e.printStackTrace();
        } finally {
            try {
                if (multiReader != null) {
                    multiReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private PersonInfoIndex document2PersonInfoIndex(Document document) {
        PersonInfoIndex personInfoIndex = new PersonInfoIndex();
        personInfoIndex.setPersonId(document.get("personId"));
//        personInfoIndex.setContent(document.get("content"));
        personInfoIndex.setColumnCode(document.get("columnCode"));
        personInfoIndex.setDescription(document.get("description"));
        return personInfoIndex;
    }

    private IndexReader getIndexReader(String tabCode) throws IOException {
        String dirPath = baseDir + File.separator + tabCode;
        File file = new File(dirPath);
        if (!file.exists()) {
            return null;
        }
        Directory directory = FSDirectory.open(file);
        IndexReader indexReader = DirectoryReader.open(directory);
        return indexReader;
    }
}
