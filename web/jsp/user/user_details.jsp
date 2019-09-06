<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Maelenn
  Date: 06/09/2019
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Eval struts</title>
  </head>
  <body>
  <s:include value="../header.jsp"/>
  <h2><s:text name="user.details"/></h2>

  <ul>
    <li><s:text name="user.firstname"/> : <s:property value="user.firstname" /></li>
    <li><s:date name="user.lastname" /> : <s:property value="user.lastname"/> </li>
    <li><s:date name="user.address" /> : <s:property value="user.address"/> </li>
    <li><s:date name="user.email" /> : <s:property value="user.email"/> </li>
  </ul>

  <s:include value="../footer.jsp"/>
  </body>
</html>
