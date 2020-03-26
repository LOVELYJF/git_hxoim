package com.hxoim.common.utils;

import java.io.File;

public class FileUtil {
	
	/**
	 * Create: Mr.Ding
	 * Date: 2019/06/11
	   *  删除目录或者文件
	 * @param file
	 */
	public static void delete(String file) {
		if(file == null) {
			return ;
		}
		delete(new File(file));
	}
	
	/**
	 * Create: Mr.Ding
	 * Date: 2019/06/11
	 * 删除目录或者文件
	 * @param file
	 */
	public static void delete(File file) {
		if(file == null || !file.exists()) {
			return ;
		}
		
		if(file.isFile()) {
			file.delete();
			return ;
		}
		
		File[] files = file.listFiles();
		if(files == null) {
			return ;
		}
		
		for(File f : files) {
			delete(f);
		}
		file.delete();
	}
	/**
	 * 删除文件和所在父目录（如果父目录只有它自己）
	 * @param file
	 */
	public static void deleteFileAndIfParentIsEmpty(String file) {
		if(file == null) {
			return ;
		}
		deleteFileAndIfParentIsEmpty(new File(file));
	}

	/**
	 * 删除文件和所在父目录（如果父目录只有它自己）
	 * @param file
	 */
	public static void deleteFileAndIfParentIsEmpty(File file) {
		if(file == null) {
			return ;
		}
		
		//if file is not exist, need check parent dir
		if(!file.exists()) {
			File parent = file.getParentFile();
			if(parent.exists()) {
				parent.delete();
			}
			return ;
		}
		
		//delete if is file 
		if(file.isFile()) {
			file.delete();
			File parent = file.getParentFile();
			if(parent == null) {//parent file is null, why???
				return;
			}
			parent.delete();
			return ;
		}
		
		//not delete folder
	}
	

	/**
	 * 删除目录及目录下的文件
	 *
	 * @param dir
	 *            要删除的目录的文件路径
	 * @return 目录删除成功返回true，否则返回false
	 */
	public static   boolean deleteDirectory(String dir) {
		// 如果dir不以文件分隔符结尾，自动添加文件分隔符
		if (!dir.endsWith(File.separator))
			dir = dir + File.separator;
		File dirFile = new File(dir);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
			System.out.println("删除目录失败：" + dir + "不存在！");
			return false;
		}
		boolean flag = true;
		// 删除文件夹中的所有文件包括子目录
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
			// 删除子目录
			else if (files[i].isDirectory()) {
				flag = deleteDirectory(files[i]
						.getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag) {
			System.out.println("删除目录失败！");
			return false;
		}
		// 删除当前目录
		if (dirFile.delete()) {
			System.out.println("删除目录" + dir + "成功！");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 删除单个文件
	 *
	 * @param filePath
	 *            要删除的文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String filePath) {
		File file = new File(filePath);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			boolean delete = file.delete();
			if (delete) {
				System.out.println("删除单个文件" + filePath + "成功！");
				return true;
			} else {
				System.out.println("删除单个文件" + filePath + "失败！");
				return false;
			}
		} else {
			System.out.println("删除单个文件失败：" + filePath + "不存在！");
			return false;
		}
	}
}
