package TestClass;

/* https://blog.hyper-link.kr/2011/11/24/java-class-for-name/
 * 
 * string [] args는 스트링 타입의 배열인 args를 선언한것으로서
 * 자바를 실행시에 넣는 인수값을 받습니다. (규칙)
 * 실행시에 java 클래스 이름이 a, b, c 클래스가 있으면
 * args[0]="a"; args[1]="b" 이런식으로 들어가게 됩니다.
 * 
 *  즉석김밥집을 예로 들어보죠.
	즉석김밥집의 주인은 손님이 어떤 김밥 종류를 원하는지 모릅니다.
	(어떤 클래스가 들어올지 모른다.)
	
	참치김밥을 원하는 손님이 와서 주문을 하면 주인은 그 자리에서 참치 김밥을 만들어 주고,
	일반김밥을 원하는 손님이 와서 주문을 하면 주인은 그 자리에서 일반 김밥을 만들어 주죠.
	(김밥 종류가 2가지 밖에 생각이 안나네요 ㅎㅎ)
	
	즉 주인은 어떤 손님이 올지 모르기 때문에 김밥을 만들어 둘 수 없죠
	( 미리 만들어 두면 즉석김밥이 아니니까.ㅎㅎ)
	
	여기서 코드로 다시 돌아가보면
	미리 만들어 둔 김밥은 String str=new String(“미리 만들어 둔 김밥”);
	즉석에서 만든 김밥은 Class.forName(“즉석에서 만든 김밥 Class”);
*/


// 왜인지 args[0]가 안들어와서 (들어온다고는 되있지만) 직접 그자리에 클래스 이름을 넣어서 진행함
public class TestClass {
	public static void main(String args[]) {

			try {
				Class classExample = null;
				classExample = Class.forName(TestClass.class.getPackage().getName() + ".LoadClass"); // 메모리로 로드(물리적경로)

				System.out.println(LoadClass.getStaticstr());	   // 정적 변수 로딩 되었습니다. 

				try {

					Object obj = classExample.newInstance();       // 여기서 객체가 생성 됨. (생성자호출)
					System.out.println(LoadClass.getStaticstr());  // 동적 로딩 성공과 객체 생성 됨

				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
	}
}
/* 출력결과
정적 변수 로딩 되었습니다.
이제 객체가 생성 되었으며 생성자가 호출되었습니다.
동적 로딩 성공과 객체 생성 됨
*/