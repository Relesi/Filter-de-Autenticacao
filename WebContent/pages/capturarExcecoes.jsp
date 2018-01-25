<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>Exceções</title>

</head>
<body>
	<h3>Capturando Exceções com Jquery</h3>
	<input type="text" value="Valor Informado" id="txtvalor">
	<input type="button" onclick="testaExcecao();" value="Testar Exceção">
</body>
<script type="text/javascript">
	function testaExcecao() {
		valorInformado = $('#txtvalor').val();
		
		$.ajax({
			method: "POST",
			url: "capturarExecao",//para qual servlet?
			data: { valorParam: valorInformado }
		})
		.done(function(response) {//resposta Ok - nenhum erro 
			alert("Sucesso" + response);
		})
		.fail(function(xhr, status, errorThrown) {//resposta erro - algum problema ocorreu
			alert("Error" + xhr.responseText);
		})
	
	
		
	}

</script>

</html>