package jingjing.com.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class IOUtil {
    public static void write(String file, List<String> list) {
        try{
            String userDir = System.getProperty("user.dir");
            PrintWriter pw = new PrintWriter(userDir+"/"+file);
            for(String s:list){
                pw.println(s);
            }
            pw.close();
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
