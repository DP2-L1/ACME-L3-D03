<%--
- list.jsp
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

<acme:list>
	<acme:list-column code="company.sessions.list.label.title" path="title" width="20%"/>	
	<acme:list-column code="company.sessions.list.label.sessionAbstract" path="sessionAbstract" width="20%"/>
	<acme:list-column code="company.sessions.list.label.isAddendum" path="isAddendum" width="20%"/>
</acme:list>	


		
	<jstl:choose>	 
		<jstl:when test="${_command == 'list' && showCreateAddendum == true}">
			<acme:button code="company.practicumsession.form.button.create-appendum" action="/company/practicum-session/create-addendum?id=${id}"/>			
		</jstl:when>
		<jstl:when test="${_command == 'list' && draftMode == true}">
			<acme:button code="company.sessions.list.button.create" action="/company/practicum-session/create?id=${id}"/>
		</jstl:when>		
	</jstl:choose>

