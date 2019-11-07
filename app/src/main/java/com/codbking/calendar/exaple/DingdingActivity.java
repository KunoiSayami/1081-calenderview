package com.codbking.calendar.exaple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.codbking.calendar.CaledarAdapter;
import com.codbking.calendar.CalendarBean;
import com.codbking.calendar.CalendarDateView;
import com.codbking.calendar.CalendarUtil;
import com.codbking.calendar.CalendarView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.codbking.calendar.exaple.Utils.px;


public class DingdingActivity extends AppCompatActivity {

	@BindView(R.id.calendarDateView)
	CalendarDateView mCalendarDateView;
	@BindView(R.id.list)
	ListView mList;
	@BindView(R.id.txtCalendarTitle)
	TextView mTitle;

	private static String TAG = "log_dingding";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dingding);
		ButterKnife.bind(this);

		mCalendarDateView.setAdapter(new CaledarAdapter() {
			@Override
			public View getView(View convertView, ViewGroup parentView, CalendarBean bean) {
				TextView view;
				if (convertView == null) {
					convertView = LayoutInflater.from(parentView.getContext()).inflate(R.layout.item_calendar, null);
					ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(px(55), px(55));
					convertView.setLayoutParams(params);
				}

				view = (TextView) convertView.findViewById(R.id.text);

				view.setText(String.valueOf(bean.day));
				if (bean.mothFlag != 0) {
					view.setTextColor(getResources().getColor(R.color.calendarWeekTitle));
				} else {
					view.setTextColor(getResources().getColor(R.color.calendarBlack));
				}

				return convertView;
			}
		});

		mCalendarDateView.setOnItemClickListener(new CalendarView.OnItemClickListener() {
			@Override
			public void onItemClick(View view, int postion, CalendarBean bean) {
				mTitle.setText(getMonthString(bean.moth));
			}
		});

		int[] data = CalendarUtil.getYMD(new Date());
		mTitle.setText(getMonthString(data[1]));

		mList.setAdapter(new BaseAdapter() {
			@Override
			public int getCount() {
				return 100;
			}

			@Override
			public Object getItem(int position) {
				return null;
			}

			@Override
			public long getItemId(int position) {
				return 0;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				if (convertView == null) {
					convertView = LayoutInflater.from(DingdingActivity.this).inflate(android.R.layout.simple_list_item_1, null);
				}

				TextView textView = (TextView) convertView;
				textView.setText("item" + position);

				return convertView;
			}
		});

	}
	private
	String getMonthString(int num) {
		Log.d(TAG, "getMonthString: num => " + num);
		if (BuildConfig.DEBUG && !(num > 0 && num < 13)) {
			throw new AssertionError();
		}
		return getResources().getStringArray(R.array.month)[num - 1];
	}

}
