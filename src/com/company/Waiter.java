package com.company;

/**
 * Created by Hillel9 on 26.06.2017.
 */
public class Waiter implements Runnable { // � ���� ������� ������� ��������� �� ������� Message, ��������� ���������������� ����

    private Message msg;

    public Waiter(Message m) {
        this.msg = m;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName(); // ������� ��� ������, ������� ��� �������
        synchronized (msg) {
            try {
                System.out.println(name + " jdem vizova metoda notify: " + System.currentTimeMillis());
                msg.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " bil vizov metoda notify: " + System.currentTimeMillis());
            // ���������� ���� ���������
            System.out.println(name + " : " + msg.getMsg());
        }
    }
}
