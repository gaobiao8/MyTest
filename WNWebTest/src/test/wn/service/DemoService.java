package test.wn.service;

import test.wn.BaseService;
import test.wn.bean.Demo;
import test.wn.core.TestDB;
import yao.util.db.where.Expression;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/3/2.
 */
public class DemoService  extends BaseService {



    public static List<Demo> getAll() throws SQLException {

        return getSelect().select(Demo.class);
    }

    public  static int  saveDemo(Demo demo) throws SQLException {
        return TestDB.TestDB().getUpdate().insert(demo);
    }

    public static int delDemo(Demo demo) throws SQLException {
         return  TestDB.TestDB().getUpdate().deleteSingle(demo);
    }

    public static int updateDemo(Demo demo) throws SQLException {
        return TestDB.TestDB().getUpdate().updateSingle(demo);
    }


    public static Demo getDemoById(Integer id) throws SQLException {
        Expression where = new Expression("id").eq(id);
        return getSelect().selectSingle(Demo.class,where);
    }
}
