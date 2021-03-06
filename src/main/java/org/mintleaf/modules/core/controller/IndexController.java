package org.mintleaf.modules.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.mintleaf.modules.core.domain.CoreMenu;
import org.mintleaf.modules.core.domain.CoreUser;
import org.mintleaf.modules.core.service.CoreMenuService;
import org.mintleaf.modules.core.service.CoreUserService;
import org.mintleaf.utils.CaptchaUtils;
import org.mintleaf.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.mintleaf.vo.ResultMsg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static org.mintleaf.vo.ResultMsg.fail;
import static org.mintleaf.vo.ResultMsg.ok;

/**
 * 后台管理主控制器
 */
@Api(tags="后台管理主控制器",description="描述")
@Controller
public class IndexController {

    @Autowired
    HttpSession session;

    @Autowired
    CoreUserService coreUserServioe;

    @Autowired
    CoreMenuService coreMenuService;

    /**
     * 进入后台首页
     * @return
     */
//  @RequiresRoles("超级用户")
    @ApiOperation(value="进入后台首页", notes="描述")
    @RequestMapping(value="index.html",method = {RequestMethod.GET})
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index.html");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        System.out.print(username);
        CoreUser coreUser=coreUserServioe.findCoreUserByName(username);
        view.addObject("user", coreUser);
        return view;
    }

    /**
     * 进入登陆页面
     * @return
     */
    @ApiOperation(value="进入登陆页面", notes="描述")
    @RequestMapping(value="login.html",method = {RequestMethod.GET})
    public ModelAndView login(){
        ModelAndView view =new ModelAndView("login.html");
        return view;
    }

    /**
     * 进入403未授权页面
     * @return
     */
    @ApiOperation(value="进入403未授权页面", notes="描述")
    @RequestMapping(value="403.html",method = {RequestMethod.GET})
    public ModelAndView error403() {
        ModelAndView view =new ModelAndView("403.html");
        return view;
    }

    /**
     * 进入404未定义页面
     * @return
     */
    @ApiOperation(value="进入404未定义页面", notes="描述")
    @RequestMapping(value="404.html",method = {RequestMethod.GET})
    public ModelAndView error404() {
        ModelAndView view =new ModelAndView("404.html");
        return view;
    }

    /**
     * 进入后台首页面
     * @return
     */
    @ApiOperation(value="进入后台首页面", notes="描述")
    @RequestMapping(value="home.html",method = {RequestMethod.GET})
    public ModelAndView home(){
        ModelAndView view =new ModelAndView("home.html");
        return view;
    }

    /**
     * 树形数据表格
     * @return
     */
    @ApiOperation(value="树形数据表格", notes="描述")
    @RequestMapping(value="treegrid.html",method = {RequestMethod.GET})
    public ModelAndView treegrid(){
        ModelAndView view =new ModelAndView("treegrid.html");
        return view;
    }

    /**
     * 树形下拉选择器
     * @return
     */
    @ApiOperation(value="树形下拉选择器", notes="描述")
    @RequestMapping(value="treeselect.html",method = {RequestMethod.GET})
    public ModelAndView treeselect(){
        ModelAndView view =new ModelAndView("treeselect.html");
        return view;
    }


    /**
     * 登陆操作
     * @param request
     * @return
     */
    @ApiOperation(value="登陆操作", notes="描述")
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg loginDo(HttpServletRequest request){
        //验证码校验
        if (!CaptchaUtils.checkVerifyCode(request)) {
           return fail("验证码有误！");
        }
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        //用户名密码校验
        UsernamePasswordToken token = new UsernamePasswordToken(name, MD5Util.MD5(password));
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (Exception e) {
            e.printStackTrace();
            return fail("用户名或密码错误！");
        }
        return ok();
    }

    /**
     * 登出操作
     * @return
     */
    @ApiOperation(value="登出操作", notes="描述")
    @RequestMapping(value = "loginOut.do", method ={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView loginOut() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/login.html");
        SecurityUtils.getSubject().logout();
        return view;
    }

    /**
     * 获取用户菜单数据
     * @return
     */
    @ApiOperation(value="获取用户菜单数据", notes="描述")
    @RequestMapping(value="getMenus.json", method ={RequestMethod.POST})
    @ResponseBody
    public ResultMsg getMenus(){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        List<CoreMenu> coreMenus =coreMenuService.findMenuByNameSample(username);
        ResultMsg result=new ResultMsg();
        result.setData(coreMenus);
        return  result;
    }

}
