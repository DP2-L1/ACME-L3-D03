<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form>
			<acme:input-textbox code="student.enrolment.form.label.code" path="code"/>
			<acme:input-textbox code="student.enrolment.form.label.motivation" path="motivation"/>
			<acme:input-textbox code="student.enrolment.form.label.goals" path="goals"/>
			<acme:input-select code="student.enrolment.form.label.course" path="course" choices="${courses}"/>	

			<acme:input-textbox code="student.enrolment.form.label.expiryDate" path="expiryDate" placeholder="MM/YY"/>
			<acme:input-textbox code="student.enrolment.form.label.cvc" path="cvc" placeholder="XXX"/>
			<acme:input-textbox code="student.enrolment.form.label.creditCard" path="creditCard" placeholder="XXXX/XXXX/XXXX/XXXX"/>
			<acme:input-textbox code="student.enrolment.form.label.holderName" path="holderName"/>
			<acme:input-textbox code="student.enrolment.form.label.lowerNibble" path="lowerNibble" readonly="true"/>

	
	<jstl:choose>
		<jstl:when test="${acme:anyOf(_command, 'show|update|delete|update')}">		
			<acme:submit code="student.enrolment.form.button.update" action="/student/enrolment/update"/>
			<acme:submit code="student.enrolment.form.button.delete" action="/student/enrolment/delete"/>
			<acme:submit code="student.enrolment.form.button.finalize" action="/student/enrolment/finalize"/>
		</jstl:when>
		<jstl:when test="${_command == 'create'}">
			<acme:submit code="student.enrolment.form.button.create" action="/student/enrolment/create"/>
		</jstl:when>
	</jstl:choose>		
</acme:form>