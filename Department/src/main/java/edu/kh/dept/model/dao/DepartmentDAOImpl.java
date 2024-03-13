package edu.kh.dept.model.dao;

import static edu.kh.dept.common.JDBCTemplate.*;

import java.io.Closeable;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.dept.model.dto.Department;

// DAO( Data Access Object) : DB 접근 객체(SQL 수행, 결과 반환)
public class DepartmentDAOImpl implements DepartmentDAO{

	// 필드
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop; // Map<String, String> 형태, 파일 입출력 쉬움

	// 기본 생성자
	// - 객체 생성시 sql.xml 파일 내용을 읽어와 prop에 저장
	public DepartmentDAOImpl() {

		try {
			prop = new Properties();
			
			String path = DepartmentDAOImpl.class.getResource("/edu/kh/dept/sql/sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(path));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	// 부서 전체 조회
	@Override
	public List<Department> selectAll(Connection conn) throws SQLException {
		
		// 결과 저장용 변수 선언 / 객체 생성
		List<Department> deptList = new ArrayList<Department>();
		
		try {
			// SQL 작성
			String sql = prop.getProperty("selectAll");
			
			// Statement 객체 생성
			stmt = conn.createStatement();
			
			// SQL 수행 후 결과(ResultSet) 반환 받기
			rs = stmt.executeQuery(sql);
			
			// ResultSet 한 행 씩 접근해서 컬럼 값을 얻어온 후
			// deptList에 옮겨 담기
			while(rs.next()) {
				String deptId = rs.getString("DEPT_ID");
				String deptTitle = rs.getString("DEPT_TITLE");
				String locationId = rs.getString("LOCATION_ID");
				
				Department dept = new Department(deptId, deptTitle, locationId);
				
				deptList.add(dept);
			}
		}finally {
			close(rs);
			close(conn);
		}
		
		return deptList;
	}

	// 부서 추가
	@Override
	public int insertDepartment(Connection conn, Department dept) throws SQLException {

		// 1. 결과 저장용 변수 선언 / 객체 생성
		int result = 0;
		
		try {
			// 2. SQL 얻어오기
			String sql = prop.getProperty("insertDepartment");
			
			// 3. PreparedStatement 객체 생성 + sql 적재
			pstmt = conn.prepareStatement(sql);
			
			// 4. ?에 알맞은 값 대입
			pstmt.setString(1,dept.getDeptId());
			pstmt.setString(2,dept.getDeptTitle());
			pstmt.setString(3,dept.getLocationId());
			
			// 5. SQL(INSERT) 수행 후 결과(삽입 성공한 행의 개수) 반환 받기
			result = pstmt.executeUpdate();
			
		}finally {
			// 6. 사용한 JDBC 객체 자원 반환 (단, 커넥션 제외)
			close(pstmt);
		}
		return result;
	}
	
	
	
	
	
	
	
}
