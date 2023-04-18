<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form> 
	<acme:input-textbox code="assistant.tutorial.form.label.code" path="code" placeholder="assistant.tutorial.form.placeholder.code"/>
	<acme:input-select code="assistant.tutorial.form.label.course" path="course" choices="${courses}"/>	
	<acme:input-textbox code="assistant.tutorial.form.label.title" path="title"/>
	<acme:input-textbox code="assistant.tutorial.form.label.abstractText" path="abstractText"/>
	<acme:input-textbox code="assistant.tutorial.form.label.goals" path="goals"/>
	<acme:input-integer code="assistant.tutorial.form.label.estimatedTotalTime" path="estimatedTotalTime" placeholder="assistant.tutorial.form.placeholder.estimatedTime"/>

	<jstl:choose>	 
		<jstl:when test="${_command == 'show' && draftMode == false}">
			<acme:button code="assistant.tutorial.form.button.sessions" action="/assistant/tutorial-session/list?masterId=${id}"/>			
		</jstl:when>
		<jstl:when test="${acme:anyOf(_command, 'show|update|delete|publish') && draftMode == true}">
			<acme:button code="assistant.tutorial.form.button.sessions" action="/assistant/tutorial-session/list?masterId=${id}"/>
			<acme:submit code="assistant.tutorial.form.button.update" action="/assistant/tutorial/update"/>
			<acme:submit code="assistant.tutorial.form.button.delete" action="/assistant/tutorial/delete"/>
			<acme:submit code="assistant.tutorial.form.button.publish" action="/assistant/tutorial/publish"/>
		</jstl:when>
		<jstl:when test="${_command == 'create'}">
			<acme:submit code="assistant.tutorial.form.button.create" action="/assistant/tutorial/create"/>
		</jstl:when>
	</jstl:choose>		
</acme:form>