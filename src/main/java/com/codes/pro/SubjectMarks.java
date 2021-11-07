package com.codes.pro;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")

public class SubjectMarks extends HttpServlet{
	public static final long serialVersionUID = 1L;
	
	private int physics;
	private	int chemistry;
	private	int math;
	private int total;
	private float percentage;
	private	char grade;
	
	public int ph;
	public int ch;
	public int ma;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("PCMFront.html")	;
		
		ph=Integer.parseInt(request.getParameter("Physics"));
		ch=Integer.parseInt(request.getParameter("Chemistry"));
		ma=Integer.parseInt(request.getParameter("Maths"));
		
		rd.include(request,response);
	}
	
	public int getPhysics() {
		return physics;
	}
	public void setPhysics(int Physics) {
		this.physics = Physics;
	}
	public void setPhysics() {
		this.physics = ph;
	}
	public int getChemistry() {
		return chemistry;
	}
	public void setChemistry(int Chemistry) {
		this.chemistry = Chemistry;
	}
	public void setChemistry() {
		this.chemistry = ch;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int Math) {
		this.math = Math;
	}
	public void setMath() {
		this.math = ma;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int Total) {
		this.total = Total;
	}
	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}	
}
	

