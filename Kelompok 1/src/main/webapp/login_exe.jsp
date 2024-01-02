<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="id.ac.uns.vokasi.d3ti.database.*"%>
	<%@ page import="java.security.MessageDigest"%>
	<%
		if(request.getParameter("login") !=null) {
			String username=request.getParameter("username");
			MessageDigest mDigest=MessageDigest.getInstance("SHA1");
			byte[] result=mDigest.digest(request.getParameter("password").getBytes());
			StringBuffer sb=new StringBuffer();
			for (int i=0; i<result.length; i++) {
				sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
			}
			String password=sb.toString();
			UserModel userModel=new UserModel();
			User user=new User();
			user=userModel.getUserByUsername(username);out.print(user.getUsername());
			if(!username.equals(user.getUsername())) {
				out.print("<script>alert('username tidak terdaftar');location.href='./login.jsp';</script>");
			} else if (!password.equals(user.getPassword())) {
				out.print("<script>alert('password tidak benar');location.href='./login.jsp';</script>");
			} else {
				session.setAttribute("Username", user.getUsername());
				out.print("<script>location.href='./tableMerk.jsp'</script>");
			}
		}
	%>
</body>
</html>