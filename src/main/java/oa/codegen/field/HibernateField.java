package oa.codegen.field;

import oa.codegen.property.Property;
import oa.codegen.property.PropertyType;

/**
 * Created by handong on 16/1/15.
 */

public class HibernateField extends Property{

    private boolean isKey = false;
    public HibernateField(String fieldName, PropertyType javaType, String comment) {
        this(fieldName, javaType, comment, new ColumnAnnotationType(fieldName, -1, true));
    }

    public HibernateField(String fieldName, PropertyType javaType, String content, AnnotationType annotationType) {
        setPropertyName(fieldName);
        setPropertyType(javaType);
        handleComment(content);
        setAnnotation(annotationType.getAnnotationInfo());
    }

    public HibernateField(String fieldName, PropertyType javaType, String content, int maxLen, boolean b) {
        this(fieldName, javaType, content, new ColumnAnnotationType(fieldName, maxLen, b));
    }
    public HibernateField(String fieldName, PropertyType javaType, String content, int maxLen) {
        this(fieldName, javaType, content, maxLen, true);
    }
    public void handleComment(String comment) {
        StringBuffer stringBuffer = new StringBuffer("/**\n");
        stringBuffer.append("     *" + comment+"\n");
        stringBuffer.append("     */");
        super.setComment(stringBuffer.toString());
    }

    public boolean isKey() {
        return isKey;
    }

    public void setIsKey(boolean isKey) {
        this.isKey = isKey;
    }
}
