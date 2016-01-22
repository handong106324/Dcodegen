package oa.codegen.field;

/**
 * Created by handong on 16/1/15.
 */
public class TableAnnotationType extends AnnotationType{
    public TableAnnotationType(String tableName){
        setAnnotationInfo("@Table(name = \""+tableName+"\")");
    }
}
