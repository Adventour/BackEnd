package com.ssafy.reply.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.reply.model.dto.ReplyDto;

@Mapper
public interface ReplyMapper {
	void writeReply(ReplyDto replyDto) throws SQLException;

	List<ReplyDto> listReply(int articleNo) throws SQLException;

	void modifyReply(ReplyDto replyDto) throws SQLException;

	void deleteReply(ReplyDto replyDto) throws SQLException;
}
