package com.example.kadai.domain.common.enums;

import org.terasoluna.gfw.common.codelist.EnumCodeList.CodeListItem;

public enum UserStatus implements CodeListItem {
	
	INIT("1", "INIT"), NORMAL("2", "NORMAL"), STOP("3", "STOP"), DELETE("4", "DELETE");

	private final String value;
	private final String label;

	private UserStatus(String codeValue, String codeLabel) {
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
