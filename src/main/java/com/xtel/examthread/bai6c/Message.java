/**
 * 
 */
package com.xtel.examthread.bai6c;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TUAN
 *
 */
public class Message {
	
	private String customerName;
	private String giftName;
	
	public Message() {
		
	}
	
	public Message(String customerName, String giftName) {
		this.customerName = customerName;
		this.giftName = giftName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getGiftName() {
		return giftName;
	}

	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}

	List<String> listCustomerName = new ArrayList<String>();
	List<String> listGiftName = new ArrayList<String>();
	
	public void dataMessage() {
		listCustomerName.add("Tuan");
		listCustomerName.add("Tuan1");
		listCustomerName.add("Tuan2");

		listGiftName.add("100.000 VND");
		listGiftName.add("200.000 VND");
		listGiftName.add("500.000 VND");
	}
	
}
