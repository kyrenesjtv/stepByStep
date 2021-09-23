package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean;

import java.util.List;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/9/17 17:57
 */
public class MenuTreeDto {
    private Long id;
    private String perms;
    private String title;
    List<MenuTreeDto> childrenList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MenuTreeDto> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<MenuTreeDto> childrenList) {
        this.childrenList = childrenList;
    }
}
