package com.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.icu.text.SimpleDateFormat;
import com.model.BLManager;
import com.pojo.Doctor;
import com.pojo.Pdisease;
import com.pojo.Pregister;

/**
 * Servlet implementation class SavePatientDiseaseInfoServlet
 */
@WebServlet("/SavePatientDiseaseInfoServlet")
public class SavePatientDiseaseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
Pdisease pd=new Pdisease();
Pdisease pd1=new Pdisease();
Pregister pr=new Pregister();
Doctor dr= new Doctor();
	BLManager blm=new BLManager();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
	    int docref=Integer.parseInt(request.getParameter("drefernce"));
		int pid=Integer.parseInt(request.getParameter("pid"));
		String diseasenaem=request.getParameter("name");
		String wardno=request.getParameter("wardno");
		String bedno=request.getParameter("bedno");
		String iname=request.getParameter("iname");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		sdf.format(date);
		long ms=date.getTime();
		java.sql.Date sdate= new java.sql.Date(ms);
		pd.setAdmissionDate(sdate);
		pd.setBedno(bedno);
		pd.setInchargeName(iname);
		pd.setWardno(wardno);
		pd.setDiseaseName(diseasenaem);
		pr=blm.searchByPatientId(pid);
		dr=blm.searchByDoctorId(docref);
		pd.setDoctor(dr);
		pd.setPregister(pr);
		int disease=blm.savePatienDiseaseInfo(pd);
		pd1=blm.searchByPatientDiseaseId(disease);
		HttpSession sess5=request.getSession();
		sess5.setAttribute("pd",pd1);
		response.sendRedirect("PatintDiseaseSuccess.jsp");
		
		
		
	}

}
