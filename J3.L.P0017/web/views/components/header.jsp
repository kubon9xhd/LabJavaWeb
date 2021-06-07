<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
    <div class="header-nav">
        <ul class="nav-link">
            <li><a href="home">My front page</a></li>
                <c:forEach var="item" items="${galleryHeader}">
                <li><a href="gallery?id=${item.id}">${item.name}</a></li>
                </c:forEach>

            <li><a href="<c:url value="/contact"></c:url>">Contact</a></li>
            </ul>
        </div>
        <div class="header-nav-dropdown">
            <button class="btn-menu" onclick="myDropDown()">Menu</button>
            <ul class="nav-link">
                <li><a href="home">My front page</a></li>
                <c:forEach var="item" items="${galleryHeader}">
                <li><a href="gallery?id=${item.id}">${item.name}</a></li>
                </c:forEach>
            <li><a href="<c:url value="/contact"></c:url>">Contact</a></li>
            </ul>
        </div>
        <div class="header-title">
            <div class="header-title-inner">
                <a href="home">
                    <img src="<c:url value="views/images/logo.png"></c:url>" alt="Logo"/>
            </a>
            <div class="title">
                <a href="home">                    
                    <div class="title-link">
                        Photographer
                    </div>
                </a>

                <div class="subtitle">
                    Welcome to this website
                </div>
            </div>
        </div>

    </div>
</div>