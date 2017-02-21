package com.ecps.common.bean;

/**
 * 封装EasyUI树
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-20 下午 02:16
 */
public class EasyUITreeNode {

    private long id;

    private String text;

    private String state;

    public EasyUITreeNode() {
        super();
    }

    public EasyUITreeNode(long id, String text, String state) {
        super();
        this.id = id;
        this.text = text;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "EasyUITreeNode [id=" + id + ", text=" + text + ", state=" + state + "]";
    }
}
