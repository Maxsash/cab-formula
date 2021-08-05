package com.cabformula.bean;

public class BookingBean {
	private int id;
	private String source;
	private String destination;
	private String book_date;
	private String trip_date;
	private int days;
	private int round_trip; //boolean
	private String status; //unused
	private int cost;
	private String name;
	private String email;
	private String gender;
	private int age;
	private String mobile;
	private int reviewed; //boolean
	private int car_id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int book_id) {
		this.id = book_id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getBook_date() {
		return book_date;
	}
	public void setBook_date(String book_date) {
		this.book_date = book_date;
	}
	public String getTrip_date() {
		return trip_date;
	}
	public void setTrip_date(String trip_date) {
		this.trip_date = trip_date;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getRound_trip() {
		return round_trip;
	}
	public void setRound_trip(int round_trip) {
		this.round_trip = round_trip;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getReviewed() {
		return reviewed;
	}
	public void setReviewed(int reviewed) {
		this.reviewed = reviewed;
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	
	

}
