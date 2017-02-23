package testmock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handong on 16/2/25.
 */
public class ControllerMethod {
    private String name;
    private List<String> paramList = new ArrayList<>();
    private String alias;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getParamList() {
        return paramList;
    }

    public void setParamList(List<String> paramList) {
        this.paramList = paramList;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }
}
