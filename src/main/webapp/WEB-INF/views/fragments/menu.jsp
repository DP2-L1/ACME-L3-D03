<%--
- menu.jsp
-
- Copyright (C) 2012-2023 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.roles.Provider,acme.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" uri="http://www.the-acme-framework.org/"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-1" action="https://www.tiktok.com/@edwardadiel/video/7144003248792456494?lang=es"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-2" action="https://hackertyper.net/"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-3" action="https://www.youtube.com/watch?v=GgWsADYJdpM&list=PLkPEGG1vZdQ0wCgSKvd6OHbuQS76GbV0N&index=13"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-4" action="https://www.youtube.com/watch?v=JgJjypXMn9Y"/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-5" action="https://www.youtube.com/watch?v=l5ixt5EuZok&t=10s"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.anonymous.peep" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.peep.list" action="/anonymous/peep/list-all"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.authenticated.peep" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.peep.list" action="/authenticated/peep/list-all"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.authenticated.offer" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.offer.list" action="/authenticated/offer/list-all"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.populate-initial" action="/administrator/populate-initial"/>
			<acme:menu-suboption code="master.menu.administrator.populate-sample" action="/administrator/populate-sample"/>			
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shut-down" action="/administrator/shut-down"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.administrator.banner" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.banner.list" action="/administrator/banner/list-all"/>
		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.note.list" action="/authenticated/note/list"/>

		</acme:menu-option>

		<acme:menu-option code="master.menu.assistant" access="hasRole('Assistant')">
			<acme:menu-suboption code="master.menu.assistant.tutorial-list" action="/assistant/tutorial/list-mine"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.lecturer" access="hasRole('Lecturer')">
			<acme:menu-suboption code="master.menu.lecturer.course.create" action="/lecturer/course/create"/>
			<acme:menu-suboption code="master.menu.lecturer.course.list.all" action="/lecturer/course/list-all"/>
			<acme:menu-suboption code="master.menu.lecturer.course.list.mine" action="/lecturer/course/list-mine"/>
			<acme:menu-suboption code="master.menu.lecturer.lecture.list.all" action="/lecturer/lecture/list-all"/>
			<acme:menu-suboption code="master.menu.lecturer.lecture.create" action="/lecturer/lecture/create"/>
		</acme:menu-option>
		
		
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create" access="!hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update" access="hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create" access="!hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update" access="hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.become-lecturer" action="/authenticated/lecturer/create" access="!hasRole('Lecturer')"/>
			<acme:menu-suboption code="master.menu.user-account.lecturer" action="/authenticated/lecturer/update" access="hasRole('Lecturer')"/>
			<acme:menu-suboption code="master.menu.user-account.become-assistant" action="/authenticated/assistant/create" access="!hasRole('Assistant')"/>
			<acme:menu-suboption code="master.menu.user-account.assistant" action="/authenticated/assistant/update" access="hasRole('Assistant')"/>
			
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>

