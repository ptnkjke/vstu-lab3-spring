<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="template/header.jsp"/>
<jsp:include page="template/mainNavigation.jsp"/>

<div class="main-container">
    <div class="main wrapper clearfix">
        <div class="mainsection">
            <div class="row">
                <c:forEach items="${entityList}" var="entity">
                    <div class="col-md-3 descr-img"><img src="/file/${entity.imgFile.id}"/> ${entity.name}</div>
                </c:forEach>
            </div>
        </div>
    </div>
    <!-- #main -->
</div>
<!-- #main-container -->

<jsp:include page="template/footer.jsp"/>
