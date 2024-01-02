<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>

<%
    String Warna_ID = request.getParameter("Warna_ID");
    WarnaModel warnaModel = new WarnaModel();
    warnaModel.hapusWarna(Warna_ID);
    response.sendRedirect("./tableWarna.jsp");
%>