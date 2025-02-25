package test;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/deposit")
public class Deposit extends HttpServlet{
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
				req.setAttribute("code", 4);
				req.getRequestDispatcher("message.jsp").forward(req, res);
			}
			else {
					total = New+ub.getAmount();
					ub.setAmount(total);
					val = new Statements().deposit_WithDraw(ub);
					if(val == 2) {
						PrintWriter pw = res.getWriter();
						pw.print("Deposited failed");
					}
					else {
					req.setAttribute("dep", "Deposited Successfully");
					req.getRequestDispatcher("deposit.jsp").forward(req, res);
					}
							
				}
			}
		
		
		
	}
}
