package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.member.model.dao.MemberDao;
import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	private static MemberDao memberDao = new MemberDaoImpl();
	private DBUtil dbUtil;
	
	private MemberDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static MemberDao getMemberDao() {
		return memberDao;
	}

	@Override
	public int registerMember(MemberDto memberDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder joinMember = new StringBuilder();
			
			joinMember.append("insert into members (user_id, user_name, user_pwd, user_email, user_sido, user_gugun, salt) \n");
			joinMember.append("values (?, ?, ?, ?, ?, ?, ?)");
			pstmt = conn.prepareStatement(joinMember.toString());
			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserName());
			pstmt.setString(3, memberDto.getUserPwd());
			pstmt.setString(4, memberDto.getUserEmail());
			pstmt.setInt(5, memberDto.getUserSido());
			pstmt.setInt(6, memberDto.getUserGugun());
			pstmt.setString(7, memberDto.getSalt());
			pstmt.executeUpdate();

		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return 0;
	}
	
	@Override
	public MemberDto loginMember(MemberDto memberDto) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto returnMemberDto = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder loginMember = new StringBuilder();
			loginMember.append("select user_id, user_name \n");
			loginMember.append("from members \n");
			loginMember.append("where user_id = ? and user_pwd = ? \n");
			pstmt = conn.prepareStatement(loginMember.toString());
			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserPwd());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				returnMemberDto = new MemberDto();
				returnMemberDto.setUserId(rs.getString("user_id"));
				returnMemberDto.setUserName(rs.getString("user_name"));	
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return returnMemberDto;
	}
	
	@Override
	public void modifyMember(MemberDto memberDto) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder loginMember = new StringBuilder();
			loginMember.append("update members \n");
			loginMember.append("set user_name = ?, \n");
			loginMember.append("user_pwd = ? \n");
			loginMember.append("where user_id = ? ");
			pstmt = conn.prepareStatement(loginMember.toString());
			pstmt.setString(1, memberDto.getUserName());
			pstmt.setString(2, memberDto.getUserPwd());
			pstmt.setString(3, memberDto.getUserId());
			pstmt.executeUpdate();

			
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public String getUserSalt(MemberDto memberDto) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select salt from members \n");
			sql.append("where user_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getUserId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
			return "";
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}
}
