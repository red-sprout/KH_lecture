package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.close;
import com.kh.member.model.vo.Member;

public class MemberDao {
	private Properties prop = new Properties();
	
	public MemberDao() {
		String filePath = MemberDao.class.getResource("/db/sql/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member loginMember(Connection conn, String userId, String userPwd) {
		// select문 -> Member객체(한행) 조회 => ResultSet 객체
		
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql); // 미완성 sql
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery(); // 조회결과가 있다면 한행 반환 | 없다면 반환x
			
			if(rset.next()) {
				m = new Member(
							rset.getInt("USER_NO"),
							rset.getString("USER_ID"),
							rset.getString("USER_PWD"),
							rset.getString("USER_NAME"),
							rset.getString("PHONE"),
							rset.getString("EMAIL"),
							rset.getString("ADDRESS"),
							rset.getString("INTEREST"),
							rset.getDate("ENROLL_DATE"),
							rset.getDate("MODIFY_DATE"),
							rset.getString("STATUS")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
}
