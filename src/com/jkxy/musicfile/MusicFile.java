package com.jkxy.musicfile;


import java.io.File;
import java.util.Scanner;
/**
 * @author 查询指定目录下MP3文件
 */
public class MusicFile {
	private static Scanner scanner = new Scanner(System.in);  

	public static void main(String[] args) {  
		System.out.println("请指定要搜索目录: ");  
		String inputPath = scanner.next();  //从控制台输入
		File file = new File(inputPath);  
		System.out.println("查询中，请稍等... ");  
		findMP3(file);  
		System.out.println("----查找完成----");  
	}  

	/*
	 * 查找音乐文件的方法
	 */
	private static void findMP3(File file) {  
		File[] fileList = file.listFiles();  //获取当前文件夹下的所有文件和文件夹
		if (fileList != null) {
			for (File f : fileList) {  // 查找各个子目录  
				if (f.isDirectory()) {
					findMP3(f);  
				} else if(f.getAbsolutePath().endsWith(".mp3") == true || f.getAbsolutePath().endsWith("MP3")){ //判断后缀名是否mp3 
					System.out.println(f.getAbsolutePath());  
				}  
			}  
		}  
	}
}