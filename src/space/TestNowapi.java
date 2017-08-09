package space;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class TestNowapi extends Thread {

	static String SIGN = "4a9331cccbc3ff30dde78d0b51fb4239";
	static String APPKEY = "26835";
	static String actionUrl = "http://api.k780.com/?app=shorturl.set";
	static String url = "https://www.baidu.com/";   
	
	@Override
	public void run() {
		long curtime = System.currentTimeMillis();
		int k = 0;
		for(int i = 0; i < 100; i++) {
//			System.out.println("TestNowapi:"+i+":"+getShortUrl(url+"i?"+i));
			String ret = getShortUrl(url+"i?"+i);
			if(ret==null || "".equals(ret)) k++;
		}
		System.out.println("TestNowapi耗时毫秒数："+(System.currentTimeMillis()-curtime)/1000+"。生成短网址失败个数："+k);
	};
	
	 
	public String getShortUrl(String longUrl) {
		String ret = "";
		try{
			String result = HttpRequest.sendPost(actionUrl,
					"url=" + longUrl + "&appkey=" + APPKEY + "&sign=" + SIGN + "&format=json");
			if (result == null || "".equals(result)) {
				return "";
			}
			JSONObject jsonObj = JSON.parseObject(result);
			JSONObject json = JSON.parseObject(jsonObj.get("result").toString());
			ret = json.get("short_url").toString();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	 
}
