<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons">
  <link rel="stylesheet"
    href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css"
    integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css"
    href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons">
  <link rel="stylesgeet" href="https://rawgit.com/creativetimofficial/material-kit/master/assets/css/material-kit.css">
  <!-- <link rel="stylesheet" href="landing_page.css"> -->
  <link rel="stylesheet"
    href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <style>
        html * {
    -webkit-font-smoothing: antialiased;
}

.container h1 {
    font-size: 3.3125rem;
    line-height: 1.15em;
}

.container h4 {
    font-size: 1.125rem;
    line-height: 1.5em;
    margin-top: 10px;
    margin-bottom: 10px;
    font-family: Roboto,Helvetica,Arial,sans-serif;
    font-weight: 300;
}

.container h5 {
    font-family: Roboto,Helvetica,Arial,sans-serif;
    font-weight: 300;
    font-size: 1.0625rem;
    line-height: 1.55em;
    margin-bottom: 15px;
}

.title, .title  {
    margin-top: 30px;
    margin-bottom: 25px;
    min-height: 32px;
    color: #3C4858;
    text-decoration: none;
    font-weight: 700;
    font-family: "Roboto Slab","Times New Roman",serif;
}

.container a {
    color: #9c27b0;
}

.description {
    color: #999;
}

.text-muted {
    color: #6c757d!important;
}

small {
    font-size: 75%;
    color: #777;
}

p {
    font-size: 14px;
    font-weight: 300;
    margin: 0 0 10px;
}

/* navbar */

.navbar {
    border: 0;
    border-radius: 3px;
    padding: .625rem 0;
    margin-bottom: 20px;
    color: #555;
    background-color: #fff!important;
    box-shadow: 0 4px 18px 0 rgba(0,0,0,.12), 0 7px 10px -5px rgba(0,0,0,.15) !important;
    z-index: 1000 !important;
    transition: all 150ms ease 0s;
    
}

.navbar.navbar-transparent {
    z-index: 1030;
    background-color: transparent!important;
    box-shadow: none !important;
    padding-top: 25px;
    color: #fff;
}

.navbar .navbar-brand {
    position: relative;
    color: inherit;
    height: 50px;
    font-size: 1.125rem;
    line-height: 30px;
    padding: .625rem 0;
    font-weight: 300;
    -webkit-font-smoothing: antialiased;
}

.navbar .navbar-nav .nav-item .nav-link:not(.btn) .material-icons {
    margin-top: -7px;
    top: 6px;
    position: relative;
    margin-right: 3px;
}

.navbar .navbar-nav .nav-item .nav-link .material-icons {
    font-size: 1.25rem;
    max-width: 24px;
    margin-top: -1.1em;
}

.navbar .navbar-nav .nav-item .nav-link .fa, .navbar .navbar-nav .nav-item .nav-link .material-icons {
    font-size: 1.25rem;
    max-width: 24px;
}

.navbar .navbar-nav .nav-item .nav-link {
    position: relative;
    color: inherit;
    padding: .9375rem;
    font-weight: 400;
    font-size: 12px;
    border-radius: 3px;
    line-height: 20px;
}

/* page header */

.page-header {
    height: 100vh;
    background-size: cover;
    margin: 0;
    padding: 0;
    border: 0;
    display: flex;
    align-items: center;
}

.header-filter:after, .header-filter:before {
    position: absolute;
    z-index: 1;
    width: 100%;
    height: 100%;
    display: block;
    left: 0;
    top: 0;
    content: "";
}

.header-filter::before {
    background: rgba(0,0,0,.5);
}

.header-filter .container {
    z-index: 2;
    position: relative;
}

.page-header .title {
    color: #fff;
}

.page-header h4{
    color: #fff;
}

/* buttons */

.container .btn{
    position: relative;
    padding: 12px 30px;
    margin: .3125rem 1px;
    font-size: .75rem;
    font-weight: 400;
    line-height: 1.428571;
    text-decoration: none;
    text-transform: uppercase;
    letter-spacing: 0;
    border: 0;
    border-radius: .2rem;
    outline: 0;
    transition: box-shadow .2s cubic-bezier(.4,0,1,1),background-color .2s cubic-bezier(.4,0,.2,1);
    will-change: box-shadow,transform;
}

.container .btn.btn-raised.btn-primary:focus,
.container .btn.btn-raised.btn-primary:hover, 
.container .btn.btn-raised.btn-primary:active{
    color: #fff;
    background-color: #9124a3 !important;
    border-color: #701c7e;
}

.container .btn.btn-lg {
    padding: 1.125rem 2.25rem;
    font-size: .875rem;
    line-height: 1.333333;
    border-radius: .2rem;
}

.container .btn.btn-danger {
    color: #fff;
    background-color: #f44336;
    border-color: #f44336;
    box-shadow: 0 2px 2px 0 rgba(244,67,54,.14), 0 3px 1px -2px rgba(244,67,54,.2), 0 1px 5px 0 rgba(244,67,54,.12);
}

.container .btn.btn-danger:hover {
    box-shadow: 0 14px 26px -12px rgba(244,67,54,.42), 0 4px 23px 0 rgba(0,0,0,.12), 0 8px 10px -5px rgba(244,67,54,.2);
}

.container .btn.btn-raised.btn-primary {
    color: #fff;
    background-color: #9c27b0;
    border-color: #9c27b0;
    box-shadow: 0 2px 2px 0 rgba(156,39,176,.14), 0 3px 1px -2px rgba(156,39,176,.2), 0 1px 5px 0 rgba(156,39,176,.12);
}

.container .btn.btn-primary:hover {
    box-shadow: 0 14px 26px -12px rgba(156,39,176,.42), 0 4px 23px 0 rgba(0,0,0,.12), 0 8px 10px -5px rgba(156,39,176,.2);
}
.container .btn.btn-just-icon {
    font-size: 24px;
    height: 41px;
    min-width: 41px;
    width: 41px;
    padding: 0;
    overflow: hidden;
    position: relative;
    line-height: 41px;
    background-color: transparent;
    color: #999;
}

.container .btn.btn-just-icon .fa, .btn.btn-just-icon .material-icons {
    margin-top: 0;
    position: absolute;
    width: 100%;
    transform: none;
    left: 0;
    top: 0;
    height: 100%;
    line-height: 41px;
    font-size: 20px;
}

/* main */

.main-raised {
    margin: -60px 30px 0;
    border-radius: 6px;
    box-shadow: 0 16px 24px 2px rgba(0,0,0,.14), 0 6px 30px 5px rgba(0,0,0,.12), 0 8px 10px -5px rgba(0,0,0,.2);
}

.main {
    background: #FFF;
    position: relative;
    z-index: 3;
}

.section {
    padding: 70px 0;
}

.info {
    max-width: 360px;
    margin: 0 auto;
    padding: 70px 0 30px;
}

.icon.icon-info {
    color: #00bcd4;
}

.icon.icon-success {
    color: #4caf50;
}

.icon.icon-danger {
    color: #f44336;
}

.info .icon>i {
    font-size: 3.85rem;
}

.info .info-title {
    font-weight: 700;
    font-family: "Roboto Slab","Times New Roman",serif;
    color: #3C4858;
    margin: 1.75rem 0 .875rem;
}

.info p {
    color: #999;
}

.title.text-center {
    margin-bottom: 50px;
}
.container .card-plain {
    background: 0 0;
    box-shadow: none !important;
}

.card-plain .card-body, .card-plain .card-footer {
    padding-left: 5px;
    padding-right: 5px;
}

.card .card-body+.card-footer {
    padding-top: 0;
    border: 0;
    border-radius: 6px;
}

.container .card {
    border: 0;
    margin-bottom: 30px;
    margin-top: 30px;
    border-radius: 6px;
    color: rgba(0,0,0,.87);
    background: #fff;
    width: 100%;
    box-shadow: 0 2px 2px 0 rgba(0,0,0,.14), 0 3px 1px -2px rgba(0,0,0,.2), 0 1px 5px 0 rgba(0,0,0,.12);
}

.container .card .card-title {
    font-weight: 700;
    font-family: "Roboto Slab","Times New Roman",serif;
    margin-top: .625rem;
    color: #3C4858;
    text-decoration: none;
    font-size: 1.125rem;
    line-height: 1.5em;
    margin-bottom: .75rem;
}

.container .card-description {
    color: #999;
}

.img-raised {
    box-shadow: 0 5px 15px -8px rgba(0,0,0,.24), 0 8px 10px -5px rgba(0,0,0,.2);
}

/* dropdown */

.dropdown-menu {
    position: absolute;
    top: 100%;
    left: 0;
    z-index: 1000;
    float: left;
    min-width: 11rem !important;
    margin: .125rem 0 0;
    font-size: 1rem;
    color: #212529;
    text-align: left;
    background-color: #fff;
    background-clip: padding-box;
    border-radius: .25rem;
    transition: transform .3s cubic-bezier(.4,0,.2,1),opacity .2s cubic-bezier(.4,0,.2,1);
}

.dropdown-menu.show{
    transition: transform .3s cubic-bezier(.4,0,.2,1),opacity .2s cubic-bezier(.4,0,.2,1);
}


.dropdown-menu .dropdown-item:focus, .dropdown-menu .dropdown-item:hover, .dropdown-menu a:active, .dropdown-menu a:focus, .dropdown-menu a:hover {
    box-shadow: 0 4px 20px 0 rgba(0,0,0,.14), 0 7px 10px -5px rgba(156,39,176,.4);
    background-color: #9c27b0;
    color: #FFF;
}
.show .dropdown-toggle:after {
    transform: rotate(180deg);
}

.dropdown-toggle:after {
    will-change: transform;
    transition: transform .15s linear;
}


.dropdown-menu .dropdown-item, .dropdown-menu li>a {
    position: relative;
    width: auto;
    display: flex;
    flex-flow: nowrap;
    align-items: center;
    color: #333;
    font-weight: 400;
    text-decoration: none;
    font-size: .8125rem;
    border-radius: .125rem;
    margin: 0 .3125rem;
    transition: all .15s linear;
    min-width: 7rem;
    padding: 0.625rem 1.25rem;
    min-height: 1rem !important;
    overflow: hidden;
    line-height: 1.428571;
    text-overflow: ellipsis;
    word-wrap: break-word;
}

.dropdown-menu.dropdown-with-icons .dropdown-item {
    padding: .75rem 1.25rem .75rem .75rem;
}

.dropdown-menu.dropdown-with-icons .dropdown-item .material-icons {
    vertical-align: middle;
    font-size: 24px;
    position: relative;
    margin-top: -4px;
    top: 1px;
    margin-right: 12px;
    opacity: .5;
}


/* inputs */

.container .bmd-form-group .bmd-label-static {
    top: .35rem;
    left: 0;
    font-size: .875rem;
}

.container .bmd-form-group .form-control, .bmd-form-group input::placeholder, .bmd-form-group label {
    line-height: 1.1;
}

.container .form-control, .is-focused .form-control {
    background-image: linear-gradient(0deg,#9c27b0 2px,
    rgba(156,39,176,0) 0),linear-gradient(0deg,#d2d2d2 1px,hsla(0,0%,82%,0) 0) !important;
}

.form-group.is-focused [class*=" bmd-label"], .form-group.is-focused [class^=bmd-label] {
    color: #9c27b0;
}
.form-control {
    background: no-repeat bottom,50% calc(100% - 1px);
    background-size: 0 100%,100% 100%;
    border: 0;
    height: 36px;
    transition: background 0s ease-out;
    padding-left: 0;
    padding-right: 0;
    border-radius: 0;
    font-size: 14px !important;
}
.form-control:focus{
    box-shadow: none;
}
.form-control::placeholder{
    font-size: 14px !important;
    color: #AAA !important;
}

.bmd-form-group label {
    font-size: .875rem !important;
    color: #AAA;
}

.bmd-form-group [class^=bmd-label].bmd-label-floating {
    will-change: left,top,contents;
    margin: 0;
    line-height: 1.4;
    font-weight: 400;
}

.bmd-form-group .bmd-label-floating, .bmd-form-group .bmd-label-placeholder {
    top: 2.3125rem !important;
}

.is-focused .bmd-label-floating {
    top: 1rem;
    left: 0;
    font-size: .6875rem;
}

.is-filled .bmd-label-floating, .is-focused .bmd-label-floating {
    top: 1rem !important;
    left: 0;
    font-size: .6875rem !important;
}

.form-control-feedback {
    position: absolute;
    top: 33px;
    right: 0;
    z-index: 2;
    display: block;
    width: 34px;
    height: 34px;
    line-height: 34px;
    pointer-events: none;
    opacity: 0;
}

.input-group .input-group-text {
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 0 15px;
    background-color: transparent;
    border-color: transparent;
}
/* footer */

footer{
    margin-top: 20px;
    color: #555;
    padding: 25px;
    font-weight: 300;
    
}
.footer p{
    margin-bottom: 0;
    font-size: 14px;
    font-weight: 300;
}
footer p a{
    color: #555;
    font-weight: 400;
}

footer p a:hover {
    color: #9f26aa;
    text-decoration: none;
}


    </style>
  <title>Welcome To GRS</title>
</head>

<body>

  <body class="landing-page ">
    <nav class="navbar navbar-color-on-scroll navbar-transparent    fixed-top  navbar-expand-lg " color-on-scroll="100"
      id="sectionsNav">
      <div class="container">
        <div class="navbar-translate">
          <a class="navbar-brand" href="http://localhost:8080/GrievanceRedressalSystem/" target="_blank"><img
              src="Image/Logo.png" style="height:65px ;border:2px ; border-radius:5px;"> </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            <span class="navbar-toggler-icon"></span>
            <span class="navbar-toggler-icon"></span>
          </button>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="navbar-nav ml-auto">
            <!-- <li class="dropdown nav-item">
                      <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                           Components
                      </a>
                      <div class="dropdown-menu dropdown-with-icons">
                        <a href="../index.html" class="dropdown-item">
                            <i class="material-icons">layers</i> All Components
                        </a>
                        
                        <a href="http://demos.creative-tim.com/material-kit/docs/2.0/getting-started/introduction.html" class="dropdown-item">
                            <i class="material-icons">content_paste</i> Documentation
                        </a>
                        
                      </div>
                    </li> -->
            <li class="nav-item">
              <a class="nav-link" href="" onclick="scrollToDownload()">
                <h5>About us</h5>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="" target="_blank">
                <h5> Services</h5>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="" target="_blank">
                <h5> Contact us </h5>
              </a>
            </li>
            <li class="nav-item">
              <a href="Login/AllLogIn.jsp" class="btn btn-success">
                <h6> Login</h6>
              </a>
            </li>

          </ul>
        </div>
      </div>
    </nav>
    <div class="page-header header-filter" data-parallax="true"
      style=" background-image: url('https://images.unsplash.com/photo-1531449862596-16e4c62e2b10?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=7261ec0c2507c69c76ec73a01162637b&auto=format&fit=crop&w=750&q=80'); ">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <h1 class="title">Making Connection Beautifull . . . </h1>
            <h4>We help our customers to connect with their loved one&apos;s without any barriers. Grs is a small
              attempt to solve those barriers. Here you can register your complaints and we will be there for you 24*7
              to help you, assist you & for your querries.</h4>
            <br>
            <a href="User/UserRegistration.jsp" target="_blank" class="btn btn-danger btn-raised btn-lg"
              style="border-radius: 10px !important ;">
              <h6> Register</h6>
            </a>
          </div>
        </div>
      </div>
    </div>
    <div class="main main-raised">
      <div class="container">
        <div class="section text-center">
          <div class="row">
            <div class="col-md-8 ml-auto mr-auto">
              <h2 class="title">Our Services</h2>
              <h5 class="description">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Exercitationem
                reprehenderit temporibus illo error. Quos consequatur a ipsum voluptates, officiis fugiat rem mollitia.
                Voluptate accusamus ea animi porro eligendi necessitatibus velit?</h5>
            </div>
          </div>

          <div class="features">
            <div class="row">
              <div class="col-md-4">
                <div class="info">
                  <div class="icon icon-info">
                    <i class="material-icons">broadcast_on_personal</i>
                  </div>
                  <h4 class="info-title">Broadband </h4>
                  <p>Divide details about your product or agency work into parts. Write a few lines about each one. A
                    paragraph describing a feature will be enough.</p>
                </div>
              </div>

              <div class="col-md-4">
                <div class="info">
                  <div class="icon icon-success">
                    <i class="material-icons">local_phone</i>
                  </div>
                  <h4 class="info-title">Landline</h4>
                  <p>Divide details about your product or agency work into parts. Write a few lines about each one. A
                    paragraph describing a feature will be enough.</p>
                </div>
              </div>

              <div class="col-md-4">
                <div class="info">
                  <div class="icon icon-danger">
                    <i class="material-icons">phone_iphone</i>
                  </div>
                  <h4 class="info-title">Mobile</h4>
                  <p>Divide details about your product or agency work into parts. Write a few lines about each one. A
                    paragraph describing a feature will be enough.</p>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="section text-center">
          <h2 class="title">About Us</h2>
          <!-- <div class="team">
            <div class="row">
              <div class="col-md-4">
                <div class="team-player">
                  <div class="card card-plain">
                    <div class="col-md-6 ml-auto mr-auto">
                      <img
                        src="https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/a47c2a784683.5629a928cbcb7.jpg"
                        alt="Thumbnail Image" class="img-raised rounded-circle img-fluid">

                    </div>
                    <h4 class="card-title">Gigi Hadid <br>
                      <small class="card-description text-muted">Model</small>
                    </h4>

                    <div class="card-body">
                      <p class="card-description">You can write here details about one of your team members. You can
                        give more details about what they do. Feel free to add some <a href="#">links</a> for people to
                        be able to follow them outside the site.</p>
                    </div>
                    <div class="card-footer justify-content-center">
                      <a href="#pablo" class="btn btn-link btn-just-icon"><i class="fa fa-twitter"></i></a>
                      <a href="#pablo" class="btn btn-link btn-just-icon"><i class="fa fa-instagram"></i></a>
                      <a href="#pablo" class="btn btn-link btn-just-icon"><i class="fa fa-facebook-square"></i></a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="team-player">
                  <div class="card card-plain">
                    <div class="col-md-6 ml-auto mr-auto">
                      <img
                        src="http://www.onepercentfortheplanet.org/storage/individualmembership/FoundingMembers/russ_stoddard_large_square.jpg"
                        alt="Thumbnail Image" class="img-raised rounded-circle img-fluid">

                    </div>
                    <h4 class="card-title">Christian Louboutin<br>
                      <small class="card-description text-muted">Designer</small>
                    </h4>

                    <div class="card-body">
                      <p class="card-description">You can write here details about one of your team members. You can
                        give more details about what they do. Feel free to add some <a href="#">links</a> for people to
                        be able to follow them outside the site.</p>
                    </div>
                    <div class="card-footer justify-content-center">
                      <a href="#pablo" class="btn btn-link btn-just-icon"><i class="fa fa-twitter"></i></a>
                      <a href="#pablo" class="btn btn-link btn-just-icon"><i class="fa fa-linkedin"></i></a>
                    </div>
                  </div>
                </div>
              </div>

              <div class="col-md-4">
                <div class="team-player">
                  <div class="card card-plain">
                    <div class="col-md-6 ml-auto mr-auto">
                      <img
                        src="http://www.solstreamstudios.com/ss/wp-content/uploads/2015/11/Portrait-17-JRH-5018-PE-square.jpg"
                        alt="Thumbnail Image" class="img-raised rounded-circle img-fluid">

                    </div>
                    <h4 class="card-title">Kendall Jenner<br>
                      <small class="card-description text-muted">Model</small>
                    </h4>

                    <div class="card-body">
                      <p class="card-description">You can write here details about one of your team members. You can
                        give more details about what they do. Feel free to add some <a href="#">links</a> for people to
                        be able to follow them outside the site.</p>
                    </div>
                    <div class="card-footer justify-content-center">
                      <a href="#pablo" class="btn btn-link btn-just-icon"><i class="fa fa-twitter"></i></a>
                      <a href="#pablo" class="btn btn-link btn-just-icon"><i class="fa fa-instagram"></i></a>
                      <a href="#pablo" class="btn btn-link btn-just-icon"><i class="fa fa-facebook-square"></i></a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div> -->
        </div>
        <div class="section section-contacts">
          <div class="row">
            <div class="col-md-8 ml-auto mr-auto">
              <h2 class="text-center title">Contact us</h2>
              <h4 class="text-center description">Divide details about your product or agency work into parts. Write a
                few lines about each one and contact us about any further collaboration. We will responde get back to
                you in a couple of hours.</h4>
              <form class="contact-form">
                <div class="row">
                  <div class="col-md-6">
                    <div class="form-group">
                      <label class="bmd-label-floating">Your Name</label>
                      <input type="email" class="form-control">
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="form-group">
                      <label class="bmd-label-floating">Your Email</label>
                      <input type="email" class="form-control">
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <label for="exampleMessage" class="bmd-label-floating">Your Message</label>
                  <textarea type="email" class="form-control" rows="4" id="exampleMessage"></textarea>
                </div>

                <div class="row">
                  <div class="col-md-4 ml-auto mr-auto text-center">
                    <button class="btn btn-primary btn-raised">
                      Send Message
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

    <footer class="footer text-center ">
    
    </footer>

    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js"
      integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U"
      crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js"
      integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9"
      crossorigin="anonymous"></script>
    <script src="landing_page.js"></script>
    <script>
        var big_image;

$(document).ready(function() {
  BrowserDetect.init();

  // Init Material scripts for buttons ripples, inputs animations etc, more info on the next link https://github.com/FezVrasta/bootstrap-material-design#materialjs
  $('body').bootstrapMaterialDesign();

  window_width = $(window).width();

  $navbar = $('.navbar[color-on-scroll]');
  scroll_distance = $navbar.attr('color-on-scroll') || 500;

  $navbar_collapse = $('.navbar').find('.navbar-collapse');

  //  Activate the Tooltips
  $('[data-toggle="tooltip"], [rel="tooltip"]').tooltip();

  // Activate Popovers
  $('[data-toggle="popover"]').popover();

  if ($('.navbar-color-on-scroll').length != 0) {
    $(window).on('scroll', materialKit.checkScrollForTransparentNavbar);
  }

  materialKit.checkScrollForTransparentNavbar();

  if (window_width >= 768) {
    big_image = $('.page-header[data-parallax="true"]');
    if (big_image.length != 0) {
      $(window).on('scroll', materialKit.checkScrollForParallax);
    }

  }


});

$(document).on('click', '.navbar-toggler', function() {
  $toggle = $(this);

  if (materialKit.misc.navbar_menu_visible == 1) {
    $('html').removeClass('nav-open');
    materialKit.misc.navbar_menu_visible = 0;
    $('#bodyClick').remove();
    setTimeout(function() {
      $toggle.removeClass('toggled');
    }, 550);

    $('html').removeClass('nav-open-absolute');
  } else {
    setTimeout(function() {
      $toggle.addClass('toggled');
    }, 580);


    div = '<div id="bodyClick"></div>';
    $(div).appendTo("body").click(function() {
      $('html').removeClass('nav-open');

      if ($('nav').hasClass('navbar-absolute')) {
        $('html').removeClass('nav-open-absolute');
      }
      materialKit.misc.navbar_menu_visible = 0;
      $('#bodyClick').remove();
      setTimeout(function() {
        $toggle.removeClass('toggled');
      }, 550);
    });

    if ($('nav').hasClass('navbar-absolute')) {
      $('html').addClass('nav-open-absolute');
    }

    $('html').addClass('nav-open');
    materialKit.misc.navbar_menu_visible = 1;
  }
});

materialKit = {
  misc: {
    navbar_menu_visible: 0,
    window_width: 0,
    transparent: true,
    fixedTop: false,
    navbar_initialized: false,
    isWindow: document.documentMode || /Edge/.test(navigator.userAgent)
  },

  initFormExtendedDatetimepickers: function() {
    $('.datetimepicker').datetimepicker({
      icons: {
        time: "fa fa-clock-o",
        date: "fa fa-calendar",
        up: "fa fa-chevron-up",
        down: "fa fa-chevron-down",
        previous: 'fa fa-chevron-left',
        next: 'fa fa-chevron-right',
        today: 'fa fa-screenshot',
        clear: 'fa fa-trash',
        close: 'fa fa-remove'
      }
    });
  },

  initSliders: function() {
    // Sliders for demo purpose
    var slider = document.getElementById('sliderRegular');

    noUiSlider.create(slider, {
      start: 40,
      connect: [true, false],
      range: {
        min: 0,
        max: 100
      }
    });

    var slider2 = document.getElementById('sliderDouble');

    noUiSlider.create(slider2, {
      start: [20, 60],
      connect: true,
      range: {
        min: 0,
        max: 100
      }
    });
  },

  checkScrollForParallax: function() {
    oVal = ($(window).scrollTop() / 3);
    big_image.css({
      'transform': 'translate3d(0,' + oVal + 'px,0)',
      '-webkit-transform': 'translate3d(0,' + oVal + 'px,0)',
      '-ms-transform': 'translate3d(0,' + oVal + 'px,0)',
      '-o-transform': 'translate3d(0,' + oVal + 'px,0)'
    });
  },

  checkScrollForTransparentNavbar: debounce(function() {
    if ($(document).scrollTop() > scroll_distance) {
      if (materialKit.misc.transparent) {
        materialKit.misc.transparent = false;
        $('.navbar-color-on-scroll').removeClass('navbar-transparent');
      }
    } else {
      if (!materialKit.misc.transparent) {
        materialKit.misc.transparent = true;
        $('.navbar-color-on-scroll').addClass('navbar-transparent');
      }
    }
  }, 17)
};

// Returns a function, that, as long as it continues to be invoked, will not
// be triggered. The function will be called after it stops being called for
// N milliseconds. If `immediate` is passed, trigger the function on the
// leading edge, instead of the trailing.

function debounce(func, wait, immediate) {
  var timeout;
  return function() {
    var context = this,
      args = arguments;
    clearTimeout(timeout);
    timeout = setTimeout(function() {
      timeout = null;
      if (!immediate) func.apply(context, args);
    }, wait);
    if (immediate && !timeout) func.apply(context, args);
  };
};

var BrowserDetect = {
  init: function() {
    this.browser = this.searchString(this.dataBrowser) || "Other";
    this.version = this.searchVersion(navigator.userAgent) || this.searchVersion(navigator.appVersion) || "Unknown";
  },
  searchString: function(data) {
    for (var i = 0; i < data.length; i++) {
      var dataString = data[i].string;
      this.versionSearchString = data[i].subString;

      if (dataString.indexOf(data[i].subString) !== -1) {
        return data[i].identity;
      }
    }
  },
  searchVersion: function(dataString) {
    var index = dataString.indexOf(this.versionSearchString);
    if (index === -1) {
      return;
    }

    var rv = dataString.indexOf("rv:");
    if (this.versionSearchString === "Trident" && rv !== -1) {
      return parseFloat(dataString.substring(rv + 3));
    } else {
      return parseFloat(dataString.substring(index + this.versionSearchString.length + 1));
    }
  },

  dataBrowser: [{
      string: navigator.userAgent,
      subString: "Chrome",
      identity: "Chrome"
    },
    {
      string: navigator.userAgent,
      subString: "MSIE",
      identity: "Explorer"
    },
    {
      string: navigator.userAgent,
      subString: "Trident",
      identity: "Explorer"
    },
    {
      string: navigator.userAgent,
      subString: "Firefox",
      identity: "Firefox"
    },
    {
      string: navigator.userAgent,
      subString: "Safari",
      identity: "Safari"
    },
    {
      string: navigator.userAgent,
      subString: "Opera",
      identity: "Opera"
    }
  ]

};
    </script>
  </body>
</body>

</html>