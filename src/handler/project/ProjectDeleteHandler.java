package handler.project;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import model.project.ProjectDao;
import mvc.controller.CommandHandler;

public class ProjectDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int serialNo = Integer.parseInt(req.getParameter("no"));
		Connection con = null;
		try{
			con = ConnectionProvider.getConnection();
			ProjectDao dao = ProjectDao.getInstance();
			dao.deleteProject(con, serialNo);
		}finally{
			JdbcUtil.close(con);
		}
		return "list.do";
	}

}
