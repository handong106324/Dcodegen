package oa.codegen.property;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by handong on 16/1/15.
 */

public enum PropertyType {
    Byte, Short,Integer, Long, Boolean, Float, Double, String, ByteArray, Date;

    public static PropertyType getType(String columnTypeName) {
        if(StringUtils.isBlank(columnTypeName)) return null;
        for(PropertyType propertyType : values()) {
            if(columnTypeName.contains("Timestamp")) return Date;
            if(columnTypeName.contains(propertyType.name())){
                return propertyType;
            }
        }
        return null;
    }
}


