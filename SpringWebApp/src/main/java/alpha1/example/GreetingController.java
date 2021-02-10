package alpha1.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import alpha1.example.beans.Customer;

@Controller
@RequestMapping("/greet")
public class GreetingController {

	
	// @PostMapping only method that will take post request by annotation
	
//	@GetMapping	// only method that will take Get request by annotation
	
	@PostMapping
	public String sayHello(@RequestParam(name= "name") 
	String custName, @RequestParam(name= "zip") 
	String custZip,  Model model) {
		
		Customer c = new Customer();
		
		c.setName(custName);
		model.addAttribute("cust", c); 
		
		c.setZip(custZip);
		
		System.out.println(c.getName()); // This can be used to check if the method is work
		
				// if the name you type in the address bar pops up the method works fine
		
		return "details"; 
	}
	
	@GetMapping
	public String sayOye(@RequestParam(name= "name") 
	String custName, Model model) {
		
		Customer c = new Customer();
		c.setName(custName);
		model.addAttribute("cust", c); 
		
		System.out.println(c.getName()); // This can be used to check if the method is work
		
				// if the name you type in the address bar pops up the method works fine
		
		return "details"; 
	}
	
	@PostMapping
	public String sayHello(@ModelAttribute Customer cust) {
		
		return "details"; 
	}
	
}
