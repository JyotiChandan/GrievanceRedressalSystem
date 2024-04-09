package com.otz.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otz.model.EmailUtility;

/**
 * Servlet implementation class EmailSendingServlet
 */
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host;
	private String port;
	private String user;
	private String pass;
	
	public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   
    	// reads form fields
        String recipient = request.getParameter("UserName");
        String subject = "Registration Successful";
        String content = "<html><head><style>p{color:white;font-size:25px;width:500px;height:500px;background-image:url('https://png.pngtree.com/thumb_back/fh260/background/20200714/pngtree-modern-double-color-futuristic-neon-background-image_351866.jpg');}</style></head><body><p>Registration Successful</p></body></html>";
        String resultMessage = "";
        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject, content);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
            getServletContext().getRequestDispatcher("/Result.jsp").forward(
                    request, response);
        }  
    	 
	}

}
