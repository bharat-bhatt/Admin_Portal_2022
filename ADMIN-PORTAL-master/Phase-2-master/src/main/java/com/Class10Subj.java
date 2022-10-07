package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Class10Subj
 */
public class Class10Subj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Class10Subj() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","Invisible16");
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select subjects from allsubjects");
			out.println("<body style=\"background-image: url('css/back.jpg');\">");
			
			while(rs.next()) {
				
				if(rs.getString("subjects").equals("Computer Basics")) {
					out.println("<center>"+"Class 10 Subjects");
				out.println("<br>"+"<strong>"+rs.getString("subjects")+"(ELECTIVE)"+"</strong>"+"<br>");
				}
				else {
					out.println("<center>"+"Class 10 Subjects");
					out.println("<br>"+"<strong>"+rs.getString("subjects")+"</strong>"+"<br>");
				}
				out.println("--------------");
			}
			
			out.println("<br>"+"<a href='Admin.html'>Back to Main Menu</a>'");
			out.println("</body>");
			
		} catch (Exception e) {
			System.out.println(e);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
