package item;

import java.util.Iterator;

public class Music {
    String name;
    String singer;

    public Music(String name,String singer){
        this.name = name;
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public String getSinger() {
        return singer;
    }

    @Override
    public String toString() {
        return name +" - " + singer;
    }
}
