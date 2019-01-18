package org.mintleaf.modules.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mintleaf.modules.core.domain.CoreMenu;
import org.mintleaf.modules.core.service.CoreMenuService;
import org.mintleaf.modules.core.vo.CoreMenuVO;
import org.mintleaf.vo.PageFrame;
import org.mintleaf.vo.ResultMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 菜单相关控制器
 */
@Api(tags="菜单相关控制器",description="描述")
@Controller
@RequestMapping("coreMenu")
public class CoreMenuController {

    private final CoreMenuService coreMenuService;

    public CoreMenuController(CoreMenuService coreMenuService) {
        this.coreMenuService = coreMenuService;
    }

    /**
     * 进入列表页面
     * @return
     */
    @ApiOperation(value="进入列表页面", notes="描述")
    @RequestMapping(value="index.html",method = {RequestMethod.GET})
    public ModelAndView index(){
        ModelAndView view =new ModelAndView("modules/core/coremenu/index.html");
        return view;
    }

    /**
     * 进入编辑页面
     * @return
     */
    @ApiOperation(value="进入编辑页面", notes="描述")
    @RequestMapping(value="edit.html",method = {RequestMethod.GET})
    public ModelAndView edit(){
        ModelAndView view =new ModelAndView("modules/core/coremenu/edit.html");
        return view;
    }

    /**
     * 进入新增页面
     * @return
     */
    @ApiOperation(value="进入新增页面", notes="描述")
    @RequestMapping(value="add.html",method = {RequestMethod.GET})
    public ModelAndView add(){
        ModelAndView view =new ModelAndView("modules/core/coremenu/add.html");
        return view;
    }

    /**
     * 添加操作
     * @param coreMenu
     * @return
     */
    @ApiOperation(value="添加操作", notes="描述")
    @RequestMapping(value = "add.do",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg add(CoreMenu coreMenu) {
        coreMenuService.save(coreMenu);
        return ResultMsg.ok(coreMenu);
    }

    /**
     * 删除操作
     * @param coreMenu
     * @return
     */
    @ApiOperation(value="删除操作", notes="描述")
    @RequestMapping(value = "delete.do",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg delete(CoreMenu coreMenu) {
        coreMenuService.deleteById(coreMenu.getId());
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
        coreMenuService.deleteBatch(idsList);
        return ResultMsg.ok();
    }

    /**
     * 编辑操作
     * @param coreMenu
     * @return
     */
    @ApiOperation(value="编辑操作", notes="描述")
    @RequestMapping(value = "edit.do",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg update(CoreMenu coreMenu) {
        coreMenu.setUpdatetime(new Date());
        coreMenuService.updateByPrimaryKeySelective(coreMenu);
        return ResultMsg.ok(coreMenu);
    }

    /**
     * 查询单条数据操作
     * @param coreMenu
     * @return
     * @throws Exception
     */
    @ApiOperation(value="查询单条数据操作", notes="描述")
    @RequestMapping(value = "findById.json",method = {RequestMethod.POST}) //请求类型
    @ResponseBody
    public ResultMsg updateCoreMenu(CoreMenu coreMenu) throws Exception{
        CoreMenu menu=coreMenuService.getCoreMenuById(coreMenu.getId());;
        return ResultMsg.ok(menu);

    }

    /**
     * 查询全部数据操作
     * @return
     */
    @ApiOperation(value="查询全部数据操作", notes="描述")
    @RequestMapping(value="all.json",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg all(){
        List<CoreMenu> coreMenus =coreMenuService.findAll("");
        CoreMenu coreMenu=new CoreMenu();
        coreMenu.setId(0);
        coreMenu.setName("/根目录");
        //向菜单list第一个位置插入根目录
        coreMenus.add(0,coreMenu);
        return ResultMsg.ok(coreMenus);
    }

    /**
     * 查询分页数据操作
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value="查询分页数据操作", notes="描述")
    @RequestMapping(value="page.json",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg page(@ModelAttribute CoreMenuVO vo, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<CoreMenu> coreLoggers =coreMenuService.findAll(vo.getName());
        PageInfo<CoreMenu> pageInfo = new PageInfo<>(coreLoggers);
        return ResultMsg.ok(pageInfo);
    }

}
