package org.cross.elsclient.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeUtil {
	public static String getCurrentTime(){
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}
	
	
}
