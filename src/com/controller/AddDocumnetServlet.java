package com.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.model.BLManager;
import com.pojo.History;
import com.pojo.Pdisease;
import com.pojo.Pregister;
import com.pojo.Report;

/**
 * Servlet implementation class AddDocumnetServlet
 */
@MultipartConfig(maxFileSize=169999999 )
@WebServlet("/AddDocumnetServlet")
public class AddDocumnetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	History h=new History();
	Pdisease pd=new Pdisease();
	BLManager blm=new BLManager();
	Pregister pr=new Pregister();
	Report r=new Report();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pdid=Integer.parseInt(request.getParameter("pdid"));
		
		pd=blm.searchByPatientDiseaseId(pdid);
		HttpSession sses6=request.getSession();
		sses6.setAttribute("pd",pd);
		response.sendRedirect("AddDocument.jsp");
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pdid=Integer.parseInt(request.getParameter("pdid"));
		int pid=Integer.parseInt(request.getParameter("pid"));
		String rname=request.getParameter("name");
		pd=blm.searchByPatientDiseaseId(pdid);
		pr=blm.searchByPatientId(pid);
		r.setRname(rname);
		r.setPdisease(pd);
		Part pic=request.getPart("reportPhoto");
		InputStream is=null;
		is=pic.getInputStream();
		byte[] p=org.apache.commons.io.IOUtils.toByteArray(is);
		r.setRphoto(p);
		int rid=blm.saveReport(r);
		r=blm.searchByReportId(rid);
		h.setPdisease(pd);
		h.setPregister(pr);
		h.setReport(r);
		blm.saveHistory(h);
		response.sendRedirect("PatintDiseaseSuccess.jsp");
		
	}

}
