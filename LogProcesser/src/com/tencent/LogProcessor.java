package com.tencent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LogProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("files"))) {
			for (Path file : stream) {

				String fileName = file.getFileName().toString();
				BufferedReader br = new BufferedReader(new FileReader(file.toFile()));
				BufferedWriter bw = new BufferedWriter(new FileWriter("csv/"+fileName.substring(0,fileName.length()-3) + "csv"));
				System.out.println("find a file " + fileName);

			   if (fileName.contains("memory-control")){
					MemoryControlLogProcessor.process(br,bw);
				}
				
				else if (fileName.contains("hdd_control")) {
					HddControlLogProcessor.process(br,bw);
				}

				else if (fileName.contains("out")&&fileName.contains("nodes") ) {
					 MultipleNodesControlLogProcessor.process(br,bw);
				}
				else if (fileName.contains("out")&&fileName.contains("control")||fileName.contains("1node")) {
					NodeControlLogProcessor.process(br,bw);
				}
				else if (fileName.contains("DS_Store")) {
			   		continue;
			   	}
				else {
					DetectorLogProcessor.process(br,bw);
				}
				
				br.close();
				bw.close();
			}

		} catch (IOException | DirectoryIteratorException ex) {
			System.err.println(ex);
		}

	}

}
