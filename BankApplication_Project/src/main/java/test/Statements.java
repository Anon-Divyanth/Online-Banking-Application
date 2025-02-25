package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Statements {
	int result = 0;
	public int register(UserBean ub) {
		try {
		Connection con = Database.getCon();
		PreparedStatement ps = con.prepareStatement("insert into bankaccount values(?,?,?,?,?,?,?)");
		ps.setLong(1, ub.getAcc_num());
		ps.setString(2, ub.getUsername());
		ps.setString(3, ub.getPassword());
		ps.setLong(4, ub.getAmount());
		ps.setString(5, ub.getAddress());
		ps.setLong(6, ub.getPhn());
		ps.setInt(7, ub.getPin());
		result = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public UserBean ub = null;
	public UserBean details(String un, String up) {
		try {
			Connection con = Database.getCon();
			PreparedStatement ps = con.prepareStatement("select * from bankaccount where username=? and password=?");
			ps.setString(1, un);
			ps.setString(2, up);
			ResultSet re = ps.executeQuery();
			if(re.next()) {
				ub = new UserBean();
				ub.setAcc_num(re.getLong(1));
				ub.setUsername(re.getString(2));
				ub.setPassword(re.getString(3));
				ub.setAmount(re.getLong(4));
				ub.setAddress(re.getString(5));
				ub.setPhn(re.getLong(6));
				ub.setPin(re.getInt(7));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ub;
	
}
	
	int value = 2;
	public int deposit_WithDraw(UserBean ub) {
		
		try {
			Connection con = Database.getCon();
			PreparedStatement ps = con.prepareStatement("update bankaccount set amount=? where username=?");
			ps.setLong(1, ub.getAmount());
			ps.setString(2, ub.getUsername());
			value = ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return value;	
	}
	
	
	public UserBean tranfertobank(int anum) {
		try {
			Connection con = Database.getCon();
			PreparedStatement ps = con.prepareStatement("select amount from bankaccount where acc_num=?");
			ps.setInt(1, anum);
			ResultSet re = ps.executeQuery();
			if(re.next()) {
				ub = new UserBean();
				ub.setCustomeramount(re.getLong(1));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ub;
		
	}
	public int tranfertobank(int anum, long amount, long newamount, String beanusername) {
		int validate = 3;
		try {
			Connection con = Database.getCon();
			PreparedStatement ps = con.prepareStatement("update bankaccount set amount=? where acc_num=?");
			PreparedStatement ps2 = con.prepareStatement("update bankaccount set amount=? where username=?");
			ps.setLong(1, amount);
			ps.setInt(2, anum);
			ps2.setLong(1, newamount);
			ps2.setString(2, beanusername);
			ps.executeUpdate();
			ps2.executeUpdate(); 
		    validate = ps.executeUpdate();		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return validate;
		
	}
	
	
	
	

	
	
	
	
	
}
