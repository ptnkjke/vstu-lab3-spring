<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page ="template/header.jsp"/>
<jsp:include page ="template/mainNavigation.jsp"/>

<div class="main-container">
    <div class="main wrapper clearfix">
        <div class="mainsection">
            ${page.content}
        </div>
    </div>
    <!-- #main -->
</div>
<!-- #main-container -->

<jsp:include page ="template/footer.jsp"/>
