package z_labWork;

public class Lab_4_SynchronizationInThread {

    static class PrintTableWithoutSynchronization{

        public static void main(String[] args) {
            Thread1 thread1 = new Thread1(5);
            Thread2 thread2 = new Thread2(100);
            thread1.start();
            thread2.start();
        }

    }

    static class Thread1 extends Thread{
        int n ;
        @Override
        public void run() {
            super.run();
            for (int i=1; i<=10; i++){
                System.out.println(i*n);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        public Thread1(int n){
            this.n = n;
        }

    }

    static class Thread2 extends Thread{
        int n ;
        @Override
        public void run() {
            super.run();
            for (int i=1; i<=10; i++){
                System.out.println(i*n);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        public Thread2(int n){
            this.n = n;
        }

    }




    static class PrintTableWithSynchronization{

        public static void main(String[] args) {
            Table t = new Table();
            Thread3 thread3 = new Thread3(t);
            Thread4 thread4 = new Thread4(t);
            thread4.start();
            thread3.start();
        }

    }

    static class Thread3 extends Thread{

        private Table t;

        @Override
        public void run() {
            super.run();
            t.printTable(100);
        }

        public Thread3(Table t){
            this.t = t;
        }

    }

    static class Thread4 extends Thread{

        private Table t;

        @Override
        public void run() {
            super.run();
            t.printTable(5);
        }

        public Thread4(Table t){
            this.t = t;
        }

    }

    static class Table{
        synchronized void printTable(int n){
            for (int i=1; i<=10; i++){
                System.out.println(i*n);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

}
