<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:list>
	<acme:list-column code="assistant.tutorial.list.label.code" path="code" width="10%"/>
	<acme:list-column code="assistant.tutorial.list.label.title" path="title" width="30%"/>
	<acme:list-column code="assistant.tutorial.list.label.abstractText" path="abstractText" width="20%"/>
	<acme:list-column code="assistant.tutorial.list.label.goals" path="goals" width="30%"/>	
	<acme:list-column code="assistant.tutorial.list.label.estimatedTotalTime" path="estimatedTotalTime" width="10%"/>			
</acme:list>

<jstl:if test="${_command == 'list-mine'}">
	<acme:button code="assistant.tutorial.list.button.create" action="/assistant/tutorial/create"/>
</jstl:if>	