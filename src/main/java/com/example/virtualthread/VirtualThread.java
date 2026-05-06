package com.example.virtualthread;

public class VirtualThread {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            System.out.println("Virtual başladı: " + Thread.currentThread());
            try {
                Thread.sleep(2000); // blocking ama aslında park edilir
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Virtual bitti: " + Thread.currentThread());
        };

        for (int i = 0; i < 5; i++) {
            Thread.startVirtualThread(task);
        }
        Thread.sleep(1000); // main thread bekliyor
    }
}


//🔹 Virtual Thread (Java 21+ / Java 25)
//JVM tarafından yönetilir (OS thread’e direkt bağlı değil)
//çok hafiftir (milyonlarca açılabilir)
//Blocking olduğunda thread askıya alınır, kaynak boşa gitmez
//Loom projesinin sonucu
//
//👉 Yani: “çok hafif, gerektiğinde çalışan akıllı işçi”