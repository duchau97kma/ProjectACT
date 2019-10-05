package DTO;

import java.util.Date;

public class Images {
    private int id_img;
    private String nameImages;
    private double size;
    private Date create_at;

    public Images() {
    }

    public Images(int id_img, String nameImages) {
        this.id_img = id_img;
        this.nameImages = nameImages;
    }

    public Images(String nameImages) {
        this.nameImages = nameImages;
    }

    public Images(int id_img, String nameImages, double size, Date create_at) {
        this.id_img = id_img;
        this.nameImages = nameImages;
        this.size = size;
        this.create_at = create_at;
    }

    public int getId_img() {
        return id_img;
    }

    public void setId_img(int id_img) {
        this.id_img = id_img;
    }

    public String getNameImages() {
        return nameImages;
    }

    public void setNameImages(String nameImages) {
        this.nameImages = nameImages;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    @Override
    public String toString() {
        return "Images{" +
                "id_img=" + id_img +
                ", nameImages='" + nameImages + '\'' +
                ", size=" + size +
                ", create_at=" + create_at +
                '}';
    }
}
