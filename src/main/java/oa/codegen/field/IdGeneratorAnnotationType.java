package oa.codegen.field;

/**
 * Created by handong on 16/1/18.
 */
public class IdGeneratorAnnotationType extends AnnotationType {
    public IdGeneratorAnnotationType(){
        setAnnotationInfo("@Id\n    @GeneratedValue(strategy = GenerationType.IDENTITY)");
    }
}
