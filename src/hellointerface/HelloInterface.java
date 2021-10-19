package src.hellointerface;

import java.util.List;

/**
 * 接口(interface)是全局常量和抽象方法的集合
 *
 */
public interface HelloInterface<E extends Object> {

    /**
     * 1.数组的静态初始化的方式。
     * 2.初始化的数组其元素长度是明确的。
     *
     */

//    public static final String[] STRING=
//            new String[]{"\u6784\u9020\u65b9\u6cd5" , "\u62bd\u8c61\u65b9\u6cd5" , "\u5f20\u76ca\u658c\uff0c\u6de1\u5b9a" , "\u62bd\u8c61\u7c7b\u5b9e\u4f8b\u5316\u5bf9\u8c61\u5fc5\u987b\u901a\u8fc7\u5b50\u7c7b\u8fdb\u884c\u5b9e\u4f8b\u5316" , "\u5185\u90e8\u7c7b\u8f93\u51fa"};

//    public static final String[] STRING = {};

    public static final String[] STRINGS =
            new String[]{"\u6784\u9020\u65b9\u6cd5",
                    "\u62bd\u8c61\u65b9\u6cd5",
                    "\u79c1\u6709\u5316\u6784\u9020",
                    "\u62bd\u8c61\u7c7b\u5b9e\u4f8b\u5316\u5bf9\u8c61\u5fc5\u987b\u901a\u8fc7\u5b50\u7c7b\u8fdb\u884c\u5b9e\u4f8b\u5316",
                    "\u5185\u90e8\u7c7b\u8f93\u51fa"};

    public abstract List<E> setListRun();

    public abstract E setListRun(int x);

    public abstract E setListRun(int x, int y);

    public abstract E setListRun(double a, double b, double c);

}
