package cn.javayong.magic.admin.tiny.controller;

import cn.javayong.magic.admin.tiny.model.LoginRequest;
import cn.javayong.magic.admin.tiny.model.LoginResponse;
import cn.javayong.magic.admin.tiny.model.PermissionInfoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 认证控制器
 */
@RestController
@RequestMapping("/system/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    /**
     * 登录接口
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        // 模拟登录成功，返回accessToken和refreshToken
        LoginResponse response = new LoginResponse();
        response.setAccessToken("mock-access-token-" + UUID.randomUUID().toString());
        response.setRefreshToken("mock-refresh-token-" + UUID.randomUUID().toString());
        
        // 模拟用户信息
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("id", 1L);
        userInfo.put("avatar", "https://picsum.photos/200");
        userInfo.put("nickname", "Admin");
        userInfo.put("deptId", 1L);
        response.setUserInfo(userInfo);
        
        return ResponseEntity.ok(response);
    }

    /**
     * 获取权限信息接口
     */
    @GetMapping("/get-permission-info")
    public ResponseEntity<PermissionInfoResponse> getPermissionInfo() {
        PermissionInfoResponse response = new PermissionInfoResponse();
        
        // 模拟权限列表
        Set<String> permissions = new HashSet<>();
        permissions.add("system:user:list");
        permissions.add("system:user:create");
        permissions.add("system:user:update");
        permissions.add("system:user:delete");
        permissions.add("system:role:list");
        permissions.add("system:role:create");
        permissions.add("system:role:update");
        permissions.add("system:role:delete");
        permissions.add("system:menu:list");
        permissions.add("system:menu:create");
        permissions.add("system:menu:update");
        permissions.add("system:menu:delete");
        permissions.add("system:dict:list");
        permissions.add("system:dict:create");
        permissions.add("system:dict:update");
        permissions.add("system:dict:delete");
        response.setPermissions(permissions);
        
        // 模拟角色列表
        List<String> roles = Arrays.asList("admin");
        response.setRoles(roles);
        
        // 模拟用户信息
        PermissionInfoResponse.UserInfo userInfo = new PermissionInfoResponse.UserInfo();
        userInfo.setId(1L);
        userInfo.setAvatar("https://picsum.photos/200");
        userInfo.setNickname("Admin");
        userInfo.setDeptId(1L);
        response.setUser(userInfo);
        
        // 模拟菜单列表
        List<PermissionInfoResponse.Menu> menus = new ArrayList<>();
        
        // 首页菜单
        PermissionInfoResponse.Menu homeMenu = new PermissionInfoResponse.Menu();
        homeMenu.setPath("/");
        homeMenu.setName("Dashboard");
        homeMenu.setComponent("/dashboard/index");
        PermissionInfoResponse.Menu.MenuMeta homeMeta = new PermissionInfoResponse.Menu.MenuMeta();
        homeMeta.setTitle("首页");
        homeMeta.setIcon("home");
        homeMeta.setHidden(false);
        homeMeta.setNoCache(false);
        homeMenu.setMeta(homeMeta);
        menus.add(homeMenu);
        
        // 系统管理菜单
        PermissionInfoResponse.Menu systemMenu = new PermissionInfoResponse.Menu();
        systemMenu.setPath("/system");
        systemMenu.setName("System");
        systemMenu.setComponent("/layout/index");
        PermissionInfoResponse.Menu.MenuMeta systemMeta = new PermissionInfoResponse.Menu.MenuMeta();
        systemMeta.setTitle("系统管理");
        systemMeta.setIcon("system");
        systemMeta.setHidden(false);
        systemMeta.setNoCache(false);
        systemMenu.setMeta(systemMeta);
        menus.add(systemMenu);
        
        // 用户管理子菜单
        PermissionInfoResponse.Menu userMenu = new PermissionInfoResponse.Menu();
        userMenu.setPath("/system/user");
        userMenu.setName("User");
        userMenu.setComponent("/system/user/index");
        PermissionInfoResponse.Menu.MenuMeta userMeta = new PermissionInfoResponse.Menu.MenuMeta();
        userMeta.setTitle("用户管理");
        userMeta.setIcon("user");
        userMeta.setHidden(false);
        userMeta.setNoCache(false);
        userMenu.setMeta(userMeta);
        menus.add(userMenu);
        
        // 角色管理子菜单
        PermissionInfoResponse.Menu roleMenu = new PermissionInfoResponse.Menu();
        roleMenu.setPath("/system/role");
        roleMenu.setName("Role");
        roleMenu.setComponent("/system/role/index");
        PermissionInfoResponse.Menu.MenuMeta roleMeta = new PermissionInfoResponse.Menu.MenuMeta();
        roleMeta.setTitle("角色管理");
        roleMeta.setIcon("role");
        roleMeta.setHidden(false);
        roleMeta.setNoCache(false);
        roleMenu.setMeta(roleMeta);
        menus.add(roleMenu);
        
        // 菜单管理子菜单
        PermissionInfoResponse.Menu menuMenu = new PermissionInfoResponse.Menu();
        menuMenu.setPath("/system/menu");
        menuMenu.setName("Menu");
        menuMenu.setComponent("/system/menu/index");
        PermissionInfoResponse.Menu.MenuMeta menuMeta = new PermissionInfoResponse.Menu.MenuMeta();
        menuMeta.setTitle("菜单管理");
        menuMeta.setIcon("menu");
        menuMeta.setHidden(false);
        menuMeta.setNoCache(false);
        menuMenu.setMeta(menuMeta);
        menus.add(menuMenu);
        
        // 字典管理子菜单
        PermissionInfoResponse.Menu dictMenu = new PermissionInfoResponse.Menu();
        dictMenu.setPath("/system/dict");
        dictMenu.setName("Dict");
        dictMenu.setComponent("/system/dict/index");
        PermissionInfoResponse.Menu.MenuMeta dictMeta = new PermissionInfoResponse.Menu.MenuMeta();
        dictMeta.setTitle("字典管理");
        dictMeta.setIcon("dict");
        dictMeta.setHidden(false);
        dictMeta.setNoCache(false);
        dictMenu.setMeta(dictMeta);
        menus.add(dictMenu);
        
        response.setMenus(menus);
        
        return ResponseEntity.ok(response);
    }
}
