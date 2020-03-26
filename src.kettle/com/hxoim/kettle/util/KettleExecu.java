package com.hxoim.kettle.util;


import com.hxoim.common.exceptions.ParameterNullException;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.repository.LongObjectId;
import org.pentaho.di.repository.ObjectId;
import org.pentaho.di.repository.Repository;
import org.pentaho.di.repository.RepositoryDirectoryInterface;
import org.pentaho.di.repository.kdr.KettleDatabaseRepository;
import org.pentaho.di.repository.kdr.KettleDatabaseRepositoryMeta;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @desc: kettle
 * @author: lijing
 * @date: 2017/15
 */
public class KettleExecu {
    /**线程执行等待程序*/
    private ExecutorService executor = Executors.newCachedThreadPool();
    private static volatile KettleExecu kettleExecu;
    /**资源库元对象*/
    private static KettleDatabaseRepositoryMeta meta;
    /**资源库*/
    private static Repository repository;
    /**作业集合*/
    private static Map<String, Job> jobMap = new ConcurrentHashMap<>();
    /**转换集合*/
    private static Map<String, Trans> transMap = new ConcurrentHashMap<>();

   /**
    * @desc: 资源库连接初始化
    * @author: lijing
    * @date: 2019/7/15
    */
    private KettleExecu() {
        try {
            // 读取配置文件，通过Spring中的PropertiesLoaderUtils工具类进行获取
            Properties prop = PropertiesLoaderUtils.loadAllProperties("kettle.properties");
            //kettle环境初始化
            KettleEnvironment.init();
            //创建资源库数据库对象，类似我们在spoon里面创建资源库
            DatabaseMeta dataMeta = new DatabaseMeta();
            dataMeta.setName(prop.getProperty("kettle.name"));
            dataMeta.setDBName(prop.getProperty("jdbc.dbname"));
            dataMeta.setDatabaseType(prop.getProperty("jdbc.databaseType"));
            dataMeta.setAccessType(Integer.parseInt(prop.getProperty("kettle.accessType")));
            dataMeta.setHostname(prop.getProperty("jdbc.hostname"));
            dataMeta.setServername(prop.getProperty("jdbc.servername"));
            dataMeta.setDBPort(prop.getProperty("jdbc.port"));
            dataMeta.setUsername(prop.getProperty("jdbc.username"));
            dataMeta.setPassword(prop.getProperty("jdbc.password"));
            ObjectId objectId = new LongObjectId(100);
            dataMeta.setObjectId(objectId);
            dataMeta.setShared(true);
            dataMeta.addExtraOption(dataMeta.getPluginId(), "characterEncoding", prop.getProperty("jdbc.characterEncoding"));
            dataMeta.addExtraOption(dataMeta.getPluginId(), "allowMultiQueries", prop.getProperty("jdbc.allowMultiQueries"));
            dataMeta.addExtraOption(dataMeta.getPluginId(), "useSSL", prop.getProperty("jdbc.useSSL"));
            //资源库元对象,名称参数，id参数，描述等可以随便定义
            meta = new KettleDatabaseRepositoryMeta();
            meta.setName(prop.getProperty("kettle.name"));
            meta.setId(prop.getProperty("kettle.name"));
            meta.setDescription(prop.getProperty("kettle.name"));
            meta.setConnection(dataMeta);
            //给资源库赋值
            KettleDatabaseRepository kettleDatabaseRepository = new KettleDatabaseRepository();
            kettleDatabaseRepository.init(meta);
            //连接资源库
            kettleDatabaseRepository.connect(prop.getProperty("kettle.username"), prop.getProperty("kettle.password"));
            repository = kettleDatabaseRepository;
        } catch (IOException e) {
            throw new ParameterNullException("配置文件读取异常");
        } catch (KettleException e) {
            throw new ParameterNullException("kettle环境初始化异常");
        }

    }

    /**
     * 转换执行
     * @param transName 转换名称
     * @param params 传递参数
     * @param dir 目录
     * @throws KettleException
     */
    public Integer transStart(String transName, String[] params, String dir) throws KettleException {
        //根据变量查找到模型所在的目录对象,此步骤很重要。
        RepositoryDirectoryInterface directory = repository.findDirectory(dir);
        //创建ktr元对象
        TransMeta transMeta = repository.loadTransformation(transName, directory, null, true, null);
        //创建ktr
        Trans trans = new Trans(transMeta);
        //添加到集合中
        transMap.put(transName, trans);
        //执行ktr
        trans.execute(params);
        //线程执行,执行完成后移除map中的数据
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //等待执行完毕
                trans.waitUntilFinished();
                //移除
                if (transMap.containsKey(transName)){
                    transMap.remove(transName);
                }
            }
        });
        if (trans.getErrors() > 0) {
            throw new ParameterNullException("执行发生异常");
        } else {
            return 0;
        }
    }

    /**
     * 转换停止
     * @param transName 转换名称
     * @throws KettleException
     */
    public void transStop(String transName) throws KettleException {
        //移除
        if (transMap.containsKey(transName)){
            //ktr
            Trans trans = transMap.get(transName);
            //停止
            trans.stopAll();
        }else{
            throw new ParameterNullException("未启动或已执行完成");
        }
    }

    /**
     * 作业执行
     * @param jobName 作业名称
     * @param params 传递参数
     * @param dir 目录
     * @throws KettleException
     */
    public Integer jobStart(String jobName, Map<String, String> params, String dir) throws KettleException {
        //根据变量查找到模型所在的目录对象,此步骤很重要。
        RepositoryDirectoryInterface directory = repository.findDirectory(dir);
        //创建kjb元对象
        JobMeta jobMeta = repository.loadJob(jobName, directory, null, null);
        //创建kjb
        Job job = new Job(repository, jobMeta);
        if (params != null && params.size() > 0){
            for(Map.Entry<String, String> param: params.entrySet()){
                job.setVariable(param.getKey(), param.getValue());
            }
        }
        //添加到集合
        jobMap.put(jobName, job);
        //执行kjb
        job.start();
        //线程执行，执行完成后移除map中的数据
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //等待执行完毕
                job.waitUntilFinished();
                //移除
                if (jobMap.containsKey(jobName)){
                    jobMap.remove(jobName);
                }
            }
        });
        if (job.getErrors() > 0) {
            throw new ParameterNullException("执行发生异常");
        } else {
            return 0;
        }
    }

    /**
     * 作业停止
     * @param jobName 转换名称
     * @throws KettleException
     */
    public void jobStop(String jobName) throws KettleException {
        //移除
        if (jobMap.containsKey(jobName)){
            //kjb
            Job job = jobMap.get(jobName);
            //停止
            job.stopAll();
        }else{
            throw new ParameterNullException("未启动或已执行完成");
        }
    }

    /**
     * 获取当前实例
     * @Param
     * @Return
     */
    public static KettleExecu getInstance() {
        if (kettleExecu == null) {
            synchronized (KettleExecu.class) {
                if (kettleExecu == null) {
                    kettleExecu = new KettleExecu();
                }
            }
        }
        return kettleExecu;
    }

    public static void main(String[] args) throws KettleException {
        KettleExecu kettleExecu = KettleExecu.getInstance();
        kettleExecu.transStart("text", null, "/");
        kettleExecu.transStop("text");
    }
}
