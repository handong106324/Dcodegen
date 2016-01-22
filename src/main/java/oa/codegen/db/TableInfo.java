package oa.codegen.db;

/**
 * Created by handong on 16/1/18.
 */
public class TableInfo {
    private String tableName;
    private String remarks;
    private String tableType;

    public TableInfo(String tableName, String tableName1, String remarks) {
        this.tableName = tableName;
        this.tableType = tableName1;
        this.remarks = remarks;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }
}
