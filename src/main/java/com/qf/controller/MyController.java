package com.qf.controller;


import com.qf.util.FastDFSUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class MyController {

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
            StringBuilder stringBuilder=new StringBuilder("http://192.168.164.88:82/");
            if (s!=null){
                for (int i = 0; i < s.length; i++) {
                    stringBuilder.append(s[i]);
                    if (i==0){
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
    public Map<String,Object> findall(){
        return null;
    }
}
