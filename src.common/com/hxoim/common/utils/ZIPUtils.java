package com.hxoim.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZIPUtils {
    /**
     * 功能:压缩多个文件成一个zip文件
     *
     * @param srcfile：源文件列表
     * @param zipfile：压缩后的文件
     */
    public static void zipFiles(List<File> srcfile, File zipfile) {
        byte[] buf = new byte[1024];
        try {
            //ZipOutputStream类：完成文件或文件夹的压缩
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
            for (int i = 0; i < srcfile.size(); i++) {
                FileInputStream in = new FileInputStream(srcfile.get(i));
                out.putNextEntry(new ZipEntry(srcfile.get(i).getName()));
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 功能:解压缩
     *
     * @param zipfile：需要解压缩的文件
     * @param descDir：解压后的目标目录
     */
    public static void unZipFiles(File zipfile, String descDir) {
        try {
            ZipFile zf = new ZipFile(zipfile);
            for (Enumeration<? extends ZipEntry> entries = zf.entries(); entries.hasMoreElements(); ) {
                ZipEntry entry = entries.nextElement();
                if (entry.isDirectory()) {
                    File dir = new File(descDir + entry.getName());
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }
                } else {
                    String zipEntryName = entry.getName();
                    InputStream in = zf.getInputStream(entry);
                    File file = new File(descDir + zipEntryName);
                    new File(file.getParent()).mkdirs();
                    OutputStream out = new FileOutputStream(file);
                    byte[] buf1 = new byte[1024];
                    int len;
                    while ((len = in.read(buf1)) > 0) {
                        out.write(buf1, 0, len);
                    }
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                }
            }
            if (zf != null) {
                zf.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //压缩文件
    private static void zipFile(ZipOutputStream zipOutputStream, File file, String parentFileName) {
        FileInputStream in = null;
        try {
            //ZipEntry zipEntry = new ZipEntry( parentFileName+file.getName() );
            ZipEntry zipEntry = new ZipEntry(parentFileName);
            zipOutputStream.putNextEntry(zipEntry);
            in = new FileInputStream(file);
            int len;
            byte[] buf = new byte[8 * 1024];
            while ((len = in.read(buf)) != -1) {
                zipOutputStream.write(buf, 0, len);
            }
            zipOutputStream.closeEntry();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 递归压缩目录结构
     *
     * @param zipOutputStream
     * @param file
     * @param parentFileName
     */
    private static void directory(ZipOutputStream zipOutputStream, File file, String parentFileName) {
        File[] files = file.listFiles();
        String parentFileNameTemp = null;
        for (File fileTemp : files) {
            parentFileNameTemp = StringUtils.isEmpty(parentFileName) ? fileTemp.getName() : parentFileName + File.separator + fileTemp.getName();
            if (fileTemp.isDirectory()) {
                directory(zipOutputStream, fileTemp, parentFileNameTemp);
            } else {
                zipFile(zipOutputStream, fileTemp, parentFileNameTemp);
            }
        }
    }


    /**
     * 压缩文件目录
     *
     * @param source 源文件目录（单个文件和多层目录）
     * @param destit 目标目录
     */
    public static void zipFiles(String source, String destit) {
        File file = new File(source);
        ZipOutputStream zipOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(destit);
            zipOutputStream = new ZipOutputStream(fileOutputStream);
            if (file.isDirectory()) {
                directory(zipOutputStream, file, "");
            } else {
                zipFile(zipOutputStream, file, "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                zipOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 压缩文件目录
     *
     * @param source 源文件目录（单个文件和多层目录）
     *               当要将文件夹压缩成zip并放置到该文件夹目录
     * @param destit 目标目录
     */
    public static void zipFiles2(String source, String destit) {
        File file = new File(source);
        ZipOutputStream zipOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                fileOutputStream = new FileOutputStream(destit);
                zipOutputStream = new ZipOutputStream(fileOutputStream);
                for (File fileTemp : files) {
                    if (fileTemp.isDirectory()) {
                        directory(zipOutputStream, fileTemp, fileTemp.getName());
                    } else {
                        zipFile(zipOutputStream, fileTemp, fileTemp.getName());
                    }
                }
            } else {
                fileOutputStream = new FileOutputStream(destit);
                zipOutputStream = new ZipOutputStream(fileOutputStream);
                zipFile(zipOutputStream, file, "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //复制文件夹下所有
    public static void copyDir(String sourcePath, String newPath) throws IOException {
        File file = new File(sourcePath);
        String[] filePath = file.list();

        if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdir();
        }

        for (int i = 0; i < filePath.length; i++) {
            if ((new File(sourcePath + File.separator + filePath[i])).isDirectory()) {
                copyDir(sourcePath + File.separator + filePath[i], newPath + File.separator + filePath[i]);
            }

            if (new File(sourcePath + File.separator + filePath[i]).isFile()) {
                copyFile(sourcePath + File.separator + filePath[i], newPath + File.separator + filePath[i]);
            }

        }
    }

    //复制文件
    public static void copyFile(String oldPath, String newPath) throws IOException {
        File oldFile = new File(oldPath);
        File file = new File(newPath);
        FileInputStream in = new FileInputStream(oldFile);
        FileOutputStream out = new FileOutputStream(file);
        ;

        byte[] buffer = new byte[2097152];
        int readByte = 0;
        while ((readByte = in.read(buffer)) != -1) {
            out.write(buffer, 0, readByte);
        }
        in.close();
        out.close();
    }


    /**
     * 功能:压缩多个文件成一个zip文件(可以是不同的文件夹和文件)
     *
     * @param srcfile：源文件列表
     * @param zipfile：压缩后的文件
     */
    public static void zipDiffFolder(List<File> srcfile, File zipfile) {
        ZipOutputStream zipOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(zipfile);
            zipOutputStream = new ZipOutputStream(fileOutputStream);
            for (int i = 0; i < srcfile.size(); i++) {
                File file = srcfile.get(i);
                if (file.isDirectory()) {
                    directory(zipOutputStream, file, file.getName());
                } else {
                    zipFile(zipOutputStream, file, file.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                zipOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 功能:
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //unZipFiles(new File("D:\\Users\\Person\\Desktop\\按机构导出文件_Z01_中央20190418140017.zip"), "D:\\Users\\Person\\Desktop\\123123123\\");

        File file = new File("D:\\dong\\eclipse\\workspace\\hxhnms\\WebContent\\photos");
        File file1 = new File("D:\\db\\20190515092328.dmp");
        List<File> files = new ArrayList<>();
        files.add(file);
        files.add(file1);
        File zipFile = new File("D:\\db\\20190515.zip");
        zipFile.createNewFile();
        zipDiffFolder(files,zipFile);
        //zipFiles();
//	    //2个源文件
//	    File f1=new File("D:\\workspace\\flexTest\\src\\com\\biao\\test\\abc.txt");
//	    File f2=new File("D:\\workspace\\flexTest\\src\\com\\biao\\test\\test.zip");
//	    File[] srcfile={f1,f2};
//	    
//	    //压缩后的文件
//	    File zipfile=new File("D:\\workspace\\flexTest\\src\\com\\biao\\test\\biao.zip");
//	    //TestZIP.zipFiles(srcfile, zipfile);
//	    //需要解压缩的文件
//	    File file=new File("D:\\workspace\\flexTest\\src\\com\\biao\\test\\biao.zip");
//	    //解压后的目标目录
//	    String dir="D:\\workspace\\flexTest\\src\\com\\biao\\test\\";
//	    ZIPUtils.unZipFiles(file, dir);

        //测试文件压缩文件夹
        //ZIPUtils.zipFiles("D:\\TEST", "D:\\TEST11111.zip");

        //测试重命名
//        String fileName = "arch.idb";
//        File oleFile = new File("D:\\TEST11111.zip");
//        File newFile = new File("D:\\arch.idb");
//        oleFile.renameTo(newFile);
        //测试copy文件
        //copyDir("D:\\TEST","D:\\test222");

        //FileUtils.copyDirectory(new File("D:\\TEST"), new File("D:\\test222"),false);

//		  List<File> fileList = (List<File>)FileUtils.listFiles(new File("D:\\DEVELOPMENT\\workspace\\hxhnms\\WebContent\\photos"),null,false);
//	      if(fileList!=null && fileList.size()>0) {
//	    	  for(File file:fileList) {
//	    		  System.out.println(file.getName());
//	    	  }
//	      }
        //FileUtils.copyDirectory(new File("D:\\TEST"), new File("D:\\test222"),false);
        //FileUtils.copyFileToDirectory(new File("D:\\TEST\\new.docx"), new File("D:\\test444"));

    }
}
