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
	
	public float percentage(float t ) {
		return((t*100)/300);
	}
	
	@GetMapping("/json")
	@ResponseBody
	  public JsonSMarks displayResult(@RequestParam(name="Physics",required=false,defaultValue="0")  String Physics,
			  @RequestParam(name="Chemistry",required=false,defaultValue="0") String Chemistry,
			  @RequestParam(name="Math",required=false,defaultValue="0") String Math ) 
	  { 
		JsonSMarks result = new JsonSMarks();
		jsonErrorResponse exe = new jsonErrorResponse(); 
		int p1=Integer.parseInt(Physics);
		int c1=Integer.parseInt(Chemistry);
		int m1=Integer.parseInt(Math);
		if(p1<0||p1>100||c1<0||c1>100||m1<0||m1>100) {
			JsonSMarks mav = new JsonSMarks(); 
			mav.setViewName("Error: Marks are out of Range. Range = 0 to 100 ");   
			return mav;
		}else{
			try { 
				result.setPhysics(Physics);
				result.setChemistry(Chemistry);
				result.setMath(Math);
				result.setTotal(Total( p1,c1,m1));
				result.setPercentage(percentage(result.getTotal()));
				result.setGrade(grade(result.getTotal() ));
				result.setViewName("Successful Build");
			}catch(Exception e) { 
				exe.setMessage("Exception:Number Format Exception");
			    exe.setDetails(""+e);
				System.out.println("Exception Here:"+e);
			}
		}		  
	    return result;
}
	

	@PostMapping(value="/json",consumes="application/json",produces="application/json")
	@ResponseBody
	public JsonSMarks acceptResult(@RequestBody JsonSMarks result){	
		return result;
	}
		
	@GetMapping("")
	@ResponseBody
	public ModelAndView htmlView(Model model,@RequestParam(name="Physics",required=false,defaultValue="0") int Physics,
				  @RequestParam(name="Chemistry",required=false,defaultValue="0") int Chemistry,
				  @RequestParam(name="Math",required=false,defaultValue="0") int Math )
	  {    
		   if(Physics<0||Physics>100||Chemistry<0||Chemistry>100||Math<0||Math>100)
		   {
			   	ModelAndView mav = new ModelAndView();
		        mav.setViewName("outofrange");   
		        return mav;
		   }else {
			   SubjectMarks result = new SubjectMarks();
			    
			   result.setPhysics(Physics);
			   result.setChemistry(Chemistry);
			   result.setMath(Math);
			   result.setTotal(Total( Physics,Chemistry,Math));
			   result.setPercentage(percentage(result.getTotal()));
			   result.setGrade(grade(result.getTotal() ));
			   
		      
		        ModelAndView mav = new ModelAndView();
		        mav.addObject("result", result);
		        mav.setViewName("PCMFront");   
		        return mav;
		   }
	  }
  }

