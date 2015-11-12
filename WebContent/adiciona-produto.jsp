<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Adicionar Produto</title>
		
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
								<h2><span class="glyphicon glyphicon-shopping-cart" ></span> Adicionar Produtos</h2>
								<span>Nessa sessão, preencha os dados do produto.</span>
							</header>
						</div>
					</div>
					
					<div class="form-horizontal col-md-8 col">
						<form  action="festonomica" method="post">
							<div class="form-group">
								<label for="campoNome" class="control-label">Nome:</label> 
								<input id="campoNome" class="form-control" type="text" name="nome"/><br/>
							</div>
							<div class="form-group">
								<label for="campoValor" class="control-label">Valor do Produto:</label> 
								<input id="campoValor" class="form-control" type="text" name="valor"/><br/>
							</div>
							<div class="form-group">
								<label for="campoQtd" class="control-label">Quantidade:</label> 
								<input id="campoQtd" class="form-control" type="number" name="quantidade"/><br/>
							</div>
							<input type="hidden" name="logica" value="AdicionaProdutoLogica"/>
							<button type="submit" class="btn btn-default">Adicionar Produto</button>
						</form>
					</div>
				</div>
			</div>	
		</section>
	</div>
	<!-- JS & JQUERY -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
 	<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>
