<#assign base = request.contextPath />
<#macro myLayout title="OKCHEM – Global B2B Platform for Chemical Raw Materials" keywords="" description="Huge selection of quality chemical products and manufacturers from China, as well as sourcing, financing, chemical search, order tracking and industry news on okchem.com." pannerMenu="" csslist=[] jslist=[] >
<!DOCTYPE html>
	<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	    <title>${title}</title>
		<meta name="keywords" content="${keywords}" >
		<meta name="description" content="${description}" >
		 		
	    <base id="base" href="${baseUrl}">
	    
		<link rel="shortcut icon" href="/static/favicon.png">
	    
	    <link rel="stylesheet" type="text/css" href="${baseUrl}/static/assets/css/bootstrap.css">
	    <link rel="stylesheet" type="text/css" href="${baseUrl}/static/assets/css/font-awesome.css">
	    <link rel="stylesheet" type="text/css" href="${baseUrl}/static/assets/css/pricing.css">
	    <link rel="stylesheet" type="text/css" href="${baseUrl}/static/assets/css/basic.css">
	    <link rel="stylesheet" type="text/css" href="${baseUrl}/static/assets/css/custom.css">
	    
	    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
	    <#if csslist?has_content>
	    	<#list csslist as css>
		    	<link rel="stylesheet" type="text/css" href="'/static/'+css />">
	    	</#list>
	    </#if>
	    <script  src="/static/assets/js/jquery-1.10.2.js"></script>
	    <script  src="/static/assets/js/bootstrap.js"></script> 
	    <script  src="/static/assets/js/jquery.metisMenu.js"></script>
	    <script  src="/static/assets/js/custom.js"></script>
	    <#if jslist?has_content>
	    	<#list jslist as js>
		    	<script  src="'/static/'+js"></script>
	    	</#list>
	    </#if>
	</head>
    <body>    
    <div id="wrapper">

      <#include "header.ftl"/>
           
      <#include "sidebarPage.ftl"/>
	   <div id="page-wrapper">
            <div id="page-inner">
	  			<#nested/>
	  		</div>
	  </div>
	  
      <#include "footer.ftl"/>
    </body>
  </html>
  <script>
  $(document).ready(function(){	
		//refreshInquiryCartHeader();		
		//initiateCookies();
  });
  
  </script>
</#macro>