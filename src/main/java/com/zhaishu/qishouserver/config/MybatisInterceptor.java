package com.zhaishu.qishouserver.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
 
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Properties;

/**
 * @Author: Choj
 * @CreateDateTime: 2020/1/14 20:32
 * @ModifyDateTime:
 * @Name: UserInterceptor
 * @Description: 用于赋值用户信息的拦截器
 * @Since: 1.0
 **/
@Intercepts({@Signature(type = Executor.class, method = "update"
        , args = {MappedStatement.class, Object.class})})
@Slf4j
public class MybatisInterceptor implements Interceptor {
 
    @Override
    public Object intercept(final Invocation invocation) throws Exception {
        if (invocation.getTarget() instanceof Executor && invocation.getArgs().length == 2) {
            final Executor executor = (Executor) invocation.getTarget();
            // 获取第一个参数
            final MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
            final Object paramObj = invocation.getArgs()[1];
            if (ms.getSqlCommandType() == SqlCommandType.INSERT) {
                return this.executeInsert(executor, ms, paramObj);
            } else if (ms.getSqlCommandType() == SqlCommandType.UPDATE) {
                return this.executeUpdate(executor, ms, paramObj);
            } else if (ms.getSqlCommandType() == SqlCommandType.DELETE) {
                return this.executeDelete(executor, ms, paramObj);
            }
        }
        return invocation.proceed();
    }
 
    @Override
    public Object plugin(final Object target) {
        return Plugin.wrap(target, this);
    }
 
    @Override
    public void setProperties(final Properties properties) {
 
    }
 
    // ------ 私有方法 --------
 
    /**
     * 更新操作
     *
     * @param executor executor
     * @param ms       ms
     * @param paramObj 参数
     * @return 返回执行结果
     */
    private Object executeInsert(final Executor executor, final MappedStatement ms, final Object paramObj) throws Exception {
        final Field[] fields = paramObj.getClass().getDeclaredFields();
        log.info("###############insert拦截");
        for (final Field field : fields) {
            field.setAccessible(true);
            final String fieldName = field.getName();

            switch (fieldName) {
                case "createTime":
                case "updateTime":
                    try {
                        if (field.get(paramObj)==null){
                            field.set(paramObj, new Date());
                        }
                    }catch (IllegalArgumentException e){
                         break;
                    }

                    break;
                case "createBy":

                    break;

                case "updateBy":

                    break;
                default:
                    break;
            }
        }
        return executor.update(ms, paramObj);
    }
 
    /**
     * 新增操作
     *
     * @param executor executor
     * @param ms       ms
     * @param paramObj 参数
     * @return 返回执行结果
     */
    private Object executeUpdate(final Executor executor, final MappedStatement ms, final Object paramObj) throws Exception {
        final Field[] fields = paramObj.getClass().getDeclaredFields();
        log.info("###############update拦截");
        for (final Field field : fields) {
            field.setAccessible(true);
            final String fieldName = field.getName();
            switch (fieldName) {
                case "updateTime":
                    try {
                        if (field.get(paramObj)==null){
                            field.set(paramObj, new Date());
                        }
                    }catch (IllegalArgumentException e){
                       break;

                    }
                    break;

                case "updateBy":

                    break;
                default:
                    break;
            }
        }
        return executor.update(ms, paramObj);
    }
 
    /**
     * 新增操作
     *
     * @param executor executor
     * @param ms       ms
     * @param paramObj 参数
     * @return 返回执行结果
     */
    private Object executeDelete(final Executor executor, final MappedStatement ms, final Object paramObj) throws Exception {
        final Field[] fields = paramObj.getClass().getDeclaredFields();
        for (final Field field : fields) {
            field.setAccessible(true);
            final String fieldName = field.getName();
            switch (fieldName) {
                case "deleted":
                    //field.set(paramObj, true);
                    break;
                default:
                    break;
            }
        }
        return executor.update(ms, paramObj);
    }
}