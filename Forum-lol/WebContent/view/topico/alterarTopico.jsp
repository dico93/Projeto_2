<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="/view/menu/menu.jsp"></c:import>
	
<h3>Alterar Tópico</h3>
	
<div style="text-align: center; color: red;"> ${msg} </div>

<form action="alterarTopico" method="post" >

	<input type="hidden" name="id" value="${topico.id}" />
	Título:
	<br /><input type="text" name="titulo" value="${topico.titulo}"/><br />
	<br />Conteúdo:<br />
	<textarea name="conteudo" rows="20" cols="75" >${topico.conteudo}</textarea>
	<br />
	<input type="hidden" name="usuario" value="${topico.usuario.id}"/>

	<select name="categoria" >
				<option value=""> Selecione </option>
				<c:forEach items="${listaCategoria}" var="obj">
					<option value="${obj.id}" <c:if test="${obj.id eq topico.categoria.id}">selected="selected"</c:if>> 
						${obj.titulo} 
					</option>
				</c:forEach> 
			</select>

	<br /><input type="submit" value="Alterar"/>
	
	</form>
</body>
</html>