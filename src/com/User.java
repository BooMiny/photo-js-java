package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class User {
	private String usName;
	private String passwd;
	static ArrayList<User> Ulist = new ArrayList<User>();
	public String getUsName() {
		return usName;
	}

	public void setUsName(String usName) {
		this.usName = usName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public static int reg(String name,String pswd) throws IOException{		
		if(equal(name))return -1;
		User u = new User();
		u.setUsName(name);
		u.setPasswd(pswd);
		Ulist.add(u);
		save();
		return 1;
	}
	public static void save() throws IOException{
		File f = new File("e://list.txt");
		FileOutputStream fo = new FileOutputStream(f);
		OutputStreamWriter writer = new OutputStreamWriter(fo, "UTF-8");
		for(User tem : Ulist){
			String tems = tem.usName+" "+tem.passwd+"\r\n";
			writer.write(tems);
		}
		writer.flush();
		writer.close();
		fo.flush();
		fo.close();
	}
	public static void read() throws IOException{
		File f = new File("e://list.txt");
		//FileInputStream fo = new FileInputStream(f);
		//InputStreamReader reader = new InputStreamReader(fo, "UTF-8");
        BufferedReader reader = new BufferedReader(new FileReader(f));
		String a= reader.readLine();
		while(a!=null){
			User tem = new User();
			if(a.split(" ").length==2){
				tem.setUsName(a.split(" ")[0]);
				tem.setPasswd(a.split(" ")[1]);
				Ulist.add(tem);
			}
		     a= reader.readLine();
		}
	}
	public static boolean equal (String name){
		
		for (User t : Ulist){
		
			if(name .equals(t.getUsName())){
				return true;
			}
		
		}
		return false;
	}
public static User search (String name){
		
		for (User t : Ulist){
		
			if(name .equals(t.getUsName())){
				return t;
			}
		
		}
		return null;
	}
public static int log(String name,String pswd){
		User t =search(name);
		if(t!=null&&t.getPasswd().equals(pswd))return 1;
		return -1;
	}
}