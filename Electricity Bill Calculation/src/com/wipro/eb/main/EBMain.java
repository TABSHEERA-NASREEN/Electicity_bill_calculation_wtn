package com.wipro.eb.main;

import java.util.Scanner;

import com.wipro.eb.service.ConnectionService;

public class EBMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter reading of previous month");
		int prevmonthreading=sc.nextInt();
		System.out.println("Enter reading of current month");
		int currmonthreading=sc.nextInt();
		System.out.println("Enter connection type");
		String type=sc.next();
		ConnectionService cs1=new ConnectionService();
		String result=cs1.generateBill(currmonthreading, prevmonthreading, type);
		System.out.println(result);
		sc.close();
	}

}
