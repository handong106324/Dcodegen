package oa.codegen.client.generator;

import freemarker.log.Logger;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import oa.codegen.entity.Entity;
import org.junit.Assert;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//import junit.framework.Assert;

/**
 * Created by handong on 16/1/18.
 */
public class GeneratorClient {

    private static final Logger LOGGER =  Logger.getLogger(GeneratorClient.class.getName());

    public void generate(String TEMPLATE_PATH,String output_path,String templateName,Entity entity) {
        Assert.assertNotNull(TEMPLATE_PATH);
        try {

            // 步骤二：获取 模板文件
            Template template = getTemplate(TEMPLATE_PATH,templateName);
            Assert.assertNotNull(template);

            // 创建.java类文件
            File outDirFile = createOutputFile(output_path);
            Map<String, Object> root = new HashMap<String, Object>();

            root.put("entity",entity);
            File file = toJavaFilename(outDirFile, entity.getJavaPackage(), entity.getClassName(), entity.getType());
            // 步骤四：合并 模板 和 数据模型
            // 创建.java类文件
            if(file != null){
                Writer javaWriter = new FileWriter(file);
                template.process(root, javaWriter);
                javaWriter.flush();
                System.out.println("文件生成路径： " + file.getCanonicalPath());
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

    private File createOutputFile(String output_path) {
        File outDirFile = new File(output_path);
        if(!outDirFile.exists()){
            outDirFile.mkdir();
        }
        return outDirFile;
    }

    private Template getTemplate(String templatePath,String entityTemplateName){
        Configuration cfg = new Configuration();
        try {
            File file = new File(templatePath);
            // 步骤一：指定 模板文件从何处加载的数据源，这里设置一个文件目录
            cfg.setDirectoryForTemplateLoading(file);
            cfg.setObjectWrapper(new DefaultObjectWrapper());
            // 步骤二：获取 模板文件
            return cfg.getTemplate(entityTemplateName);
        }catch (Exception e) {
            LOGGER.error("获取模板错误", e);
            return null;
        }
    }

    /**
     * 创建.java文件所在路径 和 返回.java文件File对象
     * @param outDirFile 生成文件路径
     * @param javaPackage java包名
     * @param fileName java类名
     * @return
     */
    private static File toJavaFilename(File outDirFile, String javaPackage, String fileName,String type) {
        String packageSubPath = javaPackage.replace('.', '/');
        File packagePath = new File(outDirFile, packageSubPath);
        File file = new File(packagePath, fileName + "."+type);
        if(!packagePath.exists()){
            packagePath.mkdirs();
        }
        return file;
    }

}
