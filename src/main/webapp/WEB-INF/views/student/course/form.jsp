<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:form>
	<acme:input-textbox code="student.course.form.label.code" path="code"/>
	<acme:input-textbox code="student.course.form.label.title" path="title"/>
	<acme:input-textarea code="student.course.form.label.courseAbstract" path="courseAbstract"/>
	<acme:input-textbox code="student.course.form.label.courseType" path="courseType"/>
	<acme:input-textbox code="student.course.form.label.retailPrice" path="retailPrice"/>
	<acme:input-textbox code="student.course.form.label.link" path="link"/>
</acme:form>