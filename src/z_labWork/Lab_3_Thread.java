package z_labWork;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lab_3_Thread {

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();

        Thread2 thread2 = new Thread2();
        Thread thread = new Thread(thread2);
        thread.start();

    }

    static class Thread1 extends Thread{

        @Override
        public void run() {
            super.run();
            System.out.println(new SimpleDateFormat("HH:mm:ss a").format(new Date(System.currentTimeMillis())));
        }

        public static void main(String[] args) {
            Thread1 thread1 = new Thread1();
            thread1.start();
        }

    }

    static class Thread2 implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread2 Running...");
            System.out.println(new SimpleDateFormat("HH:mm:ss a").format(new Date(System.currentTimeMillis())));
        }

        public static void main(String[] args){
            Thread2 thread2 = new Thread2();
            Thread thread = new Thread(thread2);

            thread.start();
        }

    }
}
