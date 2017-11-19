package cn.happy.controller;

import cn.happy.bean.Subjects;
import cn.happy.service.ISubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 张晓宇 on 2017/10/13.
 */
@Controller
public class SubjectController {
    @Resource
    private ISubjectService subjectService;

 //显式列表
    @RequestMapping("/getAllsubjects")
    public String getAll(HttpServletRequest request){
        request.setAttribute("list",subjectService.getAllSubject());
        return "subjects";
    }
//查看视图

  /*  @RequestMapping(value = "/getViewsubjects/{id}",method = RequestMethod.GET)
    public String getView(@PathVariable int id, Model model){
        Subjects subject= subjectService.getView(id);
        model.addAttribute(subject);
        return "subjectView";
     }*/

    @RequestMapping(value = "/getViewsubjects",method = RequestMethod.GET)
    public String getView(HttpServletRequest request,int id){
        subjectService.updateCount();
        Subjects subjects = subjectService.getView(id);
        System.out.println(subjects.getOptions().size());
        request.setAttribute("subject",subjects);
        return "subjectView";
    }

    @RequestMapping("/updateOption")
    public String updateOption(HttpServletRequest request,Integer id,Integer subId){
        subjectService.updateOption(id, subId);
        return "redirect:/getAllsubjects";
    }

}
