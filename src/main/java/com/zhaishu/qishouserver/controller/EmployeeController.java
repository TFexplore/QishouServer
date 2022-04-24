package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.HashPasswordEncoder;
import com.zhaishu.qishouserver.common.ErrorResultCode;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.common.RuntimeExceptions;
import com.zhaishu.qishouserver.entity.Employee;
import com.zhaishu.qishouserver.service.EmployeeService;
import com.zhaishu.qishouserver.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 员工信息表(Employee)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@RestController
@RequestMapping("employee")
@Api(tags = "EmployeeController", description = "员工信息表")
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


    /*
    登录
     */
    @PostMapping("/login")
    @ApiOperation("登录")
    public ResultResponse login(@RequestBody @Validated Employee employee) {

        //查询用户
        Employee employee1 = this.employeeService.queryByTel(employee.getPhoneNum());
        if(employee1==null){
            throw new RuntimeExceptions(ErrorResultCode.USER_NOT_FOUND);
        }
        //比对密码
        if(!encoder.matches(employee.getPassword(),employee1.getPassword())){
            throw new RuntimeExceptions(ErrorResultCode.PASSWORD_ERROR);
        }
        //生成token
        String token = tokenService.getToken(employee1);
        //将token加入缓存


        //返回token和员工类型
        Map<Object,Object> map = new HashMap<>();

        map.put("token",token);
        map.put("riderType",employee1.getEmployeeType());


        return ResultResponse.resultSuccess(map);

    }

    /*
    注册
     */
    @PostMapping("register")
    @ApiOperation(value = "注册")
    public ResultResponse register(@RequestBody @Validated  Employee employee){
        //参数校验

        //查询是否存在
        Employee employee1 = this.employeeService.queryByTel(employee.getPhoneNum());
        if(employee1!=null){
            return ResultResponse.error("用户名已存在");
        }
        //使用Encoder对密码进行加密
        employee.setPassword(encoder.encode(employee.getPassword()));

        //注册
        this.employeeService.insert(employee);//查询总记录数，设置员工编号，插入记录


        return ResultResponse.resultSuccess("注册成功");
    }

    /**
     * 分页查询
     *
     * @param employee 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Employee>> queryByPage(Employee employee, PageRequest pageRequest) {
        return ResponseEntity.ok(this.employeeService.queryByPage(employee, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Employee> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.employeeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param employee 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Employee> add(Employee employee) {
        return ResponseEntity.ok(this.employeeService.insert(employee));
    }

    /**
     * 编辑数据
     *
     * @param employee 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Employee> edit(Employee employee) {
        return ResponseEntity.ok(this.employeeService.update(employee));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.employeeService.deleteById(id));
    }

}

