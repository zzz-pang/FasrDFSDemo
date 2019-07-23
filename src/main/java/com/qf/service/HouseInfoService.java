package com.qf.service;

import com.qf.pojo.HouseInfo;

import java.util.List;

public interface HouseInfoService {

    boolean add(HouseInfo houseInfo);
    List<HouseInfo> findall();
}
