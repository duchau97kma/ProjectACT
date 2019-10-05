package Model;

import DBConnect.DBConnector;
import DTO.Images;
import DTO.Place;
import Service.IManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlaceModel implements IManager<Place> {
    private Connection conn;

    public PlaceModel() {
        DBConnector db = new DBConnector();
        this.conn = db.getConnection();
    }

    @Override
    public List<Place> getAll() {
        List<Place> list = new ArrayList<>();
        String sql = "select Place.*, Images.nameImages From Place,Images WHERE Place.id_img = Images.id_img";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Place place = new Place();
               place.setId_place(rs.getInt("id_place"));
               place.setNamePlace(rs.getString("namePlace"));
               place.setSummary(rs.getString("summaryPlace"));
               place.setId_img(rs.getInt("id_img"));
               place.setImages(new Images(rs.getInt("id_img"),rs.getString("nameImages")));
                list.add(place);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<Place> getAll(int limit,int offset) {
        List<Place> list = new ArrayList<>();
        String sql = "select Place.*, Images.nameImages From Place,Images WHERE Place.id_img = Images.id_img LIMIT ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,offset);
            ps.setInt(2,limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Place place = new Place();
                place.setId_place(rs.getInt("id_place"));
                place.setNamePlace(rs.getString("namePlace"));
                place.setSummary(rs.getString("summaryPlace"));
                place.setId_img(rs.getInt("id_img"));
                place.setImages(new Images(rs.getInt("id_img"),rs.getString("nameImages")));
                list.add(place);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Place> getAllMem(int page) {
        List<Place> list = new ArrayList<>();
        String sql ="select Place.*, Images.nameImages From Place,Images WHERE Place.id_img = Images.id_img LIMIT ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,PlaceModel.ROW_PER_PAGE * (page - 1));
            ps.setInt(2, PlaceModel.ROW_PER_PAGE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Place place = new Place();
                place.setId_place(rs.getInt("id_place"));
                place.setNamePlace(rs.getString("namePlace"));
                place.setSummary(rs.getString("summaryPlace"));
                place.setId_img(rs.getInt("id_img"));
                place.setImages(new Images(rs.getInt("id_img"),rs.getString("nameImages")));
                list.add(place);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public void Add(Place place) {
        String sql ="INSERT INTO `TourManager`.`Place` (`namePlace`, `summaryPlace`, `id_img`) VALUES (?,?,?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,place.getNamePlace());
            ps.setString(2,place.getSummary());
            ps.setInt(3,place.getId_img());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Place getById(int id) {
        Place place = null;
        String sql ="select * From Place,Images WHERE Place.id_img = Images.id_img && id_place=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                place = new Place();
                place.setId_place(id);
                place.setNamePlace(rs.getString("namePlace"));
                place.setSummary(rs.getString("summaryPlace"));
                place.setId_img(rs.getInt("id_img"));
                place.setImages(new Images(rs.getInt("id_img"),rs.getString("nameImages")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return place;
    }

    @Override
    public void update(Place place) {
        String sql = "UPDATE Place SET namePlace=?,summaryPlace=?,id_img=? WHERE id_place=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,place.getNamePlace());
            ps.setString(2,place.getSummary());
            ps.setInt(3,place.getId_img());
            ps.setInt(4,place.getId_place());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Place WHERE id_place=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int count() {
        String sql ="SELECT COUNT(*) as 'SUM' From Place,Images WHERE Place.id_img = Images.id_img";
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
        PlaceModel model = new PlaceModel();
        Place place = new Place();

//        place.setNamePlace("Hà Nội ");
//        place.setSummary("mnk");
//        place.setId_img(1);
//        place.setId_place(1);
//        model.update(place);
        for (Place p: model.getAll(6,0)
             ) {
            System.out.println(p.toString());
        }
    }

}
