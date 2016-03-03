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
@ApiDefined(label = "updateAction",description = "demo信息")
public class updateAction extends BaseApiAction {
    @ParamDefined(label = "请求参数",checkType = CheckType.empty)
    private TestForm update;


    @Override
    protected void registResult(Map<Integer, String> map) {
        map.put(1,"修改成功");
        map.put(-2,"修改失败");
    }

    @Override
    public ApiResult doApi() throws Exception {

            //查询
            Demo demo = DemoService.getDemoById(update.getId());
            //修改
            demo.setId(update.getId());
            demo.setBase_number(update.getBase_number());
            demo.setBank_id(update.getBank_id());
            demo.setNick_name(update.getNick_name());
            demo.setNum(update.getNum());
            demo.setSubsection_id(update.getSubsection_id());
            demo.setCreate_time(new Date());
            demo.setPriority(update.getPriority());
            demo.setPriority_id(update.getPriority_id());
            int i=DemoService.updateDemo(demo);
            if(i>0){
                System.out.println("修改成功");
                return result_success(1);
            }else{
                System.out.print("修改失败");
                return result_fail(-2);
            }

    }

    public TestForm getUpdate() {
        return update;
    }

    public void setUpdate(TestForm update) {
        this.update = update;
    }
}
