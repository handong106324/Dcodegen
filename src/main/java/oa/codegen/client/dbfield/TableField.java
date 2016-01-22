package oa.codegen.client.dbfield;

public class TableField {
    // 获得指定列的列名
    String columnName ;
    // 获得指定列的列值
    int columnType ;
    // 获得指定列的数据类型名
    String columnTypeName ;
    // 所在的Catalog名字
    String catalogName  ;
    // 对应数据类型的类
    String columnClassName ;
    // 在数据库中类型的最大字符个数
    int columnDisplaySize ;
    // 默认的列的标题
    String columnLabel ;
    // 获得列的模式
    String schemaName ;
    // 某列类型的精确度(类型的长度)
    int precision ;
    // 小数点后的位数
    int scale ;
    // 获取某列对应的表名
    String tableName1;
    // 是否自动递增
    boolean isAutoInctement;
    // 在数据库中是否为货币型
    boolean isCurrency ;
    // 是否为空
    int isNullable ;
    // 是否为只读
    boolean isReadOnly ;
    // 能否出现在where中
    boolean isSearchable ;

    String remark;
    public TableField(String columnName,int columnType,String columnTypeName,String catalogName,String columnClassName,
                      int columnDisplaySize,String columnLabel,String schemaName,int precision,int scale,String tableName1
            ,boolean isAutoInctement,boolean isCurrency,int isNullable, boolean isReadOnly,boolean isSearchable,String remark){
        this.columnClassName = columnClassName;
        this.columnName = columnName;
        this.columnType = columnType;
        this.columnTypeName = columnTypeName;
        this.catalogName = catalogName;
        this.columnDisplaySize = columnDisplaySize;
        this.columnLabel = columnLabel;
        this.schemaName = schemaName;
        this.isAutoInctement = isAutoInctement;
        this.isCurrency = isCurrency;
        this.precision = precision;
        this.scale = scale;
        this.tableName1 =tableName1;
        this.isNullable = isNullable;
        this.isReadOnly = isReadOnly;
        this.isSearchable = isSearchable;
        this.remark  =remark;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getColumnType() {
        return columnType;
    }

    public void setColumnType(int columnType) {
        this.columnType = columnType;
    }

    public String getColumnTypeName() {
        return columnTypeName;
    }

    public void setColumnTypeName(String columnTypeName) {
        this.columnTypeName = columnTypeName;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getColumnClassName() {
        return columnClassName;
    }

    public void setColumnClassName(String columnClassName) {
        this.columnClassName = columnClassName;
    }

    public int getColumnDisplaySize() {
        return columnDisplaySize;
    }

    public void setColumnDisplaySize(int columnDisplaySize) {
        this.columnDisplaySize = columnDisplaySize;
    }

    public String getColumnLabel() {
        return columnLabel;
    }

    public void setColumnLabel(String columnLabel) {
        this.columnLabel = columnLabel;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getTableName1() {
        return tableName1;
    }

    public void setTableName1(String tableName1) {
        this.tableName1 = tableName1;
    }

    public boolean isAutoInctement() {
        return isAutoInctement;
    }

    public void setIsAutoInctement(boolean isAutoInctement) {
        this.isAutoInctement = isAutoInctement;
    }

    public boolean isCurrency() {
        return isCurrency;
    }

    public void setIsCurrency(boolean isCurrency) {
        this.isCurrency = isCurrency;
    }

    public int getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(int isNullable) {
        this.isNullable = isNullable;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public void setIsReadOnly(boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

    public boolean isSearchable() {
        return isSearchable;
    }

    public void setIsSearchable(boolean isSearchable) {
        this.isSearchable = isSearchable;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
