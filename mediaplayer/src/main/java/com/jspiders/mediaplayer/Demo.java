package com.jspiders.mediaplayer;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter length of the String : ");
		int n = sc.nextInt();
		System.out.println("Enter the number");
		String s = sc.next();
		int a = Integer.parseInt(s);
		int temp = a;
		int sum = 0;
		while(a>0) {
			int b = a%10;
			sum = sum+b;
			a = a/10;
		}
		if (sum==n) {
			System.out.println(sum);
		}
		else {
			System.out.println(0);
		}
	}

}
