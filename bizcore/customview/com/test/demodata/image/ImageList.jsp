<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


    <c:if test="${not empty result.imageList}" >
    <ul>
    	<c:forEach var="item" items="${result.imageList}">
    		
    		
    		<div class="alert alert-danger">
  
   <image src=' ${item}' alt="${item}"/>
</div>
    	</c:forEach>
    	</ul>
    </c:if>

    
    