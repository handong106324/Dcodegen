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

    private List<DRequestParamter> listParams;

    private List<DRequestParamter>  showParams;

    private List<DRequestParamter>  delParams;

    private List<DRequestParamter>  updateParam;
    private List<String> managerImports;

    public List<String> getManagerImports() {
        return managerImports;
    }

    public void setManagerImports(List<String> managerImports) {
        this.managerImports = managerImports;
    }

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

    public List<DRequestParamter> getListParams() {
        return listParams;
    }

    public void setListParams(List<DRequestParamter> listParams) {
        this.listParams = listParams;
    }

    public List<DRequestParamter> getShowParams() {
        return showParams;
    }

    public void setShowParams(List<DRequestParamter> showParams) {
        this.showParams = showParams;
    }

    public List<DRequestParamter> getDelParams() {
        return delParams;
    }

    public void setDelParams(List<DRequestParamter> delParams) {
        this.delParams = delParams;
    }

    public List<DRequestParamter> getUpdateParam() {
        return updateParam;
    }

    public void setUpdateParam(List<DRequestParamter> updateParam) {
        this.updateParam = updateParam;
    }

    public String getBaseHibernateManager() {
        return baseHibernateManager;
    }

    public void setBaseHibernateManager(String baseHibernateManager) {
        this.baseHibernateManager = baseHibernateManager;
    }
}
