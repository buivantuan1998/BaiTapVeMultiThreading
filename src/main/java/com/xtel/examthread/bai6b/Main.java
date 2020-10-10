/**
 * 
 */
package com.xtel.examthread.bai6b;

import java.util.Scanner;

import org.apache.log4j.Logger;


/**
 * @author TUAN
 *
 */
public class Main extends Thread{
Logger logger = Logger.getLogger(Main.class);
	
	@Override
	public void run() {
		
		 int randomNumber = 0;
		 int count = 0;
		 
		 do {
			randomNumber = (int) (Math.random()*10+1);
			System.out.println(String.format("Random so thu %s la: %s", (count+1), randomNumber));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
		} while (true);
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao thoi gian chay random (tinh theo phut): ");
		int thoiGianRanDom = sc.nextInt();
		System.out.println(String.format("Ban vua nhap vao thoi gian chay random la %s phut", thoiGianRanDom));
		int quyDoiThoiGian = thoiGianRanDom*60*1000;
		
		Main b = new Main();
		b.start();
		
		try {
			Thread.sleep(quyDoiThoiGian);
			b.interrupt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(String.format("Thoi gian random la %s phut da het", thoiGianRanDom));

	}

}
