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
		//����Nowapi�ӿڷ�����������˺Žӿڵ���������,�˴����ٽ��в���
		/*TestNowapi tn = new TestNowapi();
		tn.start();*/
	}

}
