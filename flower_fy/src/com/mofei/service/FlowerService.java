package com.mofei.service;

import com.mofei.pojo.Flower;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * @author mofei
 * @create 2021-02-18:11
 */
public interface FlowerService {
    //添加花卉信息
    Integer save(Flower flower);

    List<Flower> find();
}
