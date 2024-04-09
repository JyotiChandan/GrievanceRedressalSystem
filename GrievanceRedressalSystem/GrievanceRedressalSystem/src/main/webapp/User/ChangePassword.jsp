<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% 

if(session.getAttribute("username") == "" || session.getAttribute("username")== null)
{
	response.sendRedirect("../Login/AllLogIn.jsp");
}

   /* out.println(session.getAttribute("username"));  */
%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../Resources/link.jsp"%>

</head>
<body class="hold-transition sidebar-mini">
	<!-- Site wrapper -->
	<div class="wrapper">
		<%@ include file="../Resources/topbar.jsp"%>

		<%@ include file="sidebar.jsp"%>
		<div class="content-wrapper">
			<%@ include file="../Resources/header.jsp"%>
			<div class="container-fluid" id="clear">

				<div class="mainDiv">
					<div class="cardStyle">
						<form id="changepassword">
							<img src="" id="signupLogo" />

							<h2 class="formTitle">Change Password</h2>

							<div class="inputDiv">
								<label class="inputLabel" for="password">New Password</label> <input
									type="password" id="password" name="password" required />
							</div>

							<div class="inputDiv">
								<label class="inputLabel" for="confirmPassword">Confirm
									Password</label> <input type="password" id="confirmPassword"
									name="confirmPassword" />
							</div>

							<div class="buttonWrapper">
								<button type="submit" id="submitButton"
									class="submitButton pure-button pure-button-primary">
									<span>Change</span>
								</button>
							</div>
							<input type="hidden" name="action" value="adminchangepassword"/>
						</form>
					</div>
				</div>

			</div>
		</div>
		<!-- ./wrapper -->
		<%@ include file="../Resources/footer.jsp"%>
	</div>
	<%@ include file="../Resources/script.jsp"%>

	<script type="text/javascript">
$("document").ready(function(){
	$("#profile1").addClass("menu-open");
	$("#profile2").addClass("active");
	$(".heading").text("Change Password");
	 $("#submitButton").click(function(){
		$("#changepassword").on("submit",function(event){
			event.preventDefault();
			var f=$(this).serialize();
			/* alert(f); */
			$.ajax({
				url : "../Admin",
				type : 'post',
				data : f,
				dataType : "JSON",
				success : function(data,textstatus,jqXHR){
					swal({
					    title: "Done!",
					    text: "Your Password Change Successful!",
					    type: "success"
					}).then(function() {
					    window.location = "Profile.jsp";
					});
				},
				error : function (data,textStatus,errorThrown){
					alert("failed");
				}
			});
		});
	 });
});

</script>

</body>

</html>
<!-- 



<link rel="stylesheet" href="../CSS/User/ChangePassword.css" /> -->

