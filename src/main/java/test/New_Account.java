package test;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/newAcc")
public class New_Account extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserBean ub = new UserBean();
		ub.setAcc_num(Long.parseLong(req.getParameter("acc_num")));
		ub.setUsername(req.getParameter("username"));
		ub.setPassword(req.getParameter("password"));
		ub.setAmount(Long.parseLong(req.getParameter("amount")));
		ub.setAddress(req.getParameter("address"));
		ub.setPhn(Long.parseLong(req.getParameter("number")));
		ub.setPin(Integer.parseInt(req.getParameter("pin")));
		int result = new Statements().register(ub);
		if(result > 0) {
			PrintWriter pw = res.getWriter();
			pw.print("Registered Succesesfully");
		}
		else {
			PrintWriter pw = res.getWriter();
			pw.print("Registered failed");
		}
		
	}
}
