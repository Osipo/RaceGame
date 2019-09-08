package ru.java2e;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialzier implements Serializable{
	 static void store(Serializable o,File f) throws IOException{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(o);
	}
	 static Object load(File f) throws IOException,ClassNotFoundException{
		 ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		 return in.readObject();
	 }

}
