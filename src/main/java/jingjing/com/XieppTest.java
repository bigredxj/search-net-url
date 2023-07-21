package jingjing.com;

import jingjing.com.http.HttpClientService;
import jingjing.com.object.XieppBean;
import jingjing.com.utils.IOUtil;
import jingjing.com.utils.SearchUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: xujing
 * @description: TODO
 * @date: 2023-07-21 15:35
 * @version: 1.0
 */
public class XieppTest {

    public static void main( String[] args ) {
        String originUrl = "https://www.xiepp.cc/label/zgdl-replace_page/";
        HttpClientService httpClientService = new HttpClientService();
        String charSet = "gbk";
        httpClientService.setCharSet(charSet);
        String url = null;
        String html = "";

        String key ="泄密";
        List<String> list = new ArrayList<String>();
        List<String> result = new ArrayList<String>();


        List<XieppBean> xieppBeanList = new ArrayList<>();
        for(int i=15;i<=15;i++){
            System.out.print(i+",");
            url = originUrl.replace("replace_page",i+"");
            httpClientService.setUrl(url);
            html = httpClientService.doGet();
            xieppBeanList.addAll(SearchUtil.parseXieppHtml(html));
        }

        Collections.sort(xieppBeanList);

        List<String> resultList = xieppBeanList.stream().map(x->x.toString()).collect(Collectors.toList());


        IOUtil.write("xiepp_result.txt",resultList);

        httpClientService.close();

        System.out.println(">>>>>>>>end<<<<<<<<<<<<<<<<<<");

    }
}
