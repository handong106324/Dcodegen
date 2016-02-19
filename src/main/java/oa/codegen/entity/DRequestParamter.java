package oa.codegen.entity;

/**
 * Created by handong on 16/2/19.
 */
public class DRequestParamter {
//    private RequestParam requestParam;
    private String alias;
    private String defaultValue;
    private String type;
    private String valueType;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }
}
