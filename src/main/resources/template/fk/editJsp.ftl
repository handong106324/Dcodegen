<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/taglibs.jsp"%>

<script type="text/javascript">
    function _update(){
        //TODO 必填校验


        $.ajax({
            type: "POST",
            url:form1.action,
            data:$('#form1').serialize(),// 你的formid
            async: false,
            dataType:"json",
            error: function(request) {
                alert("保存失败!");
            },
            success: function(data) {
                alert(data.msg);
                if(data.status==0){
                    window.location.href="${entity.actionUrl}";
                }
            }
        });
        return true;
    }
</script>


<article class="m-widget">
    <header class="header">
        <h4 class="title">${entity.title}</h4>
    </header>

    <div class="content content-inner">

        <form class="form-horizontal" role="form" action="${entity.actionUrl}/save" method="post" id="form1">
            <input type="hidden" id="id" name="id" value="${entity.contextFlag}{vo.id}"/>

            <#list entity.props as prop>
                <div class="control-group">
                    <label for="type" class="col-sm-4 control-label">${prop.label}：</label>
                    <div class="controls">
                        <input type="text" class="form-control" id="${prop.name}" name="${prop.name}" placeholder="${prop.label}" value="${entity.contextFlag}{vo.${prop.name}}"/>
                    </div>
                </div>

            </#list>

            <div class="control-group">
                <div class="controls">
                    <button type="button" id="btn2" class="btn btn-default" onclick="_update();">保存</button>
                </div>
            </div>
        </form>
    </div>
</article>

