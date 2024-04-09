<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
if(session.getAttribute("username") == "" || session.getAttribute("username")== null)
{
	response.sendRedirect("../Login/AllLogIn.jsp");
}
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
					<!-- left column -->
					<div class="col-md-6 m-auto" >
						<!-- general form elements -->
						<div class="card card-primary">
							<div class="card-header">
								<h3 class="card-title">Raise Ticket</h3>
							</div>
							<!-- /.card-header -->
							<!-- form start -->
							<form id="complaint_form">
								<div class="card-body" >
									<div class="form-group">
										<label>Address</label>
										<input type="text" class="form-control" placeholder="Enter Your Address" name="txtaddress" required/>
									</div>
									<div class="form-group">
										<label for="exampleInputPincode">Pincode</label>
										<input type="text" class="form-control" placeholder="Enter Your Pincode" name="txtpincode" maxlength="6" minlength="6" required/>
									</div>
									<div class="form-group">
										<label for="exampleInputMobile">Mobile</label> <input
											type="text" class="form-control" id="exampleInputMobile"
											placeholder="Enter Mobile Number" name="txtmobile" maxlength="10" minlength="10" required />
									</div>


									<!-- select -->
									<div class="form-group">
										<label id="complaint_type_name" required>Type of complaint </label> 
										<select class="form-control" id="list1" onchange="complaintCatagoryList()" name="txtcomplaint" required >
											<option value="">--select--</option>
											<!-- <option>Landline</option>
											<option>Mobile</option>
											<option>Boardband</option>
											<option>Other</option> -->
										</select>
									</div>

									<div class="form-group">
										<label id="complaint_catagory_name">Type of complaint </label> 
										<select class="form-control" id="list2" name="txtcomplaintcatagory" >
										<!-- 	<option>None</option>
											<option>Landline</option>
											<option>Mobile</option>
											<option>Boardband</option>
											<option>Other</option>-->
										</select> 
									</div>

									<div class="form-group">
										<label>Concerns</label>
										<input type="text" class="form-control" name="txtconcerns" placeholder="Enter your concern" required/>
									</div>
									<div class="form-group">
										<label>Photo &nbsp;<i>(Issue Screenshot)</i></label>
										<input type="File" class="form-control" placeholder="Insert Problem Screenshot" name="txtphoto" accept="image/jpeg" />
									</div>
								</div>
								<!-- /.card-body -->

								<div class="card-footer">
								<input type="hidden" name="action" value="set_complaint"/>
									<input type="submit" class="btn btn-primary" >
								</div>
							</form>
						</div>
						<!-- /.card -->
					</div>
				</div>
			</div>
		</div>
		<!-- String name=(String)session.getAttribute("username");  
		out.print(name);  -->
		<!-- ./wrapper -->
		<%@ include file="../Resources/footer.jsp"%>
	</div>
	<%@ include file="../Resources/script.jsp"%>
	<script type="text/javascript">
		$("document").ready(function() {
			$("li").removeClass("menu-open");
			$("a").removeClass("active");
			$("#raiseticket1").addClass("menu-open");
			$("#raiseticket2").addClass("active");
			$(".heading").text("Raise Ticket");
			var i;
			$.ajax({
				url : "../User",
				type : "post",
				data : { action : "get_complains_lists"},
				dataType : "json",
				success : function(data,textStatus,jqXHR){
					
					for(let index=0 ; index < data.length ; index++){
						console.log(data[index].C_Id);	
						console.log(data);
						$("#list1").append("<option class='list1' value="+data[index].C_Id+">"+data[index].C_Name+"</option>");
						}
				},
				error : function(data,textStatus,errorThrown){
					alert();
					
				}
			});
			
		});
		function complaintCatagoryList(){
			var x = document.getElementById("list1").value;
				$.ajax({
					url : "../User",
					type : "post",
					data : {action : "get_complains_catagory_lists", id : x},
					dataType : "json",
					success : function(data,textStatus,jqXHR){
						console.log(data);
						$("#list2").empty();
						for(let index=0 ; index < data.length ; index++){
							$("#list2").append("<option class='list2' value="+data[index].Cat_Id+">"+data[index].cat_name+"</option>"); 
							} 
					},
					error : function(data,textStatus,errorThrown){
						alert();
						
					}
				});
			}
		$("#complaint_form").on('submit',function(event){
			event.preventDefault();
			var f=$("#complaint_form").serialize();
			console.log(f);
			$.ajax({
				url : "../User",
				type : "post",
				data : f,
				dataType : "json",
				success : function(data,textStatus,jqXHR){
					swal("Complaint Registered !", "Please note your token id : "+ data, "success");
					complaint_form.reset();
					$("#list2").empty();
				},
				error : function(data,textStatus,errorThrown){
					alert("Complaint registration failed");
					
				}
			});
		});
		
	</script>
</body>
</html>