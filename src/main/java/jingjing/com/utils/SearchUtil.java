package jingjing.com.utils;

import org.apache.commons.codec.binary.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SearchUtil {
    public static List<String> searchKey(String str, String key){

        List<String> result = new ArrayList<String>();
        if(str == null || key == null){
        }else {
            String[] ss = str.split("\n");

            for(int i=0;i<ss.length;i++){
                if(ss[i].contains(key)){
                    result.add(ss[i]);
                }
            }
        }
        return result;
    }
}
