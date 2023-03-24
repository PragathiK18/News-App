package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class authorization
 */
@WebFilter(urlPatterns = {"/myapp/*" })

public class authorization extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public authorization() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
//		HttpServletRequest a = (HttpServletRequest) request;
//
//		Cookie[] cookies = ( (HttpServletRequest) request).getCookies();
//
//			
//	      for (Cookie cookie : cookies) {
//	         if (cookie.getName().equals("user")) {
//	        		
//	     		chain.doFilter(request, response);
//	     		
//	         }
//	      }

		try {
			String id="";
			Cookie [] cookies =((HttpServletRequest)request).getCookies();
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("user")) {
					id=cookie.getValue();
				}
			}
			if(id!=null) {
				chain.doFilter(request, response);
			}
			else {
			System.out.println("in elseeeeeeeee");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("in catchhhhhhhhhhhh");
			response.getWriter().append("./newLogin.html");
				
		}
		
		
		
		
		
		
		
		
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
