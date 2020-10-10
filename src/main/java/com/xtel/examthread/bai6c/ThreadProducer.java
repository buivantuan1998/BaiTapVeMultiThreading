/**
 * 
 */
package com.xtel.examthread.bai6c;

import java.util.Random;

import org.apache.log4j.Logger;

/**
 * @author TUAN
 *
 */
public class ThreadProducer extends Thread {

	Logger logger = Logger.getLogger(ThreadProducer.class);
	
	Message message = new Message();
	QueueMessage queueMessage = new QueueMessage();
	
	public ThreadProducer(QueueMessage queueMessage) {
		this.queueMessage = queueMessage;
	}

	Random random = new Random();

	@Override
	public void run() {
		synchronized (queueMessage) {
			Random random = new Random();
			String customerName = " ";
			String giftName = " ";
			int i = 0;
			
			message.dataMessage();

			do {
				for (i = 0; i < message.listCustomerName.size(); i++) {
					customerName = message.listCustomerName.get(random.nextInt(message.listCustomerName.size()));
				}
				
				for (i = 0; i < message.listGiftName.size(); i++) {
					giftName = message.listGiftName.get(random.nextInt(message.listGiftName.size()));
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				logger.info(String.format("Cusumner name: %s, Gift name: %s", customerName, giftName));
				
				if(!queueMessage.checkQueueIsFull()) {
					queueMessage.queueCustomerName.offer(customerName);
					queueMessage.queueGiftName.offer(giftName);
					queueMessage.count ++;
				}else {
					queueMessage.notifyAll();
					try {
						queueMessage.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				logger.info(String.format("Cusumer: %s, Gift: %s", queueMessage.queueCustomerName.element(), queueMessage.queueGiftName.element()));
				logger.info(String.format("Thread producer stop "));
				
				
				queueMessage.notifyAll();
				try {
					queueMessage.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} while (true);
		}
		
	}

	public static void main(String[] args) {
		QueueMessage queueMessage = new QueueMessage();
		ThreadProducer t = new ThreadProducer(queueMessage);
		t.start();

	}

}
