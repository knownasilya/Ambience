<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="<%=request.getContextPath()%>/theme/css/style.css" rel="stylesheet" type="text/css"/>
<f:loadBundle basename="g5.ambience.user.member.member_messages" var="msg"/>
</head>
<body>
<f:view>
	<h:form>
		<h:outputLabel value="#{msg.username}" for="username"></h:outputLabel>
		<h:inputText value="#{member._username}" id="username"></h:inputText>
		<h:outputLabel value="#{msg.password}" for="password"></h:outputLabel>
		<h:inputSecret value="#{member._password}" id="password"></h:inputSecret>
		<h:commandButton action="#{member.update}" value="#{msg.login}"></h:commandButton><br/>
		You have <h:outputText value="#{member._login_attempts}"></h:outputText> login attempts.
	</h:form>
</f:view>
</body>
</html>