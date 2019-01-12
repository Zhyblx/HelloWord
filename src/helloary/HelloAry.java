package src.helloary;

import src.helloabstract.HelloAbstract;
import src.hellointerface.HelloInterface;

// 因为范型类HelloAry的构造函数使用关键字protected定义(非public定义)，所以实现上需要继承调用;所以在类的定义上不能使用关键字final修饰
// 使用final关键字定义的类，说明该类不能被继承。
//public final class HelloAry<T extends String> {

public class HelloAry<T extends String> {

    private T ary = null;

    private void setAry(T ary) {
        this.ary = ary;

    }

    private T getAry() {
        return this.ary;

    }

    /*
     * 1.public修饰符来修饰的函数(或构造函数)，是指这个函数可以被其他的类来调用，也可以被自己类里的函数来调用
     * 2.protected修饰符来修饰的函数(或构造函数)，是指这个函数可以被继承类调用，也可以被自己类里的函数调用，但不能被其他的类调用
     * 3.private修饰符来修饰的函数，就具有更少的权限了，只能被自己类里的其他函数调用，其他的一概不能调用。
     */


    // 情况一 public修饰符来修饰的构造函数
//    public HelloAry(T Ary) {
//        try {
//            this.setAry(Ary);
//            HelloAbstract.getGzRun(HelloInterface.STRING[0] + "2");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    protected HelloAry(T ary) {
//        this.setAry(ary);
//        try {
//            HelloAbstract.getGzRun(HelloInterface.STRING[0] + "2");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }

    // 私有化构造方法
    private HelloAry(T ary) {
        this.setAry(ary);
        try {
            HelloAbstract.getGzRun(HelloInterface.STRING[0] + "2");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public class HelloAryNeiBu {
        public void getAryRun() throws Exception {
            System.out.println(getAry());

        }

    }

    //    private static HelloAry<String> helloAry = new HelloAry<String>(HelloInterface.STRING[2]);
    public static HelloAry<String>.HelloAryNeiBu helloAryNeiBu = new HelloAry<String>(HelloInterface.STRING[2]).new HelloAryNeiBu();


}




