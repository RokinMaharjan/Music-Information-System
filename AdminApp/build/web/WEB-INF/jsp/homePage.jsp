<%-- 
    Document   : homePage
    Created on : Aug 29, 2016, 6:21:19 PM
    Author     : rokin
--%>

<%@include file="shared/header.jsp" %>
<title>Music Information System</title>
<spring:url value="/resources/photos/Green Day.jpg" var="gd" />
</head>
<body>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">iHeartMUSIC</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="${SITE_URL}">Home</a></li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Users<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${SITE_URL}/users/admin/viewAll">All Users</a></li>
                        <li><a href="${SITE_URL}/users/admin/viewMIS">MIS</a></li>
                    </ul>
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Tracks<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${SITE_URL}/track/admin/viewAll">All Tracks</a></li>
                    </ul>
                </li>

            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="${SITE_URL}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div>
    </nav>




    <!-- Carousel -->        
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Image Page of Carousel -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img class="first-slide" src="http://tiledwallpaper.com/wallpapers/2011/1/16504432054d2a58997aba14.92905905.jpg" alt="First slide">
            </div>
            <div class="item">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4">
                            <img class="img-circle" src="https://cdn.europosters.eu/image/750/stickers/guns-n-roses-logo-i10964.jpg" alt="Generic placeholder image" width="300" height="300">
                            <h2>Guns N' Roses</h2>
                            <p>Guns N' Roses is an American hard rock band from Los Angeles formed in 1985. The classic lineup, as signed to Geffen Records in 1986, consisted of vocalist Axl Rose, lead guitarist Slash, rhythm guitarist Izzy Stradlin, bassist Duff McKagan, and drummer Steven Adler.</p>
                        </div><!-- /.col-lg-4 -->
                        <div class="col-lg-4">
                            <img class="img-circle" src="http://rockmerchuniverse.com/images/greendaygrenadebutton.jpg" alt="Generic placeholder image" width="300" height="300">
                            <h2>Green Day</h2>
                            <p>Green Day is an American punk rock band formed in 1986 by vocalist/guitarist Billie Joe Armstrong and bassist Mike Dirnt.  For much of the group's career, the band has been a trio with drummer Tré Cool, who replaced former drummer John Kiffmeyer in 1990 prior to the recording of the band's second studio album, Kerplunk (1992).</p>
                        </div><!-- /.col-lg-4 -->
                        <div class="col-lg-4">
                            <img class="img-circle" src="http://www.rock.com/assets/products/58988/large/ac-dc-logo-metallic-button-b3775ch.jpg" alt="Generic placeholder image" width="300" height="300">
                            <h2>AC/DC</h2>
                            <p>AC/DC are an Australian rock band, formed in 1973 by brothers Malcolm and Angus Young. A hard rock/blues rock band, they have also been considered a heavy metal band, although they have always dubbed their music simply "rock and roll".</p>
                        </div><!-- /.col-lg-4 -->
                    </div><!-- /.row -->
                    <!-- End of Image Page -->

                    </br>
                    </br>


                    <!-- Circles -->
                    <div class="row">
                        <div class="col-lg-4">
                            <img class="img-circle" src="https://yt3.ggpht.com/-Yn_PpHByTN8/AAAAAAAAAAI/AAAAAAAAAAA/p7Om3nMN3Bk/s900-c-k-no-mo-rj-c0xffffff/photo.jpg" alt="Generic placeholder image" width="300" height="300">
                            <h2>Ed Sheeran</h2>
                            <p>Edward Christopher "Ed" Sheeran is an English singer-songwriter, musician, and occasional actor. He was born in Hebden Bridge in Yorkshire and raised in Framlingham, Suffolk.</p>
                        </div><!-- /.col-lg-4 -->
                        <div class="col-lg-4">
                            <img class="img-circle" src="http://logonoid.com/images/blink-182-logo.png" alt="Generic placeholder image" width="300" height="300">
                            <h2>Blink 182</h2>
                            <p>Blink-182 is an American rock band formed in Poway, California in 1992. The band currently consists of bassist and vocalist Mark Hoppus, drummer Travis Barker, and guitarist and vocalist Matt Skiba.</p>
                        </div><!-- /.col-lg-4 -->
                        <div class="col-lg-4">
                            <img class="img-circle" src="http://dhgkpqsiufwl2.cloudfront.net/media/ArticleSharedImage/image400/.fsl3podU/ArticleSharedImage-11407.jpg" alt="Generic placeholder image" width="300" height="300">
                            <h2>Hozier</h2>
                            <p>Andrew Hozier-Byrne, known professionally by the mononym Hozier, is an Irish musician, singer and songwriter from County Wicklow. He released his debut EP, featuring the hit single "Take Me to Church", in 2013 and his second EP, From Eden, in 2014.</p>                           
                        </div><!-- /.col-lg-4 -->
                    </div><!-- /.row -->
                    <!-- End of Circles -->

                </div>
            </div>




            <!-- Featurette -->
            <div class="item">
                <center><h1>TOP NEWS</h1></center>
                </br>
                <div class="container">
                    <div class="row featurette">
                        <c:forEach var="n" items="${news}" varStatus="loopCount">
                            <c:if test="${loopCount.count eq 1}">
                                <div class="col-md-7">
                                    <a href="${n.link}">
                                        <h2 class="featurette-heading">${n.heading}</h2>
                                    </a>
                                </div>
                                <div class="col-md-5">
                                    <img class="featurette-image img-responsive center-block" src="${n.imageURL}" alt="Generic placeholder image"/>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>

                    <hr class="featurette-divider">

                    <div class="row featurette">
                        <c:forEach var="n" items="${news}" varStatus="loopCount">
                            <c:if test="${loopCount.count eq 2}">
                                <div class="col-md-7 col-md-push-5">
                                    <a href="${n.link}">
                                        <h2 class="featurette-heading">${n.heading}</h2>
                                    </a>
                                </div>
                                <div class="col-md-5 col-md-pull-7">
                                    <img class="featurette-image img-responsive center-block" src="${n.imageURL}" alt="Generic placeholder image">
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>

                    <hr class="featurette-divider">

                    <div class="row featurette">
                        <c:forEach var="n" items="${news}" varStatus="loopCount">
                            <c:if test="${loopCount.count eq 3}">
                                <div class="col-md-7">
                                    <a href="${n.link}">
                                        <h2 class="featurette-heading">${n.heading}</h2>
                                    </a>
                                </div>
                                <div class="col-md-5">
                                    <img class="featurette-image img-responsive center-block" src="${n.imageURL}" alt="Generic placeholder image"/>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>

                    <hr class="featurette-divider">


                    <div class="row featurette">
                        <c:forEach var="n" items="${news}" varStatus="loopCount">
                            <c:if test="${loopCount.count eq 4}">
                                <div class="col-md-7 col-md-push-5">
                                    <a href="${n.link}">
                                        <h2 class="featurette-heading">${n.heading}</h2>
                                    </a>
                                </div>
                                <div class="col-md-5 col-md-pull-7">
                                    <img class="featurette-image img-responsive center-block" src="${n.imageURL}" alt="Generic placeholder image">
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                    </br>
                    </br>
                </div>
            </div>
            <!-- End of Featurette -->


        </div>
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div><!-- /.carousel -->

</div>

</body>

</html>
