package com.codes.pro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class PCMControl {
	
	public int phy;
	public int che;
	public int mat;
	
	
	public int Total(int p,int c,int m)
	{
		phy=p;
		che=c;
		mat=m;
		return (p+c+m);
	}
	
	public char grade(int t ) {
		if (phy<40||che<40||mat<40) {return 'F';}
		else if(t/3>=80) {return 'A';}
		else if(t/3>=60&t/3<80) {return 'B'; }
		else { return 'C';}
		
	}
		
	   @GetMapping("/Grade")
	   @ResponseBody
	    public ModelAndView htmlView(Model model,@RequestParam(name="Physics",required=false,defaultValue="0") int Physics,
				  @RequestParam(name="Chemistry",required=false,defaultValue="0") int Chemistry,
				  @RequestParam(name="Math",required=false,defaultValue="0") int Math )
	  {    
		   
		   SubjectMarks result = new SubjectMarks();
		    
		   result.setPhysics(Physics);
		   result.setChemistry(Chemistry);
		   result.setMath(Math);
		   result.setTotal(Total( Physics,Chemistry,Math));
		   result.setGrade(grade(result.getTotal() ));
		   
	      
	        ModelAndView mav = new ModelAndView();
	        mav.addObject("result", result);
	        mav.setViewName("PCMFront");   
	        return mav;
	  }
  }

