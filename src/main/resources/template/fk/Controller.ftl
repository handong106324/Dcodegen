package ${entity.javaPackage};
import com.alibaba.fastjson.JSONObject;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.DefValue;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("${entity.path}")
public class RiskFormCategoryController {
private static final Logger LOGGER = LoggerFactory
.getLogger(RiskFormCategoryController.class);

@Autowired
private ${entity.baseService?cap_first} service;


@Post({"", "/"})
@Get({"", "/"})
public String list(Invocation inv, @Param("pageNo")int p,
@Param("pageSize") @DefValue("10") int size) {

int pageSize = size;
int pageNo = p;
int total = service.count();
if(pageSize == 0){
pageSize = 10;
}


if(pageNo > 0) {
pageNo --;
}
List<${entity.baseModel}> list = service.getPageList(pageNo * pageSize,
    pageSize, "id");

    inv.addModel("list", list);
    inv.addModel("resultSize", list==null?0:list.size());
    inv.addModel("pageNo",++ pageNo);
    inv.addModel("pageSize", pageSize);
    inv.addModel("totalCount", total);
    inv.addModel("pageCount", total/pageSize + 1);

    return "${entity.path}/list.jsp";
    }

    @Post("edit")
    @Get("edit")
    public String edit(Invocation inv, @Param("id") Long id) {

    if (id == null) {
    inv.addModel("vo", new ${entity.baseModel}());
    } else {
    ${entity.baseModel} vo = service.get(id);
    inv.addModel("vo", vo);
    }

    List<${entity.baseModel}> bpmConfBases = bpmConfBaseService.findOfUniqueProcessDefinitionKey();
        inv.addModel("processList",bpmConfBases);

        return "${entity.path}/edit";
        }

        @Post("/save")
        public String save(RiskFormCategory vo) {
        if (vo.getId() == null) {
        service.create(vo);
        } else {
        service.update(vo);
        }
        return jsonRet(0, "保存成功！");
        }

        @Get("/delete")
        @Post("/delete")
        public String delete(Invocation inv, @Param("id") Long id) {

        service.delete(id);
        inv.addModel("msg", "删除成功！");
        LOGGER.debug("[delete success][id:{}]",id);

        return "r:"+inv.getServletContext().getContextPath()+"/${entity.parentDir}/${entity.path}/";
        }

        private String jsonRet(int status, String msg) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        json.put("msg", msg);

        return "@" + json.toJSONString();
        }
        }
