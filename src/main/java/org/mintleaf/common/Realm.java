package org.mintleaf.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.mintleaf.modules.core.domain.CoreButton;
import org.mintleaf.modules.core.domain.CoreMenu;
import org.mintleaf.modules.core.domain.CoreRole;
import org.mintleaf.modules.core.domain.CoreUser;
import org.mintleaf.modules.core.service.CoreButtonService;
import org.mintleaf.modules.core.service.CoreMenuService;
import org.mintleaf.modules.core.service.CoreRoleService;
import org.mintleaf.modules.core.service.CoreUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Realm extends AuthorizingRealm {


    @Autowired
    CoreUserService coreUserService;

    @Autowired
    CoreRoleService coreRoleService;

    @Autowired
    CoreMenuService coreMenuService;

    @Autowired
    CoreButtonService coreButtonService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //从凭证中获得用户名
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        //根据用户名查询用户对象
//        AdminUser adminUser = new AdminUser();
        CoreUser coreUser=coreUserService.findCoreUserByName(username);


        //查询用户拥有的角色
        List<CoreRole> list = coreRoleService.findRoleByIdSample(coreUser.getId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (CoreRole coreRole : list) {
            System.out.print(coreRole.getName());
            //赋予用户角色
            info.addRole(coreRole.getName());
            List<CoreMenu> menus = coreMenuService.findMenuByNameSample(coreRole.getName());
            List<CoreButton> buttons = coreButtonService.findButtonByRoleSample(coreRole.getName());
            for (CoreMenu menu : menus)
            {//赋予用户角色权限
                System.out.print(menu.getPermission());
                info.addStringPermission(menu.getPermission());
            }
            for (CoreButton button : buttons)
            {//赋予用户角色权限
                System.out.print(button.getPermission());
                info.addStringPermission(button.getPermission());
            }
        }
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获得当前用户的用户名
        String username = (String) authenticationToken.getPrincipal();

        //从数据库中根据用户名查找用户
        CoreUser coreUser=coreUserService.findCoreUserByName(username);
        if (coreUser == null) {
            throw new UnknownAccountException(
                    "没有在本系统中找到对应的用户信息。");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(coreUser.getName(), coreUser.getPsw(),getName());
        return info;
    }

}