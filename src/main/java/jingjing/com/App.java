package jingjing.com;

import jingjing.com.http.HttpClientService;
import jingjing.com.utils.IOUtil;
import jingjing.com.utils.SearchUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        String originUrl = "https://cl.oadjkq.com/thread0806.php?fid=25&search=&page=replace_page";
        HttpClientService httpClientService = new HttpClientService();
        String charSet = "gbk";
        httpClientService.setCharSet(charSet);
        String url = null;
        String html = "";

        String key ="泄密";
        List<String> list = new ArrayList<String>();
        List<String> result = new ArrayList<String>();


        for(int i=2;i<=100;i++){
            System.out.print(i+",");
            url = originUrl.replace("replace_page",i+"");
            httpClientService.setUrl(url);
            html = httpClientService.doGet();
            list = SearchUtil.searchKey(html,key);
            for(String s:list){
                System.out.println(s);
            }

            result.addAll(list);
        }
        IOUtil.write("result.txt",result);
        httpClientService.close();

    }
}
