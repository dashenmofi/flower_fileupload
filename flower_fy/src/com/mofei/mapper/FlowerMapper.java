package com.mofei.mapper;

import com.mofei.pojo.Flower;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author mofei
 * @create 2021-02-18:06
 */
public interface FlowerMapper {

    //添加花卉信息
    @Insert("insert into flower values(default,#{name},#{price},#{production},#{filename},#{filetype})")
    Integer insert(Flower flower);

    //查询
    @Select("select * from flower")
    List<Flower> select();
}
