package Model;

import DBConnect.DBConnector;
import DTO.Images;
import Service.IManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImagesModel implements IManager<Images> {
    private Connection conn;
    public ImagesModel() {
        DBConnector db = new DBConnector();
        this.conn = db.getConnection();
    }

    @Override
    public List<Images> getAll() {
        List<Images> list = new ArrayList<>();
        String sql ="SELECT * FROM Images";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Images images = new Images();
                images.setId_img(rs.getInt("id_img"));
                images.setNameImages(rs.getString("nameImages"));
                images.setSize(rs.getInt("size"));
                images.setCreate_at(rs.getDate("create_at"));
                list.add(images);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Images> getAllMem(int page) {
        List<Images> list = new ArrayList<>();
        String sql ="SELECT * FROM Images LIMIT ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,ImagesModel.ROW_PER_PAGE * (page - 1));
            ps.setInt(2, ImagesModel.ROW_PER_PAGE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Images images = new Images();
                images.setId_img(rs.getInt("id_img"));
                images.setNameImages(rs.getString("nameImages"));
                images.setSize(rs.getInt("size"));
                images.setCreate_at(rs.getDate("create_at"));
                list.add(images);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public List<Images> getAllImages(int limit, int offset){
        List<Images> list = new ArrayList<>();
        String sql = "SELECT * FROM Images LIMIT ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,offset);
            ps.setInt(2,limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Images images = new Images();
                images.setId_img(rs.getInt("id_img"));
                images.setNameImages(rs.getString("nameImages"));
                images.setSize(rs.getInt("size"));
                images.setCreate_at(rs.getDate("create_at"));
                list.add(images);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }
    @Override
    public void Add(Images images) {
        String sql ="INSERT INTO Images(nameImages,size) VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,images.getNameImages());
            ps.setDouble(2,images.getSize());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public Images getById(int id) {
       Images images = null;
       String sql ="SELECT * FROM Images WHERE id_img=?";
       try {
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1,id);
           ResultSet rs = ps.executeQuery();
           while (rs.next()){
               String name = rs.getString("nameImages");
               double size = rs.getDouble("size");
               Date create_at =rs.getDate("create_at");
               images = new Images(id,name,size,create_at);
           }

       }catch (Exception e){
           e.printStackTrace();
       }

       return images;
    }

    @Override
    public void update(Images images) {
        String sql ="UPDATE Images SET nameImages=?, size=? WHERE id_img=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,images.getNameImages());
            ps.setDouble(2,images.getSize());
            ps.setInt(3,images.getId_img());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql= "DELETE FROM Images WHERE id_img=?";
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
        String sql ="SELECT COUNT(*) as 'SUM' FROM Images";
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
        ImagesModel model = new ImagesModel();
        Images images = new Images();
        for (Images img: model.getAllImages(3,0)
             ) {
            System.out.println(img.toString());
        }
    }

}
