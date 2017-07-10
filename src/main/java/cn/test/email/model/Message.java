package cn.test.email.model;

import java.util.Date;

public class Message {
    private Integer id;

    private String senduname;

    private String receiveuname;

    private Date posttime;

    private String note;

    private Integer readsign;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenduname() {
        return senduname;
    }

    public void setSenduname(String senduname) {
        this.senduname = senduname == null ? null : senduname.trim();
    }

    public String getReceiveuname() {
        return receiveuname;
    }

    public void setReceiveuname(String receiveuname) {
        this.receiveuname = receiveuname == null ? null : receiveuname.trim();
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getReadsign() {
        return readsign;
    }

    public void setReadsign(Integer readsign) {
        this.readsign = readsign;
    }
}