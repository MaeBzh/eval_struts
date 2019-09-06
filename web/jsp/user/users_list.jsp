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

<h2><s:text name="user.list"/></h2>


<ul>
    <s:iterator value="usersList">
        <li>

                <s:property value="user.firstname"/>
                <s:property value="user.lastname"/>
            <s:a action="user_details" value="Voir détails">
                <s:param name="userId" value="user.id" />
            </s:a>
        </li>
    </s:iterator>
</ul>

<s:include value="../footer.jsp"/>
</body>
</html>
