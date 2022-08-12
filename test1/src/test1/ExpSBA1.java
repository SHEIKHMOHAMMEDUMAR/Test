package test1;

import java.util.Scanner;

public class ExpSBA1 {
	public static String name;
	public static String id;
	public static long phone;
	public static char grade;
	public static String address;
	
	public static void disp() {
		System.out.println("Name: " + name);
		System.out.println("Emp ID: " + id);
		System.out.println("Phone: " + phone);
		System.out.println("Grade: " + grade);
		System.out.println("Address: " + address);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name: ");
		name = sc.nextLine();
		System.out.println("Enter the Emp ID: ");
		id = sc.nextLine();
		System.out.println("Enter the phone: ");
		phone= Long.parseLong(sc.nextLine());
		System.out.println("Enter the grade: ");
		grade = sc.next().charAt(0);
		sc.nextLine();
		System.out.println("Enter the address: ");
		address = sc.nextLine();
		disp();
	}
}
