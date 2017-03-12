package model.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jdbc.JdbcUtil;


public class ProjectDao {

	private static ProjectDao dao = new ProjectDao();
	
	public static ProjectDao getInstance(){
		return dao;
	}

	public List<Project> selectAllProject(Connection con) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			String sql = "select * from project";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()){
				List<Project> projects = new ArrayList<>();
			
				do{
					Project project = new Project(
							(rs.getInt("serialNo")),
							(rs.getString("project_name")),
							(rs.getString("project_content")),
							(rs.getDate("project_start_date")),
							(rs.getDate("project_end_date")),
							(rs.getString("project_process"))
						  );
					projects.add(project);
				}while(rs.next());
				return projects;
			}else{
				return Collections.emptyList();
			}

		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

	}
	
	public Project selectProject(Connection con, int serialNo) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			String sql = "select * from project where serialNo = ?";

			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, serialNo);
			
			rs = pstmt.executeQuery();
			
			Project project = null;
			if(rs.next()){
				project = new Project(
						(rs.getInt("serialNo")),
						(rs.getString("project_name")),
						(rs.getString("project_content")),
						(rs.getDate("project_start_date")),
						(rs.getDate("project_end_date")),
						(rs.getString("project_process"))
					  );
				return project;
			}

		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return null;
	}
	
	public void insertNewProject(Connection con, Project project) throws SQLException{
		PreparedStatement pstmt = null;
		
		try{
			String sql = "insert into project(project_name, project_content, project_start_date, project_end_date, project_process) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, project.getName());
			pstmt.setString(2, project.getContent());
			pstmt.setTimestamp(3, new Timestamp(project.getStartDate().getTime()));
			pstmt.setTimestamp(4, new Timestamp(project.getEndDate().getTime()));
			pstmt.setString(5, project.getProcess());
			
			pstmt.executeUpdate();
		
		}finally {
			JdbcUtil.close(pstmt);
		}		
	}
	
	public void updateProject(Connection con, Project project, int serialNo) throws SQLException{
		PreparedStatement pstmt = null;
		
		try{
			String sql = "update project set project_name = ?, project_content = ?, project_start_date = ?, project_end_date = ?, project_process = ? where serialNo = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, project.getName());
			pstmt.setString(2, project.getContent());
			pstmt.setTimestamp(3, new Timestamp(project.getStartDate().getTime()));
			pstmt.setTimestamp(4, new Timestamp(project.getEndDate().getTime()));
			pstmt.setString(5, project.getProcess());
			pstmt.setInt(6, serialNo);
			
			pstmt.executeUpdate();
		
		}finally {
			JdbcUtil.close(pstmt);
		}		
	}
	
	public int deleteProject(Connection con, int serialNo) throws SQLException{
		PreparedStatement pstmt = null;
		
		try{
			String sql = "delete from project where serialNo = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, serialNo);
			
			return pstmt.executeUpdate();
		
		}finally {
			JdbcUtil.close(pstmt);
		}		
		
	}
	
}
