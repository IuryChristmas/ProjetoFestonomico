<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edita Produto</title>
</head>
<body>
	<h2>Edite os dados do Produto</h2>
	<c:forEach var="produto" items="${produto }">
	<form action="editaProduto">
		<input type="hidden" name="id" value="${produto.id }"/>
		Nome: <input type="text" name="nome" value="${produto.nome }"/>
		Preço: <input type="text" name="valor" value="${produto.preco }"/>
		Quantidade: <input type="number" name="quantidade" value="${produto.quantidade }"/>
		
		<input type="submit" value="Salvar"/>
	</form>
	</c:forEach>
</body>
</html>