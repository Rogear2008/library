package com.rogear.library.controller;

import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Rogear on 2020/4/24
 **/
@Controller
public class UploadPic {

    @ResponseBody
    @RequestMapping(value = "/uploadPic",method = RequestMethod.POST)
    public String uploadPic(@RequestParam MultipartFile file) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String dir = request.getServletContext().getRealPath("/images");
        String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),file.getOriginalFilename().length());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String preName = simpleDateFormat.format(new Date());
        StringBuilder fileName = new StringBuilder(preName);
        Random random = new Random();
        if (type.equals(".jpg") || type.equals(".jpeg") || type.equals(".png")){
            fileName = fileName.append("_"+random.nextInt(10)).append(type);
        } else {
            return null;
        }
        FileUtils.writeByteArrayToFile(new File(dir,fileName.toString()),file.getBytes());
        return "/images/" + fileName.toString();
    }

}
