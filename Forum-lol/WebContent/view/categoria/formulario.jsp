<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:import url="/view/menu/menu.jsp"></c:import>

<h3>Nova Categoria</h3>

<div style="text-align: center; color: red;"> ${msg} </div>

<form action="cadastraCategoria" method="post">
Título:
<br /><input type="text" name="titulo"><br />
Descrição:
<br /><input type="text" name="descricao"><br />
<br /><input type="submit" value="Inserir"><br />
</form>
</body>
</html>