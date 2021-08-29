package concurrent.homework;

import java.util.concurrent.*;

public class Week3Homework2Case4RunnableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start=System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        MyRunnableFuture runnableFuture = new MyRunnableFuture(countDownLatch);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 60L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(1));
        threadPoolExecutor.execute(runnableFuture);
        System.out.println("当前线程：主线程Main");
//        Thread.sleep(300);
        countDownLatch.await();
        Integer result = runnableFuture.get();
        System.out.println("RunnableFuture, 异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

    }
}


