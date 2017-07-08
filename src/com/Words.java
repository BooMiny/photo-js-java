package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Words {
	public String youWords;
	public static ArrayList<Words> wPage = new ArrayList<Words>();
	
	public static void write(String str) throws IOException{
		Words.read();
		Words wL = new Words();
		wL.youWords = str;
		wPage.add(wL);
		File f = new File("e://liuyan.txt");
		FileOutputStream ft = new FileOutputStream(f);
		OutputStreamWriter writer = new OutputStreamWriter(ft);
		for(Words fp:wPage){
			String temp = fp.youWords+"\r\n";
			writer.write(temp);
		}
		writer.flush();
		writer.close();
		ft.flush();
		ft.close();
	}
	
	public static void read() throws IOException{
		wPage.clear();
		File f = new File("e://liuyan.txt");
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String temp = reader.readLine();
		while(temp!=null){
			Words wd = new Words();
			wd.youWords = temp;
			wPage.add(wd);
			temp = reader.readLine();
		}
	}
}
