package com.entstudy.info.platform.qrtz.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: HttpClientUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liwt
 * @date 2016年7月23日 下午6:18:03
 * 
 */
public final class HttpClientUtil {

	private static final Logger logger = LoggerFactory
			.getLogger(HttpClientUtil.class);

	public static boolean sendShortMessage(String url, String phoneNumber,
			String content) {
		boolean sendFlag = false;
		JSONObject json = null;
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httpget
		HttpPost httpost = new HttpPost(url);
		// + "mobile=" + phoneNumber + "&msg_content=" + content
		CloseableHttpResponse response = null;
		try {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			NameValuePair pair1 = new BasicNameValuePair("mobile", phoneNumber);
			NameValuePair pair2 = new BasicNameValuePair("msg_content", content);
			nvps.add(pair1);
			nvps.add(pair2);
			httpost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
			response = httpclient.execute(httpost);
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					json = JSONObject.fromObject(EntityUtils.toString(entity,
							"UTF-8"));
					int code = json.getInt("code");
					if (code == 0) {
						sendFlag = true;
					} else {
						logger.error("短信发送失败，失败原因：" + json.getString("detail"));
					}
				} else {
					logger.error("发送短信通知异常,没有正常返回状态码");
				}
			}
		} catch (Exception e) {
			logger.error("发送短信通知异常：", e);
		} finally {
			// 关闭连接,释放资源
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				logger.debug("关闭HttpClient流出现异常：", e);
			}
		}
		return sendFlag;

	}
}
