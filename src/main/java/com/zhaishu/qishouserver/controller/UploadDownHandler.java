package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.common.Utils;
import com.zhaishu.qishouserver.entity.Employee;
import com.zhaishu.qishouserver.entity.VersionCon;
import com.zhaishu.qishouserver.service.EmployeeService;
import com.zhaishu.qishouserver.service.VersionConService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@Api(tags = "B图片上传")
public class UploadDownHandler {
    /**上传地址*/
    @Value("${file.upload.path}")
    private String imgRootPath;

    /**图片url前缀*/
    @Value("${base_picture_url}")
    private String base_picture_url;

    @Resource
    EmployeeService employeeService;

    @ResponseBody
    @PostMapping("/upAvatar")
    @ApiOperation(value = "上传头像", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse upAvatar(@RequestParam("file") MultipartFile file,Integer id) throws IOException {

        //String base_picture_url = "http://localhost:8080/image/";

        //获取文件在服务器的储存位置
        File filePath = new File(imgRootPath+"av/");
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
        File targetFile = new File(imgRootPath+"av/",fileName);

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
        File filePath = new File(imgRootPath);
        System.out.println("文件的保存路径"+imgRootPath);
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
        String fileName = getRandomName(originalFileName);
        System.out.println("新文件名称" +fileName);

        //在指定路径下创建文件
        File targetFile = new File(imgRootPath,fileName);

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
        return ResultResponse.resultSuccess(result);
    }
    /**上传地址*/
    @Value("${apk.path}")
    private String apkPath;

    /**图片url前缀*/
    @Value("${apk_url}")
    private String apkUrl;
    @Resource
    VersionConService versionConService;

    /**
     * app
     * @return
     * @throws IOException
     */
    @ResponseBody
    @PostMapping("/uploadApp")
    @ApiOperation(value = "上传app", notes = "下载：https://www.zmice.top/:8080/api/downloadLocal?versionName=v1.0.0")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse uploadApp(@RequestParam("file") MultipartFile file) throws IOException {
        String versionName="zhaishu";
        //获取文件在服务器的储存位置
        Integer versionId=Utils.getShortId(8);
        String realPath=apkPath+String.valueOf(versionId)+"/";
        File filePath = new File(realPath);
        if(!filePath.exists() && !filePath.isDirectory()){
            System.out.println("目录不存在，创建目录" + filePath);
            filePath.mkdir();
        }
        //获取原始文件名称（包括格式）
        String originalFileName = file.getOriginalFilename();

        //获取文件类型，以最后一个‘.’为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

        //设置文件新名称：当前事件+文件名称（不包含格式）
        String fileName = versionName+"."+type;

        //在指定路径下创建文件
        File targetFile = new File(realPath,fileName);

        //将文件保存到服务器指定位置
        try{
            file.transferTo(targetFile);
        }catch (IOException e){
            return ResultResponse.error("400","上传失败");
        }
        VersionCon
            versionCon=new VersionCon();
            versionCon.setId(null);
            versionCon.setVersionId(versionId);
            versionCon.setIsOnline(0);
            versionCon.setVersionName(versionName);
            versionCon.setUpdateTime(System.currentTimeMillis());
            versionCon.setPath(apkUrl+String.valueOf(versionId)+"/"+fileName);
            versionConService.insert(versionCon);



        return ResultResponse.resultSuccess(versionConService.queryByPage(versionCon,0,1).get(0));
    }
    /**
     * @param response
     * @功能描述 下载文件:将输入流中的数据循环写入到响应输出流中，而不是一次性读取到内存
     */
    @RequestMapping("/downloadLocal")
    @UserToken.PassToken
    public void downloadLocal(String versionName, HttpServletResponse response) throws IOException {
        // 读到流中
        response.reset();
        String localPath=apkPath+versionName;
        File file = new File(localPath);
        response.setContentType("application/octet-stream");
        String filename = new File(localPath).getName();
        response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        WritableByteChannel writableByteChannel = Channels.newChannel(outputStream);
        FileChannel fileChannel = new FileInputStream(file).getChannel();
        fileChannel.transferTo(0, file.length(), writableByteChannel);
    }

    public static String getRandomName(String fileName){
        int index=fileName.lastIndexOf(".");
        String houzhui=fileName.substring(index);//获取后缀名
        String uuidFileName= UUID.randomUUID().toString().replace("-","")+houzhui;
        return uuidFileName;
    }

}
