package com.qf.service.impl;


import com.qf.mapper.HouseInfoMapper;
import com.qf.pojo.HouseInfo;
import com.qf.service.HouseInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HouserInfoServiceImpl implements HouseInfoService {


    @Resource
    private HouseInfoMapper houseInfoMapper;

    @Override
    public boolean add(HouseInfo houseInfo) {
        return houseInfoMapper.add(houseInfo)>0;
    }

    @Override
    public List<HouseInfo> findall() {
        return houseInfoMapper.findall();
    }
}
