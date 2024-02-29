package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Member;

// DAO(Data Access Object) : db에 직접적으로 접근해서 사용자의 요청에 맞는 sql문 실행 후 결과 반환(JDBC)
public class MemberDao {
	
	/**
	 * 사용자가 입력한 정보들을 db에 추가시켜주는 메소드
	 * @param m : 사용자가 입력한 값들이 담겨있는 member객체
	 * @return : insert문 실행 후 처리된 행수
	 */
	public int insertMember(Member m) {
		//insert문 => 처리된 행수(int) => 트랜잭션
		
		//필요한 변수들 먼저 세팅
		int result = 0; // 처리된 결과(처리된 행수)를 받아줄 변수
		Connection conn = null; // 연결된 db정보를 담는 객체
		PreparedStatement pstmt = null; // 완성된 sql문 전달해서 곧바로 실행 후 결과를 받는 객체
		
		//실행할 sql문
//		INSERT INTO MEMBER
//		VALUES(SEQ_USERNO.NEXTVAL, 'user01', 'pass01', '홍길동', 
//				NULL, 23, 'user@iei.or.kr', '01022222222', '부산', 
//				'등산, 영화보기', '2021-08-07');
		
//		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL,"
//				+ "'" + m.getUserId() + "',"
//				+ "'" + m.getUserPwd() + "',"
//				+ "'" + m.getUserName() + "',"
//				+ "'" + m.getGender() + "',"
//						+ m.getAge() + ","
//				+ "'" + m.getEmail() + "',"
//				+ "'" + m.getPhone() + "',"
//				+ "'" + m.getAddress() + "',"
//				+ "'" + m.getHobby() + "',"
//				+ "SYSDATE)";
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, ?, ? ,?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		
		try {
			// 1) JDBC Driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			// 3) Statement 객체 생성
			pstmt = conn.prepareStatement(sql); // 아직 미완성 sql문으로 ?를 전부 채워줘야한다.
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			// 4, 5) sql문 전달하면서 실행 후 값 받아오기
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 7) 다 쓴 jdbc객체를 반환
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public ArrayList<Member> selectList() {
		// select문(여러행 조회) -> ResultSet객체 -> ArrayList<Member>에 담기
	
		// 필요한 변수들 세팅
		ArrayList<Member> list = new ArrayList<Member>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null; // select문 실행 시 조회된 결과값들이 최초로 담기는 공간
		
		// 실행할 sql
		String sql = "SELECT * FROM MEMBER";
		
		try {
			// 1) JDBC Driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
						
			// 2) Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			// 3) Statement 객체 생성
			stmt = conn.createStatement();
			
			// 4, 5) sql 전송 및 결과 받기
			rset = stmt.executeQuery(sql);
			
			// 6) ResultSet으로부터 데이터를 하나씩 꺼내서 담아준다
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
				//현재 참조하고 있는 행에 대한 모든 컬럼에 데이터들을 한 Member 객체에 담기
				
				list.add(m);
			}
			
			// 반복문이 끝난 시점
			// 조회된 데이터가 없었다면 리스트는 비어있을 것이다.
			// 조회된 데이터가 있다면 전부 list에 담겨있을 것이다.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public int updateMember(Member m) {
		// update문 -> 처리된 행 수(int)
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		/*
		 * UPDATE MEMBER
		 * SET USERPWD = 'XX', EMAIL = 'XX', PHONE = 'XX', ADD = 'XX'
		 * WHERE USERID = 'XXX';
		 */
		
		String sql = "UPDATE MEMBER "
				+ "SET USERPWD = ?,"
				+ "EMAIL = ?,"
				+ "PHONE = ?,"
				+ "ADDRESS = ? "
				+ "WHERE USERID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			pstmt = conn.prepareStatement(sql); // 미완성 sql
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int deleteMember(String userId) {
		// delete문 => 처리된 행 수
		int result = 0;
		
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USERID = '" + userId + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
