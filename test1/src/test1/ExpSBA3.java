package test1;
public class ExpSBA3 {
	
	public String a = "Public";
	String b = "Default";
	protected String c = "Protected";
	private String d = "Private";
	
	public static void disp_private() {
		ExpSBA3 e1 = new ExpSBA3();
		System.out.println(e1.d);
	}
	
	public static void main(String[] args) {
		ExpSBA3 e1 = new ExpSBA3();
		System.out.println(e1.a);
		System.out.println(e1.b);
		System.out.println(e1.c);
		System.out.println(e1.d);
		e1.disp_private();
		Calldefault c1 = new Calldefault();
		c1.disp();
	}
}

class Calldefault {
	ExpSBA3 e1 = new ExpSBA3(); 
	public void disp() {
		// calling default access variable. 
		System.out.println(e1.b);
	}
}