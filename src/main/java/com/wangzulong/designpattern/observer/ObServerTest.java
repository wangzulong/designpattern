package com.wangzulong.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzulong
 * @version 1.0
 * @date 2020/7/18 23:33
 */
public class ObServerTest {
    public static void main(String[] args) {
        Subjet subjet = new Subjet();
        Task1 task1 = new Task1();
        subjet.addObserver(task1);
        subjet.addObserver(new Task2());
        subjet.notifyObserver("test");
        System.out.println("---------------------------");
        subjet.removeObserver(task1);
        subjet.notifyObserver("test");
    }
}

class Subjet {
    // 容器
    List<Observer> container = new ArrayList<>();
    // add
    public void addObserver(Observer observer) {
        container.add(observer);
    }
    // remove;
    public void removeObserver(Observer observer) {
        container.remove(observer);
    }

    public void notifyObserver(Object object) {
        for(Observer observer: container) {
            observer.update(object);
        }
    }
}

interface Observer {
    void update(Object object);
}

class Task1 implements Observer {

    @Override
    public void update(Object object) {
        System.out.println("task1 received:" + object);
    }
}

class Task2 implements Observer {
    @Override
    public void update(Object object) {
        System.out.println("task2 received:" + object);
    }
}