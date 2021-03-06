package ${entity.javaPackage};
import javax.persistence.*;
import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
*   This code is generated by FreeMarker
*   generate db table to entity
*   author:handong
*/
<#list entity.annotationTypes as type >
${type.annotationInfo}
</#list>
public class ${entity.className}<#if entity.superclass?has_content> extends ${entity.superclass}</#if>{
    <#list entity.properties as property>
    ${property.comment}
    ${property.annotation}
    private ${property.propertyType} ${property.propertyName};

    </#list>

    <#if entity.constructors>
    public ${entity.className}() {}

    </#if>

    <#--public ${entity.className}(<#list entity.properties as property>${property.javaType} ${property.propertyName}<#if property_has_next>,   ) {-->
        <#--<#list entity.properties as property>-->
            <#--this.${property.propertyName} = ${property.propertyName};-->
        <#--</#list>-->

    <#--}-->
    <#list entity.properties as property>
    public ${property.propertyType} get${property.propertyName?cap_first}() {
        return ${property.propertyName};
    }

    public void set${property.propertyName?cap_first}(${property.propertyType} ${property.propertyName}) {
        this.${property.propertyName} = ${property.propertyName};
    }

    </#list>

    @Override
    public String toString() {
    return "${entity.className}{"
            <#list entity.properties as property>
                <#if property_index == 0>
                + "${property.propertyName}=" + ${property.propertyName}
                <#else >
                + ",${property.propertyName}=" + ${property.propertyName}
                </#if>
            </#list>
            + '}';
    }
}
