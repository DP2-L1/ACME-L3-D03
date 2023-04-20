
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:list>
	<acme:list-column code="authenticated.note.list.label.instantiationMoment" path="instationMoment" width="20%"/>
	<acme:list-column code="authenticated.note.list.label.title" path="title" width="40%"/>
	<acme:list-column code="authenticated.note.list.label.author" path="author" width="40%"/>
</acme:list>

<acme:button code="authenticated.note.list.button.create" action="/authenticated/note/create"/>