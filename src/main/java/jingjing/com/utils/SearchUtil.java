package jingjing.com.utils;


import jingjing.com.object.XieppBean;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class SearchUtil {
    public static List<String> searchKey(String str, String key){

        List<String> result = new ArrayList<String>();
        if(str == null || key == null){
        }else {
            String[] ss = str.split("\n");
            String[] keys = key.split(",");
            for(int i=0;i<ss.length;i++){
                for(String k:keys) {
                    if (ss[i].contains(k)) {
                        result.add(ss[i]);
                    }
                }
            }
        }
        return result;
    }

    public static List<XieppBean> parseXieppHtml(String str) {
        List<XieppBean> xieppBeanList = new ArrayList<>();
        try {
            String[] ss = str.split("\n");
            for(int i=0;i<ss.length;i++){
                if(ss[i].contains("ah-rpxf lb_lr")){
                    XieppBean pp = new XieppBean();
                    String score = ss[i].trim();
                    if(score.contains("豆:")){
                        pp.setScore(Double.parseDouble(score.split("豆:")[1].split("<")[0]));
                    }

                    xieppBeanList.add(pp);
                    for(int j=1; j<100;j++){
                        if(ss[i+j].contains("<h4>")){
                            pp.setName(ss[i+j].trim());
                        }
                        if (ss[i+j].contains("lj-ojjv clearfix")) {
                            i=i+j;
                            break;
                        }
                    }

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return xieppBeanList;
    }

}
