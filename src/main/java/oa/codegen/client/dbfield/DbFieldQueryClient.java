package oa.codegen.client.dbfield;

import oa.codegen.sql.MysqlConnTool;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by handong on 16/1/18.
 */
public class DbFieldQueryClient {
    public DbFieldQueryClient() {

    }

    public static List<TableField> getDbFields(String tableName,Connection connection) {
        PreparedStatement preparedStatement;
        List<TableField> tableFields = new ArrayList();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM "+tableName +" WHERE 1=1 limit 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData data = resultSet.getMetaData();
            for(int i = 1  ; i <= data.getColumnCount() ; i++) {
                // 获得所有列的数目及实际列数
                int columnCount = data.getColumnCount();
                // 获得指定列的列名
                String columnName = data.getColumnName(i);
                // 获得指定列的列值
                int columnType = data.getColumnType(i);
                // 获得指定列的数据类型名
                String columnTypeName = data.getColumnTypeName(i);
                // 所在的Catalog名字
                String catalogName = data.getCatalogName(i);
                // 对应数据类型的类
                String columnClassName = data.getColumnClassName(i);
                // 在数据库中类型的最大字符个数
                int columnDisplaySize = data.getColumnDisplaySize(i);
                // 默认的列的标题
                String columnLabel = data.getColumnLabel(i);
                // 获得列的模式
                String schemaName = data.getSchemaName(i);
                // 某列类型的精确度(类型的长度)
                int precision = data.getPrecision(i);
                // 小数点后的位数
                int scale = data.getScale(i);
                // 获取某列对应的表名
                String tableName1 = data.getTableName(i);
                // 是否自动递增
                boolean isAutoInctement = data.isAutoIncrement(i);
                // 在数据库中是否为货币型
                boolean isCurrency = data.isCurrency(i);
                // 是否为空
                int isNullable = data.isNullable(i);
                // 是否为只读
                boolean isReadOnly = data.isReadOnly(i);
                // 能否出现在where中
                boolean isSearchable = data.isSearchable(i);
                String remarks = getRemarks(tableName,columnName,connection.getMetaData());
                tableFields.add(new TableField(columnName,columnType,columnTypeName,catalogName,columnClassName,columnDisplaySize,columnLabel,schemaName,
                        precision,scale,tableName1,isAutoInctement,isCurrency,isNullable,isReadOnly,isSearchable,remarks));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MysqlConnTool.colseConnection(connection);
        }
        return tableFields;
    }

    private static String getRemarks(String tableName, String columnName, DatabaseMetaData metaData) throws SQLException {
        ResultSet resultSet = metaData.getTables(null, "%", tableName, new String[]{"TABLE"});
        resultSet.next();
        ResultSet rs = metaData.getColumns(null, "%", tableName, columnName);
        rs.next();
        return  rs.getString("REMARKS") ;
    }


    @Test
    public void test() {
        Connection connection = MysqlConnTool.getConnection("soeasyoadb", "3306", "soeasy_oa", "soeasy", "soeasy");
        try {
            DatabaseMetaData dbmd = connection.getMetaData();
            ResultSet resultSet = dbmd.getTables(null, "%", "BASIC_BUSINESS", new String[]{"TABLE"});
            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                System.out.println(tableName);
                if (tableName.equals("BASIC_BUSINESS")) {
                    //ResultSet rs =getConnection.getMetaData().getColumns(null, getXMLConfig.getSchema(),tableName.toUpperCase(), "%");//其他数据库不需要这个方法的，直接传null，这个是oracle和db2这么用
                    ResultSet rs = dbmd.getColumns(null, "%", tableName, "%");
                    System.out.println("表名：" + tableName + "\t\n表字段信息：");
                    while (rs.next()) {
                        System.out.println("字段名：" + rs.getString("COLUMN_NAME") + "\t字段注释：" + rs.getString("REMARKS") + "\t字段数据类型：" + rs.getString("TYPE_NAME"));
                    }
                    System.out.println("生成成功！");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
