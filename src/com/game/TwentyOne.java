package com.game;

import java.util.Random;

public class TwentyOne {

	
	public int getRandom() {
		Random random=new Random();
		return random.nextInt(13)+1;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<20;i++) {
			System.out.println(new TwentyOne().getRandom());
		}
	}
}
