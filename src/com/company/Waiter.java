package com.company;

/**
 * Created by Hillel9 on 26.06.2017.
 */
public class Waiter implements Runnable { // в этом класссе монитор находится на объекте Message, используя синхронизирующий блок

    private Message msg;

    public Waiter(Message m) {
        this.msg = m;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName(); // выведит имя потока, который был запущен
        synchronized (msg) {
            try {
                System.out.println(name + " jdem vizova metoda notify: " + System.currentTimeMillis());
                msg.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " bil vizov metoda notify: " + System.currentTimeMillis());
            // обработаем наше сообщение
            System.out.println(name + " : " + msg.getMsg());
        }
    }
}
