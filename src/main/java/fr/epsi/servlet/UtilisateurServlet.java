package fr.epsi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.entite.Utilisateur;
import fr.epsi.service.IUtilisateurService;

@WebServlet("/Utilisateur")
public class UtilisateurServlet extends HttpServlet{
	
	private IUtilisateurService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			{
				if(req.getParameter("action").equals("Inscription")) {
					
					this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/Inscription.jsp").forward(req,resp);
				}
				if(req.getParameter("action").equals("Connexion")) {
					
					this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/Connexion.jsp").forward(req,resp);
				}
			}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if (req.getParameter("action").equals("inscription")) {
			String mail = req.getParameter("mail");
			String password = req.getParameter("password");
			
				if(!mail.isBlank() && !password.isBlank()) {
					Utilisateur u = new Utilisateur();
					u.setMail(mail);
					u.setCode(password);
					service.create(u);
					resp.sendRedirect("http://localhost:8080/TP_topaidi-0.0.1-SNAPSHOT/home");
				}
			}
			
		else if (req.getParameter("action").equals("connexion")) {
			String mail = req.getParameter("utilisateurMail");
			String password = req.getParameter("password");
			if(!mail.isBlank() && !password.isBlank()) {
				Utilisateur u = service.getUtilisateur(mail,password);
				if (u != null) {
					HttpSession session = req.getSession(true);
					session.setAttribute("utilisateur", u);
					resp.sendRedirect("http://localhost:8080/TP_topaidi-0.0.1-SNAPSHOT/home");
				}
			}
			
		}
		
	}
			
}
	
	

