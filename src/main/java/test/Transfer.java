package test;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/transfer")
public class Transfer extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession hs = req.getSession(false);//Accessing Existing Session
		int anum = Integer.parseInt(req.getParameter("anum"));
		long amount = Long.parseLong(req.getParameter("amount"));
		long beanamount;
		String beanusername;
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
			else {
			long newcusamount,newamount;
			UserBean ub1 = new Statements().tranfertobank(anum);
			if(ub1 == null) {
				PrintWriter pw = res.getWriter();
				pw.print("Account not found");
			}
			else {
				newcusamount = ub1.getCustomeramount()+amount;
				newamount = ub.getAmount()-amount;
				ub.setAmount(newamount);
				beanusername = ub.getUsername();
				int validate = new Statements().tranfertobank(anum,newcusamount,newamount,beanusername);
				PrintWriter pw = res.getWriter();
				if(validate==3) {
					
					pw.print("Transfered Declined");
				}
				else {
					pw.print("Transfered Successfully");
				}
				
				
			}}
	}
}

}
