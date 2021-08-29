package lock;

public class NoLockCounter {
    private int sum = 0;
    public int addAndGet(){
        return ++sum;
    }
    public int getSum(){
        return sum;
    }
}
