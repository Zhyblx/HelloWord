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

    private static HelloLog helloLog = HelloLog.getHelloLog("helloabstract.HelloAbstract");

    public static final void setGzRun(String strGz) throws Exception {
        helloLog.setLogger(strGz);

    }

    public static final void setCxRun(String strCx) throws Exception {
        helloLog.setLogger(strCx);

    }

    private abstract class HelloNeiBu {

        // 继承调用
        protected String str = "";

        protected HelloNeiBu(String str) {
            this.str = str;

        }

        public abstract String getNeiBuLei();

    }

    public final void getNeiBuRun() throws Exception {

//        Class<Object> myClass = (Class<Object>) Class.forName("helloabstract.HelloAbstract.NeiBuLei");
//        Constructor<Object> myClassConstructor = (Constructor<Object>) myClass.getConstructor(String.class);
//        HelloAbstract.NeiBuLei neiBuLei = (HelloAbstract.NeiBuLei) myClassConstructor.newInstance(HelloInterface.STRING[4]);
//        neiBuLei.getNeiBuLei();

        // 对抽象类进行 new 实例化相当于一个匿名类继承了这个抽象类；所以，要覆写抽象类中的抽象方法
        HelloNeiBu helloNeiBu = new HelloNeiBu(HelloInterface.STRINGS[4]) {
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
            HelloAbstract.setGzRun(HelloInterface.STRINGS[0] + "1");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected Boolean numBoolean=true;
    protected Integer numInteger = 0;
    protected Double nunDouble = 0.0;

    // 包含抽象方法的类必定是抽象类
    public abstract void getAbstractRun() throws Exception;

}




