package concurrent.homework;

import java.util.concurrent.*;

public class Week3Homework2Case1Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start=System.currentTimeMillis();

        MyCallable myCallable = new MyCallable();
        //使用ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future = executorService.submit(myCallable);
        Integer result = future.get();

        System.out.println("使用ExecutorService 和Future, 异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}


