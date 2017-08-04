<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="vueclient.css">

  
<title>Commande</title>
</head>
<body>
<br>
<br>
<% Float total=0F; %>
<c:forEach items="${commandes }" var="commandes">
<center>
<table width="80%" border="1">
<tr style="background-color: #CCC">
<th>Commande N° ${commandes.idCmd}</th>
</tr>
<tr style="background-color: #CCC">
<th>Client</th><th>Date Commande</th><th>Article</th><th>Adresse de Livraison</th>
</tr>
<tr>
<td align="center">${commandes.client.nomCl } ${commandes.client.prenom }</td><td align="center">${commandes.dateCmd }</td><td align="center"><c:forEach items="${commandes.lignesDeCmd }" var="ligne"><table border="1" width="100%"><tr style="background-color: #CCC"><th>Designation</th><th>Quantite</th></tr><tr><td align="center">${ligne.article.nomArt }</td><td align="center">${ligne.quantite }</td></tr></table></c:forEach></td><td align="center">${commandes.addresse.country } ${commandes.addresse.city }</td>
</tr>
</table>
</center>
</c:forEach>
<input width="20px" type="submit" class="btn btn-info btn-sm" value=" Imprimer" id="imprimer">
<script type="text/javascript">
var bouton = document.getElementById('imprimer');
bouton.onclick = function(e) {
  e.preventDefault();
  print();
}
</script>
</body>
</html>