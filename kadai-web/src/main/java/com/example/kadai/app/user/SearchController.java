package com.example.kadai.app.user;

import javax.inject.Inject;
import javax.validation.groups.Default;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.kadai.domain.model.user.Role;
import com.example.kadai.domain.model.user.User;
import com.example.kadai.domain.service.user.UserService;

@Controller
@RequestMapping("user")
public class SearchController {
	// TODO セッションの使用未使用をわけるのに、コントローラー自体を分けるのは適切か？

	private static final Logger logger = LoggerFactory
			.getLogger(SearchController.class);

	@Inject
	Mapper mapper;

	@Inject
	UserService userService;

	// 送信パラメータが空文字の場合はnullをセットする設定
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// bind empty strings as null
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@ModelAttribute(value = "userForm")
	public UserForm setUpUserForm() {
		UserForm form = new UserForm();
		return form;
	}

	@RequestMapping(value = "/search", params = "form", method = RequestMethod.GET)
	public String searchForm(Model model) {

		return "user/searchForm";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchList(@Validated({ Default.class }) UserForm form,
			BindingResult result, @PageableDefault(size = 5) Pageable pageable,
			Model model) {

		if (result.hasErrors()) {
			return "user/searchForm";
		}

		User user = mapper.map(form, User.class);
		Role role = mapper.map(form, Role.class);

		Page<User> page = userService.findAll(user, role, pageable);

		model.addAttribute("page", page);

		return "user/searchList";
	}
}
