package com.example.kadai.app.user;

import javax.inject.Inject;
import javax.validation.groups.Default;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.message.ResultMessages;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenCheck;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenType;

import com.example.kadai.app.user.UserForm.register;
import com.example.kadai.domain.model.user.Role;
import com.example.kadai.domain.model.user.User;
import com.example.kadai.domain.service.user.UserService;

@Controller
@RequestMapping("user")
@TransactionTokenCheck("Search")
@SessionAttributes(types = { UserForm.class })
public class RegisterController {

	private static final Logger logger = LoggerFactory
			.getLogger(RegisterController.class);

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

	@RequestMapping(value = "/register", params = "form", method = RequestMethod.GET)
	public String registerFormClear(SessionStatus sessionStatus) {

		sessionStatus.setComplete();

		return "redirect:/user/register";
	}

	@TransactionTokenCheck(type = TransactionTokenType.BEGIN)
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm(Model model) {

		return "user/registerForm";
	}

	@TransactionTokenCheck(type = TransactionTokenType.IN)
	@RequestMapping(value = "/register", params = "confirm", method = RequestMethod.POST)
	public String registerConfirm(
			@Validated({ register.class, Default.class }) UserForm form,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "user/registerForm";
		}

		return "user/registerConfirm";
	}

	@TransactionTokenCheck(type = TransactionTokenType.IN)
	@RequestMapping(value = "/register", params = "redo", method = RequestMethod.POST)
	public String registerRedo(Model model) {

		return "user/registerForm";
	}

	@TransactionTokenCheck(type = TransactionTokenType.IN)
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Validated UserForm form, BindingResult result,
			RedirectAttributes redirectAttrs, Model model) {

		if (result.hasErrors()) {
			return "user/registerForm";
		}

		// TODO RoleをUserに入れたいが時間がないのであとまわし。
		// TODO Dozerの<date-format>をyyyy/MM/ddにしていていいのだろうか？
		User user = mapper.map(form, User.class);
		Role role = mapper.map(form, Role.class);

		userService.create(user, role);

		redirectAttrs.addAttribute("id", form.getId());

		return "redirect:/user/register?finish";
	}

	@TransactionTokenCheck(type = TransactionTokenType.IN)
	@RequestMapping(value = "/register", params = "finish", method = RequestMethod.GET)
	public String registerFinish(@RequestParam("id") String id,
			SessionStatus sessionStatus, Model model) {

		ResultMessages messages = ResultMessages.info().add("i.ex.an.0001", id,
				"登録");
		model.addAttribute(messages);

		sessionStatus.setComplete();

		return "gcommon/result";
	}

}
