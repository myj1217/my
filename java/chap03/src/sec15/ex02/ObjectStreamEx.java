package sec15.ex02;

import java.io.*;

public class ObjectStreamEx {

	public static void main(String[] args) {
		String fileName = "object.dat";
		
		// 객체를 파일에 저장
		try (ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(fileName))) {
			Student student = new Student("윤혁", 32, "Computer Science");
			oos.writeObject(student);
			System.out.println("개체가 성공적으로 기록되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 객체를 파일에서 읽어옴
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			Student loadedStudent = (Student) ois.readObject();
			System.out.println("개체 읽기 성공: ");
			System.out.println(loadedStudent);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

//시리얼라이즈 가능한(Student 클래스에 implements Serializable 필요)
class Student implements Serializable {
	private String name;
	private int age;
	private String major;
	
	public Student(String name, int age, String major) {
		this.name = name;
		this.age = age;
		this.major = major;
	}
	
	@Override
	public String toString() {
		return "Student{" +
             "name='" + name + '\'' +
             ", age=" + age +
             ", major='" + major + '\'' +
             '}';
     }
}