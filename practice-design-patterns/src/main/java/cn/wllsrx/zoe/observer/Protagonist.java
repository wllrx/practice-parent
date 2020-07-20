package cn.wllsrx.zoe.observer;

/**
 * @author zoe
 *
 * 主角
 **/
public class Protagonist extends BaseSubject{
    void move(){
        System.out.println("主角向前移动");
        notifyObservers();
    }

}
