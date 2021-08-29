package concurrent.homework;

import java.util.concurrent.Callable;

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() {
        System.out.println("当前线程：" + Thread.currentThread().getName());
        return CalculateUtils.fibo(36);
    }


}