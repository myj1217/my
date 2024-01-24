package sec13.ex02;

import java.util.Stack;

public class StackEx {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		// 스택에 데이터 추가
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println("스택: " + stack);
		
		// 스택에서 데이터 꺼내기
		int topValue = stack.pop();
		System.out.println("꺼낸 데이터: " + topValue);
		System.out.println("스택: " + stack);
	}

}
