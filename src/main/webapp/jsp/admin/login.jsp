<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../main/template/header.jsp"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">

    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <form:form class="form" modelAttribute="User" action="/admin/login" method="post">
               <h2>Админка</h2>
                <input name="login" type="text" class="form-control" placeholder="Login" required="" autofocus=""/>
                <input name="password" type="password" class="form-control" placeholder="Password" required=""/>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form:form>
        </div>
    </div>

</div>

<jsp:include page="template/footer.jsp"/>