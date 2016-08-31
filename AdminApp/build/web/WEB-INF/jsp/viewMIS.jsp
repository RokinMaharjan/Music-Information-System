<%-- 
    Document   : viewUsers
    Created on : Aug 27, 2016, 12:58:23 PM
    Author     : rokin
--%>

<%@include file="shared/header.jsp" %>
<title>User List</title>
</head>
<body>
    <div class="container">
        <table class="table table-striped table-bordered table-hover">
            <h1>Your Valuable Data</h1>
            <tr>
                <th>Track Id</th>
                <th>Teen</th>
                <th>Young Adult</th>
                <th>Adult</th>
                <th>Kathmandu</th>
                <th>Bhaktapur</th>
                <th>Lalitpur</th>
                <th>Action</th>
            </tr>
            <c:forEach var="m" items="${trackLog}" varStatus="loopCount">
                <tr id="${m.trackId}">
                    <td>${m.trackId}</td>
                    <td>${m.teen}</td>
                    <td>${m.youngAdult}</td>
                    <td>${m.adult}</td>
                    <td>${m.kathmandu}</td>
                    <td>${m.bhaktapur}</td>
                    <td>${m.lalitpur}</td>
                    <td>
                        <a href="#" class="btn btn-success glyphicon glyphicon-pencil"/>
                        <a href="#" class="btn btn-danger glyphicon glyphicon-trash"/>
                    </td>
                </tr>
            </c:forEach>

        </table>

    </div>
</body>
</html>