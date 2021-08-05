package com.cabformula.bean;

public class ReviewBean {
	private int id;
	private int book_id;
	private int driver_id;
	private String review;
	private String date;
	
	
	public int getId() {
		return id;
	}
	public void setId(int review_id) {
		this.id = review_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
