package com.qnbc.venueReservation.utils;

import com.qnbc.venueReservation.dto.DateDTO;
import com.qnbc.venueReservation.dto.PlanBean;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Description 获取本周日期
 * @Author gzj
 * @Date 2023/7/31 08:52
 * @Version 1.0
 **/

public class DateUtils {

	Calendar calendar = Calendar.getInstance();
	List<PlanBean> listData = new ArrayList<>();

	/**
	 * 日期对象转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date,String format){
		String result="";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		if(date!=null){
			result=sdf.format(date);
		}
		return result;
	}

	/**
	 * 字符串转日期对象
	 * @param str
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static Date formatString(String str,String format) throws Exception{
		if(StringUtil.isEmpty(str)){
			return null;
		}
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.parse(str);
	}

	public static String getCurrentDateStr(){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssSSSSSSSSS");
		return sdf.format(date);
	}

	public static String getCurrentDatePath()throws Exception{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd/");
		return sdf.format(date);
	}



	/**
	 * 判断今天是否是周末
	 */

	public static Boolean dayOfWeek(String date) {
		LocalDate parse = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		DayOfWeek dayOfWeek = parse.getDayOfWeek();
		String dayOfWeekName = dayOfWeek.name(); // 获取星期几的名字

		if ("SATURDAY".equals(dayOfWeekName) || "SUNDAY".equals(dayOfWeekName)) {
			return true;
		}
		return false;
	}


	/**
	 * 0 本周
	 * -1 上一周
	 * +1 下一周
	 *
	 * @param next 下一个
	 */
	public void UpWeek(int next) {
		//设置周一为每周第一天
		calendar.setFirstDayOfWeek(Calendar.MONDAY);

		//设置当前日期为本周的周一
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		//日期+7/-7
		calendar.add(Calendar.DATE, next * 7);
		loadWeekList();
	}

	//获取日期列表
	private void loadWeekList() {

		listData.clear();
		for (int i = 0; i < 7; i++) {
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			int week = calendar.get(Calendar.DAY_OF_WEEK);
			PlanBean planBean = new PlanBean();
			planBean.setDate(year + "-" + month + "-" + day);
			String weeks = getWeek(week);
			planBean.setWeek(weeks);
			planBean.setDay("" + day);
			listData.add(planBean);
			if (i == 6) {
//                设置玩数据重置日期为当前周一
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			} else {
				//日期递增
				calendar.add(Calendar.DATE, 1);
			}
		}
	}

	public static String getWeek(int week) {
		switch (week) {

			case 1:
				return "周一";
			case 2:
				return "周二";
			case 3:
				return "周三";
			case 4:
				return "周四";
			case 5:
				return "周五";
			case 6:
				return "周六";
			case 7:
				return "周日";
		}
		return "";
	}


	/**
	 * 获取未来任意天内的日期数组
	 *
	 * @param intervals intervals天内
	 * @return 日期数组
	 */
	public static ArrayList<DateDTO> futureDate(int intervals) {
		ArrayList<DateDTO> futureDaysList = new ArrayList<>();
		for (int i = 0; i < intervals; i++) {
			futureDaysList.add(getFutureDate(i));
		}
		return futureDaysList;
	}

	/**
	 * 获取未来第几天的日期
	 *
	 * @param past
	 * @return
	 */
	public static DateDTO getFutureDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(today);
		DateDTO dateDTO = new DateDTO();
		dateDTO.setDateRi(result);

		return getWeekOfDate(today, dateDTO);
	}

	/**
	 * 获取过去任意天内的日期数组
	 *
	 * @param intervals intervals天内
	 * @return 日期数组
	 */
	public static ArrayList<DateDTO> pastDate(int intervals) {
		ArrayList<DateDTO> pastDaysList = new ArrayList<>();
		for (int i = 0; i < intervals; i++) {
			pastDaysList.add(getPastDate(i));
		}
		return pastDaysList;
	}

	/**
	 * 获取过去第几天的日期
	 *
	 * @param past
	 * @return
	 */
	public static DateDTO getPastDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(today);
		DateDTO dateDTO = new DateDTO();
		dateDTO.setDateRi(result);
		return getWeekOfDate(today, dateDTO);
	}

	public static DateDTO getWeekOfDate(Date date, DateDTO dateDTO) {
		String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
		int[] weekDayNum = {7, 1, 2, 3, 4, 5, 6};
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
			w = 0;
		}
		dateDTO.setWeekRi(weekDays[w]);
		dateDTO.setIndex(weekDayNum[w]);
		return dateDTO;
	}


	/**
	 * 生成订单商品核销码
	 *
	 * @return
	 */
	public static String genVerifyCode() {
		String year = new SimpleDateFormat("yy").format(new Date());
		String day = String.format("%tj", new Date());
		double random = Math.random() * 10000000;
		while (random < 1000000) {
			random = Math.random() * 10000000;
		}
		int intRandom = Double.valueOf(random).intValue();
		String verifyCode = year + day + intRandom;
		return verifyCode;
	}


}
