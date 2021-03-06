package oa.codegen.client.generator;

import oa.codegen.client.dbfield.DbFieldQueryClient;
import oa.codegen.client.dbfield.TableField;
import oa.codegen.entity.DRequestParamter;
import oa.codegen.entity.Entity;
import oa.codegen.entity.MvcController;
import oa.codegen.field.*;
import oa.codegen.property.Property;
import oa.codegen.property.PropertyType;
import oa.codegen.sql.MysqlConnTool;
import org.junit.Test;
import testmock.ControllerTest;
import testmock.ControllerTestClient;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by handong on 16/1/18.
 */
public class GeneratorClientTest {
    String TEMPLATE_PATH = "../template";
    String output_path = "./src/main/java";
    @Test
    public void testClient() throws IOException {

        GeneratorClient client = new GeneratorClient() ;
//        Entity entity = createEntity();
//        client.generate(TEMPLATE_PATH,output_path,"entity.ftl",entity);
//
//        //create manager
//        Entity managerEntity = createManager(entity);
//        client.generate(TEMPLATE_PATH,output_path,"manager.ftl",managerEntity);
        //create controller
        MvcController mvcController = createController();
        client.generate(TEMPLATE_PATH,output_path,"mvcController.ftl",mvcController);
    }
//
    @Test
    public void testControllerTest(){
        GeneratorClient client = new GeneratorClient() ;

        ControllerTest mvcController = new ControllerTestClient(com.souyidai.oa.RiskForm.class).getControllerTest();
        String className = "TestStatusController";
        String packageName = "com.souyidai.oa.persistence";
        mvcController.setClassName(className);
        mvcController.setJavaPackage(packageName);
        client.generate(TEMPLATE_PATH,output_path,"testController.ftl",mvcController);
    }

    private Entity createEntity() {
        String tableName = "OA_PROCESS_STATUS";
        String className = "OaFlowStatus";
        boolean isConstructors = true;
        String packageName = "com.souyidai.oa.persistence";
        String dbInstance = "soeasy_oa";
        Entity business = createEntity(tableName, className, isConstructors, packageName, dbInstance);

        List<AnnotationType> types = new ArrayList<AnnotationType>();
        types.add(new EntityAnnotationType());
        types.add(new TableAnnotationType(tableName));
        business.setAnnotationTypes(types);
        return business;
    }

    private Entity createManager(Entity entity) {
        String className = entity.getClassName()+"Manager";
        boolean isConstructors = true;
        String packageName = entity.getJavaPackage().substring(0,entity.getJavaPackage().lastIndexOf(".")+1)+"manager";
        String dbInstance = "soeasy_oa";
        Entity business = createEntity("", className, isConstructors, packageName, dbInstance);
        business.setSuperclass("HibernateEntityDao");
        List<AnnotationType> types = new ArrayList<AnnotationType>();
        types.add(new ServiceAnnotationType());
        business.setAnnotationTypes(types);
        return business;
    }

    private MvcController createController(){
        MvcController mvcController = new MvcController();
        mvcController.setBaseHibernateManager("loanInfoManager");//.class.getSimpleName());
        List<DRequestParamter> listParams = new ArrayList<DRequestParamter>();
        listParams.add(new DRequestParamter("name","","@RequestParam","String"));
        mvcController.setListParams(listParams);
        mvcController.setJavaPackage("com.bb");
        List<String> manas = new ArrayList<String>();
        manas.add("loanInfoManager");
        mvcController.setHibernateManagerList(manas);
        mvcController.setClassName("BController");
        mvcController.setBaseRequestMapUrl("ll-rr");
        List<String> imports = new ArrayList<>();
//        imports.add(LoanInfoManager.class.getPackage().getName()+"."+LoanInfoManager.class.getSimpleName());
        mvcController.setManagerImports(imports);
        mvcController.setControllerAlias("bbtest");
        return mvcController;
    }


    private Entity createEntity(String tableName, String className, boolean isConstructors, String packageName, String dbInstance) {
        Entity business = new Entity();
        business.setClassName(className);
        business.setConstructors(isConstructors);
        business.setJavaPackage(packageName);
        business.setProperties(loadFields(dbInstance, tableName));
        return business;
    }

    private List<? extends Property> loadFields(String dbInstanceName , String tableName) {
        List<HibernateField> fields = new ArrayList<HibernateField>();
        Connection connection = MysqlConnTool.getConnection("soeasyoadb", "3306", dbInstanceName, "soeasy", "soeasy");
        List<TableField> tableFields = DbFieldQueryClient.getDbFields(tableName,connection);

        for(TableField tableField : tableFields) {
            HibernateField property;
            if(tableField.isAutoInctement()){//其实可以通过primarykey
                property = new HibernateField(tableField.getColumnName(),PropertyType.getType(tableField.getColumnClassName()),tableField.getRemark(),new IdGeneratorAnnotationType());
            }else {
                property = new HibernateField(MysqlConnTool.transferDbFieldNameToJavaFieldName(tableField.getColumnName()), PropertyType.getType(tableField.getColumnClassName()), tableField.getRemark(), tableField.getColumnDisplaySize(), Boolean.getBoolean(tableField.getIsNullable() + ""));
            }
            fields.add(property);
        }
        return fields;
    }

}
