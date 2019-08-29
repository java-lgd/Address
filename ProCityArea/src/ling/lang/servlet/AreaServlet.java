package ling.lang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ling.lang.dao.PlaceDaoImp;
import ling.lang.domain.Place;
import ling.lang.service.PlaceServiceImp;

public class AreaServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AreaServlet() {
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
        //取出其中的数据
        String cityCode=request.getParameter("cityCode");
        
        System.out.println("cityCode: "+cityCode);
        if(cityCode!=null){
        	 ArrayList<Place> arrArea=(ArrayList<Place>) new PlaceServiceImp().getArea(cityCode);
        	 
             
             //拼 xml数据
             StringBuilder sb=new StringBuilder("<?xml version='1.0' encoding='UTF-8'?>");
             sb.append("<areas>");
             for(Place tmp:arrArea){
                 sb.append("<area>");
                 sb.append("<code>"+tmp.getCode()+"</code>");
                 sb.append("<name>"+tmp.getName()+"</name>");
                 sb.append("</area>");
             }
             
             sb.append("</areas>");
             //System.out.println(sb.toString());
             out.print(sb.toString());
        }
       
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
