package com.ecps.controller;

import com.ecps.common.bean.EasyUIResult;
import com.ecps.model.TbUser;
import com.ecps.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户管理Controller
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-21 下午 01:50
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    @ResponseBody
    public EasyUIResult queryPage(@RequestParam(value = "page", defaultValue = "1")Integer page,
                                  @RequestParam(value = "rows", defaultValue = "10")Integer rows){

        PageInfo<TbUser> pageInfo = userService.queryPageListByWhere(null, page, rows);
        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
    }
}
