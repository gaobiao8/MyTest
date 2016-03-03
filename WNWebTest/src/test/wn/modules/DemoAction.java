package test.wn.modules;

import com.weinong.base.*;
import test.wn.bean.Demo;
import test.wn.requestbean.TestForm;
import test.wn.service.DemoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/2.
 */
@ApiDefined(label = "demoAction",description = "demo信息")
public class DemoAction extends BaseApiAction {
    @ParamDefined(label = "请求参数",checkType = CheckType.empty)
    private TestForm param;


    @Override
    protected void registResult(Map<Integer, String> map) {
        map.put(1,"查询成功");
        map.put(-2,"失败");
    }

    @Override
    public ApiResult doApi() throws Exception {
        try {

            Demo demo = DemoService.getDemoById(param.getId());

            List<Demo> list = DemoService.getAll();

            Map<String, Object> rs = new HashMap<String, Object>();
            rs.put("allTest", list);
            rs.put("test", demo);
            return result_success(1, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result_fail(-2);
    }

    public TestForm getParam() {
        return param;
    }

    public void setParam(TestForm param) {
        this.param = param;
    }
}
