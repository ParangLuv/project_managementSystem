package mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
	
	private String encoding;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest sReq, ServletResponse sRes, FilterChain fChain) throws IOException, ServletException {
		sReq.setCharacterEncoding(encoding);
		fChain.doFilter(sReq, sRes);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		if(encoding == null){
			encoding = "utf-8";
		}
	}

}
