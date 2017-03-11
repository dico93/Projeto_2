<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="/view/menu/menu.jsp"></c:import>
<h3>Lista de Usuários</h3>
<div style="text-align: center; color: red;"> ${msg} </div>
<table>
<tr>
	<td>ID</td>
	<td>NOME</td>
	<td>EMAIL</td>
	<td>lOGIN</td>
	<td>DATA DE NASCIMENTO</td>
	<td>IMAGEM</td>
	<td>#</td>
</tr>
<c:forEach var="usuario" items="${listaUsuario}">
<tr>
	<td>${usuario.id}</td>
	<td>${usuario.nome}</td>
	<td>${usuario.email}</td>
	<td>${usuario.login}</td>
	<td><fmt:formatDate value="${usuario.dataNascimento}" pattern="dd/MM/yyyy" /></td>
	<td><img alt="" src="view/img/${usuario.imagem}" style="width: 30%;"></td>
	<td>
		<a href="exibirAlterarUsuario?id=${usuario.id}">Alterar</a>
		<a href="removerUsuario?id=${usuario.id}">Remover</a>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>