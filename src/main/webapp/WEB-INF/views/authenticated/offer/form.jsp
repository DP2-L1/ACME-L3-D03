
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form>
	<acme:input-textbox code="authenticated.offer.form.label.heading" path="heading"/>
	<acme:input-textarea code="authenticated.offer.form.label.summary" path="summary"/>
	<acme:input-textbox code="authenticated.offer.form.label.availabilityPeriodStart" path="availabilityPeriodStart"/>
	<acme:input-textbox code="authenticated.offer.form.label.availabilityPeriodEnd" path="availabilityPeriodEnd"/>
	<acme:input-money code="authenticated.offer.form.label.price" path="price"/>
	<acme:input-url code="authenticated.offer.form.label.optionalLink" path="optionalLink"/>
</acme:form>
