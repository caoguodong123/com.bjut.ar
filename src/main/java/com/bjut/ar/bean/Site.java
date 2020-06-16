package com.bjut.ar.bean;

public class Site {
    private Integer id;
    private Integer gid;
    private Double horizontal;
    private Double vertical;
    private Double x;
    private Double y;
    private Double compass;
    private String content;

    @Override
    public String toString() {
        return "Site{" +
                "id=" + id +
                ", gid=" + gid +
                ", horizontal=" + horizontal +
                ", vertical=" + vertical +
                ", x=" + x +
                ", y=" + y +
                ", compass=" + compass +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Double getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(Double horizontal) {
        this.horizontal = horizontal;
    }

    public Double getVertical() {
        return vertical;
    }

    public void setVertical(Double vertical) {
        this.vertical = vertical;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getCompass() {
        return compass;
    }

    public void setCompass(Double compass) {
        this.compass = compass;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
