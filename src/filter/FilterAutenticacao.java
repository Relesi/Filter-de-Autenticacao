package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import user.UserLogado;


@WebFilter(urlPatterns= {"/pages/*"})
public class FilterAutenticacao implements Filter {

	@Override
	public void destroy() {
			
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		//System.out.println(req.getServletPath());
		
		String urlParaAutenticar = req.getServletPath();
		
		//retorna null caso n�o esteja logado
		UserLogado userLogado = (UserLogado) session.getAttribute("usuario");
		
		if(userLogado == null && !urlParaAutenticar.equalsIgnoreCase("/pages/ServletAutenticacao")) {//usu�rio n�o logado
			RequestDispatcher dispatcher = request.getRequestDispatcher("/autenticar.jsp?url="+ urlParaAutenticar);
			dispatcher.forward(request, response);
			return;//redirecionar processo
		}
		
		
		//Executa as a��es do request e response
		chain.doFilter(request, response);
		
		//System.out.println("Interceptando");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
