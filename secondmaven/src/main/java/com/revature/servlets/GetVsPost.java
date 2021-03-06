package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.HtmlTemplates;

/**
 * Status Codes
 * 100-series: Informational
 * 		-100 - Continue - request has not been received in full
 * 200-series: Success
 * 		-200 - OK
 * 		-201 - Created
 * 			-A file was created
 * 		-202 - Accepted
 * 			-Still awaiting final response
 * 300-series: Redirection
 * 		-301 - Page moved permenently
 * 		-302 - Page moved temporarily
 * 400-series: Client error
 * 		-400 - Bad request, server doesn't understand
 * 		-401 - Unauthorized, incorrect username or password
 * 		-403 - Forbidden, correct login, bad role
 * 		-404 - Not found
 * 500-series: Server errors
 * 		-500 - Exception on server
 * 		-503 - Server down
 */

/**
 * Servlet implementation class GetVsPost
 */

public class GetVsPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetVsPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String values = "";
		
		if(confirmPass(request.getParameter("password1"), request.getParameter("password2")))
		{
			
			Map<String, String[]> inputs = request.getParameterMap();
			out.println("<h3>GET PARAMETERS</h3>");
			out.println("<table border=2px><tr><th>PARAMETER</th><th>VALUE</th></tr>");

			for (String key : inputs.keySet()) {
				out.println("<tr><td>" + key + "</td><td>");
				values = "";

				for (String val : inputs.get(key)) {
					values += (val + " ");
				}
				out.println(values + "</td></tr>");
			}

			out.println("</table>");			
		}else{
			out.println("<h1 style='color:red'>PASSWORDS DONT MATCH!</h1>");
		}

		HtmlTemplates.goBackButton(out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String values = "";
		
		if(confirmPass(request.getParameter("password1"), request.getParameter("password2")))
		{
			
			Map<String, String[]> inputs = request.getParameterMap();
			out.println("<h3>POST PARAMETERS</h3>");
			out.println("<table border=2px><tr><th>PARAMETER</th><th>VALUE</th></tr>");

			for (String key : inputs.keySet()) {
				out.println("<tr><td>" + key + "</td><td>");
				values = "";

				for (String val : inputs.get(key)) {
					values += (val + " ");
				}
				out.println(values + "</td></tr>");
			}

			out.println("</table>");			
		}else{
			out.println("<h1 style='color:red'>PASSWORDS DONT MATCH!</h1>");
		}
		HtmlTemplates.goBackButton(out);
	}

	/*
	 * GET VS POST
	 * -In either situation, user input is stored in a header with a key called
	 * query string. Now, in GET, this string is stored in the url of the browser, thus
	 * compromising any information you wished hidden. It also has a max size of
	 * 1024 bytes.
	 * -Parameters are separated (With GET) by a '?' followed by key=value&key2=value2&etc
	 * -Post, however, will store the user input in the body of the request instead.
	 * -As a result, information is hidden still and we can store as much as we want.
	 * 		-(barring computer memory limitations)
	 */
	
	public boolean confirmPass(String pass1, String pass2){
		return pass1.equals(pass2);
	}
}