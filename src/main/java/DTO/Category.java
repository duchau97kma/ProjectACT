package DTO;

public class Category {
    private int id_cate;
    private String nameCate;

    public Category() {
    }

    public Category(String nameCate) {
        this.nameCate = nameCate;
    }

    public Category(int id_cate, String nameCate) {
        this.id_cate = id_cate;
        this.nameCate = nameCate;
    }

    public int getId_cate() {
        return id_cate;
    }

    public void setId_cate(int id_cate) {
        this.id_cate = id_cate;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id_cate=" + id_cate +
                ", nameCate='" + nameCate + '\'' +
                '}';
    }
}
