package org.example.stream.june_25.thread;

public class ThreadWIthRunnable implements  Runnable{
    @Override
    public void run() {
        System.out.println("Run method or ThreadWithRunnable");
    }

    public static void main(String[] args) {
        ThreadWIthRunnable twr = new ThreadWIthRunnable();
        Thread thread = new Thread(twr);
        thread.start();
    }
}
