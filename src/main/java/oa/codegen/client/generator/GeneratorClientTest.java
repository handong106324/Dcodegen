package oa.codegen.client.generator;

import oa.codegen.client.dbfield.DbFieldQueryClient;
import oa.codegen.client.dbfield.TableField;
import oa.codegen.entity.Entity;
import oa.codegen.field.*;
import oa.codegen.property.Property;
import oa.codegen.property.PropertyType;
import oa.codegen.sql.MysqlConnTool;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by handong on 16/1/18.
 */
public class GeneratorClientTest {
    @Test
    public void testClient(){
        String TEMPLATE_PATH = "./src/main/resources/template";
        String output_path = "./src/main/java";
        GeneratorClient client = new GeneratorClient() ;
        Entity entity = createEntity();
        client.generate(TEMPLATE_PATH,output_path,"entity.ftl",entity);

        //create manager
        Entity managerEntity = createManager(entity);
        client.generate(TEMPLATE_PATH,output_path,"manager.ftl",managerEntity);
        //create service
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
