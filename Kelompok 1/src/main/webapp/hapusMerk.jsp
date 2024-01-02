<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>

<%
    String Merk_ID = request.getParameter("Merk_ID");
    MerkModel merkModel = new MerkModel();
    merkModel.hapusMerk(Merk_ID);
    response.sendRedirect("./tableMerk.jsp");
%>