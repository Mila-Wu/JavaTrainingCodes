package concurrent.homework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Week3Homework2Case3CompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start=System.currentTimeMillis();

        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        MyThread myThread = new MyThread(completableFuture);
        myThread.start();
        System.out.println("当前线程：主线程Main");
        Integer result = completableFuture.get();
        System.out.println("当前线程：主线程Main");
        System.out.println("使用 CompletableFuture 异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}


