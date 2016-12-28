package com.samples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// Refresh scope will refresh this bean. When we chnage value in github, the change value will be 
// picked up by this bean we use hit the url localhost:8080/refresh.  The actuator library will
// check for RefreshScope and refresh those beans

@Controller
@RefreshScope
public class RateController {

	@Value("${rate}")
	String rate;
	
	@Value("${lanecount}")
	String laneCount;
	
	@Value("${tollstart}")
	String tollStart;
	
	@Value("${connstring}")
	String connString;
	
	@RequestMapping("/rate")
	public String getRate(Model m ) {
		m.addAttribute("rateamount", rate);
		m.addAttribute("lanes", laneCount);
		m.addAttribute("tollstart", tollStart);
		m.addAttribute("connstring", connString);
		
		
		return "rateview";
	}
	
}
