package handler.project;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import model.project.Project;
import model.project.ProjectDao;
import mvc.controller.CommandHandler;

public class ProjectDetailHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int serialNo = Integer.parseInt(req.getParameter("no"));
		
		Project projects = null;
		Connection con = null;
		
		try{
			con = ConnectionProvider.getConnection();
			ProjectDao dao = ProjectDao.getInstance();
			projects = dao.selectProject(con, serialNo);
			req.setAttribute("projects", projects);
		}finally{
			JdbcUtil.close(con);
		}
		
		return "/WEB-INF/view/detail.jsp";
	}

}
