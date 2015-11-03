<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.sickleave-resources"/>
<html>
<head>
<title>Edit <fmt:message key="sickleave.title"/> <fmt:message key="visit.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1><fmt:message key="navigation.edit"/> <fmt:message key="visit.title"/></h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectSickLeave?idKey=${sickleave_id}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		<form:form action="${pageContext.request.contextPath}/saveSickLeaveVisit" method="POST" modelAttribute="visit">
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visit.id.title"/>:
						</td>
						<td>
							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="visit_id" path="id" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "visit_id",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="visit.id.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${visit.id}
						&nbsp;
									<form:hidden id="visit_id" path="id"/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visit.dateofvisit.title"/>:
						</td>
						<td>
							<input id="visit_dateOfVisit" name="dateOfVisit" type="text" value="<fmt:formatDate value="${visit.dateOfVisit.time}" pattern="yyyy-MM-dd"/>" dojoType="dijit.form.DateTextBox" constraints="{datePattern:'<fmt:message key="date.format"/>'}" trim="true" promptMessage="<fmt:message key="date.format" />" invalidMessage="<fmt:message key="date.format.invalid" /> <fmt:message key="date.format" />." style="width:300px;" />
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visit.isleave.title"/>:
						</td>
						<td>
							<form:checkbox id="visit_isLeave" path="isLeave" />
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "visit_isLeave",widgetType : "dijit.form.CheckBox",widgetAttrs : {}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="visit.special.title"/>:
						</td>
						<td>
							<form:checkbox id="visit_special" path="special" />
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "visit_special",widgetType : "dijit.form.CheckBox",widgetAttrs : {}})); </script>
						</td>
					</tr>
				</tbody>
			</table>
			<span class="inputbutton"><input class="savebutton" id="save" type="submit" value="<fmt:message key="navigation.save"/>"/></span>
			<script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'save', event:'onclick'}));</script>
				<input type="hidden" name="sickleave_id" value="${sickleave_id}" >
				
				
		</form:form>
		<div class="clear">&nbsp;</div>
	</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
