<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
 session.removeAttribute("username");
session.invalidate();
response.sendRedirect("../Login/AllLogIn.jsp");
%>

<%-- <!DOCTYPE html>
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
	$("#logout1").addClass("menu-open");
	$("#logout2").addClass("active");
	swal("Logout!", "Successfully Logout!", "success");
});
</script>
</body>
</html> --%>