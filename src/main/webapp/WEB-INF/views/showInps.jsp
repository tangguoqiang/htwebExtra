<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2016/7/27
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ht.extra.pojo.Inpatient"%>
<jsp:useBean id="inps"  class="java.util.ArrayList" scope="request"/>
<html>
<head>
    <title>Title</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/jquery-3.1.0.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-bordered">
<thead>
    <tr>
        <th>名称</th>
        <th>城市</th>
    </tr>
</thead>
<tbody>
<% for(int i=0;i<inps.size();i++) {
    Inpatient inp = (Inpatient) inps.get(i);
%>
    <tr>
        <td><%=inp.getPatientName()%></td>
        <td><%=inp.getAdmissionDept()%></td>
    </tr>
<% }%>
</tbody>
</table>
</body>
</html>
