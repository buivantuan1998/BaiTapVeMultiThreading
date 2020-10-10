/**
 * 
 */
package com.xtel.examthread.bai6c;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author TUAN
 *
 */
public class QueueMessage {
	int MAXSIZE = 1000;
	int count = 0;
	Queue<String> queueCustomerName = new PriorityQueue<String>(MAXSIZE);
	Queue<String> queueGiftName = new PriorityQueue<String>(MAXSIZE);
	
	public boolean checkQueueIsFull() {
		if(count == MAXSIZE)
			return true;
		return false;
	}
	
	public boolean checkQueueIsEmpty() {
		if(count == 0)
			return true;
		return false;
	}
}
