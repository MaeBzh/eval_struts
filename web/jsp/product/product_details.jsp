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

  <h2><s:text name="product.details"/></h2>

  <ul>
    <li><s:text name="product.name"/> : <s:property value="product.name" /></li>
    <li><s:date name="projet.dateCreation" /> : <s:property value="product.price"/> </li>
  </ul>
  <s:include value="../footer.jsp"/>
  </body>
</html>
