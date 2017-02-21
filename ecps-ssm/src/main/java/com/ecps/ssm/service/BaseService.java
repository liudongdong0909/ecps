package com.ecps.ssm.service;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * baseService
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-15 上午 12:42
 */
public interface BaseService<T> {

    /**
     * 根据id查询
     * @param id
     * @return T
     */
    public T queryById(Long id);

    /**
     * 根据条件查询一条数据
     * @param record
     * @return T
     */
    public T queryOne(T record);

    /**
     * 查询所有数据
     * @return list<T>
     */
    public List<T> queryAll();

    /**
     * 根据条件查询数据列表
     * @param record
     * @return list<T>
     */
    public List<T> queryListByWhere(T record);

    /**
     * 分页查询数据列表
     * @param record 查询条件
     * @param page 起始页
     * @param rows 每页大小
     * @return pageInfo<T>
     */
    public PageInfo<T> queryPageListByWhere(T record, Integer page, Integer rows);

    /**
     * 保存数据
     * @param record
     * @return int
     */
    public int save(T record);

    /**
     * 保存不为空的数据
     * @param record
     * @return int
     */
    public int saveSelective(T record);

    /**
     * 根据id更新数据
     * @param record
     * @return int
     */
    public int updateByPrimaryKey(T record);

    /**
     * 根据id更新不为空的数据
     * @param record
     * @return int
     */
    public int updateSelective(T record);

    /**
     * 根据id删除数据
     * @param id
     * @return int
     */
    public int deleteById(Long id);

    /**
     * 批量删除数据
     * @param clazz
     * @param property
     * @param list
     * @return int
     */
    public int deleteByIds(Class<T> clazz, String property, List<Object> list);

    /**
     * 根据条件删除数据
     * @param record
     * @return int
     */
    public int deleteByWhere(T record);
}
