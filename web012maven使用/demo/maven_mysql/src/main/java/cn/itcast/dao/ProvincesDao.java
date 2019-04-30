package cn.itcast.dao;

import cn.itcast.domain.Province;

import java.sql.SQLException;
import java.util.List;

public interface ProvincesDao {
    public List<Province> findAll() throws SQLException, Exception;
}
