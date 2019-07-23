package com.qf.pojo;


import lombok.Data;

@Data
public class HouseInfo {

    private Integer id;
    private String title;
    private String images;
    private String desc;
    private Double price;
    private String address;
}
