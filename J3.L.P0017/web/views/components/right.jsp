<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="right">
    <div class="right-heading">
        <h4 class="subtitle2">Share this page</h4>
    </div>
    <ul>
        <li><a href="${contact.faceUrl}">
                <img src="<c:url value="views/images/face.png"></c:url>" alt=""><span>Share on Facebook</span></a></li>
        <li><a href="${contact.twitterUrl}">
                <img src="<c:url value="views/images/twitter.png"></c:url>" alt=""><span>Share on Twitter</span></a></li>
    </ul>
</div>