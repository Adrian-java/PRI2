<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.statusofvisit-resources"/>
<html>
<head>
<title>View <fmt:message key="statusofvisit.title"/> <fmt:message key="visit.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="visit.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectStatusOfVisit?idKey=${statusofvisit_id}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visit.id.title"/>:
						</td>
						<td>
							${visit.id}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visit.dateofvisit.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${visit.dateOfVisit.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visit.isleave.title"/>:
						</td>
						<td>
							${visit.isLeave}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visit.special.title"/>:
						</td>
						<td>
							${visit.special}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteStatusOfVisitVisits?statusofvisit_id=${statusofvisit_id}&related_visits_id=${visit.id}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
