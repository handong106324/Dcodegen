package testmock;

import oa.codegen.entity.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handong on 16/2/25.
 */
public class ControllerTest extends Entity {
    private String controllerName;
    private String controllerAlias;
    private List<String> managerNameList = new ArrayList<>();
    private List<String> managerImportList = new ArrayList<>();

    private List<ControllerMethod> methodList = new ArrayList<>();

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getControllerAlias() {
        return controllerAlias;
    }

    public void setControllerAlias(String controllerAlias) {
        this.controllerAlias = controllerAlias;
    }

    public List<String> getManagerNameList() {
        return managerNameList;
    }

    public void setManagerNameList(List<String> managerNameList) {
        this.managerNameList = managerNameList;
    }

    public List<String> getManagerImportList() {
        return managerImportList;
    }

    public void setManagerImportList(List<String> managerImportList) {
        this.managerImportList = managerImportList;
    }

    public List<ControllerMethod> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<ControllerMethod> methodList) {
        this.methodList = methodList;
    }
}
