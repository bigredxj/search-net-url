package jingjing.com;

import jingjing.com.utils.HttpClientUtil;

public class Test {
    public static void main( String[] args ) {
        String str = "my name is 徐静\n，有人叫徐静吗";
        System.out.println(str);
        String key = "徐静";
        int len = str.length();
        int index = str.indexOf(key);
        System.out.println(index);

        String html = HttpClientUtil.doGet("https://cc.6pbk.icu/thread0806.php?fid=4&search=&page=52","gbk");
        String[] ss = html.split("\n");

        for(int i=0;i<ss.length;i++){
            if(ss[i].contains("西洋")){
                System.out.println(ss[i]);
            }
        }

    }
}
