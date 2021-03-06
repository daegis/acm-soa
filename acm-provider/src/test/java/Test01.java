import cn.aegisa.acm.dao.service.ICommonService;
import cn.aegisa.acm.model.ActiveInfo;
import cn.aegisa.acm.model.Activities;
import cn.aegisa.acm.model.CustomerInfo;
import cn.aegisa.acm.model.Customers;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

/**
 * Using IntelliJ IDEA.
 *
 * @author HNAyd.xian
 * @date 2018/1/24 19:24
 */
@Slf4j
public class Test01 extends BaseJunit4Test {

    @Autowired
    private ICommonService commonService;

    @Test
    public void test01() {
        List<Activities> list = commonService.getList(Activities.class);
        for (Activities a : list) {
            ActiveInfo info = new ActiveInfo();
            info.setActiveDayCount(Integer.valueOf(a.getDayCount()));
            info.setActiveName(a.getActivityName());
            info.setActivePrice(BigDecimal.valueOf(a.getActivityPrice()));
            info.setActiveStartDatetime(a.getActivityDate());
            commonService.save(info);
        }
        System.out.println(list);
    }

    @Test
    public void test02() {
        List<Customers> list = commonService.getList(Customers.class);
        for (Customers c : list) {
            CustomerInfo i = new CustomerInfo();
            i.setCustomerAddress(c.getAddress());
            i.setCustomerComment(c.getCnote());
            i.setCustomerId(c.getIdNumber());
            i.setCustomerName(c.getName());
            i.setCustomerNickname(c.getNickname());
            i.setCustomerPhone(c.getMobile());
            log.info("保存信息:{}", JSON.toJSONString(i));
            commonService.save(i);
        }
    }
}
