package test1;

import java.util.Scanner;

public class ExpSBA2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your age: ");
		int age = sc.nextInt();
		System.out.println("Enter your country: ");
		String s = sc.next();
		if(s.equals("Indian") || s.equals("indian")) {
			if(age >= 18 && age <= 62) {
				System.out.println("Horrah, you are eligible for voting");
			}
			else {
				System.out.println("Sorry, you are not eligible for voting");
			}
		}
		else {
			System.out.println("Sorry, you are not an Indian");
		}
		
	}
}
