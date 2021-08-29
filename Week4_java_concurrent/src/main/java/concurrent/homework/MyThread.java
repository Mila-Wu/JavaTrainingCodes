package concurrent.homework;

import java.util.concurrent.CompletableFuture;

class MyThread extends Thread {
    CompletableFuture<Integer> completableFuture;

    public MyThread(CompletableFuture<Integer> completableFuture) {
        this.completableFuture = completableFuture;
    }

    @Override
    public void run() {
        try {
            System.out.println("当前线程：" + Thread.currentThread().getName());
            Integer sum = CalculateUtils.fibo(36);
            completableFuture.complete(sum);
        } catch (Exception e){
            completableFuture.completeExceptionally(e);
        }

    }
}