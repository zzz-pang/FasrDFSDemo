package com.qf.controller;


import com.qf.pojo.HouseInfo;
import com.qf.service.HouseInfoService;
import com.qf.util.FastDFSUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {


    @Resource
    private HouseInfoService houseInfoService;

    @RequestMapping("/upload.json")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        //1.得到名字
        String name = file.getOriginalFilename();
        //2.得到后缀
        String suffix = name.substring(name.lastIndexOf(".") + 1);

        //3.得到上传数据的byte数组
        try {
            byte[] b = file.getBytes();
            FastDFSUtils fastDFSUtils = new FastDFSUtils();
            String[] s = fastDFSUtils.upload(b, suffix);
            StringBuilder stringBuilder = new StringBuilder("http://192.168.164.88:82/");
            if (s != null) {
                for (int i = 0; i < s.length; i++) {
                    stringBuilder.append(s[i]);
                    if (i == 0) {
                        stringBuilder.append("/");
                    }
                }
            }

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping("/fileupload.json")
    @ResponseBody
    public Map fileupload(@RequestParam("file") MultipartFile file) {
        Map map = new HashMap();
        try {
            //1.得到名称
            String name = file.getOriginalFilename();
            //2.得到后缀
            String suffix = name.substring(name.lastIndexOf(".") + 1);
            //3.得到上传文件的数组
            byte[] b = file.getBytes();
            FastDFSUtils fastDFSUtils = new FastDFSUtils();
            String[] s = fastDFSUtils.upload(b, suffix);
            StringBuilder stringBuilder = new StringBuilder("http://192.168.164.88:82/");
            if (s != null) {
                for (int i = 0; i < s.length; i++) {
                    stringBuilder.append(s[i]);
                    if (i == 0) {
                        stringBuilder.append("/");
                    }
                }
            }
            String url = stringBuilder.toString();
            map.put("status", 200);
            map.put("msg", "success");
            map.put("url", url);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("status", 500);
        map.put("msg", "file");
        return map;
    }
    @RequestMapping("/addHouseInfo.json")
    @ResponseBody
    public    Map<String,Object>  save(HouseInfo info){
        Map<String,Object> map = new HashMap<>();

        boolean f =  houseInfoService.add(info);
        if (f){
            map.put("status","200");
            map.put("msg","success");
        }else{
            map.put("msg","fail");
            map.put("status","500");
        }

        return map;
    }

}
