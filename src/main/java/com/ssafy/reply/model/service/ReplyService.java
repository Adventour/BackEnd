package com.ssafy.reply.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.reply.model.dto.ReplyDto;

public interface ReplyService {
	void writeReply(ReplyDto replyDto) throws SQLException;

	List<ReplyDto> listReply(int articleNo) throws SQLException;

	void modifyReply(ReplyDto replyDto) throws SQLException;

	void deleteReply(int replyId) throws SQLException;
}
