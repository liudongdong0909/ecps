package com.ecps.ssm.controller;

import com.ecps.ssm.common.EasyUIResult;
import com.ecps.ssm.pojo.TbOrder;
import com.ecps.ssm.service.OrderService;
import com.github.pagehelper.PageInfo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单管理controller
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-17 下午 02:34
 */
@RestController
@RequestMapping("order")
@Api(value = "order", description = "订单管理")
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ApiOperation(value = "订单列表查询", notes = "返回分页结果", httpMethod = "GET", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "起始页", dataType = "int", defaultValue = "1", required = true, paramType = "query"),
            @ApiImplicitParam(name = "rows", value = "每页显示数目", dataType = "int", defaultValue = "10", required = true, paramType = "query")
    })
    public EasyUIResult queryOrderList(@RequestParam(value = "page",defaultValue= "1") Integer page,
                                       @RequestParam(value = "rows", defaultValue = "10")Integer rows){
        TbOrder order = new TbOrder();
        PageInfo<TbOrder> pageInfo = orderService.queryPageListByWhere(order, page, rows);
        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
    }

}
