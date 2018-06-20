package helloenum;

public enum HelloEnum {

    Hello("Hello"), Word("Word");

    private String s = null;

    HelloEnum(String s) {
        this.s = s;
    }

    public String getS() {
        return this.s;
    }

}

