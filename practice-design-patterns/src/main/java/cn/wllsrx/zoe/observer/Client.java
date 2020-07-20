package cn.wllsrx.zoe.observer;

/**
 * @author zoe
 **/
public class Client {
    public static void main(String[] args) {
        //被观察者
        Protagonist protagonist =  new Protagonist();
        //观察者
        Monster monster = new Monster();
        Trap trap = new Trap();
        Treasure treasure = new Treasure();
        //注册观察者
        protagonist.attachObserver(monster);
        protagonist.attachObserver(trap);
        protagonist.attachObserver(treasure);
        //移动事件
        protagonist.move();
    }
}
