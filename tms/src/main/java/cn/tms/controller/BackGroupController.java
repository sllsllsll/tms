package cn.tms.controller;

import cn.tms.entity.News;
import cn.tms.entity.cm_column;
import cn.tms.service.ICm_columnService;
import cn.tms.service.INewsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by linlin on 2017/11/17.
 */
@Controller
public class BackGroupController {

    //植入 栏目管理
    @Resource(name="cm_columnservice")
    private ICm_columnService service;

    //新闻的列表
    @Resource(name="newService")
    private INewsService newservice;


    @RequestMapping("/ListNewOne")
    public String NewsList(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        List<cm_column> ListNewss = service.CMListAll1();
        request.setAttribute("list",ListNewss);
        return "/investInfo";

    }
    @RequestMapping("/ListNewPid")
    public String NewsListPid(String parentcode, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        List<cm_column> ListNewsse = service.SelectPid(parentcode);
        for (cm_column item:ListNewsse) {
            System.out.println(item.getColumnname()+"=====");
        }
        request.setAttribute("listpid",ListNewsse);
        return "/investInfo";

    }
}
