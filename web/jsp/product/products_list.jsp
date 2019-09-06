<%--
  Created by IntelliJ IDEA.
  User: Maelenn
  Date: 06/09/2019
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Eval struts</title>
</head>
<body>
<s:include value="../header.jsp"/>

<h2><s:text name="product.list"/></h2>

<ul>
    <s:iterator value="productsList">
        <li>
            <s:param name="productId" value="product.id"/>
            <s:property value="product.name"/>
            <s:property value="product.price"/>

            <s:a action="product_details" value="Voir détails">
                <s:param name="productId" value="product.id"/>
            </s:a>
        </li>
    </s:iterator>
</ul>
<s:include value="../footer.jsp"/>
</body>
</html>
