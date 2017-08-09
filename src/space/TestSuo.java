package space;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TestSuo extends Thread{
	

	static String actionUrl = "http://suo.im/api.php";
	static String url = "https://www.baidu.com/";
	
	@Override
	public void run() {
		long curtime = System.currentTimeMillis();
		int k = 0;
		
		for(int i = 0; i < 100; i++) {
//			System.out.println("TestNowapi:"+i+":"+getUrl(url+"i?"+i));
			String ret = getUrl(url+"i?"+i);
			if(ret==null || "".equals(ret))	k++;
		}
		System.out.println("TestSuo耗时毫秒数："+(System.currentTimeMillis()-curtime)/1000+"。生成短网址失败个数："+k);
	}
	
	public String getUrl(String longUrl) {
		String ret = "";
		try {
			String longUrlSuo =  java.net.URLEncoder.encode(longUrl,"utf-8");
			String result = HttpRequest.sendGet(actionUrl, "format=json&url="+longUrlSuo);
			if(result==null || "".equals(result)){
				return "";
			}		
			JSONObject json = JSON.parseObject(result);	
			return json.get("url").toString();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return ret;	
	}
	
	
	
}
;