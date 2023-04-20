
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form>
	<acme:input-textbox code="anonymous.peep.form.label.title" path="title"/>
	<acme:input-textarea code="anonymous.peep.form.label.message" path="message"/>
	<acme:input-textbox code="anonymous.peep.form.label.link" path="link"/>
	<acme:input-textbox code="anonymous.peep.form.label.nick" path="nick"/>
	<acme:input-textbox code="anonymous.peep.form.label.email" path="email"/>
	
	<jstl:choose>	 
		<jstl:when test="${_command == 'create'}">
			<acme:submit code="anonymous.peep.form.button.create" action="/anonymous/peep/create"/>
		</jstl:when>		
	</jstl:choose>
</acme:form>
