package org.mintleaf.modules.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.mintleaf.modules.core.domain.CoreUser;
import org.mintleaf.modules.core.domain.CoreUserRole;
import org.mintleaf.modules.core.service.CoreUserRoleService;
import org.mintleaf.modules.core.service.CoreUserService;
import org.mintleaf.modules.core.vo.CoreUserVO;
import org.mintleaf.utils.MD5Util;
import org.mintleaf.vo.ResultMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mintleaf.vo.ResultMsg.fail;

/**
 * 用户相关控制器
 */
@Api(tags="用户相关控制器",description="描述")
@Controller
@RequestMapping("coreUser")
public class CoreUserController {

    private final CoreUserService coreUserService;

    private final CoreUserRoleService coreUserRoleService;

    public CoreUserController(CoreUserService coreUserService, CoreUserRoleService coreUserRoleService) {
        this.coreUserService = coreUserService;
        this.coreUserRoleService = coreUserRoleService;
    }

    /**
     * 进入列表页面
     * @return
     */
    @ApiOperation(value="进入列表页面", notes="描述")
    @RequestMapping(value="index.html",method = {RequestMethod.GET})
    public ModelAndView index(){
        ModelAndView view =new ModelAndView("modules/core/coreuser/index.html");
        return view;
    }

    /**
     * 进入编辑页面
     * @return
     */
//    @RequiresRoles("超级用户")
    //@RequiresPermissions("auth:user:edit")
    @ApiOperation(value="进入编辑页面", notes="描述")
    @RequestMapping(value="edit.html",method = {RequestMethod.GET})
    public ModelAndView edit(){
        ModelAndView view =new ModelAndView("modules/core/coreuser/edit.html");
        return view;
    }

    /**
     * 进入新增页面
     * @return
     */
    @ApiOperation(value="进入新增页面", notes="描述")
    @RequestMapping(value="add.html",method = {RequestMethod.GET})
    public ModelAndView add(){
        ModelAndView view =new ModelAndView("modules/core/coreuser/add.html");
        return view;
    }

    /**
     * 进入密码修改页面
     * @return
     */
    @ApiOperation(value="进入密码修改页面", notes="描述")
    @RequestMapping(value="updatePwd.html",method = {RequestMethod.GET})
    public ModelAndView updatePwd() {
        ModelAndView view =new ModelAndView("modules/core/coreuser/updatePwd.html");
        return view;
    }

    /**
     * 添加操作
     * @param coreUser
     * @return
     */
    @ApiOperation(value="添加操作", notes="描述")
    @RequestMapping(value = "add.do",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg add(CoreUser coreUser) {
        //向用户表插入新添加用户信息
        coreUser.setPsw(MD5Util.MD5("123456"));
//        String uuid=UUIDUtils.getUUID();
//        coreUser.setId(Integer.parseInt(uuid));
        //coreUserDao.insertTemplate(coreUser);
        coreUserService.save(coreUser);
        //根据添加的用户名查出单条数据
        //CoreUser newUser=coreUserDao.sample(coreUser.getName());
        CoreUser newUser=coreUserService.findCoreUserByName(coreUser.getName());
        //向用户角色关系表插入新添加用户建立的角色
        String[] roles = coreUser.getRole().split(",");
        for (String role : roles) {
            CoreUserRole ur = new CoreUserRole();
            ur.setUserid(newUser.getId());
            ur.setRoleid( Integer.valueOf(role));
            coreUserRoleService.save(ur);
        }
        return ResultMsg.ok(coreUser);
    }

    /**
     * 删除操作
     * @param coreUser
     * @return
     */
    @ApiOperation(value="删除操作", notes="描述")
    @RequestMapping(value = "delete.do",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg delete(CoreUser coreUser) {
        //根据id删除用户表单条数据
        coreUserService.deleteById(coreUser.getId());
        //根据id删除用户角色关系表所有与id关联的数据
        CoreUserRole ur = new CoreUserRole();
        ur.setUserid(coreUser.getId());
        coreUserRoleService.deleteByUserId(ur.getUserid());
        return ResultMsg.ok();
    }

    /**
     * 批量删除操作
     * @param id
     * @return
     */
    @ApiOperation(value="批量删除操作", notes="描述")
    @RequestMapping(value = "deleteBatch.do",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg deleteBatch(String id) {
        String[] ids = id.split(",");
        List<Integer> idsList = new ArrayList<>();
        for(String str : ids){
            idsList.add(new Integer(str));
        }
        //根据多个用户id删除用户表信息
        coreUserService.deleteBatch(idsList);
        //根据多个用户id删除用户角色关系表信息
        coreUserRoleService.deleteBatch(idsList);
        return ResultMsg.ok();
    }

    /**
     * 编辑操作
     * @param coreUser
     * @return
     */
    @ApiOperation(value="编辑操作", notes="描述")
    @RequestMapping(value = "edit.do",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg update(CoreUser coreUser) {
        //更新用户表信息
        coreUserService.updateCoreUser(coreUser);
        //根据新的用户名查出单条数据
        CoreUser editUser=coreUserService.findCoreUserByName(coreUser.getName());
        //根据id删除用户角色关系表所有与id关联的数据
        CoreUserRole ur = new CoreUserRole();
        ur.setUserid(editUser.getId());
        coreUserRoleService.deleteByUserId(ur.getUserid());
        //向用户角色关系表插入用户新修改的角色
        String[] roles = coreUser.getRole().split(",");
        for (String role : roles) {
            ur.setUserid(editUser.getId());
            ur.setRoleid( Integer.valueOf(role));
            coreUserRoleService.save(ur);
        }
        return ResultMsg.ok(coreUser);
    }

    /**
     * 查询单条数据操作
     * @param coreUser
     * @return
     * @throws Exception
     */
    @ApiOperation(value="查询单条数据操作", notes="描述")
    @RequestMapping(value = "findById.json",method = {RequestMethod.POST}) //请求类型
    @ResponseBody
    public ResultMsg updateCoreMenu(CoreUser coreUser) throws Exception{
        //向用户表查询用户信息
        //CoreUser user=coreUserDao.single(coreUser.getId());
        CoreUser user=coreUserService.getCoreUserById(coreUser.getId());
        //向用户关系表查询用户角色信息
        List<CoreUserRole> userRoles=coreUserRoleService.getCoreUserByUserId(user.getId());
        String roles="";
        for (CoreUserRole userRole : userRoles) {

            String role=String.valueOf(userRole.getRoleid());
            roles=roles+","+role;
        }
        user.setRole(roles);
        return ResultMsg.ok(user);

    }

    /**
     * 查询全部数据操作
     * @return
     */
    @ApiOperation(value="查询全部数据操作", notes="描述")
    @RequestMapping(value="all.json",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg all(){
        List<CoreUser> coreMenus = coreUserService.findAll("");
        return ResultMsg.ok(coreMenus);
    }

    /**
     * 查询分页数据操作
     * @param coreUserVO
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value="查询分页数据操作", notes="描述")
    @RequestMapping(value="page.json",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg page(@ModelAttribute CoreUserVO coreUserVO, int pageNum, int pageSize){
        //创建分页对象
        PageHelper.startPage(pageNum, pageSize);
        List<CoreUser> users = coreUserService.findAll(coreUserVO.getName());
        //遍历用户集合根据用户名称查出角色信息写入vo字段
        for (CoreUser user : users) {
            //根据用户名称查出角色信息id
            List<CoreUserRole> userRoles=coreUserRoleService.getCoreUserByUserId(user.getId());
            //格式拼接用","作为分隔符
            String roles="";
            for (CoreUserRole userRole : userRoles) {
                String role=String.valueOf(userRole.getRoleid());
                roles=roles+","+role;
                System.out.print(roles);
            }
            //写入vo,格式（1，2）
            user.setRole(roles);
        }
        PageInfo<CoreUser> pageInfo = new PageInfo<>(users);
        return ResultMsg.ok(pageInfo);
    }

    /**
     * 修改用户密码操作
     * @param oldPwd
     * @param newPwd
     * @param confirm
     * @return
     */
    @ApiOperation(value="修改用户密码操作", notes="描述")
    @RequestMapping(value = "/updatePwd.do", method = RequestMethod.POST, params = {"oldPwd",  "newPwd", "confirm" })
    @ResponseBody
    public ResultMsg updatePwd(@RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd, @RequestParam("confirm") String confirm) {
        if (oldPwd == null || oldPwd.length() <= 0 || newPwd == null || newPwd.length() <= 0 || confirm == null || confirm.length() <= 0) {
            return  fail("三个密码都不能为空");
        }
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        //CoreUser coreUser=coreUserDao.sample(username);
        CoreUser coreUser=coreUserService.findCoreUserByName(username);
        if (!coreUser.getPsw().equals(MD5Util.MD5(oldPwd))) {
            return fail("密码输入错误");
        }
        coreUser.setPsw(MD5Util.MD5(newPwd));
        //coreUserDao.updateTemplateById(coreUser);
        coreUserService.save(coreUser);
        return ResultMsg.ok();
    }
}
