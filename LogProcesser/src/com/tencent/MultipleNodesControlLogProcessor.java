package com.tencent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MultipleNodesControlLogProcessor {

	public static void process(BufferedReader reader, BufferedWriter writer) throws IOException {

		String sentence = "date" + "," + "time" + "," +  "power" + ", " + "N" + "," + "P" + "," + "Q" + "," + "elipsedTime"
				+ "," + "GFlops" + "\n";

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

			for (int i = 0; i < 4; i++) {
Loop1:				while (line != null) {
					if (line.contains(
							"T/V                N    NB     P     Q               Time                 Gflops")) {
						break Loop1;
					 }
					else
						line = reader.readLine();
				    }

					line = reader.readLine();
					if (line == null)
						break;

					line = reader.readLine();
					if (line == null)
						break;

					words = line.split("\\s+");

					String n = words[1];

					String p = words[3];

					String q = words[4];

					String elapsedTime = words[5];

					String gFlops = words[6];

					line = reader.readLine();
					if (line == null)
						break;

					line = line.substring(24).trim();

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss yyyy",
							Locale.ENGLISH);

					LocalDateTime dateTime = LocalDateTime.parse(line, formatter);
					String date = dateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
					String time = dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

					sentence = date + "," + time + "," + power + "," +  n + ", " + p + "," + q + "," + elapsedTime + "," + gFlops
							+ "\n";

					writer.write(sentence);
					writer.flush();

					line = reader.readLine();
				

			}

		}
	}
}
