package com.baizhi.action;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuAction {
    @Resource
    private MenuService menuService;

    @RequestMapping("/selectMenu")
    public List<Menu> selectMenu() {
        List<Menu> menus = menuService.selectMenu();
        return menus;
    }

}
