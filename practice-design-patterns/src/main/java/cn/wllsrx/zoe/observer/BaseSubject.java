package cn.wllsrx.zoe.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zoe
 * 被观察者
 **/
public abstract class BaseSubject {

    private List<Observer> observerList = new ArrayList<>();

    public void attachObserver(Observer observer) {
        observerList.add(observer);
    }

    public void detachObserver(Observer observer){
        observerList.remove(observer);
    }

    public void notifyObservers(){
        for (Observer observer: observerList){
            observer.update();
        }
    }
}
