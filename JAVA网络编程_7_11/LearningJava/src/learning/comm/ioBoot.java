package learning.comm;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import learning.io.*;
public class ioBoot {

	public static void main(String[] args) {
		OutputStream out = new ByteArrayOutputStream();
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(new File("learn.txt"));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			System.out.println("no file found");
		}
		
		// TODO  写入每字节的内容
		try {
			outputStreamTest.generateCharacters(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(out.toString());
		try {
			out.flush();
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// TODO 写入Byte缓冲的内容
		try {
			outputStreamTest.generateCharactersByte(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(out.toString());
		// TODO 写入文件并且做防护句柄处理的内容————写法1
		try {
			outputStreamTest.generateFileOutput(fout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (fout != null){
				try {
					fout.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		}
		//TODO 写入文件并且做防护句柄处理的内容————写法2，带资源的try,不用finally，实现closeable接口
		try(FileOutputStream fout2 = new FileOutputStream(new File("learn2.txt"));){
			outputStreamTest.generateFileOutput(fout2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//TODO 读文件并输出
		try(FileInputStream input = new FileInputStream(new File("learn2.txt"))){
			inputStream.readInputStream(input);	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
