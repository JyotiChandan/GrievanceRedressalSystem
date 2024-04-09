<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 

if(session.getAttribute("username") == "" || session.getAttribute("username")== null)
{
	response.sendRedirect("../Login/AllLogIn.jsp");
}else{

  
%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../Resources/link.jsp"%>
<script type="text/javascript">
  window.onload = function () {
    var chart = new CanvasJS.Chart("chartContainer",
    {

      title:{
      text: "Site Visit - per month"
      },
       data: [
      {
        type: "line",

        dataPoints: [
        	{ x: new Date(2022, 00, 1), y: 45 },
            { x: new Date(2022, 01, 1), y: 41 },
            { x: new Date(2022, 02, 1), y: 52 },
            { x: new Date(2022, 03, 1), y: 46 },
            { x: new Date(2022, 04, 1), y: 45 },
            { x: new Date(2022, 05, 1), y: 50 },
            { x: new Date(2022, 06, 1), y: 48 },
            { x: new Date(2022, 07, 1), y: 49 },
            { x: new Date(2022, 08, 1), y: 41 },
            { x: new Date(2022, 09, 1), y: 50 },
            { x: new Date(2022, 10, 1), y: 48 },
            { x: new Date(2022, 11, 1), y: 51 }
        ]
      }
      ]
    });

    chart.render();
  }
  </script>
 <script type="text/javascript" src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
 
 </script>
</head>
<body class="hold-transition sidebar-mini">
	<!-- Site wrapper -->
	<div class="wrapper">
		<%@ include file="../Resources/topbar.jsp"%>

		<%@ include file="sidebar.jsp"%>
		<div class="content-wrapper">
			<%@ include file="../Resources/header.jsp"%>
			<div class="container-fluid" id="clear">
			
				
			<!-- <div class="row">
          <div class="col-md-3 col-sm-6 col-12">
            <div class="info-box">
              <span class="info-box-icon bg-info"><i class="fa-solid fa-user-tie"></i></span>

              <div class="info-box-content" id="feedback">
                <span class="info-box-text">Manager</span>
                <span class="info-box-number" id="managercount"></span>
              </div>
              /.info-box-content
            </div>
            /.info-box
          </div>
          /.col
          <div class="col-md-3 col-sm-6 col-12">
            <div class="info-box">
              <span class="info-box-icon bg-success"><i class="fa-solid fa-user"></i></span>

              <div class="info-box-content">
                <span class="info-box-text">User</span>
                <span class="info-box-number" id="usercount">></span>
              </div>
              /.info-box-content
            </div>
            /.info-box
          </div>
          /.col
          <div class="col-md-3 col-sm-6 col-12">
            <div class="info-box">
              <span class="info-box-icon bg-warning"><i class="fa-solid fa-user-tie"></i></span>

              <div class="info-box-content">
                <span class="info-box-text">Admin</span>
                <span class="info-box-number" id="admincount">></span>
              </div>
              /.info-box-content
            </div>
            /.info-box
          </div>
          /.col
          <div class="col-md-3 col-sm-6 col-12">
            <div class="info-box">
              <span class="info-box-icon bg-danger"><i class="fa-solid fa-users-gear"></i></span>

              <div class="info-box-content">
                <span class="info-box-text">Engineer</span>
                <span class="info-box-number" id="engineercount">></span>
              </div>
              /.info-box-content
            </div>
            /.info-box
          </div>
          /.col
        </div>
         -->
			
			
			  <div class="row">
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-info">
              <div class="inner">
                <h3 id="pendingcomplaintcount"></h3>

                <p>Pending Complaints</p>
              </div>
              <div class="icon">
                <i class="ion ion-bag"></i>
              </div>
              <a href="PendingComplains.jsp" class="small-box-footer">View Details<i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-success">
              <div class="inner">
                <h3 id="successcomplaintcount"></h3>

                <p>Sloved Complaints</p>
              </div>
              <div class="icon">
                <i class="ion ion-stats-bars"></i>
              </div>
              <a href="ResolvedComplains.jsp" class="small-box-footer">View Details <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-warning">
              <div class="inner">
                <h3 id="processcomplaintcount"></h3>

                <p>Process Complaints</p>
              </div>
              <div class="icon">
                <i class="ion ion-person-add"></i>
              </div>
              <a href="ProcessComplains.jsp" class="small-box-footer">View Details <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-danger">
              <div class="inner">
                <h3 id="rejectcomplaintcount"></h3>

                <p>Rejects Complaints</p>
              </div>
              <div class="icon">
                <i class="ion ion-pie-graph"></i>
              </div>
              <a href="RejectedComplains.jsp" class="small-box-footer">View Details <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
        </div>
        <div></div>
			<div id="chartContainer" style="height: 370px; width: 100%;">
			
			
			
			
			</div>
		</div>
		<!-- ./wrapper -->
		
	</div>
	<%@ include file="../Resources/footer.jsp"%>
	<%@ include file="../Resources/script.jsp"%>
<script type="text/javascript">
$("document").ready(function() {
	$("li").removeClass("menu-open");
	$("a").removeClass("active");
	$("#dashboard1").addClass("menu-open");
	$("#dashboard2").addClass("active");
	$(".heading").text("Customer Dashboard");
});
$( document ).ready(function() {
    console.log( "ready!" );
    $.ajax({
	url : "../User",
	type : 'post',
	data : {action:"pendingcomplaintcount"},
	dataType : "JSON",
	success : function(data,textstatus,jqXHR){
		/* alert(data); */
		$("#pendingcomplaintcount").text(data);
	},
	error : function (data,textStatus,errorThrown){
		alert("failed");
	}
});
});
$( document ).ready(function() {
    console.log( "ready!" );
    $.ajax({
	url : "../User",
	type : 'post',
	data : {action:"successcomplaintcount"},
	dataType : "JSON",
	success : function(data,textstatus,jqXHR){
		/* alert(data); */
		$("#successcomplaintcount").text(data);
	},
	error : function (data,textStatus,errorThrown){
		alert("failed");
	}
});
});
$( document ).ready(function() {
    console.log( "ready!" );
    $.ajax({
	url : "../User",
	type : 'post',
	data : {action:"successcomplaintcount"},
	dataType : "JSON",
	success : function(data,textstatus,jqXHR){
		/* alert(data); */
		$("#successcomplaintcount").text(data);
	},
	error : function (data,textStatus,errorThrown){
		alert("failed");
	}
});
});
$( document ).ready(function() {
    console.log( "ready!" );
    $.ajax({
	url : "../User",
	type : 'post',
	data : {action:"processcomplaintcount"},
	dataType : "JSON",
	success : function(data,textstatus,jqXHR){
		/* alert(data); */
		$("#processcomplaintcount").text(data);
	},
	error : function (data,textStatus,errorThrown){
		alert("failed");
	}
});
});
$( document ).ready(function() {
    console.log( "ready!" );
    $.ajax({
	url : "../User",
	type : 'post',
	data : {action:"rejectcomplaintcount"},
	dataType : "JSON",
	success : function(data,textstatus,jqXHR){
		/* alert(data); */
		$("#rejectcomplaintcount").text(data);
	},
	error : function (data,textStatus,errorThrown){
		alert("failed");
	}
});
});
</script>
</body>
</html>
<%}%>