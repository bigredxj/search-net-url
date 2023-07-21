package jingjing.com.object;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: xujing
 * @description: TODO
 * @date: 2023-07-21 16:35
 * @version: 1.0
 */
@Data
public class XieppBean implements Comparable<XieppBean>{
    private String id;
    private String name;
    private Double score;

    @Override
    public int compareTo(XieppBean o) {
        return o.score.compareTo(this.score);
    }

    public String toString(){
        return score+" , "+name;
    }
}
