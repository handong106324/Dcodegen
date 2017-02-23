package risk.codegen;

import oa.codegen.entity.Entity;
import risk.codegen.entity.EntityProperty;

import java.util.List;

/**
 * Created by handong on 16/3/15.
 */
public class EditJspEntity extends Entity{
    private String actionUrl;
    private String title;
    private List<EntityProperty> props;


    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<EntityProperty> getProps() {
        return props;
    }

    public void setProps(List<EntityProperty> props) {
        this.props = props;
    }
}
