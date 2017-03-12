package handler.project;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import model.project.Project;
import model.project.ProjectDao;
import mvc.controller.CommandHandler;

public class ProjectAddHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return "/WEB-INF/view/addproject.jsp";
		
		
		}else if(req.getMethod().equalsIgnoreCase("post")){
			Connection con = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Project project = new Project(
										req.getParameter("name"), 
										req.getParameter("content"),
										sdf.parse(req.getParameter("startDate")),
										sdf.parse(req.getParameter("endDate")),
										req.getParameter("process"));
			
			ProjectDao dao = ProjectDao.getInstance();
			
			try{
				con = ConnectionProvider.getConnection();
				dao.insertNewProject(con, project);
			}finally{
				JdbcUtil.close(con);
			}
				
			return "/WEB-INF/view/addprojectcomplete.jsp";
		}
		return null;
		
	}

}
