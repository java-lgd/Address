package ling.lang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
import ling.lang.domain.Place;
import ling.lang.service.PlaceServiceImp;

public class ProvinceServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ProvinceServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		response.setHeader("Cache-Control", "no-cache");
	  	response.setContentType("text/xml;charset=utf-8");
        PrintWriter  out= response.getWriter();
        String proCode=request.getParameter("proCode");	 
        System.out.println(proCode);
        ArrayList<Place> arrPro= (ArrayList<Place>) new PlaceServiceImp().getProvince();
//        for(int i=1;i<arrPro.size();i++){
//        	System.out.println(arrPro.get(i));
//        }
        
        //拼 xml数据
        StringBuilder sb=new StringBuilder("<?xml version='1.0' encoding='UTF-8'?>");
        sb.append("<provinces>");
        for(Place tmp:arrPro){
            sb.append("<province>");
            sb.append("<code>"+tmp.getCode()+"</code>");
            sb.append("<name>"+tmp.getName()+"</name>");
            sb.append("</province>");
        }
        
        sb.append("</provinces>");
        //System.out.println(sb.toString());
        out.print(sb.toString());
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
