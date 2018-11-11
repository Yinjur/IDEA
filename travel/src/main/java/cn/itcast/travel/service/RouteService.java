package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

/**
 * @Description: java类作用描述
 * @Author: qyj
 * @CreateDate: 2018/10/22  11:12
 * @Version: 1.0
 */

public interface RouteService {

    PageBean<Route> pageQuery(int cid, int currentPage, int pageSize,String rname);

    Route findOne(String rid);
}
