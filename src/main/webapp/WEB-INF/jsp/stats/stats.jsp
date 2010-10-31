<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/dataTables_table_jui.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/dataTables_table.css"/>" />

<h1>Estat�sticas</h1>

<h2>Globais</h2>

<p>Erros reportados: ${appData.reportedErrors}</p>
<p>Palavras no dicion�rio: ${appData.dictionaryEntries}</p>
<p>Membros cadastrados: ${appData.registeredMembers}</p>
<br />
<p>Usu�rios online: ${appData.onlineUsers}</p>
<p>Visitantes: ${appData.onlineVisits}</p>
<p>Membros online: ${appData.onlineMembers}</p>
<br />

<h2>Temporais</h2>
<img
	src="http://chart.apis.google.com/chart?chf=bg,s,67676700&chxr=0,1,18|1,0,20&chxs=0,676767,11.5,0,lt,676767|1,676767,11.5,0,lt,676767&chxt=x,y&chs=440x220&cht=lxy&chco=3072F3,FF9900&chds=1,18,0,20,1,18,0,20&chd=t:1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18|0,0,0,0,0,0,0,0,0,0,4,1,7,3,17,5,2,10|1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18|0,0,0,0,0,0,0,0,0,0,2,0,3,5,2,1,4,8&chdl=Visitas|Erros+reportados&chdlp=b&chg=0,10&chls=2,4,1|1&chma=5,5,5,25|5&chtt=Outubro"
	width="440" height="220" alt="Outubro" />

<br />

<h2>Relat�rios</h2>

<h3>Membros online</h3>
<table cellpadding="0" cellspacing="0" border="0" class="display"
	id="table_id">
	<thead>
		<tr>
			<th>Nome</th>
			<th>Login</th>
			<th>�ltimo login</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${appData.loggedUsers}">
			<tr>
				<td>${user.name}</td>
				<td>${user.login}</td>
				<td><fmt:formatDate value="${user.lastLogin}"
					pattern="dd/MM/yyyy HH:mm" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br />

<h3>Usu�rios inativos (sem login h� mais de um m�s)</h3>
<table cellpadding="0" cellspacing="0" border="0" class="display"
	id="table_id">
	<thead>
		<tr>
			<th>Nome</th>
			<th>Login</th>
			<th>�ltimo login</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${appData.idleUsers}">
			<tr>
				<td>${user.name}</td>
				<td>${user.login}</td>
				<td><fmt:formatDate value="${user.lastLogin}"
					pattern="dd/MM/yyyy HH:mm" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br />
<br />

<h3>Usu�rios mais ativos (por ordem de login)</h3>
<table cellpadding="0" cellspacing="0" border="0" class="display"
	id="table_id">
	<thead>
		<tr>
			<th>Nome</th>
			<th>Login</th>
			<th>�ltimo login</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${appData.topUsers}">
			<tr>
				<td>${user.name}</td>
				<td>${user.login}</td>
				<td><fmt:formatDate value="${user.lastLogin}"
					pattern="dd/MM/yyyy HH:mm" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br />
