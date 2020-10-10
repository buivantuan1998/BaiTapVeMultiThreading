/**
 * 
 */
package com.xtel.examthread.Bai6a;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author TUAN
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {

		String lenhNhapVao;

		RandomNumber randomNumber = new RandomNumber();
		ThreadRandomNumber threadRandomNumber = new ThreadRandomNumber(randomNumber);
		ThreadWriteFile threadWriteFile = new ThreadWriteFile(randomNumber);

		threadRandomNumber.start();
		threadWriteFile.start();

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao lenh stop de dung chuong trinh:");
		lenhNhapVao = sc.nextLine();
		do {
			threadRandomNumber.interrupt();
			threadWriteFile.interrupt();
		} while (!lenhNhapVao.equals("stop"));

	}

}
