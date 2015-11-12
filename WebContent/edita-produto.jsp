<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edita Produto</title>
		<!-- CSS -->
		<link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap-theme.min.css" />
	</head>
	<body>
		<div class="container">
'		<jsp:include page="./template/barra_superior.jspf"></jsp:include>
		
		<div class="container col-md-3 col-sm-4 col-xs-4" style="padding-top:11%">
			<div class= "row">
				<jsp:include page="./template/side_bar.jspf"></jsp:include>
			</div>
		</div>
		<section class="container col-md-9 col col-sm-8 col-xs-8">
			<div class= "row" style="padding-top: 10%">
				<div class="col-md-12 col">
					
					<div class="row">
						<div class="col-md-12 col">
							<header>
								<h2>Edite os dados do Produto</h2>
								<span>Nessa sessão, preencha os dados do produto a serem alterados.</span>
							</header>
						</div>
					</div>
					
					<div class="form-horizontal col-md-8 col">
						<c:forEach var="produto" items="${produto }">
							<form action="editaProduto">
								<input type="hidden" name="id" value="${produto.id }"/>
								<div class="form-group">
									<label for="campoNome" class="control-label">Nome:</label> 
									<input id="campoNome" class="form-control" type="text" name="nome" value="${produto.nome }"/>
								</div>
								
								<div class="form-group">
									<label for="campoPreco" class="control-label">Preço:</label> 
									<input id="campoPreco" class="form-control" type="text" name="valor" value="${produto.preco }"/>
								</div>
								
								<div class="form-group">
									<label for="campoQtd" class="control-label">Nome:</label> 
									<input id="campoQtd" class="form-control" type="number" name="quantidade" value="${produto.quantidade }"/>
								</div>
								
								<div class="btn-group-justified" role="group">
									<button type="submit" class="btn btn-primary">Salvar</button>
								</div>
								
							</form>
						</c:forEach>
					</div>
				</div>
			</div>
		</section>
		<!-- JS & JQUERY -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
 	<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>