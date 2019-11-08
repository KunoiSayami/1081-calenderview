package com.codbking.calendar.exaple.types;

import android.util.Log;

import com.codbking.calendar.CalendarBean;

public class Date {
	private static String TAG = "log_Date";
	int year, month, day;
	Date(int _year, int _month, int _day) {
		year = _year;
		month = _month;
		day = _day;
	}

	Date(CalendarBean bean) {
		year = bean.year;
		month = bean.moth;
		day = bean.day;
	}

	// NOTE: test only
	Date(String str) {
		/*if (!BuildConfig.DEBUG)
			throw new RuntimeException("This code is for debug only");*/
		String[] s = str.split("/");
		year = Integer.parseInt(s[0]);
		month = Integer.parseInt(s[1]);
		day = Integer.parseInt(s[2]);
		Log.d(TAG, "Date: date is " + year + "/" + month +"/" + day);
	}

	public boolean equals(Date date) {
		return (year == date.year && month == date.month && day == date.day);
	}

	public boolean equals(CalendarBean bean) {
		return new Date(bean).equals(this);
	}
}
