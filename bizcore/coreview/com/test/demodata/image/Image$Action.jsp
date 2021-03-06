
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty image}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Image" style="color: green">${userContext.localeMap['image']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['image.id']}</span> ${image.id}</li>
<li><span>${userContext.localeMap['image.name']}</span> ${image.name}</li>
<li><span>${userContext.localeMap['image.image_path']}</span> ${image.imagePath}</li>
<li><span>${userContext.localeMap['image.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${image.createTime}" /></li>

	
	</ul>
</div>



</c:if>


