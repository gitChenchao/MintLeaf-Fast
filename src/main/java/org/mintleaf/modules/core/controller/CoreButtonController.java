package org.mintleaf.modules.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mintleaf.modules.core.domain.CoreButton;
import org.mintleaf.modules.core.service.CoreButtonService;
import org.mintleaf.vo.PageFrame;
import org.mintleaf.vo.ResultMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按钮相关控制器
 */
@Api(tags="按钮相关控制器",description="描述")
@Controller
@RequestMapping("coreButton")
public class CoreButtonController {

    private final CoreButtonService coreButtonService;

    public CoreButtonController(CoreButtonService coreButtonService) {
        this.coreButtonService = coreButtonService;
    }


    /**
     * 进入列表页面
     * @return
     */
    @ApiOperation(value="进入列表页面", notes="描述")
    @RequestMapping(value="index.html",method = {RequestMethod.GET})
    public ModelAndView index(){
        ModelAndView view =new ModelAndView("modules/core/corebutton/index.html");
        return view;
    }

    /**
     * 进入编辑页面
     * @return
     */
    @ApiOperation(value="进入编辑页面", notes="描述")
    @RequestMapping(value="edit.html",method = {RequestMethod.GET})
    public ModelAndView edit(){
        ModelAndView view =new ModelAndView("modules/core/corebutton/edit.html");
        return view;
    }

    /**
     * 进入新增页面
     * @return
     */
    @ApiOperation(value="进入新增页面", notes="描述")
    @RequestMapping(value="add.html",method = {RequestMethod.GET})
    public ModelAndView add(){
        ModelAndView view =new ModelAndView("modules/core/corebutton/add.html");
        return view;
    }

    /**
     * 添加操作
     * @param coreButton
     * @return
     */
    @ApiOperation(value="添加操作", notes="描述")
    @RequestMapping(value = "add.do",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg add(CoreButton coreButton) {
        coreButtonService.save(coreButton);
        return ResultMsg.ok(coreButton);
    }

    /**
     * 删除操作
     * @param coreButton
     * @return
     */
    @ApiOperation(value="删除操作", notes="描述")
    @RequestMapping(value = "delete.do",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg delete(CoreButton coreButton) {
        coreButtonService.deleteById(coreButton.getId());
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
        coreButtonService.deleteBatch(idsList);
        return ResultMsg.ok();
    }

    /**
     * 编辑操作
     * @param coreButton
     * @return
     */
    @ApiOperation(value="编辑操作", notes="描述")
    @RequestMapping(value = "edit.do",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg update(CoreButton coreButton) {
        coreButtonService.updateByPrimaryKeySelective(coreButton);
        ResultMsg result=new ResultMsg();
        return  ResultMsg.ok(coreButton);
    }

    /**
     * 查询单条数据操作
     * @param coreButton
     * @return
     * @throws Exception
     */
    @ApiOperation(value="查询单条数据操作", notes="描述")
    @RequestMapping(value = "findById.json",method = {RequestMethod.POST}) //请求类型
    @ResponseBody
    public ResultMsg updateCoreMenu(CoreButton coreButton) throws Exception{
        CoreButton menu=coreButtonService.getCoreButtonById(coreButton.getId());
        return  ResultMsg.ok(menu);

    }

    /**
     * 查询全部数据操作
     * @return
     */
    @ApiOperation(value="查询全部数据操作", notes="描述")
    @RequestMapping(value="all.json",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg all(){
        List<CoreButton> coreButtons =coreButtonService.findAll();;
        return  ResultMsg.ok(coreButtons);
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
    public ResultMsg page(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<CoreButton> coreButtons =coreButtonService.findAll();
        PageInfo<CoreButton> pageInfo = new PageInfo<>(coreButtons);
        return  ResultMsg.ok(pageInfo);
    }
}
