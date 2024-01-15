package sec02.ex01;

public class Scope01 {

	public static void main(String[] args) {
		int x = 10;
        if (true) {
           
            System.out.println("x = " + x);
        }
        
        System.out.println("x = " + x);
	}

}
