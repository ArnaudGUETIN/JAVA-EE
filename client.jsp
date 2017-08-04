<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="vueclient.css">
<title>Clients</title>
</head>
<body>
<center><p> <h1>Opérations C.R.U.D</h1>  </p></center>
<hr width="90%"><br><br>
<center><p> <h1>Ajout d'un client</h1>  </p></center>
<hr width="90%">
<br><br>
<div class="row">
<div class="col-lg-4">
<form action="controlleur" method="post" class="form-horizontal">
 <div class="form-group">
  <label class="control-label col-sm-2" for="email">Nom:</label>
  <div class="col-sm-10"><input type="text" name="nom" >
  </div>
  </div>
  <div class="form-group">
  <label class="control-label col-sm-2" for="email">Prenom:</label>
  <div class="col-sm-10">
  <input type="text" name="prenom" > 
  </div>
  </div>
  
  
   <div class="form-group">
  <label class="control-label col-sm-2" for="email">Login:</label>
  <div class="col-sm-10">
  <input type="text" name="login" > 
  </div>
  </div>
  
   <div class="form-group">
  <label class="control-label col-sm-2" for="email">email:</label>
  <div class="col-sm-10">
  <input type="text" name="email" > 
  </div>
  </div>
  
   <div class="form-group">
  <label class="control-label col-sm-2" for="email">Password:</label>
  <div class="col-sm-10">
  <input type="text" name="password" > 
  </div>
  </div>
  
   <div class="form-group">
  <label class="control-label col-sm-2" for="email">Pays:</label>
  <div class="col-sm-10">
  <input type="text" name="pays" > 
  </div>
  </div>
  
   <div class="form-group">
  <label class="control-label col-sm-2" for="email">Ville:</label>
  <div class="col-sm-10">
  <input type="text" name="ville" > 
  </div>
  </div>
   <div class="form-group">
  <label class="control-label col-sm-2" for="email">Telephone:</label>
  <div class="col-sm-10">
  <input type="text" name="telephone" > 
  </div>
  </div>
  <input type="submit" value="Creer">
  <br><br>
  
</form>
</div>
<div class="col-lg-8">
<center>
<table border="1" width="80%">
<tr style="background-color: #CCC">
<th>Id Client</th><th>Nom</th><th>Prenom</th><th>Email</th><th>Login</th><th>telephone</th><th>Date de d'ajout</th><th>Adresse</th>
</tr>

<c:forEach items="${clients}" var="cl">
<tr>
<td style="padding: 2px">${cl.idCl }</td>
<td style="padding: 2px">${cl.nomCl }</td>
<td style="padding: 2px">${cl.prenom }</td>
<td style="padding: 2px">${cl.email }</td>
<td style="padding: 2px">${cl.login }</td>
<td style="padding: 2px">${cl.telephone }</td>
<td style="padding: 2px">${cl.dateNaiss }</td>
<td style="padding: 2px">${cl.adresse.country } ${cl.adresse.city } ${cl.adresse.street }</td>
</tr>

</c:forEach> 
</table>
</center>
</div>
</div>
<hr width="90%">
<center><p> <h1>Suppression d'un client</h1>  </p></center>
<hr width="90%">

<form action="suprim" method="post" class="form-horizontal">
<div class="form-group">
  <label class="control-label col-sm-2" for="id">Id :</label>
  <div class="col-sm-10">
  <input type="text" name="id" > <input type="submit" value="Supprimer">
  </div>
  </div>
  
</form>

</body>
</html>