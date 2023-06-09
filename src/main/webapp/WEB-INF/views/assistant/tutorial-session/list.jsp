<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:list>
	<acme:list-column code="assistant.tutorialSession.list.label.title" path="title" width="30%"/>
	<acme:list-column code="assistant.tutorialSession.list.label.abstractText" path="abstractText" width="20%"/>
	<acme:list-column code="assistant.tutorialSession.list.label.startPeriod" path="startPeriod" width="10%"/>
	<acme:list-column code="assistant.tutorialSession.list.label.endPeriod" path="endPeriod" width="10%"/>
	<acme:list-column code="assistant.tutorialSession.list.label.sessionType" path="sessionType" width="30%"/>					
</acme:list>

<acme:button test="${showCreate}" code="assistant.tutorialSession.list.button.create" action="/assistant/tutorial-session/create?masterId=${masterId}"/>