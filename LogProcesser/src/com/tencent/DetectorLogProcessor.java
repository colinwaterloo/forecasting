package com.tencent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class DetectorLogProcessor{

	public static void process(BufferedReader reader, BufferedWriter writer) throws IOException {
		
		String sentence = "date" + "," + "time" + "," + "power_node0" + "," + "power_node1" + "," + "memory_node0" + "," + "memory_node1" + "," + 
				"cpuusr1" + "," + "cpunice1" + "," + "cpusys1" + "," + "cpuiowait1" + "," + "cpuirq1" + "," + "cpusoft1" + "," + "cpusteal1" + "," + "cpuguest1" +"," + "cpugnice1" + "," + "cpuidle1" + "," +
				"cpuusr2" + "," + "cpunice2" + "," + "cpusys2" + "," + "cpuiowait2" + "," + "cpuirq2" + "," + "cpusoft2" + "," + "cpusteal2" + "," + "cpuguest2" +"," + "cpugnice2" + "," + "cpuidle2" + "," +
				"cpuusr3" + "," + "cpunice3" + "," + "cpusys3" + "," + "cpuiowait3" + "," + "cpuirq3" + "," + "cpusoft3" + "," + "cpusteal3" + "," + "cpuguest3" +"," + "cpugnice3" + "," + "cpuidle3" + "," +
				"cpuusravg" + "," + "cpuniceavg" + "," + "cpusysavg" + "," + "cpuiowaitavg" + "," + "cpuirqavg" + "," + "cpusoftavg" + "," + "cpustealavg" + "," + "cpuguestavg" +"," + "cpugniceavg" + "," + "cpuidleavg"+ "," +
				"memoryTotal" + "," +  "memoryUsed" + "," + "memoryFree" + "," + "memoryShared" + "," + "memoryBuffers" + "," + "memoryCache" + "," + "memoryAvailable" + "," + "swapTotal" + "," + "swapUsed" + "," + "swapFree" + "," +
				"tps1" + "," + "kbReadPerSecond1" + "," +  "kbWritePerSecond1" + "," + "kbRead1" + "," + "kbWrite1" + "," + "tps2" + "," + "kbReadPerSecond2" + "," +  "kbWritePerSecond2" + "," + "kbRead2" + "," + "kbWrite2" + "," + "tps3" + "," + "kbReadPerSecond3" + "," +  "kbWritePerSecond3" + "," + "kbRead3" + "," + "kbWrite3" + "," +
				"rKBS1" + "," + "wKBS1" + "," + "rPKS1" + "," + "wPKS1" + "," + "rAVS1" + "," + "wAVS1" + "," + "util1" + "," + "sat1" + "," +
				"rKBS2" + "," + "wKBS2" + "," + "rPKS2" + "," + "wPKS2" + "," + "rAVS2" + "," + "wAVS2" + "," + "util2" + "," + "sat2" + "," +
				"rKBS3" + "," + "wKBS3" + "," + "rPKS3" + "," + "wPKS3" + "," + "rAVS3" + "," + "wAVS3" + "," + "util3" + "," + "sat3" + "," + "\n";
				
		writer.write(sentence);
		writer.flush();
		String line = reader.readLine();
		
		while (line != null) {
			// System.out.println(line);
			if (line.contains("start detecting parameters")|| line.startsWith("--------") ){
				line = reader.readLine();
				break;
			}
		}
		
		while (line != null) {
			// System.out.println(line);
			if (line.contains("start detecting parameters")|| line.startsWith("--------")) {
				line = reader.readLine();
				continue;
			}
			
			
			String date = line.substring(0, 10);
			String time = line.substring(11);
			
			line = reader.readLine(); 
			if (line == null) break;
			
			String[] words = line.split("\\s+");
			String power_node0 = words[0].split("=")[1];
			String power_node1 = words[1].split("=")[1];
			
			line=reader.readLine();
			if (line == null) break;
			
			words = line.split("\\s+");
			String memory_node0=words[0].split("=")[1];
			String memory_node1=words[1].split("=")[1];
			
			line=reader.readLine();
			if (line == null) break;
			line=reader.readLine();
			if (line == null) break;
			line=reader.readLine();
			if (line == null) break;
			
			line=reader.readLine();
			if (line == null) break;
			words = line.split("\\s+");
			
			String cpuusr1 = words[2];
			String cpunice1 = words[3];
			String cpusys1 = words[4];
			String cpuiowait1 = words[5];
			String cpuirq1 = words[6];
			String cpusoft1 = words[7];
			String cpusteal1 = words[8];
			String cpuguest1 = words[9];
			String cpugnice1 = words[10];
			String cpuidle1 = words[11];
			
			line=reader.readLine();
			if (line == null) break;
			words = line.split("\\s+");
			
			String cpuusr2 = words[2];
			String cpunice2 = words[3];
			String cpusys2 = words[4];
			String cpuiowait2 = words[5];
			String cpuirq2 = words[6];
			String cpusoft2 = words[7];
			String cpusteal2 = words[8];
			String cpuguest2 = words[9];
			String cpugnice2 = words[10];
			String cpuidle2 = words[11];
			
			line=reader.readLine();
			if (line == null) break;
			words = line.split("\\s+");
			
			String cpuusr3 = words[2];
			String cpunice3 = words[3];
			String cpusys3 = words[4];
			String cpuiowait3 = words[5];
			String cpuirq3 = words[6];
			String cpusoft3 = words[7];
			String cpusteal3 = words[8];
			String cpuguest3 = words[9];
			String cpugnice3 = words[10];
			String cpuidle3 = words[11];
			
			line=reader.readLine();
			if (line == null) break;
			words = line.split("\\s+");
			
			String cpuusravg = words[2];
			String cpuniceavg = words[3];
			String cpusysavg = words[4];
			String cpuiowaitavg = words[5];
			String cpuirqavg = words[6];
			String cpusoftavg = words[7];
			String cpustealavg = words[8];
			String cpuguestavg = words[9];
			String cpugniceavg = words[10];
			String cpuidleavg = words[11];
			
			line=reader.readLine();
			if (line == null) break;
			
			line=reader.readLine();
			if (line == null) break;
			words = line.split("\\s+");
			
			String memoryTotal = words[1];
			String memoryUsed = words[2];
			String memoryFree = words[3];
			String memoryShared = words[4];
			String memoryBuffers = words[5];
			String memoryCache = words[6];
			String memoryAvilabe = words[7];
			
			line=reader.readLine();
			if (line == null) break;
			words = line.split("\\s+");
			
			String swapTotal = words[1];
			String swapUsed = words[2];
			String swapFree = words[3];
		

			line=reader.readLine();
			if (line == null) break;
			
			line=reader.readLine();
			if (line == null) break;
			
			line=reader.readLine();
			if (line == null) break;
			
			String tps1= null;
			String kbReadPerSecond1 = null;
			String kbWritePerSecond1 = null;
			String kbRead1 = null;
			String kbWrite1 = null;
			
			String tps2= null;
			String kbReadPerSecond2 = null;
			String kbWritePerSecond2 = null;
			String kbRead2 = null;
			String kbWrite2 = null;
			
			String tps3= null;
			String kbReadPerSecond3 = null;
			String kbWritePerSecond3 = null;
			String kbRead3 = null;
			String kbWrite3 = null;
			
			if (line.startsWith("Device"))
			{
			
			line=reader.readLine();
			if (line == null) break;
			
			words = line.split("\\s+");
			
			tps1= words[1];
			kbReadPerSecond1 = words[2];
			kbWritePerSecond1 = words[3];
			kbRead1 = words[4];
			kbWrite1 = words[5];
			
			
			line=reader.readLine();
			if (line == null) break;
			
			line=reader.readLine();
			if (line == null) break;
			
			line=reader.readLine();
			if (line == null) break;
			
			words = line.split("\\s+");
			tps2= words[1];
			kbReadPerSecond2 = words[2];
			kbWritePerSecond2 = words[3];
			kbRead2 = words[4];
			kbWrite2 = words[5];
			
			
			line=reader.readLine();
			if (line == null) break;
			
			line=reader.readLine();
			if (line == null) break;
			
			line=reader.readLine();
			if (line == null) break;
			
			words = line.split("\\s+");
			tps3= words[1];
			kbReadPerSecond3 = words[2];
			kbWritePerSecond3 = words[3];
			kbRead3 = words[4];
			kbWrite3 = words[5];
			
			line=reader.readLine();
			if (line == null) break;
			
			line=reader.readLine();
			if (line == null) break;
			
			}
			
			line=reader.readLine();
			if (line == null) break;
			
			words = line.split("\\s+");
			String rKBS1 = words[2];
			String wKBS1 = words[3];
			String rPKS1 = words[4];
			String wPKS1 = words[5];
			String rAVS1 = words[6];
			String wAVS1 = words[7];
			String util1 = words[8];
			String sat1 = words[9];
			
			
			line=reader.readLine();
			if (line == null) break;
			
			words = line.split("\\s+");
			String rKBS2 = words[2];
			String wKBS2 = words[3];
			String rPKS2 = words[4];
			String wPKS2 = words[5];
			String rAVS2 = words[6];
			String wAVS2 = words[7];
			String util2 = words[8];
			String sat2 = words[9];
			
			line=reader.readLine();
			if (line == null) break;
			
			words = line.split("\\s+");
			String rKBS3 = words[2];
			String wKBS3 = words[3];
			String rPKS3 = words[4];
			String wPKS3 = words[5];
			String rAVS3 = words[6];
			String wAVS3 = words[7];
			String util3 = words[8];
			String sat3 = words[9];
			
			
			sentence = date + "," + time + "," + power_node0 + "," + power_node1 + "," + memory_node0 + "," + memory_node1 + "," + 
			cpuusr1 + "," + cpunice1 + "," + cpusys1 + "," + cpuiowait1 + "," + cpuirq1 + "," + cpusoft1 + "," + cpusteal1 + "," + cpuguest1 +"," + cpugnice1 + "," + cpuidle1 + "," +
			cpuusr2 + "," + cpunice2 + "," + cpusys2 + "," + cpuiowait2 + "," + cpuirq2 + "," + cpusoft2 + "," + cpusteal2 + "," + cpuguest2 +"," + cpugnice2 + "," + cpuidle2 + "," +
			cpuusr3 + "," + cpunice3 + "," + cpusys3 + "," + cpuiowait3 + "," + cpuirq3 + "," + cpusoft3 + "," + cpusteal3 + "," + cpuguest3 +"," + cpugnice3 + "," + cpuidle3 + "," +
			cpuusravg + "," + cpuniceavg + "," + cpusysavg + "," + cpuiowaitavg + "," + cpuirqavg + "," + cpusoftavg + "," + cpustealavg + "," + cpuguestavg +"," + cpugniceavg + "," + cpuidleavg+ "," +
			memoryTotal + "," +  memoryUsed + "," + memoryFree + "," + memoryShared + "," + memoryBuffers + "," + memoryCache + "," + memoryAvilabe + "," + swapTotal + "," + swapUsed + "," + swapFree + ","  +
			tps1 + "," + kbReadPerSecond1 + "," +  kbWritePerSecond1 + "," + kbRead1 + "," + kbWrite1 + "," + tps2 + "," + kbReadPerSecond2 + "," +  kbWritePerSecond2 + "," + kbRead2 + "," + kbWrite2 + "," + tps3 + "," + kbReadPerSecond3 + "," +  kbWritePerSecond3 + "," + kbRead3 + "," + kbWrite3 + "," +
			rKBS1 + "," + wKBS1 + "," + rPKS1 + "," + wPKS1 + "," + rAVS1 + "," + wAVS1 + "," + util1 + "," + sat1 + "," +
			rKBS2 + "," + wKBS2 + "," + rPKS2 + "," + wPKS2 + "," + rAVS2 + "," + wAVS2 + "," + util2 + "," + sat2 + "," +
			rKBS3 + "," + wKBS3 + "," + rPKS3 + "," + wPKS3 + "," + rAVS3 + "," + wAVS3 + "," + util3 + "," + sat3 + "," + "\n";
			
			writer.write(sentence);
			writer.flush();
			
		    line=reader.readLine();
			
		}
	}
}
