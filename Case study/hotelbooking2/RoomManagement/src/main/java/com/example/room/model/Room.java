package com.example.room.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name="Room")

public class Room {

	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private String id;
		@Column(name="roomnumber")
	    private String roomNumber;
		
		@Column(name="no_of_guest")
	    private int numberOfGuests;
		@Column(name="price")
	    private double price;
		@Column(name="check_in_date")
	    private String checkInDate;
		@Column(name="check_out_date")
	    private String checkOutDate;
	
		
		
		public Room() {
			super();
			
		}
		public Room(String roomNumber, int numberOfGuests, double price, String checkInDate, String checkOutDate) {
			super();
			this.roomNumber = roomNumber;
			this.numberOfGuests = numberOfGuests;
			this.price = price;
			this.checkInDate = checkInDate;
			this.checkOutDate = checkOutDate;
		}
		public String getRoomNumber() {
			return roomNumber;
		}
		public void setRoomNumber(String roomNumber) {
			this.roomNumber = roomNumber;
		}
		public int getNumberOfGuests() {
			return numberOfGuests;
		}
		public void setNumberOfGuests(int numberOfGuests) {
			this.numberOfGuests = numberOfGuests;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getCheckInDate() {
			return checkInDate;
		}
		public void setCheckInDate(String checkInDate) {
			this.checkInDate = checkInDate;
		}
		public String getCheckOutDate() {
			return checkOutDate;
		}
		public void setCheckOutDate(String checkOutDate) {
			this.checkOutDate = checkOutDate;
		}
		
}
