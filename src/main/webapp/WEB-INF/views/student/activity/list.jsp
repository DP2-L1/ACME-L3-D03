<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<acme:list>
	<acme:list-column code="student.activity.list.label.title" path="title"/>
	<acme:list-column code="student.activity.list.label.activityType" path="activityType"/>
</acme:list>

<jstl:if test="${_command == 'list'}">
	<c:if test="${draftMode}">
		<acme:button code="student.activity.list.button.create" action="/student/activity/create?enrolmentId=${enrolmentId}"/>
	</c:if>
</jstl:if>