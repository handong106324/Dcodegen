package oa.codegen.property;

/**
 * Created by handong on 16/1/15.
 */
public class Property {
//    // 属性数据类型
//    private String javaType;
    // 属性名称
    private String propertyName;

    private PropertyType propertyType;

    private String comment = "";
    private String annotation ="";

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }
}