<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>Search Our Products</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
<style>
    .bg-cover{
      min-height: 110vh;
    }
table, th, td {
  border: 1px solid black;
}
     .container-fluid
    {
      
      
     width: 900px;
     background-color: rgb(185, 185, 185);
      
    }
    
      .col
    {
      padding-top: 20px;
      padding-bottom: 20px;
     
      
    }
    .table
    {
        
      padding-bottom: 50px;
      
      
    }
    .title
    {
        padding-top: 50px;
      padding-bottom: 50px;
      color: white;
      
    }
    .navbar{
  background: #000;
}
.btn {
  border: black;  
   background-color: red;
    color: rgb(255, 255, 255);
 
   } 
</style>
</head>
<body>
  <header>
    <nav class="navbar navbar-expand-sm navbar-dark">
      <!-- Brand -->
      <a class="navbar-brand" href="#">
        <img src="images/whiteGuitar.jpg" alt="Logo" style="width:60px;">
      </a>
    
      <!-- Links -->
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/readuser">Products</a>
        </li>
        
       </ul>
       <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="/login">Login</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="">Register</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="">Your Cart</a>
        </li>
       </ul>
    </nav>
  </header>
 

   
   
   
   
  <div style="background: url(images/backround2.jpg)" class="page-holder bg-cover">
 
     <div align="center" class="title">
        <h2>Album: ${album.name}</h2>
        <p></p>
        <a href="/readuser">
          <input type="submit" value="Back"/>
         </a><br>   
      </div>
   
    
     
 

    



<div class="table">




<div class="container-fluid" >
  <div class="row">
    <div class="col" align="center">
      <img src="images/album.jpg" alt="album" width="400" height="400">
    </div>
    <div class="col">
    <h1>${album.name}</h1><br />
    <h5>Artist: ${album.artist}</h5><br />
    
    <h5>Released: ${album.release_date}</h5><br />
    <h5>Genre: ${album.genre_name}</h5><br />
    <h1></h1><br />
    <h1></h1><br />
   <h5>Buy for a low price of:</h5> <h3>$${album.price}</h3>
</div> 
    </div>
  
  </div>


<div class="container-fluid" align="center">
    <div class="row">
      
      <div class="col">
        <div class=cta align="center">
            <a href=''><buttontype="button" class="btn btn-primary btn-lg">Add to Cart</button></a>
            </div>
         <h6> </h6>
         
      </div>
    
    </div>
  </div>
</div>
</div> 
    
</body>
</html>