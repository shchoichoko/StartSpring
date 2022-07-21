package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.BoardReply;
import kr.ac.kopo.ctc.spring.board.domain.Forum;
import kr.ac.kopo.ctc.spring.board.repository.BoardReplyRepository;
import kr.ac.kopo.ctc.spring.board.repository.ForumRepository;

@Service
public class BoardReplyServiceImpl implements BoardReplyService {

	@Autowired
	BoardReplyRepository boardReplyRepository;
	@Autowired
	ForumRepository forumRepository;
	
	@Override
	public BoardReply boardReplyWrite(BoardReply boardReply, Integer id) {
        Optional<Forum> forum = forumRepository.findById(id);
        boardReply.setForum(forum.get());
        boardReply.setAuthor(forum.get().getAuthor());

        return boardReplyRepository.save(boardReply);
	}

	@Override
	public void replyDelete(BoardReply boardReply) {
		boardReplyRepository.delete(boardReply);		
	}

	@Override
	public List<BoardReply> getReplyBoardID(Integer id) {
		return boardReplyRepository.findReplyBoardId(id);
	}

	@Override
	public void boardReplyDelete(Integer id) {
		boardReplyRepository.deleteById(id);
	}


}
