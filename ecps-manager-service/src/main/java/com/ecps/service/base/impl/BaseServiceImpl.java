package com.ecps.service.base.impl;

import com.ecps.model.base.BaseModel;
import com.ecps.service.base.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * 基础公共service实现类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-21 下午 01:44
 */
public class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {

    @Autowired
    private Mapper<T> mapper;

    /**
     * 根据id查询
     *
     * @param id
     * @return T
     */
    @Override
    public T queryById(Long id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    /**
     * 根据条件查询一条数据
     *
     * @param record
     * @return T
     */
    @Override
    public T queryOne(T record) {
        return this.mapper.selectOne(record);
    }

    /**
     * 查询所有数据
     *
     * @return list<T>
     */
    @Override
    public List<T> queryAll() {
        return this.mapper.selectAll();
    }

    /**
     * 根据条件查询数据列表
     *
     * @param record
     * @return list<T>
     */
    @Override
    public List<T> queryListByWhere(T record) {
        return this.mapper.select(record);
    }

    /**
     * 分页查询数据列表
     *
     * @param record 查询条件
     * @param page   起始页
     * @param rows   每页大小
     * @return pageInfo<T>
     */
    @Override
    public PageInfo<T> queryPageListByWhere(T record, Integer page, Integer rows) {
        //设置分页参数
        PageHelper.startPage(page, rows);
        //执行查询
        List<T> list = this.mapper.select(record);
        //返回分页结果
        return new PageInfo<T>(list);
    }

    /**
     * 保存数据
     *
     * @param record
     * @return int
     */
    @Override
    public int save(T record) {
        record.setCreated(new Date());
        record.setUpdated(record.getCreated());
        return this.mapper.insert(record);
    }

    /**
     * 保存不为空的数据
     *
     * @param record
     * @return int
     */
    @Override
    public int saveSelective(T record) {
        record.setCreated(new Date());
        record.setUpdated(record.getCreated());
        return this.mapper.insertSelective(record);
    }

    /**
     * 根据id更新数据
     *
     * @param record
     * @return int
     */
    @Override
    public int updateByPrimaryKey(T record) {
        record.setUpdated(new Date());
        return this.mapper.updateByPrimaryKey(record);
    }

    /**
     * 根据id更新不为空的数据
     *
     * @param record
     * @return int
     */
    @Override
    public int updateSelective(T record) {
        record.setUpdated(new Date());
        return this.mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return int
     */
    @Override
    public int deleteById(Long id) {
        return this.mapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除数据
     *
     * @param clazz
     * @param property
     * @param list
     * @return int
     */
    @Override
    public int deleteByIds(Class<T> clazz, String property, List<Object> list) {
        Example example = new Example(clazz);
        example.createCriteria().andIn(property, list);
        return this.mapper.deleteByExample(example);
    }

    /**
     * 根据条件删除数据
     *
     * @param record
     * @return int
     */
    @Override
    public int deleteByWhere(T record) {
        return this.mapper.delete(record);
    }
}
