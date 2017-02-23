<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/taglibs.jsp"%>
<%pageContext.setAttribute("currentHeader", "bpm-task");%>
<%pageContext.setAttribute("currentMenu", "bpm-task");%>
<!doctype html>
<html lang="en">

<head>
    <%@include file="/common/meta.jsp"%>
    <title>${entity.title}</title>
    <%@include file="/common/s.jsp"%>

    <script>

        var config = {
            id: 'processGrid',
            pageNo: ${entity.contextFlag}{pageNo },
            pageSize: ${entity.contextFlag}{pageSize},
            totalCount: ${entity.contextFlag}{totalCount},
            resultSize: ${entity.contextFlag}{resultSize},
            pageCount: ${entity.contextFlag}{pageCount},
            orderBy: '${entity.contextFlag}{orderBy == null ? "" : orderBy}',
            asc: 'desc',
            params: {
//				"telephone":$("#telephone").val(),
//				"customerName":$("#customerName").val()
            },
            selectedItemClass: 'selectedItem',
            gridFormId: 'processGridForm',
            exportUrl: 'process-export.do'
        };

        var table;

        $(function() {
            table = new Table(config);
            table.configPagination('.m-pagination');
            table.configPageInfo('.m-page-info');
            table.configPageSize('.m-page-size');
        });

        function _edit(id) {
            var htmlobj = $.ajax({url: "${entity.actionUrl}/edit?id=" + id, async: false}).responseText;
            _modal("编辑", htmlobj);
        }
        function _add() {
            var htmlobj = $.ajax({url: "${entity.actionUrl}/edit", async: false}).responseText;
            _modal("添加", htmlobj);
        }
        function _delete(id) {
            if (confirm('确认删除此记录吗？')) {
                window.location.href = "${entity.actionUrl}/delete?id=" + id;
            }
        }
        <#--$().ready(function () {-->
            <#--<c:if test="${! empty msg}">-->
                <#--$('#msg').show();-->
            <#--</c:if>-->
        <#--});-->
    </script>
</head>

<body>
<%@include file="/header/bpm-console.jsp"%>

<div class="row-fluid">
    <%@include file="/menu/bpm-console.jsp"%>
    <!-- start of main -->
    <section id="m-main" class="span10">

        <article class="m-widget">
            <header class="header">
                <h4 class="title">查询</h4>
                <div class="ctrl">
                    <a class="btn"><i id="userSearchIcon" class="icon-chevron-up"></i></a>
                </div>
            </header>
            <div id="userSearch" class="content content-inner">

                <form name="userForm" method="post" action="${entity.searchActionUrl}" class="form-inline">
                    <#list entity.searchProps as searchProp>
                        <#if searchProp.type == 'text'>
                            <input type="text" class="form-control" id="${searchProp.name}" name="${searchProp.name}" placeholder="${searchProp.label}" value="${searchProp.name}">
                        </#if>
                        <#if searchProp.type == 'select'>
                            <select name="${searchProp.name}" id="${searchProp.name}">
                                <option value="">ALL</option>
                            </select>
                        </#if>
                    </#list>
                        <input  type="submit" class="btn btn-primary" value="查询"/>

                </form>

            </div>
        </article>

        <article class="m-blank">
            <div class="pull-left">
                <region:region-permission permission="user:create">
                    <button class="btn btn-small" onclick="_add()">新建</button>
                </region:region-permission>

            </div>

            <div class="pull-right">
                每页显示
                <select class="m-page-size">
                    <option value="10">10</option>
                    <option value="20">20</option>
                    <option value="50">50</option>
                </select>
                条
            </div>

            <div class="m-clear"></div>
        </article>

        <article class="m-widget">
            <header class="header">
                <h4 class="title">${entity.title}</h4>
            </header>
            <div class="content">

                <table id="demoGrid" class="m-table table-hover">
                    <thead>
                    <tr style="text-align: center">
                        <th>序号</th>
                    <#list entity.props as prop>
                            <th>${prop.label}</th>
                        </#list>
                        <th style="text-align: center;">操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="item" items="${entity.contextFlag}{list}" varStatus="status">
                        <tr style="text-align: center">
                            <td>${entity.contextFlag}{status.count}</td>
                        <#list entity.props as prop>
                            <td>${entity.contextFlag}{item.${prop.name}}</td>
                        </#list>
                            <td style="text-align: center;">
                                <a class="btn text-primary" onclick="_edit('${entity.contextFlag}{item.id}');" >编辑</a>
                                <a class="btn text-danger" onclick="_delete('${entity.contextFlag}{item.id}');" >删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </article>

        <article>
            <div class="m-page-info pull-left">
                共100条记录 显示1到10条记录
            </div>

            <div class="btn-group m-pagination pull-right">
                <button class="btn btn-small">&lt;</button>
                <button class="btn btn-small">1</button>
                <button class="btn btn-small">&gt;</button>
            </div>

            <div class="m-clear"></div>
        </article>

        <div class="m-spacer"></div>
        <jsp:include page="/common/modal.jsp"/>

    </section>
    <!-- end of main -->
</div>

</body>

</html>