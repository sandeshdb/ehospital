package com.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Snippet {
	public static void main(String[] args) throws ParseException {
String myTime = "17:45:00";
String endTime="14:45:00";
String m0=myTime.replace(":00", "");
String m1=m0.replace(":",".");
float m11=Float.parseFloat(m1);
String e0=endTime.replace(":00","");
String e1=e0.replace(":",".");
float e11=Float.parseFloat(e1);
System.out.println("******************");

SimpleDateFormat df = new SimpleDateFormat("hh:mm");
SimpleDateFormat df1 = new SimpleDateFormat("hh:mm a");

Calendar gc = new GregorianCalendar();
Date d=df.parse(myTime);
System.out.println(df1.format(d));
for(float i=m11;i>e11;i=i+0.30f){
	
	
	//System.out.println(d);
	gc.setTime(d);
	gc.add(Calendar.MINUTE,15);
	Date d2=gc.getTime();
		
	d=d2;
	System.out.println(df1.format(d2));
	

   }
	
	
	
	

}

	
}

