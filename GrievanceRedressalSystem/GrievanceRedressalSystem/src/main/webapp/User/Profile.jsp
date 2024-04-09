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
			
			<div class="row">
							<div class="col-md-8 m-auto">
								<div class="card card-primary card-outline">
									<div class="card-body box-profile">
										<div class="text-center p-3">
											<img class="profile-user-img img-fluid img-circle" src="../Image/Jitendra Sahoo.png" alt="User profile picture" id="userProfile"> 
										</div>
										<form id="submit_form">
											<div class="list-group list-group-unbordered" id="">
												<div class="input-group input-group-default my-2">
													<span class="input-group-text" id="inputGroup-sizing-lg">NAME</span>
													<input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" name="pname" id="pname" disabled="">
												</div>
												<div class="input-group input-group-default my-2">
													<span class="input-group-text" id="inputGroup-sizing-lg">EMAIL</span>
													<input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" name="pemail" id="pemail" disabled="">
												</div>

												<div class="input-group input-group-default my-2">
													<span class="input-group-text" id="inputGroup-sizing-lg">MOBILE</span>
													<input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" name="pmobile" id="pmobile" disabled="">
												</div>

												<div class="input-group input-group-default my-2">
													<span class="input-group-text" id="inputGroup-sizing-lg">ADDRESS</span>
													<input type="text" class="form-control paddress editable" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" name="paddress" id="paddress" disabled="" required="">
												</div>
												<div class="input-group input-group-default my-2">
													<span class="input-group-text" id="inputGroup-sizing-lg">PINCODE</span>
													<input type="text" class="form-control ppincode editable" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" name="ppincode" id="ppincode" maxlength="6" minlength="6" disabled="" required="">
												</div>
											</div>
											<a href="EditProfile.jsp"><button type="button" class="btn btn-primary" id="update">Edit Profile</button></a>
											<a href="ChangePassword.jsp"><button type="button" class="btn btn-primary justify-content-md-end" id="changepassword">Change Password</button></a>
											<input type="hidden" value="adminsetdata" name="action">
										</form>
									</div>
								</div>
							</div>
						</div>
			</div>
		</div>
		<!-- ./wrapper -->
		<%@ include file="../Resources/footer.jsp"%>
	</div>
	<%@ include file="../Resources/script.jsp"%>

<script type="text/javascript">
		$(document).ready(function() {
			$("li").removeClass("menu-open");
			$("a").removeClass("active");
			$("#profile1").addClass("menu-open");
			$("#profile2").addClass("active");
			$(".heading").text("Profile");
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$.ajax({
				url : "../Admin",
				data : {
					action : "admingetdata"
				},
				type : 'post',
				dataType : 'JSON',
				success : function(data, textStaus, jqXHR) {
					$("#pname").val(data[0].name);
					$("#pemail").val(data[0].username);
					$("#pmobile").val(data[0].mobile);
					$("#paddress").val(data[0].Address);
					$("#ppincode").val(data[0].Pincode);
					$("#userProfile").attr('src','../Image/'+data[0].img_profile);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					/* console.log(data); */
				}
			});
		});
	</script>
</body>
</html>