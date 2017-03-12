package handler.project;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import model.project.Project;
import model.project.ProjectDao;
import mvc.controller.CommandHandler;

public class ProjectListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		List<Project> projects = null;
		Connection con = null;
		
		try {
			con = ConnectionProvider.getConnection();
			ProjectDao dao = ProjectDao.getInstance();
			projects = dao.selectAllProject(con);
			req.setAttribute("projects", projects);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JdbcUtil.close(con);
		}
		
		return "/WEB-INF/view/projectlist.jsp";
	}

}
