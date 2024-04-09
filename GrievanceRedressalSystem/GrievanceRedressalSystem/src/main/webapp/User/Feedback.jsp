<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("username") == "" || session.getAttribute("username") == null) {
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
					<div class="col-md-6 m-auto">
						<!-- general form elements disabled -->
						<div class="card card-primary">
							<div class="card-header">
								<h3 class="card-title">Feedback Form</h3>
							</div>
							<!-- /.card-header -->
							<div class="card-body">
								<form id="submit_feedback">
									<div class="row">
										<div class="col-sm-12">
											<!-- text input -->
											<div class="form-group">
												<label>Token Id</label> <input type="text"
													class="form-control" placeholder="Enter Token Id" name="txttoken" maxlength="17" minlength="17">
											</div>
											<div class="form-group">
												<label>Explanation</label>
												<textarea type="text" class="form-control"
													placeholder="Enter Your Explanation... "  name="txtexplanation"></textarea>
											</div>

											<div class="form-group" style="text-align: center;">
											<input type="hidden" name="action" value="submit_feedback"/>
												<button class="bg-primary" type="submit" id="btnsubmit">Submit</button>
											</div>
										</div>
									</div>
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
		$("document").ready(function() {
			$("li").removeClass("menu-open");
			$("a").removeClass("active");
			$("#feedback1").addClass("menu-open");
			$("#feedback2").addClass("active");
			$(".heading").text("Feedback");
		});
			$("#submit_feedback").on("submit", function(event) {
				event.preventDefault();
				var f = $(this).serialize();
				console.log(f);
				$.ajax({
					url : "../User",
					data : f,
					type : 'post',
					dataType : 'JSON',
					success : function(data, textStatus, jqXHR) {
						swal({
						    title: "Congratulation!",
						    text: "Your Feedback Registered Successfully!",
						    type: "success"
						}).then(function() {
						    window.location = "Feedback.jsp";
						});
					},
					error : function(data, textStatus, errorThrown) {
						
						swal({
						    title: "Faild!",
						    text: "Sorry Your Feedback Not Registered",
						    type: "error"
						}).then(function() {
						    window.location = "Feedback.jsp";
						});
					}
				});
				
			});
	</script>
</body>
</html>