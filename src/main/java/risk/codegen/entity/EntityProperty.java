package risk.codegen.entity;

/**
 * Created by handong on 16/3/14.
 */
public class EntityProperty {
    private String label;
    private String name;
    private String type;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public EntityProperty(String label, String name, String type) {
        this.label = label;
        this.name = name;
        this.type = type;
    }

    public EntityProperty(String label,String name){
        this.label = label;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
