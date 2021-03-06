<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.doctor-resources"/>
<html>
<head>
<title>View <fmt:message key="doctor.title"/> <fmt:message key="visitscheduler.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="visitscheduler.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectDoctor?idKey=${doctor_id}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visitscheduler.id.title"/>:
						</td>
						<td>
							${visitscheduler.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visitscheduler.numberofday.title"/>:
						</td>
						<td>
							${visitscheduler.numberOfDay}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visitscheduler.numberofmonth.title"/>:
						</td>
						<td>
							${visitscheduler.numberOfMonth}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visitscheduler.timeofvisit.title"/>:
						</td>
						<td>
							<fmt:formatDate timeStyle="short" type="time" value="${visitscheduler.timeOfVisit.time}"/>
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteDoctorVisitSchedulers?doctor_id=${doctor_id}&related_visitschedulers_id=${visitscheduler.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
