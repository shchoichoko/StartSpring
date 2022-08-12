package kr.ac.kopo.ctc.spring.board.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleServiceTest {
	
	@Autowired
	SampleService sampleService;
	
	/*
	@Test
	void testnoTransactional() {
		sampleService.testnoTransactional();
	}
	 */
	@Test
	void testTransactional() {
		sampleService.testTransactional();
	}
	
}
