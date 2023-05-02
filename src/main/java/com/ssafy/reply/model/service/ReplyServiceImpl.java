package com.ssafy.reply.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.reply.model.dto.ReplyDto;
import com.ssafy.reply.model.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {
	private ReplyMapper replyMapper;

	public ReplyServiceImpl(ReplyMapper replyMapper) {
		this.replyMapper = replyMapper;
	}

	public void writeReply(ReplyDto replyDto) throws SQLException {
		replyMapper.writeReply(replyDto);
	}

	public List<ReplyDto> listReply(int articleNo) throws SQLException {
		return replyMapper.listReply(articleNo);
	}

	public void modifyReply(ReplyDto replyDto) throws SQLException {
		replyMapper.modifyReply(replyDto);
	}

	public void deleteReply(ReplyDto replyDto) throws SQLException {
		replyMapper.deleteReply(replyDto);
	}
}
