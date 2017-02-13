package com.dingfeng.common;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeUtils {
	
	public static Timestamp getDateTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		String dateString = sdf.format(date);
		return Timestamp.valueOf(dateString);
	}
}
