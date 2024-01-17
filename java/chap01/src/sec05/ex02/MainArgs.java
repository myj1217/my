package sec05.ex02;

public class MainArgs {

	public static void main(String[] args) {
		// args : JVM의 entry point
		int length = args.length;
		System.out.println("인자의 개수: " + length);
		
		for (int i = 0; i < length; i++) {
			System.out.println("인자 #" + (i + 1) + ": " + args[i]);
		}
	}

}
