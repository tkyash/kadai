package com.example.kadai.app.common.check.correlation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.kadai.app.user.UserForm;

public class PasswordEqualsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// 本バリデータのチェック対象をUserFormに設定。
		return UserForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		// 単項目チェックでエラーがある場合本チェックはしない。
		if (errors.hasFieldErrors("password")) {
			return;
		}

		UserForm form = (UserForm) target;
		String password = form.getPassword();
		String cpassword = form.getConfirmPassword();
		if (!password.equals(cpassword)) {
			// 対象フィールド名、エラーコード、デフォルトメッセージ
			errors.rejectValue("password", "misettei", "パスワードと確認用パスワードが一致しません。");
		}

	}

}
