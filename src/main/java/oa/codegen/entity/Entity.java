package oa.codegen.entity;

import oa.codegen.field.AnnotationType;
import oa.codegen.property.Property;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handong on 16/1/15.
 */
public class Entity {
    // 实体所在的包名
    private String javaPackage;
    // 实体类名
    private String className;
    // 父类名
    private String superclass;
    // 属性集合
    List<? extends Property> properties;

    List<AnnotationType> annotationTypes = new ArrayList<AnnotationType>();
    // 是否有构造函数
    private boolean constructors;

    public String getJavaPackage() {
        return javaPackage;
    }

    public void setJavaPackage(String javaPackage) {
        this.javaPackage = javaPackage;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSuperclass() {
        return superclass;
    }

    public void setSuperclass(String superclass) {
        this.superclass = superclass;
    }

    public List<? extends Property> getProperties() {
        return properties;
    }

    public void setProperties(List<? extends Property> properties) {
        this.properties = properties;
    }

    public boolean isConstructors() {
        return constructors;
    }

    public void setConstructors(boolean constructors) {
        this.constructors = constructors;
    }

    public List<AnnotationType> getAnnotationTypes() {
        return annotationTypes;
    }

    public void setAnnotationTypes(List<AnnotationType> annotationTypes) {
        this.annotationTypes = annotationTypes;
    }
}