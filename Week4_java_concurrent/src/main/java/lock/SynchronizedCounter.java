package lock;

public class SynchronizedCounter {
    private int sum = 0;
//    public synchronized int addAndGet(){
//        return ++sum;
//    }

    Object object = new Object();
    public int addAndGet(){
        synchronized (object) {
            ++sum;
        }
        return sum;
    }

    public int getSum(){
        return sum;
    }
}
