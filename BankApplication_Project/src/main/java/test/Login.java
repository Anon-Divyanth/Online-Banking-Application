package test;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/login")
public class Login extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw = res.getWriter();
		String un = req.getParameter("username");
		String up = req.getParameter("password");
		UserBean ub = new Statements().details(un,up);
		if(ub == null) {
			req.setAttribute("code", 1);
			req.getRequestDispatcher("message.jsp").forward(req, res);
		}
		else {
			HttpSession hs = req.getSession();
			hs.setAttribute("session",ub);
			req.setAttribute("code", 2);
			req.getRequestDispatcher("message.jsp").forward(req, res);
			req.getRequestDispatcher("balance.jsp").forward(req, res);
			req.getRequestDispatcher("details.jsp").forward(req, res);
		}
	
	}
}
