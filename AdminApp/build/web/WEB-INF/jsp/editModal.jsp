<%-- 
    Document   : editModal
    Created on : Aug 13, 2016, 9:00:58 PM
    Author     : gandoff
--%>

<%@include file="shared/header.jsp" %>
<body>
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Editing Track</h4>
    </div>
    <div class="modal-body">
        <form:form action="${SITE_URL}/track/update" method="get" modelAttribute="track">
            <div class="form-group">
                <label for="usr">Track Id</label>
                <form:input path="trackId"/>
            </div>
            <div class="form-group">
                <label for="usr">Title</label>
                <form:input path="trackTitle"/>
            </div>
            <div class="form-group">
                <label for="usr">Artist</label>
                <form:input path="artist"/>
            </div>
            <div class="form-group">
                <label for="usr">Track Source</label>
                <form:input path="trackSource"/>
            </div>
            <input type="submit" value="Save" class="btn btn-default"/>
        </form:form>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

    </div>
</body>
</html>
