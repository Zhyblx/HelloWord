package helloabstract;


import hellointerface.HelloInterface;

import java.lang.Class;
import java.lang.reflect.Constructor;

public abstract class HelloAbstract {

    private String Name = null;

    public final void setName(String Name) {
        this.Name = Name;
    }

    public final String getName() {
        return this.Name;
    }

    public static final void getGzRun(String str_Gz) throws Exception {
        System.out.println(str_Gz);
    }

    public static final void getCxRun(String str_Cx) throws Exception {
        System.out.println(str_Cx);
    }

    final class NeiBuLei {

        private String str = "";

        public NeiBuLei(String str) {
            this.str = str;
        }

        public void getNeiBuLei() throws Exception {
            System.out.println(this.str);
        }

    }

    public final void getNeiBuLeiRun() throws Exception {

//        Class<Object> myClass = (Class<Object>) Class.forName("helloabstract.HelloAbstract.NeiBuLei");
//        Constructor<Object> myClassConstructor = (Constructor<Object>) myClass.getConstructor(String.class);
//        HelloAbstract.NeiBuLei neiBuLei = (HelloAbstract.NeiBuLei) myClassConstructor.newInstance(HelloInterface.STRING[4]);
//        neiBuLei.getNeiBuLei();
//
        new NeiBuLei(HelloInterface.STRING[4]).getNeiBuLei();

    }

    public HelloAbstract(String Name) {
        try {

            this.setName(Name);
            HelloAbstract.getGzRun(HelloInterface.STRING[0] + "1");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void getAbstractRun() throws Exception;

}




