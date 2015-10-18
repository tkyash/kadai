<div id="wrapper">

	<t:messagesPanel />

	<form:form action="${pageContext.request.contextPath}/user/register"
		method="post" modelAttribute="userForm">

		<div class="tbl">
			<div class="tbl_cell right">
				<p>ユーザID：</p>
			</div>
			<div class="tbl_cell">
				<input type="text" name="id" value="" placeholder="TODo自動採番にしたい" />
				<form:errors path="id" />
			</div>
		</div>

		<div class="tbl">
			<div class="tbl_cell right">
				<p>名前：</p>
			</div>
			<div class="tbl_cell">
				<form:input path="name" />
				<form:errors path="name" />
			</div>
		</div>

		<div class="tbl">
			<div class="tbl_cell right">
				<p>生年月日：</p>
			</div>
			<div class="tbl_cell">
				<form:input path="birthday" />
				<form:errors path="birthday" />
			</div>
		</div>

		<div class="tbl">
			<div class="tbl_cell right">
				<p>住所：</p>
			</div>
			<div class="tbl_cell">
				<form:input path="address" />
				<form:errors path="address" />
			</div>
		</div>

		<div class="tbl">
			<div class="tbl_cell right">
				<p>電話番号：</p>
			</div>
			<div class="tbl_cell">
				<form:input path="tel" />
				<form:errors path="tel" />
			</div>
		</div>

		<div class="tbl">
			<div class="tbl_cell right">
				<p>権限：</p>
			</div>
			<div class="tbl_cell">
				<form:checkboxes items="${CL_USERROLE}" path="userRole" />
				<form:errors path="userRole" />
			</div>
		</div>

		<div class="tbl">
			<div class="tbl_cell right">
				<p>パスワード：</p>
			</div>
			<div class="tbl_cell">
				<form:input path="password" />
				<form:errors path="password" />
			</div>
		</div>

		<div class="tbl">
			<div class="tbl_cell right">
				<p>パスワード確認：</p>
			</div>
			<div class="tbl_cell">
				<form:input path="confirmPassword" />
			</div>
		</div>

		<div class="tbl">
			<div class="tbl_cell right">
				<form:button name="confirm" class="btn-lg">登録</form:button>
			</div>
		</div>
	</form:form>

</div>
