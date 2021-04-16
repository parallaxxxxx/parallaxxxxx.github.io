package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.MemberDto;

public class MemberDao {

	private static MemberDao dao = new MemberDao();
	
	private MemberDao() {
		DBConnection.initConnection();
	}
	
	public static MemberDao getInstance() {		
		return dao;
	}
	
	public boolean addMember(MemberDto dto) {
		
		String sql = " INSERT INTO EMP(EMPNO, NAME, WORKDEPT, PHONENO, HIREDATE, JOB, SALARY) "
					+ " VALUES(SEQ_EMP.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
				
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getDept());
			psmt.setString(3, dto.getPhone());
			psmt.setString(4, dto.getJob());
			psmt.setInt(5, dto.getSal());
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);			
		}
		
		return count>0?true:false;
	}
	
	public List<MemberDto> getMemList() {
		
		String sql = " SELECT EMPNO, NAME, WORKDEPT, PHONENO, HIREDATE, JOB, SALARY "
					+ " FROM EMP ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		
		try {
			conn = DBConnection.getConnection();			
			psmt = conn.prepareStatement(sql);			
			rs = psmt.executeQuery();
			
			while(rs.next()) {	
				MemberDto dto = new MemberDto(	rs.getInt(1), 
												rs.getString(2), 
												rs.getString(3), 
												rs.getString(4), 
												rs.getString(5), 
												rs.getString(6), 
												rs.getInt(7)
											);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		return list;
	}
	
	
	public boolean updateMem(String name, int sal) {
		String sql = " UPDATE EMP"
						+ " SET SALARY=? "
						+ " WHERE NAME=? ";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			int count = 0;
			
			try {
				conn = DBConnection.getConnection();
				
				psmt = conn.prepareStatement(sql);
				
				psmt.setInt(1, sal);
				psmt.setString(2, name);
				
				count = psmt.executeUpdate();
		
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBClose.close(conn, psmt, rs);
			}
			return count>0?true:false;
	}
	
	public MemberDto getMem(String name) {
		
		String sql = " SELECT * "
					+ " FROM EMP "
					+ " WHERE NAME=? ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		MemberDto dto = null;
		
		try {
			conn = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, name);
			
			rs = psmt.executeQuery();
			
			if(rs.next()){
				dto = new MemberDto(	rs.getInt(1), 
										rs.getString(2), 
										rs.getString(3), 
										rs.getString(4), 
										rs.getString(5), 
										rs.getString(6), 
										rs.getInt(7)
									);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		return dto;
	}
	
	
	
}
	

