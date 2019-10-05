package Model;

import DBConnect.DBConnector;
import DTO.Category;
import DTO.Tour;
import Service.IManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryModel implements IManager<Category> {
    private Connection conn;

    public CategoryModel() {
        DBConnector db = new DBConnector();
        this.conn = db.getConnection();
    }

    @Override
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String sql ="SELECT * FROM Category";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Category category = new Category();
                category.setId_cate(rs.getInt("id_cate"));
                category.setNameCate(rs.getString("nameCate"));
                list.add(category);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Category> getAllMem(int page) {
        List<Category> list = new ArrayList<>();
        String sql ="SELECT * FROM Category LIMIT ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,CategoryModel.ROW_PER_PAGE * (page - 1));
            ps.setInt(2, CategoryModel.ROW_PER_PAGE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Category category = new Category();
                category.setId_cate(rs.getInt("id_cate"));
                category.setNameCate(rs.getString("nameCate"));
                list.add(category);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public void Add(Category category) {
        String sql ="INSERT INTO Category(nameCate) VALUES (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,category.getNameCate());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Category getById(int id) {
       Category category = null;
       String sql ="SELECT * FROM Category WHERE id_cate=?";
       try {
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1,id);
           ResultSet rs = ps.executeQuery();
           while (rs.next()){
               String name = rs.getString("nameCate");
               category = new Category(id,name);
           }
       }catch (Exception e){
           e.printStackTrace();
       }
       return category;
    }

    @Override
    public void update(Category category) {
        String sql ="UPDATE Category SET nameCate=? WHERE id_cate=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,category.getNameCate());
            ps.setInt(2,category.getId_cate());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql="DELETE FROM Category WHERE id_cate=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int count() {

        String sql ="SELECT COUNT(*) as 'SUM' FROM Category";
        int sum=0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                sum = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sum;
    }

    public static void main(String[] args) {
        CategoryModel model = new CategoryModel();
        Category category = new Category();
        category.setNameCate("Du lịch Mỹ");
        category.setId_cate(1);
        model.update(category);
//        model.Add(category);
        for (Category c:model.getAll()
             ) {
            System.out.println(c.toString());
        }

    }

}
