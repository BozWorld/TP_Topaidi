package fr.epsi.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.service.IIdeeService;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	
	@EJB
	private IIdeeService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
			req.setAttribute("listIdee", service.getIdeeListRaw());
			this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/hello.jsp").forward(req, resp);
	    }

}
