<%-- 
    Document   : viewTracks
    Created on : Aug 13, 2016, 3:48:24 PM
    Author     : gandoff
--%>
<%@include file="shared/header.jsp" %>
<title>View All Tracks</title>
</head>
<body>
    <div class="container">
        <table class="table table-striped table-bordered">
            <h1>All Tracks</h1>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Artist</th>
<!--                <th>Action</th>-->
            </tr>
            <c:forEach var="t" items="${tracks}">
                <tr id="${t.trackId}">
                    <td>${t.trackId}</td>
                    <td>${t.trackTitle}</td>
                    <td>${t.artist}</td>
<!--                    <td>
                        <a href="${SITE_URL}/track/getById/${t.trackId}" data-toggle="modal" data-target="#editModal">
                            <span class="btn btn-success glyphicon glyphicon-pencil"></span></button>   
                                                 
                    </td>-->
                </tr>
            </c:forEach>
            <div class="modal fade" id="editModal" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content"/>
                </div>
            </div>
        </table>
<!--        <div class="pull-right">
            <a href="${SITE_URL}/track/addTrack" class="btn btn-default" 
               data-toggle="modal" data-target="#editModal">
                <span class="glyphicon glyphicon-plus"/>
            </a>
        </div>-->
    </div>
</body>
<%@include file="shared/footer.jsp" %>
