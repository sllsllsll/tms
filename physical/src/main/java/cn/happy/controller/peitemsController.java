package cn.happy.controller;

import cn.happy.beans.itemtypes;
import cn.happy.beans.peitems;
import cn.happy.service.IitemtypesService;
import cn.happy.service.IpeitemsService;
import org.hibernate.type.IdentifierBagType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by linlin on 2017/10/18.
 */
@Controller
public class peitemsController {
    @Resource(name = "IpeitemsService")
    private IpeitemsService service;
    ///////id
 /*   @RequestMapping("/Peitemslist")
    public String selectLists(HttpServletRequest request) {

       String id = request.getParameter("typeid");
        System.out.println(id);

       Integer ids=Integer.parseInt(id);
      System.out.println(ids);

        List<peitems> peitemss = service.peiList(ids);
        request.setAttribute("list2", peitemss);
        for (peitems item:peitemss) {
            System.out.println(item.getNecessary()+"=========================");
        }

        List<peitems> selectitem = service.selectName();
        request.setAttribute("list13",selectitem);

        return "List1";
    }

*/
    @RequestMapping("/Peitem")
    public String selectList(HttpServletRequest request) {
        String id = request.getParameter("itemnamess");
        List<peitems> peitemss = service.peiList(id);
        request.setAttribute("list2", peitemss);
        List<peitems> selectitem = service.selectName();
        request.setAttribute("list13",selectitem);
        return "List1";
    }

    @RequestMapping("/itemNamess")
    public String selectListef(HttpServletRequest request){
        List<peitems> selectitem = service.selectName();
        request.setAttribute("list13",selectitem);
        return "List1";
    }



    @RequestMapping("/listfindBy")
    public String listfinds(Integer itemid,HttpServletRequest request) {
        peitems one =service.findOne(itemid);
        request.setAttribute("listone",one);
        return "/update";
    }

    //根据id进行修改
    @RequestMapping("/updates")
    public String updateDept(String itemname, Integer typeid, Integer necessary, String ref, Integer price, String info, Integer itemid,HttpServletRequest request) {
        System.out.println("==================================");
        System.out.println(itemname);
    /*    String nameis=request.getParameter("necessary");
        int i1=0;
        if(nameis.equals("是")){
            i1=1;
        }else{
            i1=0;
        }*/
        service.updateDept(itemname,typeid,necessary,ref,price,info,itemid);
        return "redirect:/Peitem";

    }

    public IpeitemsService getService() {
        return service;
    }

    public void setService(IpeitemsService service) {
        this.service = service;
    }
}
