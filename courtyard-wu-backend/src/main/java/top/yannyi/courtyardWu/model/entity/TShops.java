package top.yannyi.courtyardWu.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.io.Serializable;

/**
 * 店铺表：包含店铺信息，每个店铺由一个用户管理，用户通过owner_id字段关联。(TShops)实体类
 *
 * @author anshengyo
 * @since 2025-01-20 12:26:28
 */
@TableName("t_shops")
public class TShops implements Serializable {
    private static final long serialVersionUID = -99978046243475933L;
    /**
     * 店铺ID
     */
    @TableId

    private String id;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 店铺管理员ID (关联用户表中的id，表示店铺管理员)
     */
    private String ownerId;
    /**
     * 店铺描述
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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
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
}

