package test.wn.modules;

import com.weinong.base.*;
import test.wn.bean.Demo;
import test.wn.requestbean.DeleteForm;
import test.wn.service.DemoService;

import java.util.Map;

/**
 * Created by Administrator on 2016/3/2.
 */
@ApiDefined(label = "deleteAction",description = "demo信息")
public class deleteAction extends BaseApiAction {
    @ParamDefined(label = "请求参数",checkType = CheckType.empty)
    private DeleteForm delete;


    @Override
    protected void registResult(Map<Integer, String> map) {
        map.put(1,"删除成功");
        map.put(-2,"删除失败");
    }

    @Override
    public ApiResult doApi() throws Exception {

            //查询
            Demo demo = DemoService.getDemoById(delete.getId());
            //删除
            int del=DemoService.delDemo(demo);
            if(del>0){
                System.out.println("删除成功");
                return result_success(1);
            }else{
                System.out.print("删除失败");
                return result_fail(-2);
            }
    }

    public DeleteForm getDelete() {
        return delete;
    }

    public void setDelete(DeleteForm delete) {
        this.delete = delete;
    }
}
