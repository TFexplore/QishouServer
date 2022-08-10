package com.zhaishu.qishouserver.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 商品快照表
当商品表里的价格、名称、图片有改动时将原来的值保存到本表中(TGoodsSs)实体类
 *
 * @author makejava
 * @since 2022-06-24 14:06:26
 */
public class TGoodsSs implements Serializable {
    private static final long serialVersionUID = -42136425374405219L;
    /**
     * 商品快照表主键，自增
     */
    private Long id;
    /**
     * 复制下来的商品id
     */
    private Long goodsId;
    /**
     * 改动时的商品名
     */
    private String name;
    /**
     * 改动时的卖价
     */
    private Double sellPrice;
    /**
     * 改动时的原价
     */
    private Double originalPrice;
    /**
     * 改动时的图片地址
     */
    private String pictureUrl;

    //商品数量
    private Integer goodsQuantity;
    /**
     * 创建时间
     */
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

