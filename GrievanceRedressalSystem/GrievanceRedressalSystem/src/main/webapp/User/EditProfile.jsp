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
			<section class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8 m-auto">
				<div class="card card-primary card-outline">
					<div class="card-body box-profile">
						<div class="text-center p-3">
							<img class="profile-user-img img-fluid img-circle"
								src="../Image/Jitendra Sahoo.png" alt="User profile picture" id="userProfile">
						</div>
						<form id="submit_form" action="../Admin" enctype="multipart/form-data" method="POST" >
						<input type="hidden" value="usersetdata" name="action">
							<div class="list-group list-group-unbordered" id="">
								<div class="input-group input-group-default my-2">
									<span class="input-group-text" id="inputGroup-sizing-lg">NAME</span>
									<input type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-lg" name="pname"
										id="pname" disabled>
								</div>
								<div class="input-group input-group-default my-2">
									<span class="input-group-text" id="inputGroup-sizing-lg">EMAIL</span>
									<input type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-lg" name="pemail"
										id="pemail" disabled>
								</div>

								<div class="input-group input-group-default my-2">
									<span class="input-group-text" id="inputGroup-sizing-lg">MOBILE</span>
									<input type="text" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-lg" name="pmobile"
										id="pmobile" disabled>
								</div>

								<div class="input-group input-group-default my-2">
									<span class="input-group-text" id="inputGroup-sizing-lg">ADDRESS</span>
									<input type="text" class="form-control paddress editable"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-lg" name="paddress"
										id="paddress" required>
								</div>
								<div class="input-group input-group-default my-2">
									<span class="input-group-text" id="inputGroup-sizing-lg">PINCODE</span>
									<input type="text" class="form-control ppincode editable"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-lg" name="ppincode"
										id="ppincode" maxlength="6" minlength="6" required>
								</div>
								<div class="input-group input-group-default my-2" id="pphoto">
									<span class="input-group-text" id="inputGroup-sizing-lg">PHOTO</span>
									<input type="file" class="form-control pphoto"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-lg" type="file"
										id="pphoto" name="pphoto" accept=".jpg , .png" required>
								</div>
								

							</div>
							<button type="submit" class="btn btn-primary" id="submit">SUBMIT</button>
							<a href="ChangePassword.jsp"><button type="button"
												class="btn btn-primary justify-content-md-end"
												id="changepassword">Change Password</button></a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
			</div>
		</div>
		<!-- ./wrapper -->
		<%@ include file="../Resources/footer.jsp"%>
	</div>
	<%@ include file="../Resources/script.jsp"%>

<script>
<% 
String message=request.getParameter("message"); 
if(message != null){
%>
var msg= '<%=message%>';
swal({
    title: "Success",
    text: msg,
    type: "success"
}).then(function() {
	window.location = "Profile.jsp";
});

<%	
}

%>


</script>
<script
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#profile1").addClass("menu-open");
		$("#profile2").addClass("active");
		$(".heading").text("Edit Profile");
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
				console.log(data);
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
		/* $("#submit").click(function() {
			$("#submit_form").on("submit", function(event) {
				event.preventDefault();
				var f = $(this).serialize();
				$.ajax({
					enctype: 'multipart/form-data',
                    processData: false,
                    contentType: false,
                    cache: false,
					url : "../Admin",
					data : f,
					type : 'post',
					dataType : 'JSON',
					success : function(data, textStatus, jqXHR) {
						swal({
						    title: "Done!",
						    text: "Your Profile Edit Successful!",
						    type: "success"
						}).then(function() {
						    window.location = "Profile.jsp";
						});

					},
					error : function(data, textStatus, errorThrown) {
						alert("failed");
					}
				});
			});
		}); */
	}); 
</script>
<script>

</script>
</body>
</html>
