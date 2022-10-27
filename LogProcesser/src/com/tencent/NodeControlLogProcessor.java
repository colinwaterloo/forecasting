package com.tencent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NodeControlLogProcessor {
	
	public static void process(BufferedReader reader, BufferedWriter writer) throws IOException {
		 
		String sentence = "date" + "," + "time" + "," + "power" + ", " + "size" + "," + "LDA" + "," + "elipsedTime" + "," + "GFlops" + "," + "Residual" + "," + "Residual(norm)" +  "," + "Check" + "\n";
				
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
			
			line = reader.readLine();
			if (line==null) break;
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH:mm:ss");
			
			LocalDateTime dateTime = LocalDateTime.parse(line, formatter);
			
			words = line.split("-");
			
			String date = words[0].replace('_','/');
			String time = words[1];
			
			for (int i=0;i<82;i++)
			{
				line = reader.readLine();
				if (line==null) break;
			}
			
			words = line.split("\\s+");
			
			String size = words[0];
			String LDA = words[1];
			String elapsedTime = words[3];
			String gFlops = words[4];
			String residual = words[5];
			String residualNormal = words[6];
			String check = words[7];
			
			sentence = date + "," + time + "," + power + ", " + size + "," + LDA + "," + elapsedTime + "," + gFlops + "," + residual + "," + residualNormal +  "," + check + "\n";

			writer.write(sentence);
			writer.flush();
			
			line = reader.readLine();
			if (line==null) break;
			
            LocalDateTime newTime = dateTime.plusSeconds((long)Float.parseFloat(elapsedTime));
			
			date = newTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
			time = newTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			
            words = line.split("\\s+");
			
			size = words[0];
			LDA = words[1];
			elapsedTime = words[3];
			gFlops = words[4];
			residual = words[5];
			residualNormal = words[6];
			check = words[7];
			
			sentence = date + "," + time + "," + power + ", " + size + "," + LDA + "," + elapsedTime + "," + gFlops + "," + residual + "," + residualNormal +  "," + check + "\n";

			writer.write(sentence);
			writer.flush();
			
			line=reader.readLine();

		}
			
	}

}
