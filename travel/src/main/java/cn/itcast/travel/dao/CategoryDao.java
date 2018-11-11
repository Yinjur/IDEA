package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: qyj
 * @CreateDate: 2018/10/18  20:57
 * @Version: 1.0
 */

public interface CategoryDao {

    List<Category> findAll();
}
