package kr.ac.kopo.ctc.spring.board.service;

import org.springframework.stereotype.Service;

@Service
public class BoardReplyServiceImpl implements BoardReplyService {

	@Override
	public void test() {
		System.out.println("BoardItemServiceImpl.test() 메서드 호출");
	}

	@Override
	public void testAopBefore() {
		System.out.println("BoardItemServiceImpl.testAopBefore() 메서드 호출");

	}

	@Override
	public void testAopAfter() {
		System.out.println("BoardItemServiceImpl.testAopAfter() 메서드 호출");

	}

	@Override
	public String testAopAfterReturning() {
		System.out.println("BoardItemServiceImpl.testAopAfterReturning() 메서드 호출");
		return "Success";
	}

	@Override
	public void testAopAfterThrowing() {
		System.out.println("BoardItemServiceImpl.testAopAfterThrowing() 메서드 호출");
		throw new RuntimeException("runtime exception 발생");

	}

	@Override
	public void testAopAround() {
		System.out.println("BoardItemServiceImpl.testAopAround() 메서드 호출");

	}

}
