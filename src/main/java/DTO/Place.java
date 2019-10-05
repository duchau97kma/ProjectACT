package DTO;

public class Place {
    private int id_place;
    private String namePlace;
    private String summary;
    private int id_img;
    private Images images;

    public Place() {
    }

    public Place(String namePlace) {
        this.namePlace = namePlace;
    }

    public Place(int id_place, String namePlace) {
        this.id_place = id_place;
        this.namePlace = namePlace;
    }

    public Place(int id_place, String namePlace, String summary, int id_img, Images images) {
        this.id_place = id_place;
        this.namePlace = namePlace;
        this.summary = summary;
        this.id_img = id_img;
        this.images = images;
    }

    public Place(int id_place, String namePlace, String summary, int id_img) {
        this.id_place = id_place;
        this.namePlace = namePlace;
        this.summary = summary;
        this.id_img = id_img;
    }

    public int getId_place() {
        return id_place;
    }

    public void setId_place(int id_place) {
        this.id_place = id_place;
    }

    public String getNamePlace() {
        return namePlace;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getId_img() {
        return id_img;
    }

    public void setId_img(int id_img) {
        this.id_img = id_img;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id_place=" + id_place +
                ", namePlace='" + namePlace + '\'' +
                ", summary='" + summary + '\'' +
                ", id_img=" + id_img +
                ", nameImage=" + images.getNameImages() +
                '}';
    }

}
