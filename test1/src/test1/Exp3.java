package test1;

import java.util.Scanner;

public class Exp3 {
	public static boolean isBalanced(String a) {
		int count = 0;
		if(a.charAt(0) == ')') {
			return false;
		}
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i) == '(') {
				count++;
			}
			else if(a.charAt(i) == ')') {
				count--;
			}
		}
		if(count!=0) {
			return false;
		}
		else {
			return true;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the test case");
		String s = sc.next();
		if(isBalanced(s)) {
			System.out.println("Balanced");
		}
		else {
			System.out.println("Not Balanced");
		}
	}
}
