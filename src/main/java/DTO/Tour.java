package DTO;

import java.util.Date;

public class Tour {
    private int id_tour;
    private String nameTour;
    private String content;
    private String summaryTour;
    private String departureDate;
    private double price;
    private double discount;
    private int id_place;
    private int id_cate;
    private int id_img;
    private Place place;
    private Category category;
    private Images images;
    private int totalMember;

    public int getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(int totalMember) {
        this.totalMember = totalMember;
    }

    public Tour() {
    }

    public Tour(String nameTour) {
        this.nameTour = nameTour;
    }

    public Tour(int id_tour, String nameTour, String content, String summaryTour, String departureDate, double price, double discount, int id_place, int id_cate, int id_img, int totalMember) {
        this.id_tour = id_tour;
        this.nameTour = nameTour;
        this.content = content;
        this.summaryTour = summaryTour;
        this.departureDate = departureDate;
        this.price = price;
        this.discount = discount;
        this.id_place = id_place;
        this.id_cate = id_cate;
        this.id_img = id_img;
        this.totalMember = totalMember;
    }

    public Tour(int id_tour, String nameTour, String content, String summaryTour, String departureDate, double price, double discount, int id_place, int id_cate, int id_img, Place place, Category category, Images images, int totalMember) {
        this.id_tour = id_tour;
        this.nameTour = nameTour;
        this.content = content;
        this.summaryTour = summaryTour;
        this.departureDate = departureDate;
        this.price = price;
        this.discount = discount;
        this.id_place = id_place;
        this.id_cate = id_cate;
        this.id_img = id_img;
        this.place = place;
        this.category = category;
        this.images = images;
        this.totalMember = totalMember;
    }

    public Tour(int id_tour, String nameTour, String content, String summary, String departureDate, double price, double discount, int id_place, int id_cate, int id_img, Place place, Category category, Images images) {
        this.id_tour = id_tour;
        this.nameTour = nameTour;
        this.content = content;
        this.summaryTour = summaryTour;
        this.departureDate = departureDate;
        this.price = price;
        this.discount = discount;
        this.id_place = id_place;
        this.id_cate = id_cate;
        this.id_img = id_img;
        this.place = place;
        this.category = category;
        this.images = images;
    }

    public Tour(String nameTour, String content, String summaryTour, String departureDate, double price, double discount, int id_place, int id_cate, int id_img, Place place, Category category, Images images) {
        this.nameTour = nameTour;
        this.content = content;
        this.summaryTour = summaryTour;
        this.departureDate = departureDate;
        this.price = price;
        this.discount = discount;
        this.id_place = id_place;
        this.id_cate = id_cate;
        this.id_img = id_img;
        this.place = place;
        this.category = category;
        this.images = images;
    }

    public Tour(int id_tour, String nameTour, String content, String summaryTour, String departureDate, double price, double discount, int id_place, int id_cate, int id_img) {
        this.id_tour = id_tour;
        this.nameTour = nameTour;
        this.content = content;
        this.summaryTour = summaryTour;
        this.departureDate = departureDate;
        this.price = price;
        this.discount = discount;
        this.id_place = id_place;
        this.id_cate = id_cate;
        this.id_img = id_img;
    }

    public Tour(String nameTour, String content, String summaryTour, String departureDate, double price, double discount, int id_place, int id_cate, int id_img) {
        this.nameTour = nameTour;
        this.content = content;
        this.summaryTour = summaryTour;
        this.departureDate = departureDate;
        this.price = price;
        this.discount = discount;
        this.id_place = id_place;
        this.id_cate = id_cate;
        this.id_img = id_img;
    }

    public int getId_tour() {
        return id_tour;
    }

    public void setId_tour(int id_tour) {
        this.id_tour = id_tour;
    }

    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummaryTour() {
        return summaryTour;
    }

    public void setSummaryTour(String summaryTour) {
        this.summaryTour = summaryTour;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getId_place() {
        return id_place;
    }

    public void setId_place(int id_place) {
        this.id_place = id_place;
    }

    public int getId_cate() {
        return id_cate;
    }

    public void setId_cate(int id_cate) {
        this.id_cate = id_cate;
    }

    public int getId_img() {
        return id_img;
    }

    public void setId_img(int id_img) {
        this.id_img = id_img;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id_tour=" + id_tour +
                ", nameTour='" + nameTour + '\'' +
                ", content='" + content + '\'' +
                ", summaryTour='" + summaryTour + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", id_place=" + id_place +
                ", id_cate=" + id_cate +
                ", id_img=" + id_img +
                ", place=" + place.getNamePlace() +
                ", category=" + category.getNameCate() +
                ", images=" + images.getNameImages() +
                ", totalMember=" + totalMember +
                '}';
    }
}
