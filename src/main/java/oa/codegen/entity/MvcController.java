package oa.codegen.entity;

import java.util.List;

/**
 * Created by handong on 16/2/19.
 */
public class MvcController extends Entity {
    private String controllerAlias;

    private List<String> hibernateManagerList;

    private String baseHibernateManager;

    private String baseRequestMapUrl;

    private String listParams;

    private String showParams;

    private String delParams;

    private String updateParam;

    public String getControllerAlias() {
        return controllerAlias;
    }

    public void setControllerAlias(String controllerAlias) {
        this.controllerAlias = controllerAlias;
    }

    public List<String> getHibernateManagerList() {
        return hibernateManagerList;
    }

    public void setHibernateManagerList(List<String> hibernateManagerList) {
        this.hibernateManagerList = hibernateManagerList;
    }

    public String getBaseRequestMapUrl() {
        return baseRequestMapUrl;
    }

    public void setBaseRequestMapUrl(String baseRequestMapUrl) {
        this.baseRequestMapUrl = baseRequestMapUrl;
    }

    public String getListParams() {
        return listParams;
    }

    public void setListParams(String listParams) {
        this.listParams = listParams;
    }

    public String getShowParams() {
        return showParams;
    }

    public void setShowParams(String showParams) {
        this.showParams = showParams;
    }

    public String getDelParams() {
        return delParams;
    }

    public void setDelParams(String delParams) {
        this.delParams = delParams;
    }

    public String getUpdateParam() {
        return updateParam;
    }

    public void setUpdateParam(String updateParam) {
        this.updateParam = updateParam;
    }

    public String getBaseHibernateManager() {
        return baseHibernateManager;
    }

    public void setBaseHibernateManager(String baseHibernateManager) {
        this.baseHibernateManager = baseHibernateManager;
    }
}
