package kr.ac.kopo.ctc.spring.board.service;

public interface SampleCacheService {
	String testNoCache(Integer id);
	String testCache(Integer id);
	void testCacheClear(Integer id);
}
