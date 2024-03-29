package src.helloworld;

import src.helloabstract.HelloAbstract;
import src.helloary.HelloAry;
import src.helloenum.HelloEnum;
import src.hellointerface.HelloInterface;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import java.util.Timer;
import java.util.TimerTask;

import java.lang.reflect.Constructor;
import java.lang.Class;
import java.lang.Math;

class HelloExtends extends HelloAbstract implements HelloInterface<String> {

    public HelloExtends(String name) {
        super(name);

        try {
            HelloAbstract.setGzRun(HelloInterface.STRINGS[0] + "3");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void getAbstractRun() throws Exception {
        HelloAbstract.setCxRun(HelloInterface.STRINGS[1]);

    }

    protected List<String> list = new ArrayList<String>();
    //    private StringBuffer stringBuffer = new StringBuffer();

    @Override
    public List<String> setListRun() {
        this.list.add(super.getName());
        return this.list;

    }

    @Override
    public String setListRun(int x) {
        StringBuffer stringBuffer = new StringBuffer();

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
        // 三目运算：表达式?值1:值2 (说明：当条件成立返回值1 否则 返回值2)
        boolean worst = (x >= 0 && x < 60) ? true : false;//差
        boolean secondary = (x >= 60 && x < 75) ? true : false;//中
        boolean good = (x >= 75 && x < 85) ? true : false;//良
        boolean excellent = (x >= 85 && x <= 100) ? true : false;//优

        System.out.println(worst);
        System.out.println(secondary);
        System.out.println(good);
        System.out.println(excellent);

        // == 符号表示判断左右是否相等；而 = 符号表示负值
        try {
            if (worst == true) {
                stringBuffer.append(HelloEnum.差.getEnumName());

            }

            if (secondary == true) {
                stringBuffer.append(HelloEnum.中.getEnumName());

            }

            if (good != false) {
                stringBuffer.append(HelloEnum.良.getEnumName());

            }

            if (excellent != false) {
                stringBuffer.append(HelloEnum.优.getEnumName());

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return stringBuffer.toString();

    }

    @Override
    public String setListRun(int x, int y) {
        this.numInteger = x + y;
        return String.valueOf((int) this.numInteger);

    }

    @Override
    public String setListRun(double a, double b, double c) {
        this.nunDouble = a + b - c;
        return String.valueOf((double) this.nunDouble);

    }

}

//class HelloRunnable extends HelloExtends implements Runnable {
//
//    public HelloRunnable(String name) {
//        super(name);
//
//        try {
//            HelloAbstract.setGzRun(HelloInterface.STRING[0] + "4");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }
//
//    @Override
//    public void getAbstractRun() throws Exception {
//        super.list = new ArrayList<String>();
//        super.list.addAll(super.getListRun());
//
//        super.list.forEach(System.out::println);// 迭代器的另一种输出方式【在遍历数组、集合方面，foreach为开发人员提供了极大的方便。】
//
//        Iterator<String> iterator = super.list.iterator();
//        while (iterator.hasNext()) {
//            String str = iterator.next();
//            System.out.println(str);
//
//        }
//    }
//
//    @Override
//    public void run() {
//        System.out.println("Runnable线程：" + Thread.currentThread().getName());
//        try {
//            int intx = (int) (Math.random() * 100);
//
//            System.out.println("随机数是:" + intx);
//
//            String[] strName = new String[3];
//            strName[0] = super.getListRun(intx);
//            strName[1] = String.valueOf(super.getListRun(4, 3));
//            strName[2] = String.valueOf(super.getListRun(5, 6, 7));
//
//            for (String str : strName) {
//                System.out.println(str);
//            }
//
//            super.getAbstractRun();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }
//}

class HelloRunnable implements Runnable {

    // 静态内部类
    static class HelloInternal extends HelloExtends {
        public HelloInternal(String name) {
            super(name);
            try {
                HelloAbstract.setGzRun(HelloInterface.STRINGS[0] + 4);

            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        @Override
        public void getAbstractRun() throws Exception {
            Random random = new Random();
            int x = random.nextInt(100);
            System.out.println("random:" + x);

            String[] strName = new String[3];
            strName[0] = super.setListRun(x);
            strName[1] = super.setListRun(x, x);
            strName[2] = super.setListRun(x, x, x);
            for (int i = 0; i < strName.length; i++) {
                System.out.println(strName[i]);

            }

            super.getAbstractRun();
            super.list.addAll(super.setListRun());
            Iterator<String> iterator = super.list.iterator();
            while (iterator.hasNext()) {
                String str = iterator.next();
                System.out.println(str);
                if (super.numBoolean == true) {
                    break;
                }
            }

            Class<HelloExtends> myClass = (Class<HelloExtends>) Class.forName("src.helloworld.HelloExtends");
            Constructor<HelloExtends> myConstructor = (Constructor<HelloExtends>) myClass
                    .getConstructor(String.class);
            HelloAbstract helloAbstract = (HelloExtends) myConstructor
                    .newInstance(HelloInterface.STRINGS[3]);
            helloAbstract.getNeiBuRun();
            System.out.println(helloAbstract.getName());

        }
    }

    @Override
    public void run() {
        try {
            HelloRunnable.HelloInternal helloInternal = new HelloRunnable
                    .HelloInternal(HelloEnum.Hello.getEnumName() + HelloEnum.Word.getEnumName());
            helloInternal.getAbstractRun();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}


public class HelloWorld {

    private Thread thread = new Thread() {
        @Override
        public void run() {
            System.out.println("thread线程：" + Thread.currentThread().getName());
            try {
                Class<HelloRunnable> myClass = (Class<HelloRunnable>) Class
                        .forName("src.helloworld.HelloRunnable");
//                Constructor<HelloRunnable> myConstructor = (Constructor<HelloRunnable>) myClass
//                        .getConstructor(Object.class);
                HelloRunnable hellRunnable = (HelloRunnable) myClass.newInstance();
                new Thread(hellRunnable).start();

                HelloAry.helloAryNeiBu.getAryRun();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    };

    private static HelloWorld helloWorld = new HelloWorld();
    private Timer timer = new Timer();
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            System.out.println("timer线程：" + Thread.currentThread().getName());
            try {
                int i = (int) (Math.random() * 10);
                while (i >= 0) {
                    Thread.sleep(1000);

                    if (i == 0) {
                        helloWorld.thread.start();
                        helloWorld.timer.cancel();
                        break;

                    }

                    System.out.println("sleep:" + i);
                    i--;

                }

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    };

//    private static Thread thread = new Thread() {
//        @Override
//        public void run() {
//            System.out.println("thread线程：" + Thread.currentThread().getName());
//            try {
//                myClass = (Class<Object>) Class.forName("src.helloword.HelloRunnable");
//                myConstructor = (Constructor<Object>) myClass.getConstructor(String.class);
//
//                helloRunnable = (HelloRunnable) myConstructor
//                        .newInstance(HelloEnum.Hello.getEnumName() + HelloEnum.Word.getEnumName());
//                helloRunnable.getAbstractRun();
//                new Thread(helloRunnable).start();
//
//                // 抽象类的本身不能进行实例化，而必须通过子类进行实例化。
//                helloAbstract = new HelloRunnable(HelloInterface.STRINGS[3]);
//                helloAbstract.getNeiBuLeiRun();
//                System.out.println(helloAbstract.getName());
//
//
////                        myClass = (Class<Object>) Class.forName("src.helloary.HelloAry");
////                        myConstructor = (Constructor<Object>) myClass.getConstructor(String.class);
////
////                        helloAry = (HelloAry<String>) myConstructor.newInstance(HelloInterface.STRING[3]);
////                        helloAry.getAryRun();
////
////                                 因为范型类HelloAry的构造函数使用关键字protected定义(非public定义)，所以实现上需要继承调用
////                        helloAry=new HelloAry<String>(HelloInterface.STRING[3]);
////
////                        helloAry = new HelloAry<>(HelloInterface.STRING[3]) {
////                            public String getAryName() {
////                                return "你好，世界";
////
////                            }
////                        };
////                        helloAry.getAryRun();
////                        System.out.println(helloAry.getAryName());
//
//                HelloAry.helloAryNeiBu.getAryRun();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//
//            }
//        }
//    };
//
//
//    private static Timer timer = new Timer();
//    private static TimerTask timerTask = new TimerTask() {
//        @Override
//        public void run() {
//            System.out.println("timer线程：" + Thread.currentThread().getName());
//            try {
//                int i = 5;
//                while (true) {
//                    try {
//                        Thread.sleep(1000);
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//
//                    }
//                    if (i == 0) {
//                        HelloWord.thread.start();
//                        timer.cancel();
//                        break;
//
//                    }
//
//                    System.out.println("sleep:" + i);
//                    i--;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//
//            }
//        }
//    };


    /*
     * 递归计算：是指程序调用自身的编程技巧
     */
    public static int getsum(int n) {
        if (n == 1) {
            //满足条件,递归结束
            return 1;
        }
        int temp = getsum(n - 1);// 这就是"递归"
        System.out.println(n);
        System.out.println(temp);
        return temp + n;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("main线程：" + Thread.currentThread().getName());
        helloWorld.timer.schedule(helloWorld.timerTask, 1000);
        System.out.println(HelloWorld.getsum(4));

    }
}
