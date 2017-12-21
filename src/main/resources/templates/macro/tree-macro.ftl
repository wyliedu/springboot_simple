<#macro appTree categroys>
<ul class="list-unstyled c-first-layer">
	<#if categroys?? && categroys?size gt 0>
		<#list categroys as category>
			<#if category.child?? && category.child?size gt 0>
				<li>
				 	<a class="action-anticon">
				    	<i class="action-anticon-i anticon icon-up"></i>
				  	</a>
				  	<a href="/category/${category.productCategoryCode}">
				    	<h2>${category.categoryName}</h2>
				  	</a>
				  	<ul class="list-unstyled c-second-layer">
				  		<@appTree categroys=category.child />
				  	</ul>
				</li>
			<#else>
				<li>
				  <span class="blank-space-16"></span>
				  <a href="/category/${category.productCategoryCode}">
				    <h2>${category.categoryName}</h2>
				  </a>
				</li>
			</#if>
		</#list>
	</#if>
</ul>
</#macro>