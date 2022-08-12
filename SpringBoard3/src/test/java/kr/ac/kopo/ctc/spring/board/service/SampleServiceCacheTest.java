package kr.ac.kopo.ctc.spring.board.service;

import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleServiceCacheTest {

	@Autowired
	private SampleCacheService sampleCacheService;
	
	private long startTime;
	private long endTime;
	
	
	@Before(value = "sample")
	public void onBefore() {
		startTime = System.currentTimeMillis();
	}
	
	@After(value = "sample")
	public void onAfter() {
		endTime = System.currentTimeMillis();
		System.out.println("소요시간 : " + (endTime - startTime) + "ms");
	}
	@Test
	void testNoCache() {
		sampleCacheService.testNoCache(1);
	}
	@Test
	void testCache1() {
		sampleCacheService.testCache(1);
	}
	@Test
	void testCache2() {
		sampleCacheService.testCache(1);
	}
	@Test
	void testCache3() {
		sampleCacheService.testCache(2);
	}
	@Test
	void testCache4() {
		sampleCacheService.testCache(1);
	}
	@Test
	void testCache5() {
		sampleCacheService.testCacheClear(1);
		sampleCacheService.testCache(1);
	}

}
