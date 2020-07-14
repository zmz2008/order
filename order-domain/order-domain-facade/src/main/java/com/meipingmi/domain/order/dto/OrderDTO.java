package com.meipingmi.domain.order.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/***
 * @Description : TODO
 * @Author : zhoumiaozhong
 * @Date : 2020/7/14-15:17
 */
@Data
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = -8527150839622758299L;
    private Long id;

    private Date createTime;

    private Date deleteTime;

    private Date modifyTime;

    private Boolean valid;

    private Integer version;

    private Boolean autoconfirm;

    private Long businessid;

    private Double carriage;

    private String ip;

    private String memo;

    private String openid;

    private String ordernum;

    private Double price;

    private Date receivetime;

    private Date sendtime;

    private Long shopid;

    @ApiModelProperty(value = "状态 0待支付 1待发货  2待收货 7已收货（用户确认收货、物流信息异常、定时器15天之后） 3已完成（已收货7天之后自动已完成） 4已退款5已下单（货到付款专用，相当于下单，商家可以发货了） -1 已取消 6未退款（用户申请退款的状态）")
    private Integer status;

    private Date time;

    @ApiModelProperty(value = "用户ID")
    private String userid;

    private Long addressId;

    //private String businessname;
    private String businessnameA;

    private Double originalprice;

    private Long suporderId;

    @ApiModelProperty(value = "2为店铺转发订单， 默认不填为普通平台订单")
    private Integer type;

    private Date newReceiveTime;

    private Integer orderVersion;

    @ApiModelProperty(value = "第三方商家备注")
    private String busmemo;

    @ApiModelProperty(value = "买家备注")
    private String remark;

    private Integer delayDays;

    private Double originalcarriage;

    @ApiModelProperty(value = "买家支付订单号")
    private String payordernum;

    @ApiModelProperty(value = "买家支付价格")
    private Double payprice;

    @ApiModelProperty(value = "超值套餐id")
    private Long mealId;

    @ApiModelProperty(value = "app用户端版本号")
    private Integer appversion;

    @ApiModelProperty(value = "平台券id")
    private Long platCouponuser;

    @ApiModelProperty(value = "平台券金额")
    private Double platAmount;

    @ApiModelProperty(value = "店铺券id")
    private Long busiCouponuser;

    @ApiModelProperty(value = "店铺券金额")
    private Double busiAmount;
}
