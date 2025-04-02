package Javapackage;

public class staticnonstatic {
    int roll = 10 ;
    static String name ="shreya";
    String college;
    
    public void method1() {
    	roll = 5;
    	System.out.println(roll);
    }
    
    public static void method2() {
    	int roll = 3;
    	System.out.println(roll);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		staticnonstatic s2 = new staticnonstatic();
		method2();
		s2.method1();
		System.out.println(s2.college);

	}

}
