package org.beanstalk4j.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class IsoDateTimeFormat {
	
	/* Did you know that SimpleDateFormat is not thread-safe? */
	private static final SimpleDateFormat isodate = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat isodatetime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	
	public static synchronized Date parseDate(String source) {
		Date date = null;
		try {
			date = isodate.parse(source);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
		return date;
	}
	
	public static synchronized String formatDate(Date date) {
		return isodate.format(date);
	}
	
	public static synchronized Date parseDateTime(String source) {
		Date date = null;
		try {
			date = isodatetime.parse(source);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
		return date;
	}
	
	public static synchronized String formatDateTime(Date date) {
		return isodatetime.format(date);
	}
	

}
