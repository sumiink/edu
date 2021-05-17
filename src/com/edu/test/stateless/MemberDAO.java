package com.edu.test.stateless;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	Connection conn;
	PreparedStatement psmt = null;
	ResultSet rs;

	public MemberDAO() {
//		DataSource ds = DataSource.getIncetance();
//		conn = ds.getConnection();
		//Connection Pool을 활용해 Connection객체
		try {
			InitialContext ic = new InitialContext();		//리소스 관리
			javax.sql.DataSource ds =  (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {		//Exception e
			e.printStackTrace();
		}
	}
	public Member getMember(String id) {
		//id 조회해서 한건 가져와 Member
		String sql = "select * from member where member_id=?";
		Member member = new Member();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				member.setMemberAge(rs.getInt("member_age"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPwd(rs.getString("member_pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public Member checkInfo(String id, String pwd) {
		//id, pwd조회해서 한건 가져와 
		String sql = "select * from member where member_id=? and member_pwd=?";
		Member member = new Member();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			rs = psmt.executeQuery();
			if(rs.next()) {
				member.setMemberAge(rs.getInt("member_age"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPwd(rs.getString("member_pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	public List<Member> getMemberList(){
		String sql = "select * from member order by 1";
		List<Member> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Member mem = new Member();
				mem.setMemberAge(rs.getInt("member_age"));
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberPwd(rs.getString("member_pwd"));
				
				list.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public void insertMember(Member mem) {
		String sql = "insert into member values(?,?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getMemberId());
			psmt.setString(2, mem.getMemberName());
			psmt.setInt(3, mem.getMemberAge());
			psmt.setString(4, mem.getMemberPwd());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
