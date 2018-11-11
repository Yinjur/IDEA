package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: qyj
 * @CreateDate: 2018/10/22  17:06
 * @Version: 1.0
 */

public interface RouteImgDao {

    List<RouteImg> findById(int rid);
}
