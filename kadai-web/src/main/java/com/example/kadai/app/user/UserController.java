package com.example.kadai.app.user;

import javax.inject.Inject;
import javax.validation.groups.Default;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.kadai.app.user.UserForm.register;
import com.example.kadai.domain.model.user.Role;
import com.example.kadai.domain.model.user.User;
import com.example.kadai.domain.service.user.UserService;

@Controller
@RequestMapping("user")
@SessionAttributes(types = { UserForm.class })
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	Mapper mapper;

	@Inject
	UserService userService;

	@ModelAttribute(value = "userForm")
	public UserForm setUpUserForm() {
		UserForm form = new UserForm();
		return form;
	}

	@RequestMapping(value = "/search", params = "form", method = RequestMethod.GET)
	public String searchForm(Model model) {

		return "user/searchForm";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchList(Model model) {

		return "user/searchList";
	}

	@RequestMapping(value = "/register", params = "form", method = RequestMethod.GET)
	public String registerForm(Model model) {

		return "user/registerForm";
	}

	@RequestMapping(value = "/register", params = "confirm", method = RequestMethod.POST)
	public String registerConfirm(@Validated({ register.class, Default.class }) UserForm form, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "user/registerForm";
		}

		return "user/registerConfirm";
	}

	@RequestMapping(value = "/register", params = "redo", method = RequestMethod.POST)
	public String registerRedo(Model model) {

		return "user/registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Validated UserForm form, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "user/registerForm";
		}

		// TODO RoleをUserに入れたいが時間がないのであとまわし。
		User user = mapper.map(form, User.class);
		Role role = mapper.map(form, Role.class);

		userService.create(user, role);

		return "redirect:/user/register?finish";
	}

	@RequestMapping(value = "/register", params = "finish", method = RequestMethod.GET)
	public String registerFinish(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "gcommon/result";
	}

}
