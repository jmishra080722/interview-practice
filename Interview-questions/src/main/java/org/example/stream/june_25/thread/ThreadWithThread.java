package org.example.stream.june_25.thread;

public class ThreadWithThread extends  Thread{

    public void run()
    {
        System.out.println("My thread is in running state.");
    }
    public static void main(String[] args) {
        ThreadWithThread twt = new ThreadWithThread();
        twt.start();
    }
}
