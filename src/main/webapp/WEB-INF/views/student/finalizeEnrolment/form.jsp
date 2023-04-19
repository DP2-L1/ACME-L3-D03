<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form>
	<acme:input-textbox code="student.enrolment.pay.label.nameHolder" path="nameHolder"/>
	<acme:input-textbox code="student.enrolment.pay.label.cardNumber" path="cardNumber"/>
	<acme:input-textbox code="student.enrolment.pay.label.expiryDate" path="expiryDate"/>
	<acme:input-textbox code="student.enrolment.pay.label.cvc" path="cvc"/>
	<acme:input-select code="student.enrolment.pay.label.course" path="course" choices="${courses}"/>
</acme:form>