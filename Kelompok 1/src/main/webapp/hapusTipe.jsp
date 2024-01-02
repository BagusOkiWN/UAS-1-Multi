<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>

<%
    String Tipe_ID = request.getParameter("Tipe_ID");
    TipeModel tipeModel = new TipeModel();
    tipeModel.hapusTipe(Tipe_ID);
    response.sendRedirect("./tableTipe.jsp");
%>