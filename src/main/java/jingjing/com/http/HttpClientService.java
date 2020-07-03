package jingjing.com.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpClientService {
    //1.生成httpclient，相当于该打开一个浏览器
    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private CloseableHttpResponse response = null;
    private String url = null;
    private String charSet = "UTF-8";

    public HttpClientService(){
    }

    public  String doGet() {
        //2.创建get请求，相当于在浏览器地址栏输入 网址
        HttpGet request = new HttpGet(url);
        //request.setHeader("Accept","application/x-www-form-urlencoded;charset=utf-8");
        String html = null;
        try {
            //3.执行get请求，相当于在输入地址栏后敲回车键
            response = httpClient.execute(request);
            //4.判断响应状态为200，进行处理
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //5.获取响应内容
                HttpEntity httpEntity = response.getEntity();
                html = EntityUtils.toString(httpEntity,charSet);
            } else {
                //如果返回状态不是200，比如404（页面不存在）等，根据情况做处理，这里略
                System.out.println("返回状态不是200");
                System.out.println(EntityUtils.toString(response.getEntity(), charSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
            close();
        }
        return html;
    }

    public void close(){
        HttpClientUtils.closeQuietly(response);
        HttpClientUtils.closeQuietly(httpClient);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCharSet() {
        return charSet;
    }

    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }
}
