/**
 * 
 */
package com.xtel.examthread.Bai6a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.apache.log4j.Logger;

/**
 * @author TUAN
 *
 */
public class ThreadWriteFile extends Thread {
	
	private static String filePath = "C:\\log\\output.txt";
	int i = 1;
	
	Logger logger = Logger.getLogger(ThreadWriteFile.class);
	
	File file = new File(filePath);
	RandomNumber randomNumber;
	

	public ThreadWriteFile(RandomNumber randomNumber) {
		this.randomNumber = randomNumber;
	}

	public void write() {
		
	}
	@Override
	public void run() {
		do {
			synchronized (randomNumber) {
				if (file.exists()) {
					try {
			            BufferedWriter out = new BufferedWriter( new FileWriter(filePath, true)); 
			            out.write(String.valueOf(randomNumber.randomNumberInteger)); 
			            out.close(); 
						
						randomNumber.notifyAll();
						randomNumber.wait();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					logger.warn(String.format("File not found"));
				}
			}
			synchronized (randomNumber) {
				randomNumber.notifyAll();
			}
		} while (true);
			

	}
}
