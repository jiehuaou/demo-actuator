package com.example.demo.pojo;

public class MyDoc {
    private String id;
    private String data;

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    private String other;

    public MyDoc() {
    }
    public MyDoc(String id, String data, String other) {
        this.id = id;
        this.data = data;
        this.other = other;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
