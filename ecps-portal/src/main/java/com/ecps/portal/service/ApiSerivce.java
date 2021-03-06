package com.ecps.portal.service;

import com.ecps.portal.httpclient.HttpResult;
import org.apache.commons.collections.MapUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 封装对外访问API接口的service
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-04 上午 02:56
 */
@Service
public class ApiSerivce implements BeanFactoryAware {

    /* @Autowired
     private CloseableHttpClient httpClient;*/
    private BeanFactory beanFactory;

    @Autowired
    private RequestConfig requestConfig;

    /**
     * GET请求(不带参数)
     * 响应200，返回响应的内容， 响应404 或者 500， 返回null
     *
     * @param url
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public String doGET(String url) throws ClientProtocolException, IOException {

        // 创建http GET请求
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(this.requestConfig);
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = getHttpClient().execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("内容长度：" + content.length());
            }
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return null;
    }

    /**
     * doGet请求(带参数)
     * 响应200，返回响应的内容， 响应404 或者 500， 返回null
     *
     * @param url
     * @param params
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @throws URISyntaxException
     */
    public String doGet(String url, Map<String, String> params) throws ClientProtocolException, IOException, URISyntaxException {
        // 定义请求参数
        URIBuilder uriBuilder = new URIBuilder();
        if (MapUtils.isEmpty(params)) {
            return this.doGET(url);
        }
        for (Map.Entry<String, String> entry : params.entrySet()) {
            uriBuilder.setParameter(entry.getKey(), entry.getValue());
        }
        return this.doGET(uriBuilder.build().toString());
    }

    /**
     * doPost请求(带参数)
     * 响应200，返回响应的内容， 响应404 或者 500， 返回null
     *
     * @param url
     * @param params
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public HttpResult doPost(String url, Map<String, String> params) throws ClientProtocolException, IOException {

        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(this.requestConfig);

        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        if (MapUtils.isNotEmpty(params)) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                parameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = getHttpClient().execute(httpPost);
            return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), "UTF-8"));

        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    /**
     * doPost请求(不带参数)
     * 响应200，返回响应的内容， 响应404 或者 500， 返回null
     *
     * @param url
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public HttpResult doPost(String url) throws ClientProtocolException, IOException {
        return this.doPost(url, null);
    }

    // 通过beanFactory来创建HttpClient对象
    private CloseableHttpClient getHttpClient() {
        return beanFactory.getBean(CloseableHttpClient.class);
    }

    @Override
    // 该方法在spring 容器初始化时调用该方法，传入beanFactory
    // 用来解决service单例中使用 HttpClient多例
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
