package hellointerface;

import java.util.List;

public interface HelloInterface {

//    public static final String STRING[]=
//            new String[]{"构造方法", "抽象方法", "张益斌，淡定", "抽象类实例化对象必须通过子类进行实例化", "内部类输出"};

    public static final String STRING[] = {"构造方法", "抽象方法", "张益斌，淡定", "抽象类实例化对象必须通过子类进行实例化", "内部类输出"};

    public abstract List<String> getListRun();
    
    public abstract String getListRun(int x);

    public abstract int getListRun(int x, int y);

    public abstract double getListRun(double a, double b, double c);

}
