package cn.tms.controller;

import cn.tms.entity.*;
import cn.tms.service.*;
import cn.tms.util.PageUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

import static com.mysql.jdbc.StringUtils.getBytes;

/**
 * Created by Happy on 2017-08-21.
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    //植入用户的service
    @Resource(name ="useService" )
    IUserInfoService userInfoService;

    //植入字典的Service
    @Resource(name = "dicService")
    IDicInfoService dicInfoService;

    //植入权限的Service
    @Resource(name = "privilegeService")
    IPrivilegeService privilegeService;
//植入 栏目管理
    @Resource(name="cm_columnservice")
    private ICm_columnService service;

    //新闻的列表
    @Resource(name="newService")
    private INewsService newservice;


    //



    //登录方法
    @RequestMapping("/doLogin")
    @ResponseBody
    public Object doLogin(HttpSession session,UserInfo info){
        UserInfo user = userInfoService.isLogin(info);
        if (user!=null&&user.getUsername()!=null){
            //登录成功,将用户名放入Session
            session.setAttribute("userinfo",user);
            return "y";
        }else {
            //登录失败
            return "login";
        }
    }
    //转向系统主界面
    @RequestMapping("/doMain")
    public String doMain(HttpSession session,Model model){
        //新的容器 保存有父子关系的权限
        List<Privilege> rootMenus=new ArrayList<Privilege>();
        UserInfo user= (UserInfo)session.getAttribute("userinfo");
        //保存的是平级的权限集合  使用内存级别的手段，构造成有关系的权限集合
        List<Privilege> privilegeList = privilegeService.getAllPrivilegesByEmpId(user.getUserid().toString());
        for (Privilege item:privilegeList){
            Privilege childMenu=item;
            int pid = childMenu.getParent();
            if (pid==0){
                rootMenus.add(item);
            }else{
                for (Privilege innerMenu:privilegeList){
                    Integer id = innerMenu.getId();
                    if (id==pid){
                        Privilege parentMenu=innerMenu;
                        parentMenu.getChildren().add(childMenu);
                        break;
                    }
                }
            }
        }
        //request.setAttribute(“”)等价  。有层级关系的集合
        model.addAttribute("privilegeList",rootMenus);
        return "main";
    }
    //转向机房和教员设定界面
    @RequestMapping("/labWeekSet")
   public String labWeekSet(){
        return "/page/userManage";
   }

    @ResponseBody
    //获取单页用户数据
    @RequestMapping("/UserInfoList")
    public Object selectUser(@RequestParam(defaultValue = "1",value = "page") int pageIndex, @RequestParam(defaultValue = "2",value = "rows") int pageSize, UserInfo info){
        //key:total
        //key:rows:
        Map<String,Object> map=new HashMap<String,Object>();
        PageUtil pp=null;
        if (info==null||info.getUsername()==null){
            pp=userInfoService.UserInfoList(pageIndex-1,pageSize);

        }else{
            pp= userInfoService.UserInfoList(pageIndex-1,pageSize,info);
        }
        Integer total = pp.getTotalRecords();
        map.put("total",total);
        map.put("rows",pp.getList());
        return map;
    }

    //遍历所有 的 角色
    @ResponseBody
    @RequestMapping("/checkUserRoleIsExist")
    public Object checkUserRoleIsExist(Integer userid,Integer roleid){
        Integer integer = this.userInfoService.checkUserRoleIsExist(userid, roleid);
        if(integer>0){
            return "f";
        }else{
            return "y";
        }
    }



    //根据用户id获取用户对象本身
    @RequestMapping("/douserInfoByUserId")
    @ResponseBody
    public Object doUserInfo(Integer userid){

        UserInfo userInfoById = this.userInfoService.getUserInfoById(userid);
        List<Role> roleByUserId = this.userInfoService.getRoleByUserId(userid);
        StringBuilder sb = new StringBuilder("");
        for (Role item:
                roleByUserId) {
            sb.append(item.getRolename());
            sb.append(",");
        }
        userInfoById.setRolename(sb.toString());
        return userInfoById;
    }


    //所有权限 的 查询 遍历
    @ResponseBody
    @RequestMapping("/getAllMenusJson")
    public Object allPrivilege(HttpSession session){

        //查询所有的权限
        List<Privilege> rootMenus = new ArrayList<Privilege>();
        UserInfo user=(UserInfo)session.getAttribute("userinfo");
        List<Privilege> privilegeList=privilegeService.PrivilegeListAll();
        for(Privilege item:privilegeList){
            Privilege childMenu=item;
            int pid=childMenu.getParent();
            if(pid==0){
                rootMenus.add(item);
            }else{
                for (Privilege innerMenu:privilegeList) {
                    Integer id=innerMenu.getId();
                    if(id==pid){
                        Privilege parentMenu=innerMenu;
                        parentMenu.getChildren().add(childMenu);
                        break;
                    }
                }
            }

        }
        return  rootMenus;
    }


    //===================================================================最终
    @ResponseBody
    @RequestMapping("/getPrivilegeJson")
    public Object getPrivilegeJson(String rid){
        //保存的是平级的权限集合  使用内存级别的手段，构造成有关系的权限集合
        List<Privilege> privilegeList = privilegeService.getAllPrivilegesByRoldId(rid);
        return privilegeList;
    }
    //保存权限
    @RequestMapping("/savePrivilege")
    @ResponseBody
    public void savePrivilege(String rid,String s){

        System.out.println("=================");
        privilegeService.delPrivilegeByRoldId(rid);
        String[] ids=s.split(",");
        for(String item:ids){
            int pid=Integer.parseInt(item);
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("rid",Integer.parseInt(rid));
            map.put("pid",pid);
            privilegeService.addDataToRolePrivilege(map);

        }
    }

//============================栏目管理
//所有权限 的 查询 遍历
@ResponseBody
@RequestMapping("/cmList")
public Object CMList(HttpSession session,Model model){
    List<cm_column> rootMenus=new ArrayList<cm_column>();
    //保存的是平级的权限集合  使用内存级别的手段，构造成有关系的权限集合
    List<cm_column> privilegeList = service.CMListAll();
    for (cm_column item:privilegeList){
        cm_column childMenu=item;
        String pid = childMenu.getParentcode();
        if ("0".equals(pid)){
            rootMenus.add(item);
        }else{
            for (cm_column innerMenu:privilegeList){
                String id = innerMenu.getSyscode();
                if (id.equals(pid)){
                    cm_column parentMenu=innerMenu;
                    parentMenu.getChildren().add(childMenu);
                    break;
                }
            }
        }
    }
    return rootMenus;

}



//内容显示
/*@ResponseBody
@RequestMapping("/ListNewList")
public Object NewsList(String columnname, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
    String str=new String(columnname.getBytes("ISO-8859-1"),"UTF-8");
    List<News> ListNewss = newservice.ListNews(str);
    return ListNewss;

}*/



    @ResponseBody
    //获取单页用户数据
    @RequestMapping("/LimitLsitNew")
    public Object LimitNEwsList(@RequestParam(defaultValue = "1",value = "page") int pageIndex, @RequestParam(defaultValue = "2",value = "rows") int pageSize,String ccode, News news){
        //key:total
        //key:rows:
        System.out.println(ccode);
        Map<String,Object> map=new HashMap<String,Object>();
        PageUtil pp=newservice.ListNewsLimit(ccode,pageIndex-1,pageSize);
        System.out.println(pp.getPageSize());
        Integer total = pp.getTotalRecords();
        map.put("total",total);
        map.put("rows",pp.getList());
        return map;
    }



    @ResponseBody
    @RequestMapping("/ListNewList")
    public Object NewsList(String ccode, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        List<News> ListNewss = newservice.ListNews(ccode);
        return ListNewss;

    }
//带条件查询

    @ResponseBody
    @RequestMapping("/ListNewListLike")
    public Object ListNewListLike(String ntitle,Integer start,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        List<News> ListNewss = newservice.ListNewsLike(ntitle,start);
        for(News item:ListNewss){
            System.out.println(item.getNtitle()+"====标题：Like");
        }
        return ListNewss;

    }

    @ResponseBody
    @RequestMapping("/delNews")
    public Object delNews(Integer nid){
        System.out.println("-==========");
        int i = newservice.delNews(nid);
        System.out.println(i);
        if(i>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        return "redirect:/user/ListNewList";
    }


    //根据 id查询所有
    @RequestMapping("ByNewsIdd")
    public String  ByNewsId(Integer nid,HttpServletRequest request){
        System.out.println("=====");
        News news = newservice.ByNewsId(nid);
        System.out.println(news.getNtitle()+"===");
        request.setAttribute("news",news);
        return "main2cm";
    }

    //添加
    @RequestMapping("addNews")
    public String  addNews(News news,HttpSession session,@RequestParam(value = "attachs", required = false) MultipartFile[] attachs,HttpServletRequest request) throws IOException {
        //判断文件是否为空
        String idPicPath = null;
        String twoPicPath = null;
        String errorInfoString=null;
        boolean flag=true;

        String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "upload");

        for (int i=0;i<attachs.length;i++) {

            MultipartFile attach = attachs[i];
            System.out.println(attach);
            if (!attach.isEmpty()) {
                if (i == 0) {
                    errorInfoString = "uploadFileError";
                } else if (i == 1) {
                    errorInfoString = "uploadWpError";
                }
                //定义上传目标路径
                String oldFileName = attach.getOriginalFilename();
                String prefix = FilenameUtils.getExtension(oldFileName);
                int filesize = 500000;
                if (attach.getSize() > filesize) {
                    request.setAttribute(errorInfoString, "上传的太大了");
                } else if (prefix.equalsIgnoreCase("jpg") ||
                        prefix.equalsIgnoreCase("jpeg") ||
                        prefix.equalsIgnoreCase("png") ||
                        prefix.equalsIgnoreCase("pneg")) {
                    String fileName = System.currentTimeMillis() + RandomUtils.nextInt(100000)
                            + "_Personal.jpg";
                    File targetFile = new File(path, fileName);
                    if (!targetFile.exists()) {
                        if (i == 0) {
                            idPicPath = path + File.separator + fileName;
                        } else if (i == 1) {
                            twoPicPath = path + File.separator + fileName;
                        }

                        attach.transferTo(targetFile);
                    }
                } else {
                    request.setAttribute(errorInfoString, "上传的格式不对");
                }
            }
        }

        if(flag){
            System.out.println(news.getNtitle()+"======");
            news.setCreateId(1);
            news.setUpdateTime(new Date());
            news.setOnePicPath(idPicPath);
            news.setTwoPicPath(twoPicPath);
            int r = newservice.addNews(news);
            if (r > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }

        }
        return "main2cm";
    }

    //修改

    @RequestMapping("updateNews")
    public String  updateNews(News news,HttpServletRequest request) {
        return "main2cm";
    }


}


