package com.codbking.calendar.exaple.types;

import android.support.annotation.ColorRes;

public class DateWithMark extends Date {
	@ColorRes int color;
	public DateWithMark(int _year, int _month, int _day, int _color) {
		super(_year, _month, _day);
		color = _color;
	}
	public DateWithMark(String s, int _color) {
		super(s);
		color = _color;
	}

	public int getColor() {
		return color;
	}
}
