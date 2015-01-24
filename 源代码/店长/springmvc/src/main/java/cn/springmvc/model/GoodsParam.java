package cn.springmvc.model;

import java.util.Date;

public class GoodsParam {
    private Integer id;

    private Integer goodsId;

    private Integer lackThreshold;

    private Integer backlogThreshold;

    private Integer count;

    private Date createTime;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getLackThreshold() {
        return lackThreshold;
    }

    public void setLackThreshold(Integer lackThreshold) {
        this.lackThreshold = lackThreshold;
    }

    public Integer getBacklogThreshold() {
        return backlogThreshold;
    }

    public void setBacklogThreshold(Integer backlogThreshold) {
        this.backlogThreshold = backlogThreshold;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}