package com.zhaishu.qishouserver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.entity.Employee;
import com.zhaishu.qishouserver.service.EmployeeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")

public class UploadDownHandler {
    /**上传地址*/
    @Value("${file.upload.path}")
    private String path;

    /**图片url前缀*/
    @Value("${base_picture_url}")
    private String base_picture_url;

    @Resource
    EmployeeService employeeService;

    @ResponseBody
    @PostMapping("/upAvatar")
    @ApiOperation(value = "上传图片", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse upAvatar(@RequestParam("file") MultipartFile file,Integer id) throws IOException {

        //String base_picture_url = "http://localhost:8080/image/";

        //获取文件在服务器的储存位置
        File filePath = new File(path+"av/");
        if(!filePath.exists() && !filePath.isDirectory()){
            System.out.println("目录不存在，创建目录" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称（包括格式）
        String originalFileName = file.getOriginalFilename();
        System.out.println("原始文件名称" + originalFileName);

        //获取文件类型，以最后一个‘.’为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型" + type);

        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0,originalFileName.lastIndexOf("."));

        //设置文件新名称：当前事件+文件名称（不包含格式）
        String fileName = "av"+id  + "." +type;
        System.out.println("新文件名称" +fileName);

        //在指定路径下创建文件
        File targetFile = new File(path+"av/",fileName);

        Map<String,Object> result = new HashMap<String,Object>();//定义结果
        //将文件保存到服务器指定位置
        try{
            file.transferTo(targetFile);
            System.out.println("上传成功");
            Employee employee=new Employee();
            employee.setEmployeeId(id);
            employee.setAvatar(base_picture_url+"av/"+ fileName);
            employeeService.update(employee);
        }catch (IOException e){
            return ResultResponse.error("400","上传失败");
        }

        result.put("code",200);
        result.put("picture",base_picture_url+"av/"+ fileName);
        System.out.println(result);
        return ResultResponse.resultSuccess(result);
    }

    /**
     * 上传图片
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @ResponseBody
    @PostMapping("/uploadPicture")
    @ApiOperation(value = "上传图片", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse uploadPicture(@RequestParam("file") MultipartFile file, HttpServletRequest request,Integer id) throws IOException {

        //String base_picture_url = "http://localhost:8080/image/";

        //获取文件在服务器的储存位置  
        File filePath = new File(path);
        System.out.println("文件的保存路径"+path);
        if(!filePath.exists() && !filePath.isDirectory()){
            System.out.println("目录不存在，创建目录" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称（包括格式）
        String originalFileName = file.getOriginalFilename();
        System.out.println("原始文件名称" + originalFileName);

        //获取文件类型，以最后一个‘.’为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型" + type);

        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0,originalFileName.lastIndexOf("."));

        //设置文件新名称：当前事件+文件名称（不包含格式）
        String fileName = id  + "." +type;
        System.out.println("新文件名称" +fileName);

        //在指定路径下创建文件
        File targetFile = new File(path,fileName);

        Map<String,Object> result = new HashMap<String,Object>();//定义结果
        //将文件保存到服务器指定位置
        try{
            file.transferTo(targetFile);
            System.out.println("上传成功");

        }catch (IOException e){
            return ResultResponse.error("400","上传失败");
        }

        result.put("code",200);
        result.put("picture",base_picture_url+ fileName);
        System.out.println(result);
        return ResultResponse.resultSuccess(result);
    }
    @PostMapping("/dateTest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse getDate(@RequestBody Employee employee){
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        System.out.println(gson.toJson(employee.getCreateTime())+" "+gson.toJson(employee.getCreateTime()).length());

        return ResultResponse.resultSuccess(employee.getCreateTime());
    }
}
