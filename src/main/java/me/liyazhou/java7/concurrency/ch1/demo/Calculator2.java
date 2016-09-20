package me.liyazhou.java7.concurrency.ch1.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by liyazhou on 2015/6/17.
 */
public class Calculator2{
    public  static void main(String[] args){
        Thread[] threads = new Thread[3];
        Thread.State[] status = new Thread.State[3];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Calculator(i));
            if (i % 2 == 0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread:" + i);
        }
        try {
            FileWriter fileWriter = new FileWriter("log.txt");
            PrintWriter pw = new PrintWriter(fileWriter);
            pw.printf("test %s", "liyazhouliyazhou");
            pw.flush();
            for (int i = 0; i < threads.length; i++) {
                pw.println("main status thread " + i + " : " + threads[i].getState());
                status[i] = threads[i].getState();
            }
            for (int i = 0; i < threads.length; i++) {
                threads[i].start();
            }
            boolean finish = false;
            while(!finish){
                for (int i = 0; i < threads.length; i++) {
                    if (threads[i].getState() != status[i]){
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < threads.length; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state){
        pw.printf("Id: %d Name: %s", thread.getId(), thread.getName());
        pw.printf("Priority: %d", thread.getPriority());
        pw.printf("Old state", state);
        pw.printf("New state", thread.getState());
        pw.println("*************************\n");
        pw.flush();
    }
}
