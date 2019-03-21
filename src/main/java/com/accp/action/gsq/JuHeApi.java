package com.accp.action.gsq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
* @ClassName: JuHeApi 
* @Description: 聚合数据API（身份证+电话号+天气）
* @author 筠颜
* @date 2019年3月19日 上午11:03:58 
*
 */
@RestController
@RequestMapping("/http")
public class JuHeApi {
	/**
	 * 
	    * @Title: queryCardInfo
	    * @Description: 身份证
	    * @param @param cardno
	    * @param @return
	    * @param @throws Exception    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping(method = RequestMethod.GET, value = "cardno", produces = "text/html;charset=UTF-8") // 非常重要
	public String queryCardInfo(String cardno) throws Exception {
		BufferedReader br = null;
		StringBuffer data = new StringBuffer();
		try {
			String key = "b2f0143880445388a1bdcb41ddcbb037";
			// 1.定义标识符
			URL url = new URL("http://apis.juhe.cn/idcard/index?key="+key+"&cardno=" + cardno);
			// 2.获得连接资源
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			// 3.设置连接信息
			httpConn.setRequestMethod("GET");
			httpConn.setReadTimeout(50 * 1000);
			httpConn.setConnectTimeout(4 * 1000);
			// 4.开始连接
			httpConn.connect();
			// 5.接收响应信息
			int rsCode = httpConn.getResponseCode();
			switch (rsCode) {
			case HttpURLConnection.HTTP_OK:
				// 6.利用流处理数据
				// 高级字符流
				br = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
				for (String rs; (rs = br.readLine()) != null;) {
					data.append(rs);
				}
				break;
			case HttpURLConnection.HTTP_NOT_FOUND:
				break;
			case HttpURLConnection.HTTP_INTERNAL_ERROR:
				break;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return data.toString();
	}
	/**
	 * 
	    * @Title: queryPhoneInfo
	    * @Description: 电话号码
	    * @param @param phone
	    * @param @return
	    * @param @throws Exception    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping(method = RequestMethod.GET, value = "phone", produces = "text/html;charset=UTF-8") // 非常重要
	public String queryPhoneInfo(String phone) throws Exception {
		BufferedReader br = null;
		StringBuffer data = new StringBuffer();
		try {
			String key = "ebf8e037343c4270b009de6dcf5785b4";
			// 1.定义标识符
			URL url = new URL("http://apis.juhe.cn/mobile/get?key="+key+"&phone=" + phone);
			// 2.获得连接资源
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			// 3.设置连接信息
			httpConn.setRequestMethod("GET");
			httpConn.setReadTimeout(50 * 1000);
			httpConn.setConnectTimeout(4 * 1000);
			// 4.开始连接
			httpConn.connect();
			// 5.接收响应信息
			int rsCode = httpConn.getResponseCode();
			switch (rsCode) {
			case HttpURLConnection.HTTP_OK:
				// 6.利用流处理数据
				// 高级字符流
				br = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
				for (String rs; (rs = br.readLine()) != null;) {
					data.append(rs);
				}
				break;
			case HttpURLConnection.HTTP_NOT_FOUND:
				break;
			case HttpURLConnection.HTTP_INTERNAL_ERROR:
				break;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return data.toString();
	}
	
	/**
	 * 
	    * @Title: queryTianqiInfo
	    * @Description: 天气
	    * @param @param city
	    * @param @return
	    * @param @throws Exception    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping(method = RequestMethod.GET, value = "tianqi", produces = "text/html;charset=UTF-8") // 非常重要
	public String queryTianqiInfo(String city) throws Exception {
		BufferedReader br = null;
		StringBuffer data = new StringBuffer();
		try {
			String key = "1bb4acbc55e5020f9731d1231a16fb42";
			// 1.定义标识符
			URL url = new URL("http://apis.juhe.cn/simpleWeather/query?key="+key+"&city=" + city);
			// 2.获得连接资源
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			// 3.设置连接信息
			httpConn.setRequestMethod("GET");
			httpConn.setReadTimeout(50 * 1000);
			httpConn.setConnectTimeout(4 * 1000);
			// 4.开始连接
			httpConn.connect();
			// 5.接收响应信息
			int rsCode = httpConn.getResponseCode();
			switch (rsCode) {
			case HttpURLConnection.HTTP_OK:
				// 6.利用流处理数据
				// 高级字符流
				br = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
				for (String rs; (rs = br.readLine()) != null;) {
					data.append(rs);
				}
				break;
			case HttpURLConnection.HTTP_NOT_FOUND:
				break;
			case HttpURLConnection.HTTP_INTERNAL_ERROR:
				break;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return data.toString();
	}
}
