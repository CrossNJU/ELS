package org.cross.elsclient.util;

public class CompareTime {
	
	public static int compare(String first, String second){
		MyTime time1 = getTime(first);
		MyTime time2 = getTime(second);
		return time1.compareWith(time2);
	}
	
	public static MyTime getTime(String time){
		String[] temp = time.split(" ");
		String[] temp1 = temp[0].split("-");
		String[] temp2 = temp[1].split(":");
		
		return new MyTime(Integer.parseInt(temp1[0]), Integer.parseInt(temp1[1]), 
				Integer.parseInt(temp1[2]), Integer.parseInt(temp2[0]), 
				Integer.parseInt(temp2[1]), Integer.parseInt(temp2[2]));
	}
}
