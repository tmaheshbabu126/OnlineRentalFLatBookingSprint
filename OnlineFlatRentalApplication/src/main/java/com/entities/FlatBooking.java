package com.entities;

//import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;
@Entity
@Table(name="MyFlatBooking")
	public class FlatBooking {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
		private long bookingId;
		/*
		 * // @OneToOne //@JoinColumn(name = "flatId") //private Flat flat; // @OneToOne
		 * //@JoinColumn(name = "tenant_id") //private Tenant tenantId;
		 */	    
	    @NotNull
		private String bookingFromDate;
	    @NotNull
		private String bookingToDate;
		public long getBookingId() {
			return bookingId;
		}
		public void setBookingId(long bookingId) {
			this.bookingId = bookingId;
		}
		public String getBookingFromDate() {
			return bookingFromDate;
		}
		public void setBookingFromDate(String bookingFromDate) {
			this.bookingFromDate = bookingFromDate;
		}
		public String getBookingToDate() {
			return bookingToDate;
		}
		public void setBookingToDate(String bookingToDate) {
			this.bookingToDate = bookingToDate;
		}
		@Override
		public String toString() {
			return "FlatBooking [bookingId=" + bookingId + ", bookingFromDate=" + bookingFromDate + ", bookingToDate="
					+ bookingToDate + "]";
		}
	
		
		
}