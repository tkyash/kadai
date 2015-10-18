<div id="wrapper">

	<t:messagesPanel />
	<h1>メニュー</h1>

	<form:form action="${pageContext.request.contextPath}/user/menu"
		method="get" modelAttribute="loginForm">

		<div class="tbl">
			<div class="tbl_cell">
				<form:button name="register" class="btn-lg">登録</form:button>
			</div>

			<div class="tbl_cell">
				<form:button name="list" class="btn-lg">検索</form:button>
			</div>
		</div>

		<div class="tbl">
			<div class="tbl_cell">
				<form:button name="registerBulk" class="btn-lg">一括登録（未実装）</form:button>
			</div>
			<div class="tbl_cell">
				<form:button name="registerBulkConfirm" class="btn-lg">一括登録結果確認（未実装）</form:button>
			</div>
		</div>
	</form:form>

</div>
