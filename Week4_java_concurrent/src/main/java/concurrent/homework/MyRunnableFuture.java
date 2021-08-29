package concurrent.homework;

import java.util.concurrent.*;

public class MyRunnableFuture implements RunnableFuture {
    CountDownLatch countDownLatc;
    private  Integer sum = 0;

    public MyRunnableFuture(CountDownLatch countDownLatc) {
        this.countDownLatc = countDownLatc;
    }

    @Override
    public void run() {
        System.out.println("当前线程：" + Thread.currentThread().getName());
        sum = CalculateUtils.fibo(36);
        countDownLatc.countDown();
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public Integer get() throws InterruptedException, ExecutionException {
        return sum;
    }

    @Override
    public Integer get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
