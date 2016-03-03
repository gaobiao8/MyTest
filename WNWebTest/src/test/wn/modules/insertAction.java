package test.wn.modules;

import com.weinong.base.*;
import test.wn.bean.Demo;
import test.wn.requestbean.TestForm;
import test.wn.service.DemoService;

import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/2.
 */
@ApiDefined(label = "insertAction",description = "demo信息")
public class insertAction extends BaseApiAction {
    @ParamDefined(label = "请求参数",checkType = CheckType.empty)
    private TestForm insert;


    @Override
    protected void registResult(Map<Integer, String> map) {
        map.put(1,"添加成功");
        map.put(-2,"添加失败");
    }

    @Override
    public ApiResult doApi() throws Exception {

            //添加
            Demo d = new Demo();
            d.setId(insert.getId());
            d.setBase_number(insert.getBase_number());
            d.setBank_id(insert.getBank_id());
            d.setNick_name(insert.getNick_name());
            d.setNum(insert.getNum());
            d.setSubsection_id(insert.getSubsection_id());
            d.setCreate_time(new Date());
            d.setPriority(insert.getPriority());
            d.setPriority_id(insert.getPriority_id());
            if (DemoService.saveDemo(d) > 0) {
                System.out.println("添加成功");
                return result_success(1);
            } else {
                System.out.println("添加失败");
                return result_fail(-2);
            }
        }



    public TestForm getInsert() {
        return insert;
    }

    public void setInsert(TestForm insert) {
        this.insert = insert;
    }
}
