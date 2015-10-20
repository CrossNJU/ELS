package org.cross.elsclient.util;

public class Time {
	public int year;
	public int month;
	public int day;
	public int hour;
	public int min;
	public int seconds;
	
	public Time(int year, int month, int day, int hour,
			int min, int seconds){
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.min = min;
		this.seconds = seconds;
	}
	
	public Time(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
}
