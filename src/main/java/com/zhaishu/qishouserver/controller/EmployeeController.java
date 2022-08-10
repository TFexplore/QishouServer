package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.HashPasswordEncoder;
import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.common.*;
import com.zhaishu.qishouserver.entity.Employee;
import com.zhaishu.qishouserver.entity.SalaryLevel;
import com.zhaishu.qishouserver.service.EmployeeService;
import com.zhaishu.qishouserver.service.RiderService;
import com.zhaishu.qishouserver.service.SalaryLevelService;
import com.zhaishu.qishouserver.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 员工信息表(Employee)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@RestController
@RequestMapping("employee")
@Api(tags = "AAA员工管理接口", description = "员工信息表 使用mode :Employee")
public class EmployeeController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;

    @Resource
    private HashPasswordEncoder encoder;

    @Resource
    private TokenService tokenService;

    @Resource
    private RiderService riderService;


    /*
    登录
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录",notes = "员工登录接口employee_type:1-5")
    public ResultResponse login(@RequestBody  Employee employee) {
        //参数校验
        if (employee.getPhoneNum() == null || employee.getPassword() == null) {
            throw new RuntimeExceptions(ErrorResultCode.PARAMETER_ERROR);
        }
        //查询用户
        Employee employee1 = this.employeeService.queryByTel(employee.getPhoneNum());
        if(employee1==null){
            throw new RuntimeExceptions(ErrorResultCode.USER_NOT_FOUND);
        }
        //非管理人员登录
        if(employee1.getEmployeeType()>=6||employee1.getEmployeeType()<1){
            throw new RuntimeExceptions(ErrorResultCode.PERMISSION_DENIED);
        }
        //比对密码
        if(!encoder.matches(employee.getPassword(),employee1.getPassword())){
            throw new RuntimeExceptions(ErrorResultCode.PASSWORD_ERROR);
        }

        //生成token
        String token = tokenService.getToken(employee1);

        //返回token和员工类型
        Map<Object,Object> map = new HashMap<>();

        map.put("token",token);
        map.put("employeeType",employee1.getEmployeeType());

        return ResultResponse.resultSuccess(map);

    }


    /*
    增加员工
     */
    @PostMapping("/addEmployee")
    @ApiOperation(value = "添加员工",notes = "默认密码为123456，必须传入员工类型等必要参数，员工类型在2-5之间，不能直接添加骑手类型")
    @UserToken.Admin
    @ApiImplicitParams({
      @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse addEmployee(@RequestBody @Validated Employee employee) {
        //参数校验
        if (employee.getEmployeeType() == null) {
            throw new RuntimeExceptions(ErrorResultCode.PARAMETER_ERROR);
        }
        if (employee.getEmployeeType()>5||employee.getEmployeeType()<=1){
            return ResultResponse.error("403","员工类型必须在2-5之间，不能直接添加骑手类型");
        }
        //查询是否存在
        Employee employee1 = this.employeeService.queryByTel(employee.getPhoneNum());
        if (employee1 != null) {
            return ResultResponse.error("403","电话号码已绑定，请更换手机号");
        }
        if (employee.getIdCard()!=null){
           String pwd=employee.getIdCard().substring(employee.getIdCard().length()-6);
           employee.setPassword(encoder.encode(pwd));
        }else {
            employee.setPassword(encoder.encode("123456"));
        }
        //注册
        this.employeeService.insert(employee);

        return ResultResponse.resultSuccess("添加成功，登录账号为电话号，默认密码为身份证后6位");
    }
    @PostMapping("/getEmployeebyMap")
    @ApiOperation(value = "根据条件查询",notes = "map 为空时获取全部员工，通过传入参数进行筛选，isDelete=1为离职员工")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getEmployeebyMap(@RequestBody Employee employee,int offset,int limit){
        List<Employee> list=this.employeeService.queryByMap(employee,offset,limit);
        Map<String,Object> map=new HashMap<>();
        map.put("total",this.employeeService.countMap(employee));
        map.put("list",list);
        return ResultResponse.resultSuccess(map);
    }

    @GetMapping("{id}")
    @ApiOperation("通过工号获取员工信息")
    @UserToken.Admin
    @ApiImplicitParams({
            //TOKEN
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse queryById(@PathVariable("id") Integer id) {
        Employee employee = this.employeeService.queryById(id);
        if (employee==null){
            return ResultResponse.error("404","用户不存在");
        }
        return ResultResponse.resultSuccess(employee);
    }

    @GetMapping("/getEmployeeInfo")
    @ApiOperation("通过token获取个人信息")
    @UserToken.Admin
    public ResultResponse queryByToken(@RequestHeader String token) {
        Employee employee = this.employeeService.queryById(TokenUtils.getIntegerValus("userId",token));
        if (employee==null){
            return ResultResponse.error("404","用户不存在或token信息错误");
        }
        return ResultResponse.resultSuccess(employee);
    }

    @PostMapping("/edit")
    @ApiOperation(value = "编辑员工信息",notes = "只能修改员工信息，不能修改骑手和管理员信息")
    @UserToken.Admin
    @ApiImplicitParams({
            //TOKEN
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse edit(@RequestBody @Validated Employee employee) {
        if (employee.getEmployeeId()==null){
            return ResultResponse.error("400","工号不能为空");
        }

        if (employee.getPhoneNum()!=null){
            Employee employee1=this.employeeService.queryByTel(employee.getPhoneNum());
            if (employee1!=null){
                return ResultResponse.error("403","存在相同电话号，一个电话号只能绑定一个用户");
            }
        }
        if (employee.getEmployeeType()!=null){
            if (employee.getEmployeeType()>5||employee.getEmployeeType()<=1){
                return ResultResponse.error("403","只能修改员工信息，不能修改骑手或管理员信息");
            }
        }

        if (employee.getPassword()!=null){
            return ResultResponse.error("403","只能修改员工信息，不能通过此接口修改密码");
        }
        this.employeeService.update(employee);
        return ResultResponse.resultSuccess("编辑成功");
    }

    @PostMapping("/editPwd")
    @ApiOperation("修改密码")
    @UserToken.Admin
    @ApiImplicitParams({
            //TOKEN
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse editPassWord(Integer id,String pwd,String idCard){
        if (pwd.length()>20){
            return ResultResponse.error("400","密码长度在1-20之间");
        }
        Employee r= this.employeeService.queryById(id);
        if (r==null){
            throw new RuntimeExceptions(ErrorResultCode.USER_NOT_FOUND);
        }
        if (r.getIdCard()==null||r.getIdCard().length()!=18){
            return ResultResponse.error("400","请先设置正确的身份证号码");
        }
        //比对身份证号码后六位
        if (!idCard.equals(r.getIdCard().substring(r.getIdCard().length()-6))){
            return ResultResponse.error("身份证号码不正确");
        }

        Employee employee=new Employee();
        employee.setEmployeeId(id);
        employee.setPassword(this.encoder.encode(pwd));
        this.employeeService.update(employee);

        return ResultResponse.resultSuccess("编辑成功");
    }
    @PostMapping("/resetPwd")
    @ApiOperation(value = "重置密码",notes = "当身份证号码不存在时，密码重置为123456")
    @UserToken.Admin
    @ApiImplicitParams({
            //TOKEN
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse resetPassWord(Integer id) {
        Employee employee = this.employeeService.queryById(id);
        //取身份证后六位
        String code;
        if (employee.getIdCard()==null){
            code="123456";
        }
        code=employee.getIdCard().substring(employee.getIdCard().length()-6);
        Employee employee1=new Employee();
        employee1.setId(id);
        employee1.setPassword(this.encoder.encode(code));
        this.employeeService.update(employee1);
        if (employee.getIdCard()==null){
            return ResultResponse.resultSuccess("身份证号码未设置，密码重置为123456");
        }

        return ResultResponse.resultSuccess("重置密码为身份证后6位");
    }
    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    @ApiOperation("删除员工")
    @UserToken.Admin
    @ApiImplicitParams({
            //TOKEN
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse deleteById(Integer id) {
        Employee employee=this.employeeService.queryById(id);
        if (employee.getEmployeeType()>5||employee.getEmployeeType()<=1){
            return ResultResponse.error("403","只能操作员工类型范围2-5");
        }
        if (!this.employeeService.deleteById(id)){
            throw new RuntimeExceptions(ErrorResultCode.SYSTEM_ERROR);
        }

        return ResultResponse.resultSuccess("删除成功");
   }

    /**
     * 查询全部员工
     *
     * @param
     * @return 查询结果
     */
    @GetMapping("/getEmployees")
    @ApiOperation(value = "查询所有员工")
    @UserToken.Admin
    @ApiImplicitParams({
            //TOKEN
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getAdmins(Integer offset, Integer limit) {

        //查询总记录数
        Integer count = this.employeeService.countAdmin();
        //分页查询
        Map<String,Object> map=new HashMap<>();
        map.put("total",count);
        map.put("list",this.employeeService.queryAdminByPage(offset, limit));


        return ResultResponse.resultSuccess(map);
    }

    @GetMapping("/getEmployeesByStatus")
    @ApiOperation("按在职状态查询")
    @UserToken.Admin
    @ApiImplicitParams({
            //TOKEN
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getEmployeeByStatus(Integer status,Integer offset, Integer limit) {

        //查询总记录数
        Integer count = this.employeeService.countAdminByStatus(status);
        //分页查询

        Map<String,Object> map=new HashMap<>();
        map.put("total",count);
        map.put("list",this.employeeService.queryAdminByStatus(status,offset, limit));

        return ResultResponse.resultSuccess(map);
    }
    @GetMapping("/getEmployeesByType")
    @ApiOperation("按员工类型查询")
    @UserToken.Admin
    @ApiImplicitParams({
            //TOKEN
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getEmployeeByType(Integer type,Integer offset, Integer limit) {

        //查询总记录数
        Integer count = this.employeeService.countAdminbyType(type);
        //分页查询

        Map<String,Object> map=new HashMap<>();
        map.put("total",count);
        map.put("list",this.employeeService.queryAdminByType(type,offset, limit));

        return ResultResponse.resultSuccess(map);
    }
    @GetMapping("/getEmployeesByInfo")
    @ApiOperation("按员工信息查询")
    @UserToken.Admin
    @ApiImplicitParams({
            //TOKEN
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getEmployeeByInfo(String type,String info){
        Employee employee;
        if (type.equals("name")){
            employee=this.employeeService.queryByName(info);
        }
        else if (type.equals("tel")){
            employee=this.employeeService.queryByTel(info);
        }
        else employee=null;
        if (employee==null){
            return ResultResponse.error("404","not found");
        }

        return ResultResponse.resultSuccess(employee);
    }
}

