package com.ssafy.attraction.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ssafy.attraction.model.dto.AttractionDto;
import com.ssafy.util.DBUtil;

public class AttractionDaoImpl implements AttractionDao{
	private static AttractionDaoImpl instance = new AttractionDaoImpl();
	private DBUtil util=DBUtil.getInstance();
	private AttractionDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	public static AttractionDaoImpl getInstance() {
		return instance;
	}
	@Override
	public List<AttractionDto> doList(int sido, int gugun, int contentType) {
		// TODO Auto-generated method stub
		List<AttractionDto> list= new ArrayList<AttractionDto>();
		System.out.println("dao"+" "+sido+" "+gugun);
		
		Connection conn= null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		if (contentType==0) {
			try {
				conn=util.getConnection();
				StringBuilder sql= new StringBuilder();
				sql.append("select * from attraction \n");
				sql.append("where sido_code= ? and gugun_code= ? \n");
				pstmt=conn.prepareStatement(sql.toString());
				pstmt.setInt(1, sido);
				pstmt.setInt(2, gugun);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					AttractionDto a= new AttractionDto();
					a.setTitle(rs.getString("title"));
					a.setContentTypeId(rs.getInt("content_type_id"));
					a.setAddr(rs.getString("addr"));
					a.setImage(rs.getString("image"));
					a.setLatitude(rs.getDouble("latitude"));
					a.setLongitude(rs.getDouble("longitude"));
					a.setDistance();
					list.add(a);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("sql에러");
				e.printStackTrace();
			}
		} else { //0이 아닌 특정 관광지를 호출
			try {
				conn=util.getConnection();
				StringBuilder sql= new StringBuilder();
				sql.append("select * from attraction \n");
				sql.append("where sido_code=? and gugun_code=? and content_type_id=? ");
				pstmt=conn.prepareStatement(sql.toString());
				pstmt.setInt(1, sido);
				pstmt.setInt(2, gugun);
				pstmt.setInt(3, contentType);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					AttractionDto a= new AttractionDto();
					a.setTitle(rs.getString("title"));
					a.setContentTypeId(rs.getInt("content_type_id"));
					a.setAddr(rs.getString("addr"));
					a.setImage(rs.getString("image"));
					a.setLatitude(rs.getDouble("latitude"));
					a.setLongitude(rs.getDouble("longitude"));
					a.setDistance();
					list.add(a);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("sql에러");
				e.printStackTrace();
			}
		}
		Collections.sort(list);
		return list;
	}

}
