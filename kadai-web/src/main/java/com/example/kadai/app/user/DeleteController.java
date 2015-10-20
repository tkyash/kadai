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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.example.kadai.app.user.UserForm.delete;
import com.example.kadai.domain.model.user.User;
import com.example.kadai.domain.service.user.UserService;

@Controller
@RequestMapping("user")
public class DeleteController {

	private static final Logger logger = LoggerFactory
			.getLogger(DeleteController.class);

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

	@RequestMapping(value = "/delete", params = "form", method = RequestMethod.GET)
	public String registerForm(@Validated({ delete.class }) UserForm form,
			BindingResult result, Model model) {

		//TODO　もう一度表示するため、formの検索条件を引き継いだままuser/searchにとんで再検索させたいが、paramsのformが残っていて検索条件入力にとんでしまう。
		if (result.hasErrors()) {
			return "forward:/user/search";
		}

		User user = userService.findOne(form.getId());
		model.addAttribute("userForm", user);

		return "user/deleteForm";
	}

	@RequestMapping(value = "/delete", params = "confirm", method = RequestMethod.POST)
	public String registerConfirm(
			@Validated({ delete.class, Default.class }) UserForm form,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "user/deleteForm";
		}

		// TODO ここで再度取得するのは適切か？hiddenでID以外も持ち回ったほうがいいか？
		User user = userService.findOne(form.getId());
		model.addAttribute("userForm", user);

		return "user/deleteConfirm";
	}

	@RequestMapping(value = "/delete", params = "redo", method = RequestMethod.POST)
	public String registerRedo(
			@Validated({ delete.class, Default.class }) UserForm form,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "user/deleteForm";
		}

		// TODO とりあえず検索画面に戻すことにする。
		// User user = userService.findOne(form.getId());
		// model.addAttribute("userForm", user);

		return "user/searchForm";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String register(
			@Validated({ delete.class, Default.class }) UserForm form,
			BindingResult result, RedirectAttributes redirectAttrs, Model model) {

		if (result.hasErrors()) {
			return "user/deleteForm";
		}

		// TODO
		// hiddenに持っているので、対象idの改ざんを検知できない。画面の値を全部hiddenで送って、全部合致しないと削除できないようにしたほうがいいか？
		userService.delete(form.getId());

		redirectAttrs.addAttribute("id", form.getId());

		return "redirect:/user/delete?finish";
	}

	@RequestMapping(value = "/delete", params = "finish", method = RequestMethod.GET)
	public String registerFinish(@RequestParam("id") String id, Model model) {

		ResultMessages messages = ResultMessages.info().add("i.ex.an.0001", id,
				"削除");
		model.addAttribute(messages);

		return "gcommon/result";
	}

}
