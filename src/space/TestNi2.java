package space;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
public class TestNi2 extends Thread{
	static String ACTIONURL = "http://ni2.org/api/create.json";
	static String url = "https://www.baidu.com/";

	@Override
	public void run() {
		long curtime = System.currentTimeMillis();
		int k = 0;
		for(int i = 0; i < 100; i++) {
//			System.out.println("TestNi2:"+i+":"+getUrlJson(url+"i?"+i));
			String ret = getUrlJson(url+"i?"+i);
			if(ret==null || "".equals(ret))	k++;
		}
		System.out.println("TestNi2耗时毫秒数："+(System.currentTimeMillis()-curtime)/1000+"。生成短网址失败个数："+k);
	};

	public String getUrlJson(String url) {
		String ret = "";
		try {
			String longUrlSuo =  java.net.URLEncoder.encode(url,"utf-8");
			String result = HttpRequest.sendGet(ACTIONURL, "url="+longUrlSuo+"&format=json");
			if(result==null || "".equals(result)){
				return "";
			}		
			JSONObject json = JSON.parseObject(result);	
			ret = json.get("url").toString();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return ret;	
	}
}
