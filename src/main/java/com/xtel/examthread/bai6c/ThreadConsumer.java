/**
 * 
 */
package com.xtel.examthread.bai6c;

import org.apache.log4j.Logger;

/**
 * @author TUAN
 *
 */
public class ThreadConsumer extends Thread {
	
	Logger logger = Logger.getLogger(ThreadConsumer.class);
	
	QueueMessage queueMessage = new QueueMessage();

	public ThreadConsumer(QueueMessage queueMessage) {
		this.queueMessage = queueMessage;
	}

	@Override
	public void run() {
		synchronized (queueMessage) {
			logger.info(String.format("Thread Consumer get up"));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				logger.error(String.format("Error while run: "));
				e.printStackTrace();
			}
			
			if(!queueMessage.checkQueueIsEmpty()) {
				System.out.println(String.format("Chuc mung %s la khach hang may man nhan duoc %s tu chuong trinh tri an khach hang",
						queueMessage.queueCustomerName.element(), queueMessage.queueGiftName.element()));
				queueMessage.count--;
			}else {
				queueMessage.notifyAll();
				try {
					queueMessage.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			logger.info(String.format("Thread Consumer stopped"));
			queueMessage.notifyAll();
			try {
				queueMessage.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		synchronized (queueMessage) {
			queueMessage.notifyAll();
		}
	}
}
