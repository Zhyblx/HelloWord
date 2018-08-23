package src.hellointerface;

import java.util.List;

public interface HelloInterface<E> {

//    public static final String STRING[]=
//            new String[]{"\u6784\u9020\u65b9\u6cd5" , "\u62bd\u8c61\u65b9\u6cd5" , "\u5f20\u76ca\u658c\uff0c\u6de1\u5b9a" , "\u62bd\u8c61\u7c7b\u5b9e\u4f8b\u5316\u5bf9\u8c61\u5fc5\u987b\u901a\u8fc7\u5b50\u7c7b\u8fdb\u884c\u5b9e\u4f8b\u5316" , "\u5185\u90e8\u7c7b\u8f93\u51fa"};

    public static final String STRING[] = {"\u6784\u9020\u65b9\u6cd5" , "\u62bd\u8c61\u65b9\u6cd5" , "\u5f20\u76ca\u658c\uff0c\u6de1\u5b9a" , "\u62bd\u8c61\u7c7b\u5b9e\u4f8b\u5316\u5bf9\u8c61\u5fc5\u987b\u901a\u8fc7\u5b50\u7c7b\u8fdb\u884c\u5b9e\u4f8b\u5316" , "\u5185\u90e8\u7c7b\u8f93\u51fa"};

    public abstract List<E> getListRun();

    public abstract String getListRun(int x);

    public abstract int getListRun(int x, int y);

    public abstract double getListRun(double a, double b, double c);

}
