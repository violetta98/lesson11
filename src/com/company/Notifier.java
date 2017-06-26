package com.company;

/**
 * Created by Hillel9 on 26.06.2017.
 */
public class Notifier implements Runnable  {

    private Message msg;

    public Notifier(Message m) {
        this.msg = m;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName(); // выведит имя потока, который был запущен
        System.out.println(name + " startoval");
        try {
            Thread.sleep(1000); // поток спит 1 секунду
            synchronized (msg) {
                msg.setMsg(name + " potok Notifier otrabotal");
                msg.notify();
                // msg.notifyAll();
            }
        }
        catch(InterruptedException e){
             e.printStackTrace();
        }
    }
}
