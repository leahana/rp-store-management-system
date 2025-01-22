package top.yannyi.courtyardWu.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.io.Serializable;

/**
 * 评论表：每条评论包含用户、店铺和评论内容，通过user_id和shop_id与用户表、店铺表关联。(TComments)实体类
 *
 * @author anshengyo
 * @since 2025-01-20 12:26:13
 */

@TableName("t_comments")
public class TComments implements Serializable {
    private static final long serialVersionUID = 944586731033229793L;
    /**
     * 评论ID
     */
    @TableId(value = "id")
    private String id;
    /**
     * 用户ID (关联用户表中的id，表示评论由哪个用户发出)
     */
    private Integer userId;
    /**
     * 店铺ID (关联店铺表中的id，表示评论属于哪个店铺)
     */
    private Integer shopId;
    /**
     * 评论内容
     */
    private String commentText;
    /**
     * 评分 (1到5星)
     */
    private Integer rating;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
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

