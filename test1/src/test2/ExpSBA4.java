package test2;

import test1.ExpSBA3;
class Callprotected extends ExpSBA3{
	public void Callprotect() {
		System.out.println(c);
	}
}
public class ExpSBA4 {
	public static void main(String[] args) {
		ExpSBA3 e1 = new ExpSBA3();
		Callprotected c1 = new Callprotected();
		System.out.println(e1.a);
		c1.Callprotect();
	}
}
