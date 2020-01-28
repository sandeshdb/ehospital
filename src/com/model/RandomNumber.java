package com.model;

import java.util.Random;

public class RandomNumber {
	
	static Random ram=new Random();
	static int ram1=ram.nextInt(999999)+100000;
	public static int PrintRandomNumber(){
		
		while(true){
		ram1=ram.nextInt(999999)+100000;
		
		if(ram1>100000 && ram1 < 999999){
			
			break;
		}
		
	}
		return ram1;
	}
}
