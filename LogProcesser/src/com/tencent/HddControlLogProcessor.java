package com.tencent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class HddControlLogProcessor {
	
	public static void process(BufferedReader reader, BufferedWriter writer) throws IOException {
		 
		String sentence = "date" + "," + "time" + "," + "power" + ", " + "elipsedTime1" + "," + "speed1" + "," + "elipsedTime2" + "," + "speed2" + "," + "elipsedTime3" + "," + "speed3" +  "\n";
				
		writer.write(sentence);
		writer.flush();
		
		String line = reader.readLine();
		while (line != null) {
			// System.out.println(line);
			if (!line.contains("case power") || !line.contains("start")) {
				line = reader.readLine();
				continue;
			}
			
			
			String[] words = line.split("\\s+");
			
			String power = words[2];
			
			for (int i=0;i<53;i++)
			{
				line = reader.readLine();
				if (line==null) break;
			}
			
			words = line.split("-");
			
			String date = words[0].replace('_','/');
			String time = words[1];
			
			for (int i=0;i<3;i++)
			{
				line = reader.readLine();
				if (line==null) break;
			}
			
			words = line.split("\\s+");
			
			String elapsedTime1 = words[5];
			
			String speed1= words[7];
			
			for (int i=0;i<3;i++)
			{
				line = reader.readLine();
				if (line==null) break;
			}
			
			words = line.split("\\s+");
			
			String elapsedTime2 = words[5];
			
			String speed2= words[7];
			
			for (int i=0;i<3;i++)
			{
				line = reader.readLine();
				if (line==null) break;
			}
			
			words = line.split("\\s+");
			
			String elapsedTime3 = words[5];
			
			String speed3= words[7];
			
			sentence = date + "," + time + "," + power + ", "  + elapsedTime1 + "," + speed1 + "," + elapsedTime2 + "," + speed2 + "," + elapsedTime3 + "," + speed3 + "\n";
			writer.write(sentence);
			writer.flush();
			
			line=reader.readLine();

		}
			
	}

}
