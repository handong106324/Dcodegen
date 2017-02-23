package risk.codegen;

import oa.codegen.entity.Entity;
import risk.codegen.entity.EntityProperty;

import java.util.List;

/**
 * Created by handong on 16/3/14.
 */
public class ListJspEntity extends Entity{
    private String title;

    private String actionUrl;

    private String searchActionUrl;

    private List<EntityProperty> searchProps;

    private String createUrl;

    private List<EntityProperty> props;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSearchActionUrl() {
        return searchActionUrl;
    }

    public void setSearchActionUrl(String searchActionUrl) {
        this.searchActionUrl = searchActionUrl;
    }

    public List<EntityProperty> getSearchProps() {
        return searchProps;
    }

    public void setSearchProps(List<EntityProperty> searchProps) {
        this.searchProps = searchProps;
    }

    public String getCreateUrl() {
        return createUrl;
    }

    public void setCreateUrl(String createUrl) {
        this.createUrl = createUrl;
    }

    public List<EntityProperty> getProps() {
        return props;
    }

    public void setProps(List<EntityProperty> props) {
        this.props = props;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }
}
