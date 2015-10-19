<div id="wrapper">

	<t:messagesPanel />

	<form:form action="${pageContext.request.contextPath}/user/delete"
		method="get" modelAttribute="userForm">

		<c:choose>
			<c:when test="${page != null && page.totalPages != 0}">
				<div style="text-align: center">
					<t:pagination page="${page}" outerElementClass="pagination" />
				</div>
				<div style="text-align: right">
					<fmt:formatNumber value="${page.totalElements}" />
					件 ${f:h(page.number + 1) } / ${f:h(page.totalPages)} ページ
				</div>

				<table class="maintable">
					<thead>
						<tr>
							<th class="no">No</th>
							<th class="radio">選択</th>
							<th class="id">ユーザID</th>
							<th class="name">名前</th>
							<th class="birthday">生年月日</th>
							<th class="address">住所</th>
							<th class="tel">電話番号</th>
							<th class="userRole">権限</th>
							<th class="userStatus">状態</th>
						</tr>
					</thead>

					<c:forEach var="article" items="${page.content}"
						varStatus="rowStatus">
						<tr>
							<td class="no">${(page.number * page.size) + rowStatus.count}
							</td>
							<td class="radio"><form:radiobutton path="id"
									value="${f:h(article.id)}" /></td>
							<td class="id">${f:h(article.id)}</td>
							<td class="name">${f:h(article.name)}</td>
							<td class="birthday"><fmt:formatDate
									value="${article.birthday}" pattern="yyyy/MM/dd" /><br></td>
							<td class="address">${f:h(article.address)}</td>
							<td class="tel">${f:h(article.tel)}</td>
							<td class="userRole">${f:h(article.userRole)}</td>
							<td class="userStatus">${f:h(article.userStatus)}</td>
						</tr>
					</c:forEach>

				</table>

				<div class="tbl center">
					<div class="tbl_cell">
						<form:button name="form" class="btn-lg">更新（未実装）</form:button>
					</div>
					<div class="tbl_cell">
						<form:button name="form" class="btn-lg">削除</form:button>
					</div>
				</div>
			</c:when>
		</c:choose>

	</form:form>
</div>
