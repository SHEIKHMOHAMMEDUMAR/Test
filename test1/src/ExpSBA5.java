class St {
	private static St s = null;
	
	private St() {}
	
	public static St getObj() {
		if (s == null)
			s = new St();
		
		return s;
	}
}
public class ExpSBA5 {
	public static void main(String[] args) {
		St s1 = St.getObj();
		St s2 = St.getObj();
		
		System.out.println("Hashcode for obj1: " + s1.hashCode());
		System.out.println("Hashcode for obj2: " + s2.hashCode());
		System.out.println("Therefore, they both reference the same object");
	}
}