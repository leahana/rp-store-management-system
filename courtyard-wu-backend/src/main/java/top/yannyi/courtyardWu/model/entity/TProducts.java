package top.yannyi.courtyardWu.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.io.Serializable;

/**
 * 商品表：包含每个店铺的商品信息，每个商品属于一个店铺，通过shop_id与店铺表关联。(TProducts)实体类
 *
 * @author anshengyo
 * @since 2025-01-20 12:26:28
 */
@TableName("t_products")
public class TProducts implements Serializable {
    private static final long serialVersionUID = 583447801820831653L;
    /**
     * 商品ID
     */
    @TableId(value = "id")
    private String id;
    /**
     * 店铺ID (关联店铺表中的id，表示商品属于哪个店铺)
     */
    private String shopId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品价格
     */
    private Double price;

    /**
     * 图片地址
     */
    private String picture;

    /**
     * 商品描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 最后更新时间
     */
    private Date updatedAt;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

