package com.zhaishu.qishouserver.Vo;

import com.zhaishu.qishouserver.entity.TGoodsSs;

import java.util.List;

public class OrderVo {

    Integer id;
    //订单编号
    String orderId;
    //收货人id
    Integer buyerId;
    //商铺id
    Integer shopId;
    //收货人姓名
    String buyerName;
    //收获楼栋
    String buyerApart;
    //收获手机号
    String buyerPhone;
    //楼栋
    Integer apartmentId;
    //收货地址
    String address;
    //配送骑手信息
    ShipRiderVo rider;

    Integer statusCode;
    //订单状态
    String status;
    //订单完成时间
    Long completeTime;
    //支付时间
    Long payTime;
    //创建时间
    Long createTime;

    //配送方式：115送货上门，116送至楼下
    Integer buyerWill;
    //商品列表
    List<TGoodsSs> goodsList;
    //订单金额
    double payPrice;
    //配送费
    double shippingFee;
    //折扣
    double discountAmount;
    //备注
    String remark;
    String refundRemark;
    //商品数量
    Integer goodsQuantity;

    public OrderVo() {
    }

    public Integer getBuyerWill() {
        return buyerWill;
    }

    public void setBuyerWill(Integer buyerWill) {
        this.buyerWill = buyerWill;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getRefundRemark() {
        return refundRemark;
    }

    public void setRefundRemark(String refundRemark) {
        this.refundRemark = refundRemark;
    }

    public Integer getId() {
        return id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<TGoodsSs> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<TGoodsSs> goodsList) {
        this.goodsList = goodsList;
    }

    public double getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(double payPrice) {
        this.payPrice = payPrice;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(Integer goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerApart() {
        return buyerApart;
    }

    public void setBuyerApart(String buyerApart) {
        this.buyerApart = buyerApart;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public ShipRiderVo getRider() {
        return rider;
    }

    public void setRider(ShipRiderVo rider) {
        this.rider = rider;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Long completeTime) {
        this.completeTime = completeTime;
    }
}
