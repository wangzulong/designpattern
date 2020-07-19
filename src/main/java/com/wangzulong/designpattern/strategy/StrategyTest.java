package com.wangzulong.designpattern.strategy;

/**
 * @author wangzulong
 * @version 1.0
 * @date 2020/7/17 21:35
 */
public class StrategyTest {
    public static void main(String[] args) {
        NormalZombie normalZombie = new NormalZombie(new StepByStepMove(), new BiteAttack());
        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();

        normalZombie.setAttackable(new HitAttack());
        normalZombie.attack();
    }
}

interface Moveable {
    void move();
}

interface Attackable {
    void attack();
}

abstract class Zombie {
    abstract public void display();
    Moveable moveable;
    Attackable attackable;

    abstract void move();
    abstract void attack();

    public Zombie(Moveable moveable, Attackable attackable) {
        this.moveable = moveable;
        this.attackable = attackable;
    }

    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }

    public Attackable getAttackable() {
        return attackable;
    }

    public void setAttackable(Attackable attackable) {
        this.attackable = attackable;
    }
}

class StepByStepMove implements Moveable {

    @Override
    public void move() {
        System.out.println("一步一步地移动");
    }
}

class HitAttack implements Attackable {

    @Override
    public void attack() {
        System.out.println("打");
    }
}

class BiteAttack implements Attackable {

    @Override
    public void attack() {
        System.out.println("咬");
    }
}

class NormalZombie extends Zombie {

    public NormalZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("我是普通僵尸");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }

}
