package com.bagile.gmo.config.filter;

		import org.springframework.core.Ordered;
		import org.springframework.core.annotation.Order;
		import org.springframework.stereotype.Component;

		import javax.servlet.*;
		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;
		import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCORSFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Headers", "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");

		chain.doFilter(req, res);

	}

	public void init(FilterConfig filterConfig) {
		System.out.println("Initializing CORS filter...");
	}

	public void destroy() {
		System.out.println("Destroying CORS filter...");
	}
}