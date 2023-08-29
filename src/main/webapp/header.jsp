<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: deepskyblue">
        <div>
            <b><a href="<%=request.getContextPath()%>/user/article" class="navbar-brand">Article App</a></b>
        </div>
        <b>
            <c:set var = "name" scope = "session" value = "${name}"/>
            <c:if test="${name != null}">
                <ul class="navbar-nav navbar-collapse justify-content-end" style="position:absolute;top: 8px;right: 0">
                    <li><h3 style="color: white">${name}</h3></li>
                    <li><a href="<%= request.getContextPath() %>/logout" class="nav-link">Logout</a></li>
                </ul>
            </c:if>
        </b>

    </nav>
</header>