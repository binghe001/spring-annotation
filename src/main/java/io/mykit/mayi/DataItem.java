package io.mykit.mayi;

/**
 * @author binghe
 * @version 1.0.0
 * @description 数据实体模型
 */
public class DataItem {

    /**
     * id
     */
    private String id;
    /**
     * 分组
     */
    private String groupId;
    /**
     * 指标
     */
    private Float quota;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    public Float getQuota() {
        return quota;
    }
    public void setQuota(Float quota) {
        this.quota = quota;
    }

}