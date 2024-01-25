package sec14.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ConstructorEx {

	public static void main(String[] args) {
		// 매개변수가 없고 리턴값이 있는 메서드를 나타내는 함수형 인터페이스
		Supplier<List<String>> listSupplier = ArrayList::new;
		
		List<String> list = listSupplier.get();
		list.add("Hello");
		list.add("World");
		
		System.out.println(list);
	}

}
