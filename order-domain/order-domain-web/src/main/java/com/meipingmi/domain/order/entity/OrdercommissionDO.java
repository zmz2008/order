package com.meipingmi.domain.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author mpm
 * @since 2020-07-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ordercommission")
@ApiModel(value="OrdercommissionDO对象", description="")
public class OrdercommissionDO implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "订单号")
    private String ordernum;

    @ApiModelProperty(value = "订单金额")
    private Double orderprice;

    @ApiModelProperty(value = "推客用户ID")
    private Long userid;

    @ApiModelProperty(value = "商户ID")
    private Long businessid;

    @ApiModelProperty(value = "实际收益")
    private Double realmoney;

    @ApiModelProperty(value = "交易净额")
    private Double surplus;

    @ApiModelProperty(value = "交易手续费")
    private Double charge;

    @ApiModelProperty(value = "平台使用费")
    private Double platmoney;

    @ApiModelProperty(value = "商品净交易额")
    private Double goodssurplus;

    @ApiModelProperty(value = "佣金")
    private Double money;

    @ApiModelProperty(value = "类型 1支付成功;2发货前退款;3结算;4版本升级结转;5提现;6提现返回 ")
    private Integer moneytype;

    @ApiModelProperty(value = "退款金额")
    private Double returnmoney;

    @ApiModelProperty(value = "平台券返回金额")
    private Double couponbackmoney;

    @ApiModelProperty(value = "买家可提现余额")
    private Double buyersmoney;

    @ApiModelProperty(value = "商家可提现余额")
    private Double busimoney;

    private Date createTime;

    private Date deleteTime;

    private Date modifyTime;

    private Boolean valid;

    @Version
    private Integer version;

    @ApiModelProperty(value = "订单有效销售数量")
    private Integer realnum;


}
