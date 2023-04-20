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

<h2>
	<acme:message code="assistant.dashboard.form.title.general-indicators"/>
</h2>

<table class="table table-sm">
	<tr>
		<th scope="row">
			<acme:message code="assistant.dashboard.form.label.totalTutorials"/>
		</th>
		<td>
			<acme:print value="${totalTutorials}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="assistant.dashboard.form.label.averageTimeSession"/>
		</th>
		<td>
			<acme:print value="${averageTimeSession}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="assistant.dashboard.form.label.deviationTimeSession"/>
		</th>
		<td>
			<acme:print value="${deviationTimeSession}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="assistant.dashboard.form.label.minimumTimeSession"/>
		</th>
		<td>
			<acme:print value="${minimumTimeSession}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="assistant.dashboard.form.label.maximumTimeSession"/>
		</th>
		<td>
			<acme:print value="${maximumTimeSession}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="assistant.dashboard.form.label.averageTimeTutorial"/>
		</th>
		<td>
			<acme:print value="${averageTimeTutorial}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="assistant.dashboard.form.label.deviationTimeTutorial"/>
		</th>
		<td>
			<acme:print value="${deviationTimeTutorial}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="assistant.dashboard.form.label.minimumTimeTutorial"/>
		</th>
		<td>
			<acme:print value="${minimumTimeTutorial}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="assistant.dashboard.form.label.maximumTimeTutorial"/>
		</th>
		<td>
			<acme:print value="${maximumTimeTutorial}"/>
		</td>
	</tr>	
</table>

<acme:return/>

