<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Articles</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="vueclient.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="menu.jsp" %>
<% HttpSession sessions= request.getSession();
if(request.getAttribute("client")!=null){
sessions.setAttribute("clientNom", request.getAttribute("client") );
sessions.setAttribute("idCl",request.getAttribute("idCl"));
}
if(request.getAttribute("idCmd")!=null){
	sessions.setAttribute("idCmd", request.getAttribute("idCmd"));
}
%>
<p>
 <%String p=(String)sessions.getAttribute("clientNom");
Long i=(Long)sessions.getAttribute("idCl"); 
Long x=(Long)sessions.getAttribute("idCmd");
if(p!=null)
out.println("Bienvenue"+" "+p);
else out.println("Veillez vous connectez");
%></p>


<form method="get" action="articles">
   <p>
       <label for="pays">Selectionner Votre Produit</label><br />
       <select name="categorie" id="categorie">
           <option value="0"></option>
           <option value="0">tous les articles</option>
           <option value="3">Smartphone</option>
           <option value="2">Pc</option>
           <option value="1">Ordinateur</option>
          <!--   <option value="12">Huawei</option>
           <option value="15">Nokia</option>-->
           <input style="margin-left: 5px" type="submit" value="Chercher">
       </select>
   </p>
   
</form>
<center>
<table border="1" width="80%" >
<tr style="background-color: #CCC">
<th>Commander </th><th>Designation</th><th>Prix</th><th>Photo</th><th>Categorie </th><th>Description </th>
</tr>

<c:forEach items="${articles}" var="articles">
<tr>
<td align="center">


  <!-- Trigger the modal with a button -->
  <form action="commande" method="post" >
  <input type="hidden" name="idArt" value="${articles.idArt }">
  <input type="hidden" name="idCl" value="<%= i %>">
  <input width="20px" type="submit" class="btn btn-info btn-sm" value=" Ajouter" >
  </form>


  

</td>
<td align="center">${articles.nomArt }  </td>
<td align="center">${articles.pu } T.N.D</td>
<td align="center"><img  width="200px" height="200px" src="photos/${articles.imagePath }"></td>
<td align="center">${articles.produit.categorie.nomCat }</td>
<td align="center">${articles.produit.descPrct }<br>${articles.produit.categorie.descCat } </td>
</tr>
</c:forEach> 
</table><br /><br />
<form action="vueCmd" method="get" >
  <input type="hidden" name="idCmd" value="<%= x %>">
  <input type="hidden" name="idCl" value="<%= i %>">
  <input width="20px" type="submit" class="btn btn-info btn-sm" value=" Voir la commande" >
  </form>
</center>








</body>
</html>