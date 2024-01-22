package sec11.ex01;

public class MemberEx {

   public static void main(String[] args) {
      Member member1 = new Member("Alice", 25);
      Member member2 = new Member("June", 30);
      Member member3 = new Member("Alice", 25);

      System.out.println(member1);
      System.out.println(member2);
      System.out.println(member3);
        
   }
}
   class Member {
       private String name;
       private int age;

       public Member(String name, int age) {
           this.name = name;
           this.age = age;
       }
   

      @Override
      public String toString() {
         return "Member [name=" + name + ", age=" + age + "]";
      }


      @Override
       public boolean equals(Object obj) {
          if(obj instanceof Member) {      // 매개값이 Person 타입인지 확인합니다
             Member member = (Member) obj;   // Person 타입으로 변환하고 
             if(name.equals(member.name)) {   // name필드값이 동일한지 검사 후
                return true;         // 동일 하면 true를 반환합니다
             }
          }
          return false;            // 매개값이 Person 타입이 아니거나 
                            // name필드값이 다른 경우 false를 반환합니다
       }
       @Override
       public int hashCode() {
          // name필드값이 null이 아니면 name.hashCode를 호출
           int result = name != null ? name.hashCode(): 0;
           result = 31 * result + age;
           return result;
       }
   }