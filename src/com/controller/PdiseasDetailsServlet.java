package com.controller;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Pregister;

/**
 * Servlet implementation class PdiseasDetailsServlet
 */
@WebServlet("/PdiseasDetailsServlet")
public class PdiseasDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Pregister pr=new Pregister();
	BLManager blm=new BLManager();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pr=(Pregister) request.getAttribute("pr");
			System.out.println(pr.getPname());
	int pid=(int)request.getAttribute("pr");
	System.out.println("Your pid :"+pid);
		
		
	}

}
