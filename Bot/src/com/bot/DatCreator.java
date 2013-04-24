package com.bot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatCreator {
	static List<String> d = new ArrayList<String>();


	public static void WriteToFile() {

		try {			
			File file = new File("ds.dat");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);			

			for(String ms : d) {				
				bw.write(ms);
				bw.newLine();

			}
			bw.close();
			System.out.println("Created Data File with " + d.toArray().length + " hooks");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void AddScring(String s) {
		d.add(s);
	}

}


