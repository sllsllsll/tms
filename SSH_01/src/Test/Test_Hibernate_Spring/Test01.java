package Test_Hibernate_Spring;

import cn.happy.beans.Stock;
import cn.happy.service.IStockService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by linlin on 2017/10/10.
 */
public class Test01 {
    //spring-hibernate整合的第一个 测试
    @Test
    public void test01(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        IStockService service=(IStockService)ctx.getBean("stockservice");
        Stock s=new Stock("susu",40);
        System.out.println(s);
        service.addStock(s);
        System.out.println("ok");
    }
}
