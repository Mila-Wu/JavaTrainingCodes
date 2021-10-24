package com.example.demo;

import com.example.demo.lock.DistributedLock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	private final static String LOCK_ID = "redis_lock";

	private static int amount = 10;

	@Autowired
	DistributedLock distributedLock;

	public static void testRedisLock() {
		System.out.println("lock test:: begin");

		if (!DistributedLock.getInstance().getLock(LOCK_ID, 10 * 1000)) {
			System.out.println("获取锁失败");
			return;
		}

		try {
			Thread.sleep(10000);
			amount -= 1;
			System.out.printf("After amount - 1, now amount =  %d\n", amount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		DistributedLock.getInstance().releaseLock(LOCK_ID);
		System.out.println("lock test:: end");
	}

	@Test
	void contextLoads() throws InterruptedException {
		Thread thread1 = new Thread(DemoApplicationTests::testRedisLock);
		Thread thread2 = new Thread(DemoApplicationTests::testRedisLock);
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();

		Thread thread3 = new Thread(DemoApplicationTests::testRedisLock);
		thread3.start();
		thread3.join();
	}

}
