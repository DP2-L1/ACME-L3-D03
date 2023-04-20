<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form> 
	<acme:input-textbox code="assistant.tutorialSession.form.label.title" path="title"/>
	<acme:input-textarea code="assistant.tutorialSession.form.label.abstractText" path="abstractText"/>	
	<acme:input-moment code="assistant.tutorialSession.form.label.startPeriod" path="startPeriod"/>
	<acme:input-moment code="assistant.tutorialSession.form.label.endPeriod" path="endPeriod"/>
	<acme:input-select code="assistant.tutorialSession.form.label.sessionType" path="sessionType" choices="${sessionType}"/>
	<acme:input-url code="assistant.tutorialSession.form.label.link" path="link"/>
		
	<jstl:choose>	 
		<jstl:when test="${acme:anyOf(_command, 'show|update|delete') && draftMode == true}">
			<acme:submit code="assistant.tutorialSession.form.button.update" action="/assistant/tutorial-session/update"/>
			<acme:submit code="assistant.tutorialSession.form.button.delete" action="/assistant/tutorial-session/delete"/>
		</jstl:when>
		<jstl:when test="${_command == 'create'}">
			<acme:submit code="assistant.tutorialSession.form.button.create" action="/assistant/tutorial-session/create?masterId=${masterId}"/>
		</jstl:when>
	</jstl:choose>	
</acme:form>