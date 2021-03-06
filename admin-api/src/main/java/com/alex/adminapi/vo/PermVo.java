package com.alex.adminapi.vo;

import java.util.List;

/**
 * @Description:
 * @Author:     alex
 * @CreateDate: 2019/8/5 14:46
 * @Version:    1.0
 *
*/
public class PermVo {

    private String id;

    private String label;

    private String api;

    private List<PermVo> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public List<PermVo> getChildren() {
        return children;
    }

    public void setChildren(List<PermVo> children) {
        this.children = children;
    }
}
