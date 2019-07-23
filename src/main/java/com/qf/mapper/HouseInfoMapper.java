package com.qf.mapper;

import com.qf.pojo.HouseInfo;

import java.util.List;

public interface HouseInfoMapper {

    int add(HouseInfo houseInfo);
    List<HouseInfo> findall();
}


