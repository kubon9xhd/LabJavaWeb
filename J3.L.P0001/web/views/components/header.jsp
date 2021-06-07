<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
    <div class="header_bg"></div>
    <div class="header_nav">
        <ul class="menu">
            <li><a href="home">Home</a></li>
                <c:if test="${not empty USERMODEL}">
                <li><a href="takequiz">Take Quiz</a></li>

                <c:if test="${USERMODEL.roleId == 1}">
                    <li><a href="makequiz">Make Quiz</a></li>
                    <li><a href="managequiz">Manage Quiz</a></li>
                </c:if>
                <li><a href="logout">Logout</a></li>
                </c:if>
        </ul>
    </div>
</div>