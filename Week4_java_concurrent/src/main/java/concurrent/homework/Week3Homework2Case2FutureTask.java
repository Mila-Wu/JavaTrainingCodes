package concurrent.homework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Week3Homework2Case2FutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start=System.currentTimeMillis();

        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask).start();
        System.out.println("当前线程：主线程Main");
        Integer result = futureTask.get();
        System.out.println("当前线程：主线程Main");
        System.out.println("使用 FutureTask 异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}


