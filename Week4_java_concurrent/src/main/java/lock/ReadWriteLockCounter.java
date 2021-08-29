package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockCounter {
    private int sum = 0;
    //可重入锁 - 读写锁 - 公平锁
    //每次只能有一个写线程，但是可以同时有多个线程并发的读数据，适用于读多写少的并发情况
    private ReadWriteLock lock = new ReentrantReadWriteLock(true);
//    ReentrantReadWriteLock的构造方法：
//    sync = fair ? new FairSync() : new NonfairSync();
//    readerLock = new ReadLock(this);
//    writerLock = new WriteLock(this);

    public int addAndGet(){
        try {
            lock.writeLock().lock();  //写锁；独占锁；被读锁排斥
            return ++sum;
        } finally {
            lock.writeLock().unlock();
        }
    }
    public int getSum(){
        try {
            lock.readLock().lock();  //读锁；共享锁；跑正可见性
            return sum;
        } finally {
            lock.readLock().unlock();
        }
    }
}
