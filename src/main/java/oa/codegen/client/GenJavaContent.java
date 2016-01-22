package oa.codegen.client;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import oa.codegen.entity.Entity;
import oa.codegen.field.AnnotationType;
import oa.codegen.field.EntityAnnotationType;
import oa.codegen.field.HibernateField;
import oa.codegen.field.TableAnnotationType;
import oa.codegen.property.Property;
import oa.codegen.property.PropertyType;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by handong on 16/1/15.
 */
public class GenJavaContent {
//    private static final String OUTPUT_PATH = "./src/main/java/oa/codegen/createdEntity";
    private String TEMPLATE_PATH = "./src/main/resources/template";


    private static File javaFile = null;

    @Test
    public void testGenContent(){
        GenJavaContent genJavaContent = new GenJavaContent();
        genJavaContent.gen();
    }

    public void gen() {
        Configuration cfg = new Configuration();
        try {
            // 步骤一：指定 模板文件从何处加载的数据源，这里设置一个文件目录

            cfg.setDirectoryForTemplateLoading(new File(this.TEMPLATE_PATH));
            cfg.setObjectWrapper(new DefaultObjectWrapper());

            // 步骤二：获取 模板文件
            Template template = cfg.getTemplate("entity.ftl");

            // 步骤三：创建 数据模型
            Map<String, Object> root = createModel();

            // 步骤四：合并 模板 和 数据模型
            // 创建.java类文件
            if(javaFile != null){
                Writer javaWriter = new FileWriter(javaFile);
                template.process(root, javaWriter);
                javaWriter.flush();
                System.out.println("文件生成路径： "+ javaFile.getCanonicalPath());

                javaWriter.close();
            }
            // 输出到Console控制台
            Writer out = new OutputStreamWriter(System.out);
            template.process(root, out);
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

    public Map<String, Object> createModel(){
        Entity business = new Entity();
        business.setClassName("ViewBus");
        business.setConstructors(true);
        business.setJavaPackage("oa.codegen.created.entity");
        business.setProperties(loadFields());

        List<AnnotationType> types = new ArrayList<AnnotationType>();
        types.add(new TableAnnotationType("LI_YONG_XIAN"));
        types.add(new EntityAnnotationType());
        business.setAnnotationTypes(types);
        // 创建.java类文件
        File outDirFile = new File("./src/main/java");
        if(!outDirFile.exists()){
            outDirFile.mkdir();
        }
        Map<String, Object> root = new HashMap<String, Object>();


        javaFile = toJavaFilename(outDirFile, business.getJavaPackage(), business.getClassName());

        root.put("entity", business);
        return root;
    }

    /**
     * 创建.java文件所在路径 和 返回.java文件File对象
     * @param outDirFile 生成文件路径
     * @param javaPackage java包名
     * @param javaClassName java类名
     * @return
     */
    private static File toJavaFilename(File outDirFile, String javaPackage, String javaClassName) {
        String packageSubPath = javaPackage.replace('.', '/');
        File packagePath = new File(outDirFile, packageSubPath);
        File file = new File(packagePath, javaClassName + ".java");
        if(!packagePath.exists()){
            packagePath.mkdirs();
        }
        return file;
    }


    private List<HibernateField> loadFields() {
        List<HibernateField> javaFields = new ArrayList();
        javaFields.add(new HibernateField("processInstanceId",PropertyType.String,"流程实例ID",20,false));
        javaFields.add(new HibernateField("formKey",PropertyType.String,"formkey"));

        javaFields.add(new HibernateField("firstyPayTime", PropertyType.Date,"自筹首付缴纳时间"));
        javaFields.add(new HibernateField("firstPayAmount",PropertyType.Long,"客户自筹首付款金额;以分为单位"));
        javaFields.add(new HibernateField("firstPayLocation",PropertyType.String,"自筹首付缴纳地点",100));
        javaFields.add(new HibernateField("firstPayStaff",PropertyType.String,"我方参与人员",50));
        javaFields.add(new HibernateField("lastyPayTime",PropertyType.Date,"剩余款项缴纳时间"));
        javaFields.add(new HibernateField("lastPayAmount",PropertyType.Long,"剩余款项金额;以分为单位"));
        javaFields.add(new HibernateField("lastPayLocation",PropertyType.String,"剩余款项缴纳地点",100));
        javaFields.add(new HibernateField("lastPayStaff",PropertyType.String,"我方参与人员,多个名单用“，”分割",50));
        javaFields.add(new HibernateField("serviceFeeDeductTime",PropertyType.Date,"服务费划扣时间"));

        return javaFields;
    }

    private List<Property> loadFieldsFromDb() {
        return null;
    }

    @Test
    public void testTransferTo(){
        System.out.println(transferFieldToTableField("setNameUser"));
    }

    public static String transferFieldToTableField(String javaFieldName) {
        char[] chars = javaFieldName.toCharArray();
        return transferToTableField(chars);
    }

    public static String transferToTableField(char[] chars) {
        StringBuffer stringBuffer = new StringBuffer("");
        for(char c : chars) {
            if(Character.isUpperCase(c)){
                stringBuffer.append('_').append(Character.toLowerCase(c));
            } else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }
}