<#import "../macro/okchem-macro.ftl" as okchem />
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>OKCHEM - Global largest B2B Marketplace of Chemical Products</title>
<meta name="keywords" content="" >
<meta name="description" content="Huge selection of quality chemical products and manufacturers from China, as well as sourcing, financing, chemical search, order tracking and industry news on okchem.com. " >

  <link rel="stylesheet" type="text/css" href="<@okchem.staticUrl '/static/css/header.css'/>">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="<@okchem.staticUrl '/static/css/page404.css'/>">
  <link rel="stylesheet" type="text/css" href="<@okchem.staticUrl '/static/css/okchem.css'/>">
  <script  src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="<@okchem.staticUrl '/static/plugin/js/scotthamper.cookies.js'/>"></script> 
  <script type="text/javascript" src="<@okchem.staticUrl '/static/js/okchem.main.js'/>"></script>
  <link rel="stylesheet" type="text/css" href="/static/fonts/iconfont.css">	
  <style type="text/css">
  	.Page404Content {
	    width: 1170px;
	}
  </style>
</head>
<body>
<div class="container-fluid">
  <div class="container sourcing-header">
    <div class="logo pull-left">
      <a href="/"><img src="${mainSiteUrl}/static/assets/logo2.png" alt="OKCHEM – Global B2B Platform for Chemical Raw Materials"></a>
    </div>
    <!-- <div class="form-group form-group-sm pull-left language-select">
      <select class="form-control">
        <option>English</option>
        <option>Español</option>
      </select>
    </div> -->
  </div>
</div>
<div class="header-shadow">

</div>
<!--主体内容部分-->
<div class="Page404Content" s>
  <div class="page404Left"><img src="${mainSiteUrl}/static/assets/page404.png"></div>
  <div class="page404Right">
    <h2><@spring.message "static.404.whoops"/></h2>
    <div><@spring.message "static.404.not.found"/></div>
    <ul>
      <li><@spring.message "static.500.url.correct"/></li>
      <li><@spring.message "static.500.link.outdated"/></li>
    </ul>
    <div><@spring.message "static.404.what.can.you.do"/></div>
    <ul class="whatCanYouDo">
      <li><a href="javascript:window.history.back();"><@spring.message "static.500.go.Back"/></a></li>
      <li><a href="/"><@spring.message "static.500.home"/></a></li>
      <li><@spring.message "static.404.use.search.bar"/></li>
    </ul>
    <div class="form-group row page404Search">
      <div class="col-md-10"><input type="text" id="keywordsText" class="form-control"  placeholder="<@spring.message "static.404.placeholder.looking.for"/>"></div>
      <div class="col-md-2"><button type="submit" id="searchBtn" class="btn btn-default">
        <i class="icon anticon icon-search1"></i>
      </button></div>
    </div>
  </div>
</div>

<!--侧边栏-->
<#include "/layout/sidebarPage.ftl"/>

<!--其他页面的底部-->
<div class="otherFooter">
  <div class="otherFooterContainer">
    <ul class="footerAboutUs">
      <li><a href="${baseUrl}/companyinfo/aboutus"><@spring.message "common.about.us"/>&nbsp;-&nbsp;</a></li>
      <li><a href="${baseUrl}/companyinfo/termsofservice"><@spring.message "common.terms"/>&nbsp;-&nbsp;</a></li>
      <li><a href="${baseUrl}/companyinfo/privacypolicy"><@spring.message "common.privacy.policy"/>&nbsp;-&nbsp;</a></li>
      <li><a href="${baseUrl}/companyinfo/buyersguide"><@spring.message "common.buyers.guide"/>&nbsp;-&nbsp;</a></li>
      <li><a href="${baseUrl}/companyinfo/faq"><@spring.message "common.faq"/>&nbsp;-&nbsp;</a></li>
      <li><a href="${baseUrl}/companyinfo/contactus"><@spring.message "common.contact.us"/></a></li>
    </ul>
    <div class="footerCopy">Copyright © 2016-2017, OKchem.com All rights reserved.</div>
  </div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$('#keywordsText').keypress(function (e) {
		 var key = e.which;
		 if(key == 13) 
		  {
			 searchAllChannel();
		  }
	});
	
	$("#searchBtn").bind("click",function(){
		searchAllChannel();
	});
});
function searchAllChannel(){
	setSubPageCookie("all-channels");
	window.location.href="/search-all?keyword="+$("#keywordsText").val();
}
</script>
</body>
</html>

