package fr.epsi.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Categorie;
import fr.epsi.entite.Idee;
import fr.epsi.service.ICategorieService;
import fr.epsi.service.IIdeeService;
import fr.epsi.service.IdeeService;

@WebServlet("/Idee")
public class IdeeServlet extends HttpServlet{
	
	@EJB
	private IIdeeService service;
	
	@EJB 
	private ICategorieService categorieService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			{
				if(req.getParameter("action").equals("ListTop")) {
					req.setAttribute("listIdee", service.getListTop());
					this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/IdeeTop.jsp").forward(req,resp);
				}
				if(req.getParameter("action").equals("ListBuzz")) {
					req.setAttribute("listIdee", service.getListBuzz());
					this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/IdeeBuzz.jsp").forward(req,resp);
				}
				if(req.getParameter("action").equals("ListBrain")) {
					req.setAttribute("listIdee", service.getListTop());
					this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/TopUtulisateur.jsp").forward(req,resp);
				}
				if(req.getParameter("action").equals("creation")) {
					this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/CreateIdee.jsp").forward(req, resp);
				}
			}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
				if(req.getParameter("actionPost").equals("cree")) {
				 System.out.println("test");
				 Idee i = new Idee();
				 Categorie c = new Categorie();
				 c.setNom(req.getParameter("categorie"));
				 i.setDescription(req.getParameter("description"));
				 i.setPhoto(req.getParameter("image"));
		  		 i.setDate(Date.valueOf(java.time.LocalDate.now()));
				 i.setCategorie(c);
				 categorieService.create(c);
			     service.create(i);
		    	 req.setAttribute("listIdee", service.getIdeeList());
		    	 this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/hello.jsp").forward(req, resp);
		    }
	    }
}
