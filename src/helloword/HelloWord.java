package src.helloword;

import src.helloabstract.HelloAbstract;
import src.helloary.HelloAry;
import src.helloenum.HelloEnum;
import src.hellointerface.HelloInterface;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.Timer;
import java.util.TimerTask;

import java.lang.reflect.Constructor;
import java.lang.Class;
import java.lang.Math;

class HelloExtends extends HelloAbstract implements HelloInterface<String> {

    public HelloExtends(String name) {
        super(name);

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
    private StringBuffer stringBuffer = new StringBuffer();
    private Integer sum1 = 0;
    private Double sum2 = 0.0;

    @Override
    public List<String> getListRun() {
        list.add(super.getName());
        return list;

    }

    @Override
    public String getListRun(int x) {
//        try {
//            if (x >= 0 && x < 60) {
//                stringBuffer.append("差");
//            } else if (x >= 60 && x < 75) {
//                stringBuffer.append("中");
//            } else if (x >= 75 && x < 85) {
//                stringBuffer.append("良");
//            } else {
//                stringBuffer.append("优");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // 在条件表达式中不允许有赋值操作，同时也不允许出现复杂的逻辑表达式；(如上代码)
        // 解决方案：将复杂的逻辑运算赋值给一个具体有含义的布尔变量；(如下代码)

        boolean worst = (x >= 0 && x < 60);//差
        boolean secondary = (x >= 60 && x < 75);//中
        boolean good = (x >= 75 && x < 85);//良
        boolean excellent = (x >= 85 && x <= 100);//优

        System.out.println(worst);
        System.out.println(secondary);
        System.out.println(good);
        System.out.println(excellent);

        try {
            if (worst) {
                stringBuffer.append(HelloEnum.差.getEnumName());

            }

            if (secondary) {
                stringBuffer.append(HelloEnum.中.getEnumName());

            }

            if (good) {
                stringBuffer.append(HelloEnum.良.getEnumName());

            }

            if (excellent) {
                stringBuffer.append(HelloEnum.优.getEnumName());

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return stringBuffer.toString();

    }

    @Override
    public String getListRun(int x, int y) {
        sum1 = x + y;
        return String.valueOf((int) sum1);

    }

    @Override
    public String getListRun(double a, double b, double c) {
        sum2 = a + b - c;
        return String.valueOf((double) sum2);

    }

}

class HelloRunnable extends HelloExtends implements Runnable {

    public HelloRunnable(String name) {
        super(name);

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
            System.out.println(str);

        }
    }

    @Override
    public void run() {
        try {

            int intx = (int) (Math.random() * 100);

            System.out.println("随机数是:" + intx);

            String[] strName = new String[3];
            strName[0] = super.getListRun(intx);
            strName[1] = String.valueOf(super.getListRun(4, 3));
            strName[2] = String.valueOf(super.getListRun(5, 6, 7));

            for (String str : strName) {
                System.out.println(str);
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

    private static Timer timer = new Timer();
    private static TimerTask timerTask = new TimerTask() {
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


//                myClass = (Class<Object>) Class.forName("src.helloary.HelloAry");
//                myConstructor = (Constructor<Object>) myClass.getConstructor(String.class);

//                helloAry = (HelloAry<String>) myConstructor.newInstance(HelloInterface.STRING[3]);
//                helloAry.getAryRun();

                // 因为范型类HelloAry的构造函数使用关键字protected定义(非public定义)，所以实现上需要继承调用
//                helloAry=new HelloAry<String>(HelloInterface.STRING[3]);

//                helloAry = new HelloAry<>(HelloInterface.STRING[3]) {
//                    public String getAryName() {
//                        return "你好，世界";
//
//                    }
//                };
//                helloAry.getAryRun();
//                System.out.println(helloAry.getAryName());

                HelloAry.helloAryNeiBu.getAryRun();

                timer.cancel();

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    };


    public static void main(String[] args) {
        try {
            timer.schedule(timerTask, 1000);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }


}

