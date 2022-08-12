package test1;

import java.util.Scanner;

public class Exp1 {
	
	public static void disp(int[] arra) {
		for(int x:arra) {
			System.out.print(x+" ");
		}
		System.out.println("");
	}
	
	public static void rotateL(int rot, int[] arr) {
		rot = rot%arr.length;
		int[] arr_t = new int[rot];
		for(int i=0;i<rot;i++) {
			arr_t[i] = arr[i];
		}
		
		for(int i=rot;i<arr.length;i++) {
			arr[i-rot] = arr[i];
		}

		for(int i=arr.length-rot;i<arr.length;i++) {
			arr[i] = arr_t[i-(arr.length-rot)];
		}
	}
	public static void rotateR(int rot, int[] arr) {
		int[] arr_t = new int[rot];
		for(int i=arr.length-rot;i<arr.length;i++) {
			arr_t[i-(arr.length-rot)] = arr[i];
		}
		
		for(int i=0;i<arr.length-rot;i++) {
			arr[rot+i] = arr[i];
		}

		for(int i=0;i<rot;i++) {
			arr[i] = arr_t[i];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an array: ");
		int s = sc.nextInt();
		System.out.println("Enter the elements of an array: ");
		int[] arr = new int[s];
		for(int i=0;i<s;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the rotation number: ");
		int r = sc.nextInt();
		System.out.println("Enter the type of rotation: ");
		String t = sc.next();
		System.out.println("Array Before rotation");
		disp(arr);
		if(t.equals("l") || t.equals("L")) {
			rotateL(r, arr);
			System.out.println("Array After rotation");
			disp(arr);
		}
		else if (t.equals("r") || t.equals("R")) {
			rotateR(r, arr);
			System.out.println("Array After rotation");
			disp(arr);
		}
	}
}
