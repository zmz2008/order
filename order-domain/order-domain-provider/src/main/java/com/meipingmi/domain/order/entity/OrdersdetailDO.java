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
@TableName("ordersdetail")
@ApiModel(value="OrdersdetailDO对象", description="")
public class OrdersdetailDO implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Date createTime;

    private Date deleteTime;

    private Date modifyTime;

    private Boolean valid;

    @Version
    private Integer version;

    private String attrname;

    private String name;

    private Integer num;

    private String ordernum;

    private String piclogo;

    private Double price;

    private Integer ptype;

    private Double total;

    private String userid;

    private Long attrId;

    private Long orderId;

    private Long productId;

    private Long traproductId;

    private Long returngoodsId;

    private Double cash;

    private Long logistics;

    @ApiModelProperty(value = "商品佣金比例")
    private Integer commission;

    private Double originalprice;

    @ApiModelProperty(value = "直播id")
    private Long lpid;

    @ApiModelProperty(value = "抢购id")
    private Long rushId;

    @ApiModelProperty(value = "折扣id")
    private Long discountId;

    @ApiModelProperty(value = "app用户端版本号")
    private Integer appversion;

    @ApiModelProperty(value = "混批id")
    private Long mixsaleId;

    @ApiModelProperty(value = "混批价格")
    private Double mixsalePrice;

    @ApiModelProperty(value = "打包id")
    private Long packsaleId;

    @ApiModelProperty(value = "打包方案")
    private Integer plan;

    @ApiModelProperty(value = "平台券id")
    private Long platCouponuser;

    @ApiModelProperty(value = "店铺券id")
    private Long busiCouponuser;

    @ApiModelProperty(value = "平台券金额")
    private Double platAmount;


}
