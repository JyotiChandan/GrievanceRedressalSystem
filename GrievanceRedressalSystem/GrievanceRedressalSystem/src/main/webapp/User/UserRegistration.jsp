<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<!-- CSS only -->
<%@ include file="../Resources/link.jsp"%>
</head>
<body>
	<section class="vh-120" style="background-color: #eee">
		<div class="container h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">
										Sign up</p>

									<form id="new_user_registration_form"
										class="mx-1 mx-md-4">
										<div class="d-flex flex-row align-items-center mb-4">
											<div class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example1c">Your
													Name</label> <input type="text" id="form3Example1c"
													class="form-control" name="Name" required />

											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<div class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example3c">Your
													Email</label> <input type="email" id="form3Example3c"
													class="form-control" name="UserName" required />

											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<div class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example4cd">Mobile
													No.</label> <input type="text" id="form3Example4cd"
													class="form-control" name="Mobile" maxlength="10"
													minlength="10" required />

											</div>
										</div>
										<div class="d-flex flex-row align-items-center mb-4">
											<div class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example4cd">Address
												</label> <input type="text" id="form3Example4cd"
													class="form-control" name="Address" required />

											</div>
										</div>
										<div class="d-flex flex-row align-items-center mb-4">
											<div class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example4cd">Pincode
												</label> <input type="text" id="form3Example4cd"
													class="form-control" name="Pincode" maxlength="6"
													minlength="6" required />

											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<div class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example4c">Password</label>
												<input type="password" id="form3Example4c"
													class="form-control" name="Password" required />

											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<div class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example4c">Confirm
													Password</label> <input type="password" id="form3Example4c"
													class="form-control" name="Confirm_Password" required />

											</div>
										</div>

			

										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
										<input type="hidden" name="action" value="new_user_registration"/>
											<input type="submit" class="btn btn-primary btn-lg"
												value="Register" id="registration_form" required/>

										</div>
									</form>
								</div>
								<div
									class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
									<img
										src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
										class="img-fluid" alt="Sample image" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- JavaScript Bundle with Popper -->
<%@ include file="../Resources/script.jsp"%>
		<script>
		$("#new_user_registration_form").on("submit",function(event){
			event.preventDefault();
			var f=$("#new_user_registration_form").serialize();
			console.log(f);
			$.ajax({
				url : "../User",
				type : "post",
				data : f,
				dataType : "json",
				success : function(data,textStatus,jqXHR){
					location.reload();
				},
				error : function(data,textStatus,jqXHR){
					alert("failed");
				}
			})
		})
		</script>
		

</body>
</html>
