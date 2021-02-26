package com.mofei.service.impl;

import com.mofei.mapper.FlowerMapper;
import com.mofei.pojo.Flower;
import com.mofei.service.FlowerService;
import com.mofei.util.DBUtil;

import java.util.List;

/**
 * @author mofei
 * @create 2021-02-18:16
 */
public class FlowerServiceImpl implements FlowerService {

    @Override
    public Integer save(Flower flower) {
        FlowerMapper mapper = DBUtil.getSqlSession().getMapper(FlowerMapper.class);
        Integer insert = mapper.insert(flower);
        DBUtil.closeAll();
        return insert;
    }

    @Override
    public List<Flower> find() {
        FlowerMapper mapper = DBUtil.getSqlSession().getMapper(FlowerMapper.class);
        List<Flower> select = mapper.select();
        DBUtil.closeAll();
        return select;
    }
}
