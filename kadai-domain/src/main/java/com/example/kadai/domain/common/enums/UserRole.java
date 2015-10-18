package com.example.kadai.domain.common.enums;

import org.terasoluna.gfw.common.codelist.EnumCodeList.CodeListItem;

public enum UserRole implements CodeListItem {

	ADMIN("1", "ADMN"), USER("2", "USER");

	private final String value;
	private final String label;

	private UserRole(String codeValue, String codeLabel) {
		this.value = codeValue;
		this.label = codeLabel;
	}

	@Override
	public String getCodeValue() {
		return value;
	}

	@Override
	public String getCodeLabel() {
		return label;
	}
}
