package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;

import kr.ac.kopo.ctc.spring.board.domain.BoardReply;

public interface BoardReplyService {
	
    public BoardReply boardReplyWrite(BoardReply boardReply, Integer id);    

    public void replyDelete(BoardReply boardReply);
    
    public List<BoardReply> getReplyBoardID(Integer id);
    void boardReplyDelete(Integer replyId);

}
