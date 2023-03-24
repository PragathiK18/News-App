package Filters;

import java.io.IOException;
import java.net.http.HttpRequest;

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

import roles.admin;
import roles.user;

/**
 * Servlet Filter implementation class approveManagerFilter
 */
@WebFilter("/myapp/addManager")
public class approveManagerFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public approveManagerFilter() {
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
		//chain.doFilter(request, response);
		
System.out.println("in approve");
		
		
		try {
			String id="";
			Cookie [] cookies =((HttpServletRequest)request).getCookies();
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("user")) {
					id=cookie.getValue();
				}
			}
			if(id!=null) {
				
				if(user.usersMap.get(id) instanceof admin) {
					
					chain.doFilter(request, response);
				}else {
					response.getWriter().append("./notAdmin");
					System.out.println(user.usersMap.get(id));
				}
				
			}
			else {
				
				System.out.println("not managerrrrrr!!!!!");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
