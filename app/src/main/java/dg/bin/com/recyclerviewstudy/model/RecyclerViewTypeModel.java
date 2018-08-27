package dg.bin.com.recyclerviewstudy.model;

import java.io.Serializable;

/**
 * Created by b on 2018/8/22.
 */

public class RecyclerViewTypeModel implements Serializable {

    String name;
    String content;
//    Class cla;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public Class getCla() {
//        return cla;
//    }
//
//    public void setCla(Class cla) {
//        this.cla = cla;
//    }
}
