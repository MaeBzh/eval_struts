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

<h2>Inscription</h2>

<s:form action="signin">
    <s:textfield name="firstname" label="Prénom" requiredLabel="true" labelposition="top" />
    <s:textfield name="lastname" label="Nom" requiredLabel="true" labelposition="top" />
    <s:textfield name="address" label="Adresse" requiredLabel="true" labelposition="top" />
    <s:textfield name="email" label="Adresse e-mail" requiredLabel="true" labelposition="top" />
    <s:password name="password" label="Mot de passe" requiredLabel="true" labelposition="top" />

    <s:submit value="Connexion"/>
</s:form>
<s:include value="../footer.jsp"/>
</body>
</html>
