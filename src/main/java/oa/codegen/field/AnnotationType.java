package oa.codegen.field;

/**
 * Created by handong on 16/1/15.
 */
public class AnnotationType {

    private String annotationInfo;
//    public String toFieldAnnotation() ;
    private Class annotationClass;

    public String getAnnotationInfo() {
        return annotationInfo;
    }

    public void setAnnotationInfo(String annotationInfo) {
        this.annotationInfo = annotationInfo;
    }

    public Class getAnnotationClass() {
        return annotationClass;
    }

    public void setAnnotationClass(Class annotationClass) {
        this.annotationClass = annotationClass;
    }
}
