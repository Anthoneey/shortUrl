package space;

public class MainTest {

	public static void main(String[] args) {
	
		TestSuo ts = new TestSuo();
		ts.start();
		TestWeibo tw = new TestWeibo();
		tw.start();
		Test980 t9 = new Test980();
		t9.start();
		TestNi2 tn2 = new TestNi2();
		tn2.start();
		//由于Nowapi接口服务器对免费账号接口调用有限制,此处不再进行测试
		/*TestNowapi tn = new TestNowapi();
		tn.start();*/
	}

}
