package src.helloenum;

public enum HelloEnum {

    Hello("Hello"),
    Word("Word"),
    差("差"),
    中("中"),
    良("良"),
    优("优");

    private String strName = "";

    // 枚举值的构造方法必须试用关键字 private 进行定义
    private HelloEnum(String strName) {
        // TODO Auto-generated constructor stub
        this.strName = strName;
    }

    public String getEnumName() {
        return this.strName;
    }

}
