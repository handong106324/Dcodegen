package oa.codegen.field;

import oa.codegen.client.GenJavaContent;

/**
 * Created by handong on 16/1/15.
 */
public class ColumnAnnotationType extends AnnotationType {
    private String propertyName;
    private int maxLen;
    private boolean isNull;
    public ColumnAnnotationType(String propertyName,int maxLen,boolean isNull){
        this.maxLen = maxLen;
        this.isNull = isNull;
        this.propertyName = propertyName;
        toFieldAnnotation();
    }

    public void toFieldAnnotation() {
        String len = "";
        String nullAble = "";
        if (maxLen > 0) len = ", length = " + maxLen;
//        if (!isNull) nullAble = ", nullable = false";
        setAnnotationInfo( "@Column(name=\"" + GenJavaContent.transferFieldToTableField(propertyName ) + "\"" + len + nullAble + ")");
    }


}
