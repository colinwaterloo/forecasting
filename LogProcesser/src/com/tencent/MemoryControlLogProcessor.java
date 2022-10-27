package com.tencent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class MemoryControlLogProcessor {
	
	public static void process(BufferedReader reader, BufferedWriter writer) throws IOException {
		 
		String sentence = "date" + "," + "time" + "," + "band" + "," + "power" + ", " +  "\n";
				
		writer.write(sentence);
		writer.flush();
		String line = reader.readLine();
		while (line != null) {
			// System.out.println(line);
			if (!line.contains("setting power")) {
				line = reader.readLine();
				continue;
			}
			
			String[] words = line.split("\\s+");
			
			String band = words[2];
			String power = words[5];
			
			line = reader.readLine();
			if (line==null) break;
			
			words = line.split("\\s+");
			
			String date = words[1].replace('_', '/');
			String time = words[2];
			
			sentence = date + "," + time + "," + band + "," + power + ", " + "\n";
			writer.write(sentence);
			writer.flush();
			
			line=reader.readLine();
			if (line==null) break;
			
			line=reader.readLine();
			

		}
			
	}

}
