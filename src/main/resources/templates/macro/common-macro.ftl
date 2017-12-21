<#macro staticUrl relativeUrl>${mainSiteUrl}${springMacroRequestContext.getContextUrl(relativeUrl)}</#macro>

<#macro okchemModal>
<div id="okchemModalDIV" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <!-- <h4 class="modal-title">OKCHEM B2B Chemical Supply</h4> -->
            </div>
            <div class="modal-body">
                <iframe id="okchemModalFrame" width="560" height="315" src="" frameborder="0" allowfullscreen></iframe>
            </div>
        </div>
    </div>
</div>
</#macro>

<#macro languageSelect currentLn="en">
 	<select class="form-control" id="languagePicker">
        <option <#if currentLn == "en"> selected</#if> value="en">English</option>
        <option <#if currentLn == "es"> selected</#if> value="es">Español</option>
        <option <#if currentLn == "pt"> selected</#if> value="pt">Português</option>
    </select>
 </#macro>