package testmock;

import oa.codegen.util.StringTool;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by handong on 16/2/25.
 */
public class ControllerTestClient {
    private ControllerTest controllerTest = new ControllerTest();
    private Class controller;
    public ControllerTestClient(Class controller){
        this.controller = controller;
        init();
    }

    private void init() {
        RequestMapping requestMapping = (RequestMapping) controller.getAnnotation(RequestMapping.class);
        if(null != requestMapping){
            controllerTest.setControllerAlias(requestMapping.value()[0]);
            controllerTest.setControllerName(StringTool.lowcaseFirst(controller.getSimpleName()));
        }

        controllerTest.setJavaPackage(controller.getPackage().getName());
        controllerTest.setClassName(controller.getSimpleName()+"Test");
        dealMethods();

        dealProperties();
    }

    private void dealProperties() {
        Field[] fields = controller.getDeclaredFields();
        for (Field field : fields) {
            if(null != field.getType().getAnnotation(Service.class)){
                controllerTest.getManagerNameList().add(field.getName());
//                controllerTest.getManagerImportList().add(field.getType().getPackage().getName()+"."+
//                field.getType().getSimpleName());
                controllerTest.getManagerImportList().add(field.getType().getName());
            }
        }
    }

    private void dealMethods() {
        Method[] methods = controller.getDeclaredMethods();
        for(Method method : methods) {
            if(method.isAnnotationPresent(RequestMapping.class)){
                RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                ControllerMethod controllerMethod = new ControllerMethod();
                controllerMethod.setAlias(requestMapping.value()[0]);
                controllerMethod.setName(method.getName());
                Annotation[][] requestParams = method.getParameterAnnotations();
                for(Annotation[] annotations : requestParams) {
                    for(Annotation annotation : annotations) {
                        if((annotation instanceof RequestParam)){
                            controllerMethod.getParamList().add(((RequestParam) annotation).value());
                            break;
                        }
                    }
                }
                controllerTest.getMethodList().add(controllerMethod);
            }
        }
    }

    public ControllerTest getControllerTest() {
        return controllerTest;
    }
}
