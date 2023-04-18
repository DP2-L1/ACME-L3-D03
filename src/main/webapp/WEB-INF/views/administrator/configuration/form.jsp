<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form readonly="true">
	<acme:input-textbox code="administrator.configuration.form.label.defaultCurrency" path="defaultCurrency"/>	
	<acme:input-textbox code="administrator.configuration.form.label.aceptedCurrencies" path="acceptedCurrencies"/>
</acme:form>