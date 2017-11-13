package com.game;

import java.util.Random;

public class GuessNumber {

	private int count = 0;
	private int answerNumber = new Random().nextInt(100) + 1;

	public int getCount() {
		return count;
	}

	public int getAnswerNumber() {
		return answerNumber;
	}
	


	public int guess(int number) {
		this.count++;

		int flag = 0;
		if (number > answerNumber) {
			flag = 1;
		} else if (number < answerNumber) {
			flag = -1;
		} else {
			flag = 0;
		}

		return flag;
	}

	// @SuppressWarnings("resource")
	// public static void main(String[] args) {
	// GuessNumber guessNumber = new GuessNumber();
	// int state;
	//
	// guess:
	// for(;;){
	// System.out.print("请输入一个数(100以内):");
	// int num=new Scanner(System.in).nextInt();
	// state=guessNumber.guess(num);
	// switch (state) {
	// case 1:
	// System.out.println("大了");
	// break;
	// case -1:
	// System.out.println("小了");
	// break;
	// case 0:
	// System.out.println("恭喜你！！猜中了");
	// System.out.println("正确答案是:"+guessNumber.answerNumber);
	// System.out.println("你共猜了 "+guessNumber.count+" 次");
	// break guess;
	// }
	//
	// }
	// }
}
