<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CATalogue</title>
<!-- <link href="../css/mystyle.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 --></head>
<body  style="background-image: url("https://cdn.shopify.com/s/files/1/3004/1474/products/orange-tabby_1800x1800.png?v=1544042837"); background-repeat:no-repeat; background-size:cover;">
<jsp:include page="Header.jsp"/>

 <div id="myCarousel" style="top: -20px;" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img style="  margin-left: auto; margin-right: auto;bottom: 6px; width:100%; height: 698px; width: 700px; overflow: hidden" src="https://images-na.ssl-images-amazon.com/images/I/91gpB2zyuNL._SL1500_.jpg" alt="Los Angeles">
    </div>

    <div class="item">
      <img style="bottom: 6px; width:100%; height: 698px;" src="https://shop.r10s.jp/karabanashop/cabinet/neko01/imgrc0084742919.jpg" alt="Chicago">
    </div>

    <div class="item">
      <img style="margin-left: auto; margin-right: auto;bottom: 6px; width:100%; height: 698px; width: 700px; overflow: hidden;" src="https://images-na.ssl-images-amazon.com/images/I/61t-C6K9FsL._SL1000_.jpg" alt="New York">
    </div>
  </div>

<!--   Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div> 





<jsp:include page="Footer.jsp"/>
<!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 --></body>
</html>