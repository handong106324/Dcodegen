package risk.codegen.client;

import oa.codegen.client.dbfield.DbFieldQueryClient;
import oa.codegen.client.generator.GeneratorClient;
import oa.codegen.entity.Entity;
import oa.codegen.sql.MysqlConnTool;
import org.junit.Test;
import risk.codegen.Controller;
import risk.codegen.EditJspEntity;
import risk.codegen.ListJspEntity;
import risk.codegen.entity.EntityProperty;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by handong on 16/3/14.
 */
public class ListJspGenCreator {

    String TEMPLATE_PATH = "./src/main/resources/template/fk";
    String output_path = "./src/main/webapp";

    public static void createListJsp(String TEMPLATE_PATH, String output_path, Entity entity){
        GeneratorClient client = new GeneratorClient() ;
        client.generate(TEMPLATE_PATH,output_path,"listJsp.ftl",entity);
    }

    public static void createEditJsp(String TEMPLATE_PATH, String output_path, Entity entity){
        GeneratorClient client = new GeneratorClient() ;
        client.generate(TEMPLATE_PATH,output_path,"editJsp.ftl",entity);
    }


    public static void createController(String TEMPLATE_PATH, String output_path, Entity entity){
        GeneratorClient client = new GeneratorClient() ;
        client.generate(TEMPLATE_PATH,output_path,"Controller.ftl",entity);
    }


    @Test
    public void testCreate(){
        ListJspEntity entity = new ListJspEntity();
//        entity.setCreateUrl("\\$\\{ctx\\}/process/edit");
        entity.setTitle("配置表单规则");
        entity.setSearchActionUrl("${ctx}/param/list");
        entity.setType("jsp");
        entity.setSearchProps(getSearchProps());
        entity.setClassName("list");
        entity.setJavaPackage("gg.content");
        entity.setActionUrl("${ctx}/param/list");
        entity.setProps(getProps("soeasy_riskmanage","RISK_PARAM"));

        EditJspEntity editEntity = new EditJspEntity();
        editEntity.setActionUrl("${ctx}/param/list");
        editEntity.setTitle("表单规则");
        editEntity.setJavaPackage("gg.content");
        editEntity.setClassName("edit");
        editEntity.setType("jsp");
        editEntity.setProps(getProps("soeasy_riskmanage","RISK_PARAM"));

        Controller controller = new Controller();
        controller.setJavaPackage("com.souyidai.risk.param");
        controller.setBaseModel("");
        createListJsp(TEMPLATE_PATH,output_path,entity);
        createEditJsp(TEMPLATE_PATH,output_path,editEntity);
    }

    private List<EntityProperty> getProps(String dbIns,String dbName) {
        Connection connection = MysqlConnTool.getConnection(dbIns);
        return DbFieldQueryClient.loadPropToField(connection,dbName);
    }

    private List<EntityProperty> getSearchProps() {
        List<EntityProperty> list = new ArrayList<>();
        list.add(new EntityProperty("创建时间","createTime","input"));
        return list;
    }

}
