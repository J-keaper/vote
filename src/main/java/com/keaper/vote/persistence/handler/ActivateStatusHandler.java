package com.keaper.vote.persistence.handler;

import com.keaper.vote.common.constants.ActivateStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivateStatusHandler implements TypeHandler<ActivateStatus> {

    public void setParameter(PreparedStatement ps, int i, ActivateStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getCode());
    }

    public ActivateStatus getResult(ResultSet rs, String columnName) throws SQLException {
        return ActivateStatus.fromCode(rs.getInt(columnName));
    }

    public ActivateStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
        return ActivateStatus.fromCode(rs.getInt(columnIndex));
    }

    public ActivateStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return ActivateStatus.fromCode(cs.getInt(columnIndex));
    }
}
