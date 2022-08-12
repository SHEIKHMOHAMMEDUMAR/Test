package test1;

import java.util.Scanner;

public class Exp2 {

	public static int sum(int c, int d) {
		return c+d;
	}
	
	public static void searchI(int t, int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(sum(arr[i],arr[j])==t) {
					System.out.print(i+" ");
					System.out.println(j+" ");
				}
			}
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
		System.out.println("enter the target number");
		int t = sc.nextInt();
		searchI(t,arr);
	}
}
