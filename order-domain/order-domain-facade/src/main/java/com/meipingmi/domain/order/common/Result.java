package com.meipingmi.domain.order.common;

import lombok.Data;

import java.io.Serializable;
/**
 * @Author : wuzhifei
 * @Description : 该对象会在公共的jar包提供
 * @Date : 2020/7/15-16:09
 * @Param :
 * @return :
 **/
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -4411108418398147363L;
    /**
     * 状态码,200表示成功，400表示失败
     */
    private Integer status;
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 数据载体
     */
    private T data;

    Result(Integer status,String code,String message,T data){
        this.status=status;
        this.code=code;
        this.message=message;
        this.data= data;
    }

    public static Result  ok(Object data){
        return new Result(200,"00000","success",data);
    }

    public static Result  ok(String message,Object data){
        return new Result(200,"00000",message,data);
    }

    public static Result  ok(String code,String message,Object data){
        return new Result(200,code,message,data);
    }

    public static Result fail(String code,String message,Object data){
        return new Result(400,code,message,data);
    }

}
