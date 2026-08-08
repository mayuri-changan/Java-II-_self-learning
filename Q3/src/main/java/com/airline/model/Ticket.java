package com.airline.model;

public class Ticket {

	private int id;
	private String passengerName;
	private String flightNo;
	private String source;
	private String destination;
	private String dateOfJourney;
	
	/*
	 * CREATE TABLE ticket ( id INT PRIMARY KEY AUTO_INCREMENT, passenger_name VARCHAR(100), flight_no VARCHAR(20), source VARCHAR(50), destination VARCHAR(50), date_of_journey DATE );
	 */

	public Ticket() {
	}

	public Ticket(int id, String passengerName, String flightNo, String source, String destination,
			String dateOfJourney) {
		this.id = id;
		this.passengerName = passengerName;
		this.flightNo = flightNo;
		this.source = source;
		this.destination = destination;
		this.dateOfJourney = dateOfJourney;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
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

	public String getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", passengerName=" + passengerName + ", flightNo=" + flightNo + ", source=" + source
				+ ", destination=" + destination + ", dateOfJourney=" + dateOfJourney + "]";
	}

}
