
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form>
	<acme:input-moment code="administrator.banner.form.label.displayPeriodStart" path="displayPeriodStart"/>
	<acme:input-moment code="administrator.banner.form.label.displayPeriodEnd" path="displayPeriodEnd"/>
	<acme:input-url code="administrator.banner.form.label.picture" path="picture"/>
	<acme:input-textbox code="administrator.banner.form.label.slogan" path="slogan"/>
	<acme:input-url code="administrator.banner.form.label.link" path="link"/>
	
	<jstl:choose>
		<jstl:when test="${acme:anyOf(_command, 'show|update|delete|publish')}">
			<acme:submit code="administrator.banner.form.label.update" action="/administrator/banner/update"/>
			<acme:submit code="administrator.banner.form.label.delete" action="/administrator/banner/delete"/>
		</jstl:when>	 
		<jstl:when test="${_command == 'create'}">
			<acme:submit code="administrator.banner.form.label.create" action="/administrator/banner/create"/>
		</jstl:when>		
	</jstl:choose>
</acme:form>
