package com.example;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// The controller class is to handle requests 
// coming from the hyperlink: 
// "Click here to list all contacts"
// from the address URL /list_contact

@Controller
public class AController {

	@RequestMapping("/contacts")

	// The @RequestMapping("/list_contact") annotation specifies that the
	// listContact()
	// method is responsible to handle requests coming from the /list_contact URL.

	public String listContact(Model model) {

		ContactBusiness bus = new ContactBusiness();
		List<Contact> contactList = bus.getContactList();

		model.addAttribute("obj", contactList);

		return "contact";

	}

	// This method above uses the ContactBusiness class to get a List of
	// Contact objects and puts this collection to a Model object,
	// which will be then used by the view. Finally it returns the view name
	// “contact”,
	// which can be resolved to a JSP page or a ThymeLeaf template, depending on our
	// configuration.

	@PostMapping("/hello")
	public String sayHello(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

}
