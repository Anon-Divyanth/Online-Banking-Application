package test;

import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class logout extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession hs = req.getSession(false);//Accessing Existing Session
		if(hs == null) {
			req.setAttribute("code", 3);
			req.getRequestDispatcher("message.jsp").forward(req, res);
		}
		else {
			hs.removeAttribute("session");
			hs.invalidate();
			PrintWriter pw = res.getWriter();
			pw.print("Logout successfully");
		}
		
		}
}
