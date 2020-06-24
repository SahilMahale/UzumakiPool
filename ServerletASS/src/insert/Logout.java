package insert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet {
 @SuppressWarnings("unused")
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	 resp.setContentType("text/html");
	 PrintWriter pout = resp.getWriter();
	 Cookie ck[] = req.getCookies();
	 String cname="";
	 for (int i = 0; i < ck.length; i++) {
		if(ck[i].getName().equals("auth")) {
			cname = ck[i].getValue();
		}
	}
		if(!cname.equals("") || cname!=null) {
			pout.print("You are  logged out ");
			Cookie c = new Cookie("auth","");
		 c.setMaxAge(0);
		 resp.addCookie(c);
		}
		else {
			pout.print("You are not logged in");
		}
}
}
