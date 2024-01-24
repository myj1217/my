package sec13.ex02;

import java.util.Stack;

public class StackMethodEx {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		System.out.println("스택: " + stack); // A, B, C
		
		String poppedItem = stack.pop();
		System.out.println("꺼낸 데이터: " + poppedItem); // C
		System.out.println("남아있는 데이터: " + stack); // A, B
		
		String peekedItem = stack.peek();
		System.out.println("위에 있는 데이터: " + peekedItem); // B
		System.out.println("현재 데이터: " + stack); // A, B
		
		System.out.println("스택이 비어있나요? " + stack.isEmpty()); // false
		System.out.println("스택 개수: " + stack.size()); // 2
		
		int index = stack.search("B");
		System.out.println("'B'의 위치: " + index); // 1
	}

}
