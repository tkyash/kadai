package com.example.kadai.app.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("login")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@ModelAttribute
	public LoginForm setUpLoginForm() {
		LoginForm form = new LoginForm();
		return form;
	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String loginView(Model model) {

		return "top/menu";

	}

	@RequestMapping(value = "/menu", method = RequestMethod.POST)
	public String login(Model model) {

		return "top/menu";

	}

}
