<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>频道 添加</title>
<%@ include file="/jsp/common/meta.jsp"%>
<script language="javascript">
function checkForm(){
	return true;
}
function cancleClick(){
	self.location='channelAction.${actionExt}';    
}
</script>
<style type="text/css">
    body{ font-size:12px;}
    .l-table-edit {}
    .l-table-edit-td{ padding:4px;}
    .l-button-submit,.l-button-reset{width:80px; float:left; margin-left:10px; padding-bottom:2px;}
    .l-verify-tip{ left:230px; top:120px;}
</style>
</head>
<body>
<form name="channelForm" id="channelForm" method="post" action="channelAction!addSave.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
	<tr>
    	<td align="right" class="l-table-edit-td">编码：</td>
    	<td align="left" class="l-table-edit-td"><input name="channel.code" type="text" id="channel.code" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">名称：</td>
    	<td align="left" class="l-table-edit-td"><input name="channel.name" type="text" id="channel.name" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">摘要：</td>
    	<td align="left" class="l-table-edit-td">
    	<input name="channel.brief" type="text" id="channel.brief" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">模板：</td>
    	<td align="left" class="l-table-edit-td">
    	<select name="channel.templeteId" id="channel.templeteId">
    	<c:forEach items="${templeteList }" var="templete">
        <option value="${templete.id }" >${templete.name }</option>
        </c:forEach>
    	</select>
    	</td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">状态：</td>
    	<td align="left" class="l-table-edit-td">
    	<select name="channel.status" id="channel.status" >
        <option value="1">有效</option>
        <option value="0">无效</option>
        </select>
        </td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">排序：</td>
    	<td align="left" class="l-table-edit-td"><input name="channel.ordernum" type="text" id="channel.ordernum" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="center" colspan="3">
    	<input type="submit" value="保存" id="Button1" class="l-button l-button-submit" /> 
    	<input type="button" value="取消" class="l-button l-button-reset" onclick="javascript:cancleClick();"/>
    	</td>
    </tr>
</table>
</form>
</body>
</html>