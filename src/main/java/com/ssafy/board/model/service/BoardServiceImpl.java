package com.ssafy.board.model.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.dto.FileInfoDto;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dto.BoardDto;
import com.ssafy.board.model.mapper.BoardMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {
	private BoardMapper boardMapper;
	
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	@Transactional
	public void writeArticle(BoardDto boardDto) throws Exception {
		boardMapper.writeArticle(boardDto);
		List<FileInfoDto> fileInfos = boardDto.getFileInfos();
		if (fileInfos != null && !fileInfos.isEmpty()) {
			boardMapper.registerFile(boardDto);
		}
	}

	public    List<BoardDto> listArticle() throws SQLException {
		return boardMapper.listArticle();
	}

	public BoardDto getArticle(int articleNo) throws SQLException {
		return boardMapper.getArticle(articleNo);
	}

	public void modifyArticle(BoardDto boardDto) throws Exception {
		System.out.println(boardDto.getSaveFile()+"saveFile.........");
		boardMapper.modifyArticle(boardDto);
		List<FileInfoDto> fileInfos = boardDto.getFileInfos();
		if (fileInfos != null && !fileInfos.isEmpty()) {
			boardMapper.modifyFile(boardDto);
		}
	}

	public void deleteArticle(int articleNo, String path) throws Exception {
		List<FileInfoDto> fileList = boardMapper.fileInfoList(articleNo);
		boardMapper.deleteFile(articleNo);
		boardMapper.deleteReplies(articleNo);
		boardMapper.deleteArticle(articleNo);
		for(FileInfoDto fileInfoDto : fileList) {
			File file = new File(path + File.separator + fileInfoDto.getSaveFolder() + File.separator + fileInfoDto.getSaveFile());
			file.delete();
		}
	}

	@Override
	public String getImage(int articleNo) throws SQLException {
		return boardMapper.getImage(articleNo);
	}
}
