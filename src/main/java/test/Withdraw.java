package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/withdraw")

public class Withdraw extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession hs = req.getSession(false);//Accessing Existing Session
		long New = Long.parseLong(req.getParameter("amount"));
		if(hs == null) {
			req.setAttribute("code", 3);
			req.getRequestDispatcher("message.jsp").forward(req, res);
		}
		else {
			UserBean ub = (UserBean) hs.getAttribute("session");
			if(ub == null) {
				req.setAttribute("code", 3);
				req.getRequestDispatcher("message.jsp").forward(req, res);
			}
			

			long total;
			int val;
			int pin = Integer.parseInt(req.getParameter("pin"));
			int orgpin = ub.getPin();
			if(pin != orgpin) {	
				req.setAttribute("code", 5);
				req.getRequestDispatcher("message.jsp").forward(req, res);
			}
			else {
				total = ub.getAmount()-New;
				ub.setAmount(total);
				val = new Statements().deposit_WithDraw(ub);
				if(val != 0) {
				req.setAttribute("with", "WithDraw Successfully");
				req.getRequestDispatcher("withdraw.jsp").forward(req, res);
						
			}
			}
			
		}
		
		
	}
}
