package com.controller;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.icu.text.SimpleDateFormat;
import com.model.BLManager;
import com.pojo.Bill;
import com.pojo.Pdisease;
import com.pojo.Pregister;
@WebServlet("/AddBillingServlet")
public class AddBillingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
Pdisease pd=new Pdisease();
BLManager blm=new BLManager();
Pregister pr=new Pregister();
Bill b=new Bill();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		int pid=Integer.parseInt(request.getParameter("pid"));
	
		List<Pdisease> pd=blm.searchByPidInPdisease(pid);
		System.out.println();
		HttpSession session =request.getSession();
		if(pd.isEmpty()==true){
			response.sendRedirect("RecordNotFound.jsp");	
		}
		else if((pd.size()>=1))
		{
		session.setAttribute("pd",+pd.get(pd.size()-1).getPdid());
		response.sendRedirect("AddBilling.jsp");
		}
		else{
			session.setAttribute("pd",+pd.get(0).getPdid());
			response.sendRedirect("AddBilling.jsp");
		}
		
		
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid=Integer.parseInt(request.getParameter("pid"));
		int pdid=Integer.parseInt(request.getParameter("pdid"));
		pd=blm.searchByPatientDiseaseId(pdid);
		pr=blm.searchByPatientId(pid);
		String status="paid";
	    int gday=Integer.parseInt(request.getParameter("gday"));
	    int sday=Integer.parseInt(request.getParameter("sday"));
	    int iday=Integer.parseInt(request.getParameter("iday"));
	    int gt=Integer.parseInt(request.getParameter("gt"));
	    int st=Integer.parseInt(request.getParameter("st"));
	    int it=Integer.parseInt(request.getParameter("it"));
	    String acnonac=request.getParameter("acnonac");
	    int other=Integer.parseInt(request.getParameter("other"));
	    String reason=request.getParameter("reason");
	   int  ot=Integer.parseInt(request.getParameter("ot"));
	   int confee=Integer.parseInt(request.getParameter("confee"));
	   int lab=Integer.parseInt(request.getParameter("lab"));
	   int medical=Integer.parseInt(request.getParameter("medical"));
	   String payment=request.getParameter("payment");
	  long amt=Long.parseLong(request.getParameter("amt"));
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date udate=new Date();
		sdf.format(udate);
		long ms=udate.getTime();
		java.sql.Date sdate=new java.sql.Date(ms);
		b.setDate(sdate);
		b.setGeneralDay(gday);
		b.setSpecialDay(sday);
		b.setIcuDay(iday);
		b.setGeneralTotal(gt);
		b.setSpecialTotal(st);
		b.setIcuTotal(it);
		b.setAcNonac(acnonac);
		b.setOtherCharges(other);
		b.setReason(reason);
		b.setOperationTheater(ot);
		b.setConsultingFees(confee);
		b.setLabTestCharges(lab);
		b.setMedicalCharges(medical);
		b.setPayment(payment);
        b.setTotal(amt);
        b.setStatus(status);
        b.setPdisease(pd);
        b.setPregister(pr);
        blm.saveBillingDetails(b);
        response.sendRedirect("Billing.jsp");
        
		
		
		
		
	}

}
