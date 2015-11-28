<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Produtos</title>
</head>
<body>
	<table>
		<tr>
			<th>Nome do Produto</th>
			<th>Valor</th>
			<th>Quantidade</th>
		</tr>
		<c:forEach var="produtos" items="${produtos}">
		<tr>
			<td>${produtos.nome}</td>
			<td>${produtos.preco}</td>
			<td>${produtos.quantidade}</td>
			<td><a href="festonomica?logica=SelecionaProdutoLogica&id=${produtos.id }">Alterar</a></td>
			<td><a href="festonomica?logica=RemoveProdutoLogica&id=${produtos.id }">Remover</a></td>
		</tr>
		</c:forEach>
		<tr>
			<th>Total</th>
			<th>${total }</th>
		</tr>
	</table>
	<a href="adiciona-produto.jsp"><button>Adicionar Novo Produto</button></a>
</body>
</html>