package me.liyazhou.java7.concurrency.ch1.demo;

/**
 * Created by liyazhou on 2015/6/18.
 */
public class PrimeGenerator extends Thread{
    @Override
    public void run() {
        long number = 1L;
        while (true){
            if(isPrime(number)){
                System.out.printf("number %d is prime\n", number);
            }
            if(isInterrupted()){
                System.out.println("thread has been interrupted");
                return;
            }
            number++;
        }

    }
    private boolean isPrime(Long number){
        if(number <= 2)
            return true;
        for (int i = 2; i * i <= number ; i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String [] args){
        Thread primeGenerator = new PrimeGenerator();
        primeGenerator.start();
        try{
            Thread.sleep(500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        primeGenerator.interrupt();
    }

}

