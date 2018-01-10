package com.mydemo.model;

/**
 * Created by apple on 18/1/8.
 */

public class CommonMessage {
    private int key;
    private String msg;
    private Object content;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommonMessage{" +
                "key=" + key +
                ", msg='" + msg + '\'' +
                ", content=" + content +
                '}';
    }
}
