package cn.itcast.test;

import cn.itcast.dao.ProvincesDao;
import cn.itcast.dao.impl.ProvincesDaoImpl;
import cn.itcast.domain.Province;
import org.junit.Test;

import java.util.List;

public class ProvinceTest {
    @Test
    public void findAll() throws Exception {
        ProvincesDao dao = new ProvincesDaoImpl();
        List<Province> list = dao.findAll();
        for(Province p:list){
            System.out.println(p.getName());
        }
    }
}
