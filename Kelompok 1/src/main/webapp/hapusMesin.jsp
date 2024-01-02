<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>

<%
    String Mesin_ID = request.getParameter("Mesin_ID");
    MesinModel mesinModel = new MesinModel();
    mesinModel.hapusMesin(Mesin_ID);
    response.sendRedirect("./tableMesin.jsp");
%>