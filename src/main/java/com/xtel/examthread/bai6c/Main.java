/**
 * 
 */
package com.xtel.examthread.bai6c;

/**
 * @author TUAN
 *
 */
public class Main {

	public static void main(String[] args) {
		QueueMessage queueMessage = new QueueMessage();
		ThreadProducer threadProducer = new ThreadProducer(queueMessage);
		ThreadConsumer threadConsumer = new ThreadConsumer(queueMessage);
		
		threadProducer.start();
		threadConsumer.start();
//		queueMessage.outputQueue();
	}

}
