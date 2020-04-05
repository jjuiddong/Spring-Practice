package com.mycompany.mvc;

//import java.text.DateFormat;
//import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application echo page.
 */
@Controller
public class EchoController {
	
	private static final Logger logger = LoggerFactory.getLogger(EchoController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/echo", method = RequestMethod.GET)
	public String viewInput(Locale locale, Model model) {

		logger.info("echo request");
		
		EchoForm form = new EchoForm();
		model.addAttribute("echoForm", form);
		return "echo/input";
	}
	
	@RequestMapping(value = "/echo", method = RequestMethod.POST)
	public String echo(@Valid EchoForm form, BindingResult result)
	{
		logger.info("echo POST request");
		if (result.hasErrors())
		{
			return "echo/input";
		}		
		return "echo/output";
	}	
	
}
