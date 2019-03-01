package whut.pojo;

import java.io.Serializable;

/**
 * 管理员分类
 * @author wangql
 *
 */
public class ManagerCategory implements Serializable {
    private Integer categoryId; //分类id

    private Integer level; //级别

    private String name;  //级别对应的名字

    private String describe;  //职位描述

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}