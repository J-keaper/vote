package com.keaper.vote.persistence.handler;

import com.keaper.vote.common.model.ValidateRule;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidateRuleHandler implements TypeHandler<ValidateRule>{


    public void setParameter(PreparedStatement ps, int i, ValidateRule parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getCode());
    }

    public ValidateRule getResult(ResultSet rs, String columnName) throws SQLException {
        return ValidateRule.fromCode(rs.getInt(columnName));
    }

    public ValidateRule getResult(ResultSet rs, int columnIndex) throws SQLException {
        return ValidateRule.fromCode(rs.getInt(columnIndex));
    }

    public ValidateRule getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return ValidateRule.fromCode(cs.getInt(columnIndex));
    }
}
