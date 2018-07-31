package src.helloary;

import src.helloabstract.HelloAbstract;
import src.hellointerface.HelloInterface;

public final class HelloAry<T extends String> {

    private T Ary = null;

    private void setAry(T Ary) {
        this.Ary = Ary;
    }

    private T getAry() {
        return this.Ary;
    }

    public HelloAry(T Ary) {
        try {
            this.setAry(Ary);
            HelloAbstract.getGzRun(HelloInterface.STRING[0] + "2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAryRun() {
        try {
            System.out.println(this.getAry());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}




