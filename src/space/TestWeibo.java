package space;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestWeibo extends Thread {

	static String actionUrl = "http://api.t.sina.com.cn/short_url/shorten.json";
	static String APPKEY = "2815391962,31641035,3271760578,3925598208,917518064";
	static String url = "https://www.baidu.com/";
	
	@Override
	public void run() {
		long curtime = System.currentTimeMillis();
		int k = 0;
		for(int i = 0; i < 100; i++) {
//			System.out.println("TestNowapi:"+i+":"+sinaShortUrl(url+"i?"+i));
			String ret = sinaShortUrl(url+"i?"+i);
			if(ret==null || "".equals(ret))	k++;
		}
		System.out.println("TestWeibo耗时毫秒数："+(System.currentTimeMillis()-curtime)/1000+"。生成短网址失败个数："+k);
	}
	

	public String sinaShortUrl(String longUrl){
		longUrl = java.net.URLEncoder.encode(longUrl);
		String appkey = APPKEY;
		String[] sourceArray = appkey.split(",");
		for(String key:sourceArray){
			String shortUrl = sinaShortUrl(key,longUrl);
			if(shortUrl != null){
				return shortUrl;
			}
		}
		return null;
	}
	
	public String sinaShortUrl(String source, String longUrl){
		String result = HttpRequest.sendPost(actionUrl, "url_long="+longUrl+"&source="+source);
		if(result==null || "".equals(result)){
			return "";
		}
		JSONArray jsonArr = JSON.parseArray(result);
		JSONObject json = JSON.parseObject(jsonArr.get(0).toString());
		String ret = json.get("url_short").toString();
	    return ret;
	}	
	

}
