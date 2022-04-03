package com.example.demojenkins.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(List.class)
public class TypeHandler<T> extends BaseTypeHandler<List<T>> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<T> list, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, JSON.toJSONString(list));
    }

    @Override
    public List<T> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        JSONArray jsonArray = JSONArray.parseArray( resultSet.getString(s));
        return (List<T>)jsonArray;
    }

    @Override
    public List getNullableResult(ResultSet resultSet, int i) throws SQLException {
        JSONArray jsonArray = JSONArray.parseArray( resultSet.getString(i));
        return jsonArray;
    }

    @Override
    public List getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        JSONArray jsonArray = JSONArray.parseArray( callableStatement.getString(i));
        return jsonArray;
    }
}
