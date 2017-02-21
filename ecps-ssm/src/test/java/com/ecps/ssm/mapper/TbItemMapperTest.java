package com.ecps.ssm.mapper;

import com.ecps.ssm.pojo.TbItem;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-13 下午 05:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-trans.xml",
        "classpath:spring/applicationContext-service.xml"})
public class TbItemMapperTest {

    @Autowired
    private TbItemMapper itemMapper;


    @Test
    public void selectByExample() throws Exception {
        PageHelper.startPage(1, 10);
        Example example = new Example(TbItem.class);
        List<TbItem> list = itemMapper.selectByExample(example);
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo.getTotal());
        System.out.print(pageInfo.getList());

    }

    @Test
    public void selectByPrimaryKey() throws Exception {

        TbItem tbItem = itemMapper.selectByPrimaryKey(536563L);
        System.out.println(tbItem.getTitle() + "---" + tbItem.getCreated());
    }

}