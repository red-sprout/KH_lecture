package com.kh.Test240201;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDAO {
	public boolean checkName(String file) {
		File checkFile = new File(file);
		return checkFile.exists();
	}
	
	public void fileSave(String file, String s) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			bw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * StringBuilder : 효율적으로 문자열을 처리하기 위한 클래스로 다양한 기능의 메소드를 제공한다.
	 * append(), insert(), delete(), replace()....
	 */
	public StringBuilder fileOpen(String file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String str = null;
			while((str = br.readLine()) != null) {
				sb.append(str + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb;
	}
	
	public void fileEdit(String file, String s) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			bw.write(s);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
