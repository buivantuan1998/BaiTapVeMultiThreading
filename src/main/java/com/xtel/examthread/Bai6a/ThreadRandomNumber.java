/**
 * 
 */
package com.xtel.examthread.Bai6a;

import org.apache.log4j.Logger;

/**
 * @author TUAN
 *
 */
public class ThreadRandomNumber extends Thread {
	
	Logger logger = Logger.getLogger(ThreadRandomNumber.class);
	RandomNumber randomNumber;
	
	public ThreadRandomNumber(RandomNumber randomNumber) {
		this.randomNumber = randomNumber;
	}

	@Override
	public void run() {
		int i = 1;

		do {
			synchronized (randomNumber) {
				randomNumber.randomNumberInteger = (int) (Math.random() * 10 + 1);
				logger.info(String.format("Random so thu %s la: %s", i, randomNumber.randomNumberInteger));
				randomNumber.notifyAll();
				try {
//					Thread.sleep(1000);
					randomNumber.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;
			}
		} while (i != 0);

	}

}
