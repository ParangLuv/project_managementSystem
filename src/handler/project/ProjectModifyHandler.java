package handler.project;

import java.sql.Connection;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import model.project.Project;
import model.project.ProjectDao;
import mvc.controller.CommandHandler;

public class ProjectModifyHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int serialNo;
		Connection con = null;
		Project projects = null;
		
		try{
		con = ConnectionProvider.getConnection();
		ProjectDao dao = ProjectDao.getInstance();
		
			if(req.getMethod().equalsIgnoreCase("get")){
				serialNo = Integer.parseInt(req.getParameter("no"));
				projects = dao.selectProject(con, serialNo);
				req.setAttribute("projects", projects);
				return "/WEB-INF/view/modifyproject.jsp";
				
				
			}else if(req.getMethod().equalsIgnoreCase("post")){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				serialNo = Integer.parseInt(req.getParameter("no"));
				projects = new Project(
								req.getParameter("name"), 
								req.getParameter("content"), 
								sdf.parse(req.getParameter("startDate")),
								sdf.parse(req.getParameter("endDate")),
								req.getParameter("process"));
				dao.updateProject(con, projects, serialNo);
				return "list.do";
			}
		}finally{
			JdbcUtil.close(con);
		}
		
		return null;
	}

}
