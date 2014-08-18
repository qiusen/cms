package com.dihaitech.acomp.dao;

import java.util.List;

import com.dihaitech.acomp.model.Manager;

/**
 * 管理员 DAO 接口
 * 
 * @author cg
 * 
 * @since 2014-08-18
 */
public interface IManagerDAO {

	/**
	 * 根据条件查询管理员 条数
	 * 
	 * @param manager
	 * @return
	 */
	public Long getManagerCount(Manager manager);

	/**
	 * 分页查找管理员
	 * 
	 * @param manager
	 * @param page
	 * @return
	 */
	public List<Manager> selectManagerLike(Manager manager);

	/**
	 * 添加管理员
	 * 
	 * @param manager
	 * @return
	 */
	public int addSaveManager(Manager manager);

	/**
	 * 根据ID获取指定的管理员信息
	 * 
	 * @param manager
	 * @return
	 */
	public Manager selectManagerById(Manager manager);

	/**
	 * 修改管理员
	 * 
	 * @param manager
	 * @return
	 */
	public int editSaveManager(Manager manager);

	/**
	 * 根据ID删除指定的管理员
	 * 
	 * @param str
	 * @return
	 */
	public int deleteByIds(String str);

	/**
	 * 查询所有管理员
	 * 
	 * @return
	 */
	public List<Manager> selectAll();
}
