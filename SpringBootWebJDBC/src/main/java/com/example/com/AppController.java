package com.example.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	
	@Autowired
	private SalesDAO dao;
	
	@RequestMapping("/")
	public String sales(Model model) {
		List<Sales> sa = dao.list();
		model.addAttribute("list", sa);
		return "index";
	}

	@RequestMapping("/new")
	public String showNewForm(Model model) {
	    Sales sale = new Sales();
	    model.addAttribute("add", sale);
	      
	    return "new_form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("sale") Sales sale) {
	    dao.save(sale);
	      
	    return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_form");
	    Sales sale = dao.get(id);
	    mav.addObject("edit", sale);
	 
	    return mav;
	}
}




// Example of handler method and fxn

// We have defined a single request handler method, 
// it’s accepting GET requests with URI “/hello” and returning “home.jsp” page
// as the response. Notice that we are setting an attribute to the model, 
// which will be used in the home.jsp page

//@Controller
//public class HomeController {
//
//	@GetMapping("/hello")
//	public String home(Locale locale, Model model) {
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		String formattedDate = dateFormat.format(date);
//		model.addAttribute("serverTime", formattedDate);
//		return "home";
//	}
//
//}