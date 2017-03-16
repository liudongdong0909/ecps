package com.ecps.api.service.base;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 基础公共service接口
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-21 下午 01:43
 */
public interface BaseService<T> {

    /**
     * 根据id查询
     *
     * @param id
     * @return T
     */
    T queryById(Long id);

    /**
     * 根据条件查询一条数据
     *
     * @param record
     * @return T
     */
    T queryOne(T record);

    /**
     * 查询所有数据
     *
     * @return list<T>
     */
    List<T> queryAll();

    /**
     * 根据条件查询数据列表
     *
     * @param record
     * @return list<T>
     */
    List<T> queryListByWhere(T record);

    /**
     * 分页查询数据列表
     *
     * @param record 查询条件
     * @param page   起始页
     * @param rows   每页大小
     * @return pageInfo<T>
     */
    PageInfo<T> queryPageListByWhere(T record, Integer page, Integer rows);

    /**
     * 保存数据
     *
     * @param record
     * @return int
     */
    int save(T record);

    /**
     * 保存不为空的数据
     *
     * @param record
     * @return int
     */
    int saveSelective(T record);

    /**
     * 根据id更新数据
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKey(T record);

    /**
     * 根据id更新不为空的数据
     *
     * @param record
     * @return int
     */
    int updateSelective(T record);

    /**
     * 根据id删除数据
     *
     * @param id
     * @return int
     */
    int deleteById(Long id);

    /**
     * 批量删除数据
     *
     * @param clazz
     * @param property
     * @param list
     * @return int
     */
    int deleteByIds(Class<T> clazz, String property, List<Object> list);

    /**
     * 根据条件删除数据
     *
     * @param record
     * @return int
     */
    int deleteByWhere(T record);
}
