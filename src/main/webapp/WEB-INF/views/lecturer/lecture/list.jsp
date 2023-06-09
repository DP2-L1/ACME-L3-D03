<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:list>
	<acme:list-column code="lecturer.lecture.label.title" path="title"  width="40%"/>
	<acme:list-column code="lecturer.lecture.label.lectureAbstract" path="lectureAbstract" width="40%" />
	<acme:list-column code="lecturer.lecture.label.estimatedLearningTime" path="estimatedLearningTime" width="20%" />
</acme:list>
<!--<acme:button code="lecturer.lecture.button.create" action="/lecturer/lecture/create"/>-->

<jstl:if test="${courseId != null && showAddToCourse == true}">
	<acme:button code="lecturer.course-lecture.button.add" action="/lecturer/course-lecture/add?courseId=${courseId}"/>
</jstl:if>