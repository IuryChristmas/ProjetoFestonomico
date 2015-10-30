<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adição de Produto</title>
</head>
<body>
	<h1>Adiciona Produtos</h1>
	<form action="adicionaProduto">
		Nome: <input type="text" name="nome"/><br/>
		Codigo do Produto: <input type="text" name="cod_produto"/><br/>
		Valor Unitário: <input type="number" name="preco_unitario"/><br/>
		Quantidade: <input type="number" name="quantidade"/><br/>
		
		<input type="submit" value="Adicionar Produto"/>
	</form>
</body>
</html>