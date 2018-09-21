package src.helloword;

import src.helloabstract.HelloAbstract;
import src.helloary.HelloAry;
import src.helloenum.HelloEnum;
import src.hellointerface.HelloInterface;
import src.hellolog.HelloLog;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.Timer;
import java.util.TimerTask;

import java.lang.reflect.Constructor;
import java.lang.Class;
import java.util.logging.Logger;

import java.lang.Math;

class HelloExtends extends HelloAbstract implements HelloInterface<String> {

    public HelloExtends(String Name) {
        super(Name);
        try {
            HelloAbstract.getGzRun(HelloInterface.STRING[0] + "3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAbstractRun() throws Exception {
        HelloAbstract.getCxRun(HelloInterface.STRING[1]);
    }

    private List<String> list = new ArrayList<String>();
    private StringBuffer stringBUffer = new StringBuffer();
    private Integer sum_1 = 0;
    private Double sum_2 = 0.0;

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
            if (x > 50) {
                stringBUffer.append("max");
            } else {
                stringBUffer.append("min");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBUffer.toString();
    }

    @Override
    public String getListRun(int x , int y) {
        sum_1 = x + y;
        return String.valueOf((int) sum_1);
    }

    @Override
    public String getListRun(double a , double b , double c) {
        sum_2 = a + b - c;
        return String.valueOf((double) sum_2);
    }

}

class HelloRunnable extends HelloExtends implements Runnable {

    public HelloRunnable(String Name) {
        super(Name);
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
        while (iterator.hasNext()) {
            String str = iterator.next();
            HelloLog.getLog(str);
        }
    }

    @Override
    public void run() {
        try {

            int intx=(int) (Math.random()*100);

            System.out.println("随机数是:"+intx);

            String strName[] = new String[3];
            strName[0] = super.getListRun(intx);
            strName[1] = String.valueOf(super.getListRun(4 , 3));
            strName[2] = String.valueOf(super.getListRun(5 , 6 , 7));

            for (int i = 0; i < strName.length; i++) {
                System.out.println(strName[i]);
            }

            super.getAbstractRun();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


public class HelloWord {

    private static Class<Object> myClass = null;
    private static Constructor<Object> myConstructor = null;
    private static HelloRunnable helloRunnable = null;
    private static HelloAbstract helloAbstract = null;
    private static HelloAry<String> helloAry = null;

    private static HelloWord helloWord = new HelloWord();
    private static Timer timer = new Timer();

    /*
     * 类：Logger ；作用：日志记录
     * 方法：info() ；作用打印出日志信息
     *
     */
    private static Logger logger= Logger.getLogger("helloabstract.HelloAbstract");

    private static TimerTask timerTask=new TimerTask() {
        @Override
        public void run() {
            try {

                myClass = (Class<Object>) Class.forName("src.helloword.HelloRunnable");
                myConstructor = (Constructor<Object>) myClass.getConstructor(String.class);

                helloRunnable = (HelloRunnable) myConstructor.newInstance(HelloEnum.Hello.getEnumName() + HelloEnum.Word.getEnumName());
                helloRunnable.getAbstractRun();
                new Thread(helloRunnable).start();

                helloAbstract = (HelloRunnable) myConstructor.newInstance(HelloInterface.STRING[2]);
                helloAbstract.getNeiBuLeiRun();
                System.out.println(helloAbstract.getName());
                logger.info(helloAbstract.getName());


//                myClass = (Class<Object>) Class.forName("src.helloary.HelloAry");
//                myConstructor = (Constructor<Object>) myClass.getConstructor(String.class);

//                helloAry = (HelloAry<String>) myConstructor.newInstance(HelloInterface.STRING[3]);
//                helloAry.getAryRun();

                // 因为范型类HelloAry的构造函数使用关键字protected定义(非public定义)，所以实现上需要继承调用
//                helloAry=new HelloAry<String>(HelloInterface.STRING[3]);

                helloAry=new HelloAry<>(HelloInterface.STRING[3]){
                    public String getAryName(){
                        return "你好，世界";
                    }
                };
                helloAry.getAryRun();
                HelloLog.getLog(helloAry.getAryName());

                timer.cancel();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };



    public static void main(String[] args) {
        try {
            timer.schedule(timerTask , 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

