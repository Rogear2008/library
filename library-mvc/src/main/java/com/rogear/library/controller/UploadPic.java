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

    @RequestMapping(value = "/uploadHeadPic"
            //, method = RequestMethod.POST
            //, produces = "application/json; charset=utf-8"
    )
//    @ResponseBody
    public Object uploadHeadPic(@RequestParam() MultipartFile file, HttpServletRequest request) {
        //在这里面文件存储的方案一般是：收到文件→获取文件名→在本地存储目录建立防重名文件→写入文件→返回成功信息
        //如果上面的步骤中在结束前任意一步失败，那就直接失败了。
        FileOutputStream out=null;
        if (null == file || file.isEmpty()) {
            System.out.println("文件为空");
        }else{
            System.out.println("上传成功");
            //这里以用户ID作为文件夹
            int uid = (Integer) request.getSession().getAttribute("userid");
            //创建一个文件夹，网上代码很多
            String url = "/images";
            try {
                //获得二进制流并输出
                byte[] f = file.getBytes();
                out = new FileOutputStream(url+file.getOriginalFilename());
                out.write(f);

            } catch (IOException e) {
                System.out.println("上传失败");
            }finally {
                // 完毕，关闭所有链接
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("关闭流失败");
                }
            }

        }

        return null;
    }

}
