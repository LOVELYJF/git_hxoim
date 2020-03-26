package com.hxoim.common.utils;

import com.itextpdf.text.pdf .PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileParseTextUtil {

    public String parseText(String path) throws FileNotFoundException {
        String result;
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("文件不存在");
        }
        if ("PDF".equalsIgnoreCase(path.substring(path.lastIndexOf(".") + 1))) {
            result = pdfParse(path);
        } else {
            result = tikaParse(file);
        }
        return result;
    }

    private String pdfParse(String path) {
        StringBuilder result = new StringBuilder();
        PdfReader pdfReader = null;
        try {
            pdfReader = new PdfReader(path);
            int numberOfPages = pdfReader.getNumberOfPages();
            for (int i = 1; i <= numberOfPages; i++) {
                String textFromPage = PdfTextExtractor.getTextFromPage(pdfReader, i);
                result.append(textFromPage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pdfReader != null) {
                pdfReader.close();
            }
        }
        return result.toString();
    }

    private String tikaParse(File file) {
        Tika tika = new Tika();
        String result = null;
        try {
            result = tika.parseToString(file);
        } catch (IOException | TikaException e) {
            e.printStackTrace();
        }
        return result;
    }
}
