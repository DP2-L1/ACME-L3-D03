<%--
- form.jsp
-
- Copyright (C) 2012-2023 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form> 
	<acme:input-textbox code="company.practicumsession.form.label.title" path="title"/>	
	<acme:input-textbox code="company.practicumsession.form.label.sessionAbstract" path="sessionAbstract"/>
	<acme:input-moment code="company.practicumsession.form.label.periodstart" path="timePeriodStart"/>
	<acme:input-moment code="company.practicumsession.form.label.periodend" path="timePeriodEnd"/>
	<acme:input-textbox code="company.practicumsession.form.label.optionallink" path="optionalLink"/>
	
	

	<jstl:choose>	 		
		<jstl:when test="${acme:anyOf(_command, 'show|update|delete|publish') && draftMode == true}">
			<acme:submit code="company.practicumsession.form.button.update" action="/company/practicum-session/update"/>
			<acme:submit code="company.practicumsession.form.button.delete" action="/company/practicum-session/delete?masterId=${masterId}"/>
			<acme:submit code="company.practicumsession.form.button.publish" action="/company/practicum-session/publish"/>
		</jstl:when>	
		<jstl:when test="${_command == 'create'}">
			<acme:submit code="company.practicumsession.form.button.create" action="/company/practicum-session/create?masterId=${masterId}"/>
		</jstl:when>
		<jstl:when test="${draftMode == false && hasAddendum == false}">
			<acme:submit code="company.practicumsession.form.button.create-appendum" action="/company/practicum-session/create-addendum?id=${id}"/>	
			<acme:input-checkbox code="company.session.form.label.confirmation" path="confirmation"/>		
		</jstl:when>
	</jstl:choose>
</acme:form>
