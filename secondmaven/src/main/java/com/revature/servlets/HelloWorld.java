package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Lifecycle of a Servlet
 * 1. A client sends a http request as a flat file to the server. (get:www.google.com)
 * 2. Server passes along the request as well as an empty response file to the web container
 * 3. Web container checks the deployment descriptor (web.exml) for where to send the
 * 	  request/response next
 * 4. www.google.com/stuff The web container goes to servletStuff which is defined in the deployment
 * 	  descriptor. Web container wraps the request and response as a java object and
 * 	  sends it to the proper servlet
 * 5. If the servlet is not instanciated, Web container calls init()
 * 6. The request/response is sent to the servlet for processing and creating a response
 * 	  At this point, multile req/res are multithreaded to the thread pool (service())
 * 7. If timeout is reached or server is shutdown wc calls destroy()
 * 8. Response is finished and sent back with the request to the web container
 * 9. Objects unwrapped, web container send both request and finished response to the server
 * 10.Server forwards request and response to the client, who, depending on the
 * 	  status code, displays response
 */
/*
 * Front End
 * -html,css,javascript,angular
 * -user sees this
 * Front end---->Servlets
 * 
 * Middleware
 * -java
 * Servlets
 * -DD
 * -Various servlets
 * Servlets---->Service
 * Service
 * -business logic
 * -Service methods
 * Service---->Dao
 * Dao
 * -Only grabs data
 * Dao---->DB
 * 
 * Backend
 * -oracle
 * DB
 */

/*
 * Request
 * POST localhost:8085/GetVsPost Http/1.1
 * accept = blah
 * cookie = blah
 * 		|
 * <Body>
 * 	Query_String = param1 = blah; param2 = blah;
 * </Body>
 * 
 * Response
 * Http/1.1 200 OK
 * header1: blah
 * header2: blah
 * header3: blah
 * <html>
 * 	<head>blah</head>
 * 	<body>blah</body>
 * </html>
 */

/*
 * Session Tracking
 * -Http is stateless
 * 	-This means for every page received by the server, a seoerate
 * 	 connection is made to the server
 * 	-Any information pertaining to the last connection is lost
 * 
 * 4 ways
 * 	-Url rewriting :(
 * 		-Append a manually generated session ID to the end of url
 * 	-Hidden fields :(
 * 		-<input type="hidden">
 * 	-Cookies :|
 * 		-Flat files with cookie name and value + other metadata
 * 		-Created on client side
 * 	-JSession :D
 * 		-Creates a dynamic ID and stores it as a cookie client side
 * 		-Also stores this info server side
 * 		-Can invalidate session server side
 */

/*
 * A servlet is a java application or program that serves to take incoming http
 * requests and handle appropriately, then send back proper http responses
 */
public class HelloWorld extends HttpServlet {
	/*
	 * Servlets have 3 key methods in their lifecycle
	 * When a servlet is first interacted with, the web comtainer will check
	 * if the servlet has been instantiated yet, if it hasn't, then it will call
	 * the init() method for that servlet. However, if the servlet is already instantiated,
	 * it will use the current instance. This effectively makes the servlet a Singleton
	 */
	public void init() {
		System.out.println(this.getServletName() + ": INIT");
	}
	/*
	 * Once the servlet is instanciated, the web comtainer calls the ervlet's service()
	 * while passing it the user request and response objects. It is at this point that
	 * the servlet will use the information hwoever it needs to, as well as modify the response
	 * to be sent back.
	 */
	public void service(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException,IOException{
		System.out.println(this.getServletName() + ": SERVICE");
		
		/*
		 * You must always tell the server what kind of content we are sending back to the user.
		 * In this case, an html file
		 */
		res.setContentType("text/html");
		//The printwriter is actually used to write the response back dynamically
		PrintWriter out = res.getWriter();
		
		//Using the actual writer
		out.println(
				"<h3>HELLO WORLD</h3>"
				);
		out.println(
				"<hr><input type='button' value='GO BACK' onclick='goBack()'</hr>"
				+ "<script>function goBack(){window.history.back();}</script>"
				);
	}
	/*
	 * After a certain amount of inactivity the web container will call the servlets detroy() method
	 * before ultimately deleting and taking back the memory.
	 */
	public void destroy() {
		System.out.println(this.getServletName() + ": DESTROY");
	}

}
