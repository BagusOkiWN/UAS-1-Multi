<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>

<%
    String Transmisi_ID = request.getParameter("Transmisi_ID");
    TransmisiModel transmisiModel = new TransmisiModel();
    transmisiModel.hapusTransmisi(Transmisi_ID);
    response.sendRedirect("./tableTransmisi.jsp");
%>