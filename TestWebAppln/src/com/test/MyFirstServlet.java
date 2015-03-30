package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlet
 */
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(){
		System.out.println("123123");	
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // Set response content type
		 {
		      // Set response content type
		      response.setContentType("text/html");

		      PrintWriter out = response.getWriter();
			  String title = "Reading All Form Parameters";
		      String docType =
		      "<!doctype html public \"-//w3c//dtd html 4.0 " +
		      "transitional//en\">\n";
		      out.println(docType +
		        "<html>\n" +
		        "<head><title>" + title + "</title></head>\n" +
		        "<body bgcolor=\"#f0f0f0\">\n" +
		        "<h1 align=\"center\">" + title + "</h1>\n" +
		        "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
		        "<tr bgcolor=\"#949494\">\n" +
		        "<th>Param Name</th><th>Param Value(s)</th>\n"+
		        "</tr>\n");

		      Enumeration paramNames = request.getHeaderNames();
		      
		     /* while(paramNames.hasMoreElements()) {
		         String paramName = (String)paramNames.nextElement();
		         out.print("<tr><td>" + paramName + "</td>\n<td>");
		         String[] paramValues =
		                request.getParameterValues(paramName);
		         // Read single valued data
		         if (paramValues.length == 1) {
		           String paramValue = paramValues[0];
		           if (paramValue.length() == 0)
		             out.println("<i>No Value</i>");
		           else
		             out.println(paramValue);
		         } else {
		             // Read multiple valued data
		             out.println("<ul>");
		             for(int i=0; i < paramValues.length; i++) {
		                out.println("<li>" + paramValues[i]);
		             }
		             out.println("</ul>");
		         }
		      }*/
		      while(paramNames.hasMoreElements()) {
		          String paramName = (String)paramNames.nextElement();
		          out.print("<tr><td>" + paramName + "</td>\n");
		          String paramValue = request.getHeader(paramName);
		          out.println("<td> " + paramValue + "</td></tr>\n");
		       }
		       out.println("</table>\n</body></html>");
		      out.println("</tr>\n</table>\n</body></html>");
		 }
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside doPost");
		 doGet(request, response);
	}

}
