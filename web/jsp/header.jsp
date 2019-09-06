<%--
  Created by IntelliJ IDEA.
  User: Maelenn
  Date: 06/09/2019
  Time: 09:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<header>
    <nav>
        <s:if test="#session.user">
            Bonjour <s:property value="#session.user.firstname"/><s:property value="#session.user.lastname"/>
            <s:a action="logout">Déconnexion</s:a>
        </s:if>
        <s:else>
            <s:a action="login">Connexion</s:a>
            <s:a action="signin">Inscription</s:a>
        </s:else>

        <s:a action="products_list">catalogue</s:a>
        <s:if test="#session.user.isAdmin">
            <s:a action="users_list">catalogue</s:a>
        </s:if>

    </nav>
</header>

<s:actionerror/>
<s:actionmessage/>