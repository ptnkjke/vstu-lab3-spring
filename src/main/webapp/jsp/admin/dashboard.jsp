<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../main/template/header.jsp"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../main/template/mainNavigation.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="//tinymce.cachefly.net/4.0/tinymce.min.js"></script>
<script>
    tinymce.init({selector: 'textarea'});
</script>
<div class="main-container">
    <div class="main wrapper clearfix">
        <div class="mainsection">
            <%--Изменение "About"--%>
            <form:form class="form" modelAttribute="HtmlPage" action="/admin/about" method="POST">
                <h2>О компании:</h2>
                <textarea id="t1" class="form-control" name="contant">${aboutHtml.content}</textarea>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
            </form:form>


            <%--Изменение "Contacts"--%>
            <form:form class="form" modelAttribute="HtmlPage" action="/admin/contacts" method="POST">
                <h2>Контакты:</h2>
                <textarea id="t2" class="form-control" name="contant">${contactsHtml.content}</textarea>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
            </form:form>

            <%--Управление продукцией--%>
            <c:if test="${products.size() > 0}">
                <h2>Список всех продукций:</h2>
                <table style="width: 100%">
                    <tr>
                        <td style="width: 50%">Название</td>
                        <td style="width: 50%">Удалить</td>
                    </tr>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.name}</td>
                            <td><a href="/admin/descrDel/${product.id}">DELETE</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <h2>Добавление новой продукции:</h2>
            <form:form class="form file-admin" modelAttribute="DescriptionModel" enctype="multipart/form-data"
                       action="/admin/production/add" method="POST">
                <div class="control-group file-admin">
                    <label class="control-label">Название</label>
                    <input type="text" name="name" class="tb-text-black"/>
                    <input name="file" type="file"/>
                </div>
                <button type="submit" class="btn">Добавить</button>
            </form:form>
            <%--Управление услугами--%>
            <c:if test="${services.size() > 0}">
                <h2>Список всех услуг:</h2>
                <table style="width: 100%">
                    <tr>
                        <td style="width: 50%">Название</td>
                        <td style="width: 50%">Удалить</td>
                    </tr>
                    <c:forEach items="${services}" var="service">
                        <tr>
                            <td>${servics.name}</td>
                            <td><a href="/admin/descrDel/${service.id}">DELETE</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <h2>Добавление новой услуги:</h2>
            <form:form class="form file-admin" modelAttribute="DescriptionModel" enctype="multipart/form-data"
                       action="/admin/service/add" method="POST">
                <div class="control-group file-admin">
                    <label class="control-label">Название</label>
                    <input type="text" name="name" class="tb-text-black"/>
                    <input name="file" type="file"/>
                </div>
                <button type="submit" class="btn">Добавить</button>
            </form:form>

        </div>
    </div>
    <!-- #main -->
</div>

<jsp:include page="template/footer.jsp"/>