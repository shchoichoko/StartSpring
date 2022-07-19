package kr.ac.kopo.ctc.spring.board.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface SampleService {
	//aop
	String testNoAop();
	String testAop();
	
	// transactional
	String testnoTransactional();
	String testTransactional();
}
