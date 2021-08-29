package lock;

import java.util.stream.IntStream;

public class TestLockCounter {
    public static void main(String[] args){
        int loopNum = 100_0000; //运行次数

        //1. 没有锁
        NoLockCounter noLockCounter = new NoLockCounter();
        IntStream.range(0, loopNum).parallel().forEach(i -> {
            noLockCounter.addAndGet();
        });
        System.out.println("NoLockCounter Sum = " + noLockCounter.getSum());
        System.out.println("---------------------------------------");
        //2. 使用同步块（同步锁），只能由一个线程进去
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        IntStream.range(0, loopNum).parallel().forEach(i -> {
            synchronizedCounter.addAndGet();
        });
        System.out.println("SynchronizedCounter Sum = " + synchronizedCounter.getSum());
        System.out.println("---------------------------------------");
        //3. 使用显式锁Lock
        LockCounter lockCounter = new LockCounter();
        IntStream.range(0, loopNum).parallel().forEach(i -> {
            lockCounter.addAndGet();
        });
        System.out.println("LockCounter Sum = " + lockCounter.getSum());
        System.out.println("---------------------------------------");
    }
}
