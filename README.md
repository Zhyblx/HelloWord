## 知识点复习

----
#### 一、接口定义：
定义：接口是全局常量和抽象方法的集合，定义关键字interface。<br>

HelloInterface接口说明：<br>
1、接口中定义类全局常量和抽象方案。<br>
2、全局常量的定义规则使用关键字static final。例如：<br>

    public static final String STRING[] = {"\u6784\u9020\u65b9\u6cd5" , "\u62bd\u8c61\u65b9\u6cd5" , "\u5f20\u76ca\u658c\uff0c\u6de1\u5b9a" , "\u62bd\u8c61\u7c7b\u5b9e\u4f8b\u5316\u5bf9\u8c61\u5fc5\u987b\u901a\u8fc7\u5b50\u7c7b\u8fdb\u884c\u5b9e\u4f8b\u5316" , "\u5185\u90e8\u7c7b\u8f93\u51fa"};

3、在同一个类中方法名相同，但参数"个数"或参数"数据类型"不同称之为方法重载。例如：<br>

    public abstract List<E> getListRun();
    public abstract E getListRun(int x);
    public abstract E getListRun(int x , int y);
    public abstract E getListRun(double a , double b , double c);

#### 二、抽象类的定义：
定义：包含抽象方法的类必须是抽象类，定义关键词abstract。<br>
1、抽象类使用关键字abstract修饰，定义规则：<br>

    public abstract class HelloAbstract {}
2、抽象方法使用abstract修饰，只需要声明不需要实现，具体的实现由抽象类的子类继承后，覆写抽象方法进行实现。抽象方法的声明规则：<br>

    public abstract void getAbstractRun() throws Exception;
3、抽象类中可以包含普通方法(即：非抽象方法)。<br>
4、抽象类中可以包含内部类；内部类即是类内部声明的类型，内部类也必须在类的内部进行示例化。<br>
5、使用关键字static定义的方法说明此方法为全局方法，可以使用类名直接调用。<br>
6、抽象类型不可以在用final进行修饰，使用final修饰的类，说明该类不可以被继承，而抽象类是一定要给子类继承的。<br>
7、使用final修饰的方法，说明该方法不能被覆写。<br>
8、抽象类的本身不能进行实例化，而必须通过子类进行实例化。<br>

#### 范型类：
定义：参数化类型，可以处理指定数据类型的类。<br>
a.范型类的声明规则：<br>

    public final class HelloAry<T>{}
说明：<br>
1、T为范型类的参数；实现过程中可以指定为具体的数据类型。<br>
2、参数可以指定上限或下限数据类型，例如：<br>
a)为参数指定数据类型上限，即使用关键字extends，在实现的过程中就只能处理指定数据类型的本身或子类。<br>
b)为参数指定数据类型下限，即使用关键字super，在实现的过程中就只能处理指定数据类型的本身或父类。<br>

b.私有化构造方法<br>
    
    private HelloAry(T ary){
        
    }
说明：<br>
必须在本类中进行实例化，并且必须使用static定义对象名。如：<br>
    
        public static HelloAry<String> helloAry=new HelloAry<String>(HelloInterface.STRING[2]);

对私有化构造类进行实例化的方法：类名 对象名2=类名.对象名1。如：<br>

    HelloAry<String> helloAry1=HelloAry.helloAry;

#### 日志类：
通过调用类Logger可实现自定义日志(log)的输出。<br>
使用方式：<br>

    Logger logger = Logger.getLogger(""); 
    logger.info(msg);

#### 枚举类：
作用：枚举类可以看作是常量的集合类，可使用名词或中文进行声明，以提高代码的可读性。例如:<br>

    public enum HelloEnum{
        Hello("Hello"),
        Word("Word");
        private String strName="";
        // 枚举值的构造方法必须试用关键字 private 进行定义
        private HelloEnum(String strName) {
            // TODO Auto-generated constructor stub
            this.strName=strName;
        }
        public String getEnumName() {
            return this.strName;
        }
    }


#### 实现类：
根据之前对接口、抽象类、范型类、枚举类的声明，项目中使用HelloWord做为主类进行实现。<br>

1、使用类HelloExtends 继承抽象类HelloAbstract 和实现接口 HelloInterface。例如:<br>

    class HelloExtends extends HelloAbstract implements HelloInterface<String> {}
2、一个类继承了抽象类或实现了接口，那么就必须覆写抽象类和接口中所有的抽象方法。例如：<br>

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
    public int getListRun(int x , int y) {
        sum_1 = x + y;
        return (int) sum_1;
    }

    @Override
    public double getListRun(double a , double b , double c) {
        sum_2 = a + b - c;
        return (double) sum_2;
    }

3、如何继承的类拥有一个有参的构造方法，那么子类必须优先给父类的构造方法进行参数回传(即，优先为父类的构造方法初始化参数)，而且必须将代码写在构造方法的第一行。例如:<br>

    public HelloExtends(String Name) {
        super(Name);--优先为父类的构造方法初始化参数
        try {
            HelloAbstract.getGzRun(HelloInterface.STRING[0] + "3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


4、List是一个集合，Iterator是一个迭代器，作用是用于list集合元素的输出。Iterator迭代器中有两个方法，作用分别如下：<br>
4.1:hasNext()作用是判断是否还有下一个可输出的元素。<br>
4.2:next()作用是输出当前元素。<br>

5、实现一个线程接口(Runnable)必须覆写接口中run()方法。<br>
6、java.lang.Math是一个随机类(水机函数)，例如产生100以内的随机数代码如下：<br>

    int intx=(int) (Math.random()*100);

7、java的反射机制；通过反射进行类的示例化。
7.1：每个类都可以看作是Class类的对象。
7.2：如果类中带有构造方法，那么必须通过Constructor类为反射示例化类进行初始化参数类型。

8、计时器：Timer 和 TimerTask 必须配合使用。

#### 继承调用原理：
1.概念说明：<br>
public修饰符来修饰的函数(或构造函数)，是指这个函数可以被其他的类来调用，也可以被自己类里的函数来调用<br>
protected修饰符来修饰的函数(或构造函数)，是指这个函数可以被继承类调用，也可以被自己类里的函数调用，但不能被其他的类调用。<br>
private修饰符来修饰的函数，就具有更少的权限了，只能被自己类里的其他函数调用，其他的一概不能调用。<br>


2.实现方式：<br>

    public class HelloAry<T extends String> {
            protected HelloAry(T Ary) {
                try {
                    this.setAry(Ary);
                    HelloAbstract.getGzRun(HelloInterface.STRING[0] + "2");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }
    说明：以上类的构造方法定义使用protected关键字字修饰
    
    继承类调用的实现方式：
    public class HelloWord {
        private static void main(String[] args){
            HelloAry helloAry=new HelloAry<>(HelloInterface.STRING[3]){
                      public String getAryName(){
                                    return "你好，世界";
                      }
            };
            helloAry.getAryRun();
            HelloLog.getLog(helloAry.getAryName());
        }
    }





