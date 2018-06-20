package helloword;

import helloabstract.HelloAbstract;
import helloary.HelloAry;
import helloenum.HelloEnum;
import hellointerface.HelloInterface;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import java.lang.Class;
import java.lang.reflect.Constructor;

class HelloExtends extends HelloAbstract implements HelloInterface {

    public HelloExtends(String Name) {
        super(Name);
        try {
            HelloAbstract.getGzRun(HelloInterface.STRING[0] + "3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> list = new ArrayList<String>();
    private StringBuffer stringBuffer = new StringBuffer();
    private Integer sum_1 = 0;
    private Double sum_2 = 0.0;

    @Override
    public void getAbstractRun() throws Exception {
        HelloAbstract.getCxRun(HelloInterface.STRING[1]);
    }

    @Override
    public List<String> getListRun() {
        try {
            list.add(super.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String getListRun(int x) {
        try {
            if (x < 343) {
                stringBuffer.append("min");
            } else {
                stringBuffer.append("max");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    @Override
    public int getListRun(int x, int y) {
        sum_1 = x + y;
        return (int) sum_1;
    }

    @Override
    public double getListRun(double a, double b, double c) {
        sum_2 = a + b - c;
        return (double) sum_2;
    }

}

class HelloRunnable extends HelloExtends implements Runnable {


    public HelloRunnable(String Nama) {
        super(Nama);
        try {
            HelloAbstract.getGzRun(HelloInterface.STRING[0] + "4");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> list = new ArrayList<String>();
    private Iterator<String> iterator = null;

    @Override
    public void getAbstractRun() throws Exception {
        list.addAll(super.getListRun());
        iterator = list.iterator();
        do {
            String str = iterator.next();
            System.out.println(str);
        } while (iterator.hasNext());
    }

    @Override
    public void run() {
        try {

            String strName[] = new String[3];
            strName[0] = super.getListRun(32);
            strName[1] = String.valueOf(super.getListRun(4, 3));
            strName[2] = String.valueOf(super.getListRun(4, 4, 4));
            for (int i = 0; i < strName.length; i++) {
                System.out.println(strName[i]);
            }

            super.getAbstractRun();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

public class HelloWord extends TimerTask {

    private Class<Object> myClass = null;
    private Constructor<Object> myConstructor = null;
    private HelloRunnable helloRunnable = null;
    private HelloAry<String> helloAry = null;
    private HelloAbstract helloAbstract = null;

    private static HelloWord helloWord = new HelloWord();
    private static Timer timer = new Timer();

    @Override
    public void run() {
        try {

            myClass = (Class<Object>) Class.forName("helloword.HelloRunnable");
            myConstructor = (Constructor<Object>) myClass.getConstructor(String.class);

            helloRunnable = (HelloRunnable) myConstructor.newInstance(HelloEnum.Hello.getS() + HelloEnum.Word.getS());
            helloRunnable.getAbstractRun();
            new Thread(helloRunnable).start();

            helloAry = new HelloAry<String>(HelloInterface.STRING[2]);
            helloAry.getAryRun();

            helloAbstract = (HelloRunnable) myConstructor.newInstance(HelloInterface.STRING[3]);
            helloAbstract.getNeiBuLeiRun();
            System.out.println(helloAbstract.getName());

            timer.cancel();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        timer.schedule(helloWord, 1000);
    }

}

















