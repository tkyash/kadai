<div id="wrapper">

	<t:messagesPanel />

	<form:form action="${pageContext.request.contextPath}/user/register"
		method="post" modelAttribute="userForm">

		<div class="tbl">
			<div class="tbl_cell right">
				<p>ユーザID：</p>
			</div>
			<div class="tbl_cell">${f:h(userForm.id)}</div>
		</div>

		<div class="tbl">
			<div class="tbl_cell right">
				<p>名前：</p>
			</div>
			<div class="tbl_cell">${f:h(userForm.name)}</div>
		</div>

		<div class="tbl">
			<div class="tbl_cell right">
				<p>生年月日：</p>
			</div>
			<div class="tbl_cell">${f:h(userForm.birthday)}</div>
		</div>

		<div class="tbl">
			<div class="tbl_cell right">
				<p>住所：</p>
			</div>
			<div class="tbl_cell">${f:h(userForm.address)}</div>
		</div>

		<div class="tbl">
			<div class="tbl_cell right">
				<p>電話番号：</p>
			</div>
			<div class="tbl_cell">${f:h(userForm.tel)}</div>
		</div>

		<div class="tbl">
			<div class="tbl_cell right">
				<p>権限：</p>
			</div>
			<div class="tbl_cell">
				<c:forEach var="userRole" items="${userForm.userRole}"
					varStatus="status">
					${f:h(CL_USERROLE[userRole])}&nbsp;
				</c:forEach>
			</div>
		</div>

		<div class="tbl">
			<div class="tbl_cell right">
				<form:button class="btn-lg">確認</form:button>
				<form:button name="redo" class="btn-lg">やり直し</form:button>
			</div>
		</div>
	</form:form>

</div>
