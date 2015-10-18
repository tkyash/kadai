<div id="wrapper">

	<t:messagesPanel />
	<h1>メニュー</h1>


	<div class="tbl center">
		<div class="tbl_cell">
			<form:form action="${pageContext.request.contextPath}/user/register"
				method="get" modelAttribute="loginForm">
				<form:button name="form" class="btn-lg">登録</form:button>
			</form:form>
		</div>

		<div class="tbl_cell">
			<form:form action="${pageContext.request.contextPath}/user/search"
				method="get" modelAttribute="loginForm">
				<form:button name="form" class="btn-lg">検索</form:button>
			</form:form>
		</div>
	</div>

	<div class="tbl center">
		<div class="tbl_cell">
			<form:form action="${pageContext.request.contextPath}/user/registerBulk"
				method="get" modelAttribute="loginForm">
				<form:button name="form" class="btn-lg">一括登録（未実装）</form:button>
			</form:form>
		</div>
		<div class="tbl_cell">
			<form:form action="${pageContext.request.contextPath}/user/registerBulkConfirm"
				method="get" modelAttribute="loginForm">
				<form:button name="form" class="btn-lg">一括登録結果確認（未実装）</form:button>
			</form:form>
		</div>
	</div>

</div>
