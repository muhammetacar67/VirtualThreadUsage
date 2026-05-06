package com.example.virtualthread;

public class NormalThread {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Thread başladı: " + Thread.currentThread());
            try {
                Thread.sleep(2000); // blocking
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread bitti: " + Thread.currentThread());
        };

        for (int i = 0; i < 5; i++) {
            new Thread(task).start();
        }
    }
}

//🔹 Normal Thread (Platform Thread)
//OS (işletim sistemi) thread’ine birebir bağlıdır
//Oluşturması pahalıdır
//Çok sayıda açarsan sistem zorlanır
//Blocking (bekleme) durumunda thread boş boş bekler