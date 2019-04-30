package cn.itcast.dao.impl;

import cn.itcast.dao.ProvincesDao;
import cn.itcast.domain.Province;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProvincesDaoImpl implements ProvincesDao {
    public List<Province> findAll() throws Exception {
        List<Province> list = new ArrayList<Province>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///db3","root","root");
            pst = connection.prepareCall("select * from province");
            rs = pst.executeQuery();
            while(rs.next()){
                Province province = new Province();
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("name"));
                list.add(province);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
            pst.close();
            rs.close();
        }
        return list;
    }
}
