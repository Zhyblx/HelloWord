package src.helloabstract;

import src.hellointerface.HelloInterface;
import src.hellolog.HelloLog;

// 抽象类使用 abstract 进行定义
public abstract class HelloAbstract {

    private String name = null;

    public final void setName(String name) {
        this.name = name;

    }

    public final String getName() {
        return this.name;

    }

    public static final void setGzRun(String strGz) throws Exception {
        HelloLog.setLogger(strGz);

    }

    public static final void setCxRun(String strCx) throws Exception {
        HelloLog.setLogger(strCx);

    }

    private abstract class HelloNeiBu {

        // 继承调用
        protected String str = "";

        protected HelloNeiBu(String str) {
            this.str = str;

        }

        public abstract String getNeiBuLei();

    }

    public final void getNeiBuLeiRun() throws Exception {

//        Class<Object> myClass = (Class<Object>) Class.forName("helloabstract.HelloAbstract.NeiBuLei");
//        Constructor<Object> myClassConstructor = (Constructor<Object>) myClass.getConstructor(String.class);
//        HelloAbstract.NeiBuLei neiBuLei = (HelloAbstract.NeiBuLei) myClassConstructor.newInstance(HelloInterface.STRING[4]);
//        neiBuLei.getNeiBuLei();

        // 对抽象类进行 new 实例化相当于一个匿名类继承了这个抽象类；所以，要覆写抽象类中的抽象方法
        HelloNeiBu helloNeiBu = new HelloNeiBu(HelloInterface.STRING[4]) {
            @Override
            public String getNeiBuLei() {
                return this.str;

            }
        };
        System.out.println(helloNeiBu.getNeiBuLei());

    }

    public HelloAbstract(String name) {
        this.setName(name);
        try {
            HelloAbstract.setGzRun(HelloInterface.STRING[0] + "1");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public abstract void getAbstractRun() throws Exception;

}




