 package com.codes.pro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class PCMControl {
	public int total(int p,int c,int m)
	{ return (p+c+m);}
	
	public char Grade(int t ) {
		if (t/3>=80) {return 'A';}
		else if(t/3>=50&t/3<80) {return 'B'; }
		else { return 'C';}
		
	}
	
	@GetMapping("/grade-json")
	@ResponseBody
	  public SubjectMarks displayResult(@RequestParam(name="Physics",required=false,defaultValue="")  String Physics,
			  @RequestParam(name="Chemistry",required=false,defaultValue="") String Chemistry,
			  @RequestParam(name="Math",required=false,defaultValue="") String Math ) 
	  { 
		SubjectMarks result = new SubjectMarks();
		jsonErrorResponse exe = new jsonErrorResponse(); 
		int p1=Integer.parseInt(Physics);
		int c1=Integer.parseInt(Chemistry);
		int m1=Integer.parseInt(Math);
if (Physics==null||Chemistry==null||Math==null) {SubjectMarks mav = new SubjectMarks();
        
        mav.setViewName("error.html");   
        return mav;}	

else if(p1<0||p1>100||c1<0||c1>100||m1<0||m1>100) {
	SubjectMarks mav = new SubjectMarks();
     
     mav.setViewName("Error: Marks out of RANGE ");   
     return mav;
}




else {
		try { 
		result.setPhysics(Physics);
		result.setChemistry(Chemistry);
		result.setMath(Math);
		result.setTotal(total( p1,c1,m1));
		if((result.getTotal()/3)>=80) 
		{result.setGrade('A');}
		else if ((result.getTotal()/3)>=50 &(result.getTotal()/3)<80) {result.setGrade('B');}
		else if (result.getTotal()/3<50) {result.setGrade('C');
		}
		}catch(Exception e) { 
			exe.setMessage("Exception:Number Format Exception");
		    exe.setDetails(""+e);
			System.out.println("Exception Here:"+e);}
}	
		  
	    return result;
	
	 }
	

	@PostMapping(value="/grade-json",consumes="application/json",produces="application/json")
	 @ResponseBody
	public SubjectMarks acceptResult(@RequestBody SubjectMarks result){
		
		return result;
		}
		
 
	   @GetMapping("/Grade")
	   @ResponseBody
	    public ModelAndView htmlView(Model model,@RequestParam(name="Physics",required=true,defaultValue="")String Physics,
				  @RequestParam(name="Chemistry",required=false,defaultValue="") String Chemistry,
				  @RequestParam(name="Math",required=false,defaultValue="") String Math )
	  {    
		   SubjectMarks  result = new SubjectMarks();
		   int p1=Integer.parseInt(Physics);
			int c1=Integer.parseInt(Chemistry);
			int m1=Integer.parseInt(Math);
		   result.setPhysics(Physics);
		   result.setChemistry(Chemistry);
		   result.setMath(Math);
		   
		   	
		   result.setTotal(total( p1,c1,m1));
		   result.setGrade(Grade(result.getTotal() ));
		   
		   if(p1<0||p1>100||c1<0||c1>100||m1<0||m1>100) {
			   ModelAndView mav = new ModelAndView();
		        
		        mav.setViewName("error.html");   
		        return mav;
		   }
		   else if(Physics==null||Chemistry==null||Math==null) {
		    	ModelAndView mav = new ModelAndView();
		        
		        mav.setViewName("error.html");   
		        return mav;}
		    else {
	        ModelAndView mav = new ModelAndView();
	        mav.addObject("result", result);
	        mav.setViewName("PCMFront.html");   
	        return mav;}}
	  

	   
	   
	   
	   
	   
	   
	  
	   

	  
}

