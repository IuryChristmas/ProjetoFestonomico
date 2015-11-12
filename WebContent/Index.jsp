<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Projeto Festonômico</title>
		
		<!-- CSS -->
		<link rel="stylesheet" type="text/css" href="../../resources/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="../../resources/bootstrap/css/bootstrap-theme.min.css" />
    </head>
    
    <body>
        <form action="index.html" method="post">
            <fieldset>
                <p align=CENTER>
                    <tr>
                        <td>
                            TIPO DE FESTA
                        </td>
                        <select name=mytextarea>
                            <option name=um value=one>
                                TIPO DE FESTA 1
                            </option>
                            <option name=dois value=two>
                                TIPO DE FESTA 2
                            </option>
                            <option name=tres value=three>
                                TIPO DE FESTA 3
                            </option>
                        </select>
                        <td>
                            TOTAL PESSOAS
                            <input type="number" name="total" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p align=CENTER>
                                Cadastre-se e tenha dicas para ir bem na sua festa!!!!
                        </td>
                        <tr/>
                        <p align=CENTER>
                            LOGIN:
                            <input type="email" name="id" />
                            </td>
                    </tr>
                    <tr>
                        <table>
                            <p align=CENTER>
                                SENHA:
                                <input type="password" name="senha_do_usuario" />
                                </td>
                    </tr>
                    <tr>
                        <td>
                            <td align="left">
                                <button type="button">
                                    LOGIN
                                </button>
                            </td>
                            <td align="left">
                                <button type="button">
                                    ESQUECI A SENHA
                                </button>
                            </td>
                            <td align="left">
                                <button type="button">
                                    CADASTRAR
                                </button>
                            </td>
                    </tr>
                    </table>
            </fieldset>
        </form>
        <!-- JS & JQUERY -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
 	<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
    </body>

</html>