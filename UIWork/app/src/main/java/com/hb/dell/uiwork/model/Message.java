package com.hb.dell.uiwork.model;

public class Message {
    public static final String TYPE_RECEIVED = "0";
    public static final String TYPE_SENT = "1";

    private String type;
    private String content;

    public Message(){

    }

    public Message(String type, String content){
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
