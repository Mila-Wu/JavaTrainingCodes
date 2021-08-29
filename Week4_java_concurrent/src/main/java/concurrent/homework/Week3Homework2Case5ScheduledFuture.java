package concurrent.homework;

import java.util.concurrent.*;

public class Week3Homework2Case5ScheduledFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();
        MyCallable myCallable = new MyCallable();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);
        ScheduledFuture<Integer> scheduledFuture = scheduledThreadPoolExecutor.schedule(myCallable, 10, TimeUnit.SECONDS);
        System.out.println("当前线程：主线程Main");
        Integer result = scheduledFuture.get();
        CopyOnWriteArrayList list = new CopyOnWriteArrayList<String>();
        System.out.println("ScheduledFuture, 异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}


