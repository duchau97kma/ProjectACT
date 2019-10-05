package Model;

import DBConnect.DBConnector;
import DTO.Category;
import DTO.Images;
import DTO.Place;
import DTO.Tour;
import Service.IManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TourModel implements IManager<Tour> {
    private Connection conn;
    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    public TourModel() {
        DBConnector db = new DBConnector();
        this.conn = db.getConnection();
    }
    @Override
    public List<Tour> getAll() {
        List<Tour> list = new ArrayList<>();
        String sql = "select Tour.id_tour, Tour.nameTour,Tour.content,Tour.summaryTour,Tour.departureDate,Tour.price,Tour.discount,Place.namePlace,Category.nameCate,Images.nameImages,Tour.totalMember \n" +
                "from Tour \n" +
                "join Place on Tour.id_place = Place.id_place \n" +
                "join Category on Tour.id_cate = Category.id_cate\n" +
                "join Images on Tour.id_img = Images.id_img";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tour tour1 = new Tour();
                tour1.setId_tour(rs.getInt("id_tour"));
                tour1.setNameTour(rs.getString("nameTour"));
                tour1.setTotalMember(rs.getInt("totalMember"));
                tour1.setContent(rs.getString("content"));
                tour1.setSummaryTour(rs.getString("summaryTour"));
                tour1.setDepartureDate(rs.getString("departureDate"));
                tour1.setPrice(rs.getDouble("price"));
                tour1.setDiscount(rs.getDouble("discount"));
                tour1.setPlace(new Place(rs.getString("namePlace")));
                tour1.setCategory(new Category(rs.getString("nameCate")));
                tour1.setImages(new Images(rs.getString("nameImages")));
                list.add(tour1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Tour> getAll(int limit,int offset) {
        List<Tour> list = new ArrayList<>();
        String sql = "select Tour.id_tour, Tour.nameTour,Tour.content,Tour.summaryTour,Tour.departureDate,Tour.price,Tour.discount,Place.namePlace,Category.nameCate,Images.nameImages,Tour.totalMember \n" +
                "from Tour \n" +
                "join Place on Tour.id_place = Place.id_place \n" +
                "join Category on Tour.id_cate = Category.id_cate\n" +
                "join Images on Tour.id_img = Images.id_img LIMIT ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,offset);
            ps.setInt(2,limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tour tour1 = new Tour();
                tour1.setId_tour(rs.getInt("id_tour"));
                tour1.setNameTour(rs.getString("nameTour"));
                tour1.setTotalMember(rs.getInt("totalMember"));
                tour1.setContent(rs.getString("content"));
                tour1.setSummaryTour(rs.getString("summaryTour"));
                tour1.setDepartureDate(rs.getString("departureDate"));
                tour1.setPrice(rs.getDouble("price"));
                tour1.setDiscount(rs.getDouble("discount"));
                tour1.setPlace(new Place(rs.getString("namePlace")));
                tour1.setCategory(new Category(rs.getString("nameCate")));
                tour1.setImages(new Images(rs.getString("nameImages")));
                list.add(tour1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Tour> getAllByCateVN() {
        List<Tour> list = new ArrayList<>();
        String sql = "select Tour.id_tour ,Tour.nameTour,Tour.content,Tour.summaryTour,Tour.departureDate,Tour.price,Tour.discount,Place.namePlace,Category.nameCate,Images.nameImages ,price,Tour.totalMember\n" +
                "from Tour \n" +
                "join Place on Tour.id_place = Place.id_place \n" +
                "join Category on Tour.id_cate = Category.id_cate\n" +
                "join Images on Tour.id_img = Images.id_img where Category.id_cate=1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tour tour1 = new Tour();
                tour1.setId_tour(rs.getInt("id_tour"));
                tour1.setNameTour(rs.getString("nameTour"));
                tour1.setTotalMember(rs.getInt("totalMember"));
                tour1.setContent(rs.getString("content"));
                tour1.setSummaryTour(rs.getString("summaryTour"));
                tour1.setDepartureDate(rs.getString("departureDate"));
                tour1.setPrice(rs.getDouble("price"));
                tour1.setDiscount(rs.getDouble("discount"));
                tour1.setPlace(new Place(rs.getString("namePlace")));
                tour1.setCategory(new Category(rs.getString("nameCate")));
                tour1.setImages(new Images(rs.getString("nameImages")));
                list.add(tour1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Tour> getAllByCateVN(int limit,int offset) {
        List<Tour> list = new ArrayList<>();
        String sql = "select Tour.id_tour, Tour.nameTour,Tour.content,Tour.summaryTour,Tour.departureDate,Tour.price,Tour.discount,Place.namePlace,Category.nameCate,Images.nameImages,Tour.totalMember \n" +
                "from Tour \n" +
                "join Place on Tour.id_place = Place.id_place \n" +
                "join Category on Tour.id_cate = Category.id_cate\n" +
                "join Images on Tour.id_img = Images.id_img WHERE Category.id_cate=1 LIMIT ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,offset);
            ps.setInt(2,limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tour tour1 = new Tour();
                tour1.setId_tour(rs.getInt("id_tour"));
                tour1.setNameTour(rs.getString("nameTour"));
                tour1.setTotalMember(rs.getInt("totalMember"));
                tour1.setContent(rs.getString("content"));
                tour1.setSummaryTour(rs.getString("summaryTour"));
                tour1.setDepartureDate(rs.getString("departureDate"));
                tour1.setPrice(rs.getDouble("price"));
                tour1.setDiscount(rs.getDouble("discount"));
                tour1.setPlace(new Place(rs.getString("namePlace")));
                tour1.setCategory(new Category(rs.getString("nameCate")));
                tour1.setImages(new Images(rs.getString("nameImages")));
                list.add(tour1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Tour> getAllByCateInt() {
        List<Tour> list = new ArrayList<>();
        String sql = "select Tour.id_tour ,Tour.nameTour,Tour.content,Tour.summaryTour,Tour.departureDate,Tour.price,Tour.discount,Place.namePlace,Category.nameCate,Images.nameImages,price,Tour.totalMember\n" +
                "from Tour \n" +
                "join Place on Tour.id_place = Place.id_place \n" +
                "join Category on Tour.id_cate = Category.id_cate\n" +
                "join Images on Tour.id_img = Images.id_img where Category.id_cate=2";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tour tour1 = new Tour();
                tour1.setId_tour(rs.getInt("id_tour"));
                tour1.setNameTour(rs.getString("nameTour"));
                tour1.setTotalMember(rs.getInt("totalMember"));
                tour1.setContent(rs.getString("content"));
                tour1.setSummaryTour(rs.getString("summaryTour"));
                tour1.setDepartureDate(rs.getString("departureDate"));
                tour1.setPrice(rs.getDouble("price"));
                tour1.setDiscount(rs.getDouble("discount"));
                tour1.setPlace(new Place(rs.getString("namePlace")));
                tour1.setCategory(new Category(rs.getString("nameCate")));
                tour1.setImages(new Images(rs.getString("nameImages")));
                list.add(tour1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Tour> getAllByCateInt(int limit,int offset) {
        List<Tour> list = new ArrayList<>();
        String sql = "select Tour.id_tour, Tour.nameTour,Tour.content,Tour.summaryTour,Tour.departureDate,Tour.price,Tour.discount,Place.namePlace,Category.nameCate,Images.nameImages,Tour.totalMember \n" +
                "from Tour \n" +
                "join Place on Tour.id_place = Place.id_place \n" +
                "join Category on Tour.id_cate = Category.id_cate\n" +
                "join Images on Tour.id_img = Images.id_img WHERE Category.id_cate=2 LIMIT ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,offset);
            ps.setInt(2,limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tour tour1 = new Tour();
                tour1.setId_tour(rs.getInt("id_tour"));
                tour1.setNameTour(rs.getString("nameTour"));
                tour1.setTotalMember(rs.getInt("totalMember"));
                tour1.setContent(rs.getString("content"));
                tour1.setSummaryTour(rs.getString("summaryTour"));
                tour1.setDepartureDate(rs.getString("departureDate"));
                tour1.setPrice(rs.getDouble("price"));
                tour1.setDiscount(rs.getDouble("discount"));
                tour1.setPlace(new Place(rs.getString("namePlace")));
                tour1.setCategory(new Category(rs.getString("nameCate")));
                tour1.setImages(new Images(rs.getString("nameImages")));
                list.add(tour1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Tour> getAllMem(int page) {
        List<Tour> list = new ArrayList<>();
        String sql = "select Tour.id_tour ,Tour.nameTour,Tour.content,Tour.summaryTour,Tour.departureDate,Tour.price,Tour.discount,Place.namePlace,Category.nameCate,Images.nameImages,price\n" +
                "from Tour \n" +
                "join Place on Tour.id_place = Place.id_place \n" +
                "join Category on Tour.id_cate = Category.id_cate\n" +
                "join Images on Tour.id_img = Images.id_img LIMIT ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,TourModel.ROW_PER_PAGE * (page - 1));
            ps.setInt(2, TourModel.ROW_PER_PAGE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tour tour1 = new Tour();
                tour1.setId_tour(rs.getInt("id_tour"));
                tour1.setNameTour(rs.getString("nameTour"));
                tour1.setContent(rs.getString("content"));
                tour1.setSummaryTour(rs.getString("summaryTour"));
                tour1.setDepartureDate(rs.getString("departureDate"));
                tour1.setPrice(rs.getDouble("price"));
                tour1.setDiscount(rs.getDouble("discount"));
                tour1.setPlace(new Place(rs.getString("namePlace")));
                tour1.setCategory(new Category(rs.getString("nameCate")));
                tour1.setImages(new Images(rs.getString("nameImages")));
                list.add(tour1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


//    @Override
//    public List<Tour> getAll() {
//        List<Tour> list = new ArrayList<>();
//        String sql = "SELECT * FROM Tour";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Tour tour1 = new Tour();
//                tour1.setId_tour(rs.getInt("id_tour"));
//                tour1.setNameTour(rs.getString("nameTour"));
//                tour1.setContent(rs.getString("content"));
//                tour1.setSummaryTour(rs.getString("summaryTour"));
//                tour1.setDepartureDate(rs.getString("departureDate"));
//                tour1.setPrice(rs.getDouble("price"));
//                tour1.setDiscount(rs.getDouble("discount"));
//                tour1.setId_place(rs.getInt("id_place"));
//                tour1.setId_cate(rs.getInt("id_cate"));
//                tour1.setId_img(rs.getInt("id_img"));
//                list.add(tour1);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }


    @Override
    public void Add(Tour tour) {
        String sql = "INSERT INTO Tour (nameTour,content,summaryTour,departureDate,price,discount,id_place,id_cate,id_img,totalMember)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tour.getNameTour());
            ps.setString(2, tour.getContent());
            ps.setString(3, tour.getSummaryTour());
            ps.setString(4,  tour.getDepartureDate());
            ps.setDouble(5, tour.getPrice());
            ps.setDouble(6, tour.getDiscount());
            ps.setInt(7, tour.getId_place());
            ps.setInt(8, tour.getId_cate());
            ps.setInt(9, tour.getId_img());
            ps.setInt(10,tour.getTotalMember());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tour getById(int id) {
        Tour tour = null;
        String sql = "select Tour.id_tour ,Tour.totalMember,Tour.nameTour,Tour.content,Tour.summaryTour,Tour.departureDate,Tour.price,Tour.discount,Place.namePlace,Category.nameCate,Images.nameImages,price\n" +
                "from Tour \n" +
                "join Place on Tour.id_place = Place.id_place \n" +
                "join Category on Tour.id_cate = Category.id_cate\n" +
                "join Images on Tour.id_img = Images.id_img WHERE id_tour=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tour = new Tour();
                tour.setId_tour(id);
                tour.setNameTour(rs.getString("nameTour"));
                tour.setTotalMember(rs.getInt("totalMember"));
                tour.setContent(rs.getString("content"));
                tour.setSummaryTour(rs.getString("summaryTour"));
                tour.setDepartureDate(rs.getString("departureDate"));
                tour.setPrice(rs.getDouble("price"));
                tour.setDiscount(rs.getDouble("discount"));
                tour.setPlace(new Place(rs.getString("namePlace")));
                tour.setCategory(new Category(rs.getString("nameCate")));
                tour.setImages(new Images(rs.getString("nameImages")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tour;
    }
    public List<Tour> getByIdPlace(int id){
       List<Tour> list = new ArrayList<>();
        String sql ="select Tour.id_tour ,Tour.nameTour,Tour.content,Tour.summaryTour,Tour.departureDate,Tour.price,Tour.discount,Place.namePlace,Category.nameCate,Images.nameImages,price\n" +
                "from Tour \n" +
                "join Place on Tour.id_place = Place.id_place \n" +
                "join Category on Tour.id_cate = Category.id_cate\n" +
                "join Images on Tour.id_img = Images.id_img where Place.id_place=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Tour tour = new Tour();
                tour.setId_tour(rs.getInt("id_tour"));
                tour.setNameTour(rs.getString("nameTour"));
                tour.setContent(rs.getString("content"));
                tour.setSummaryTour(rs.getString("summaryTour"));
                tour.setDepartureDate(rs.getString("departureDate"));
                tour.setPrice(rs.getDouble("price"));
                tour.setDiscount(rs.getDouble("discount"));
                tour.setPlace(new Place(rs.getString("namePlace")));
                tour.setCategory(new Category(rs.getString("nameCate")));
                tour.setImages(new Images(rs.getString("nameImages")));
                tour.setId_place(id);
                list.add(tour);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public void update(Tour tour) {
        String sql = "UPDATE Tour SET nameTour=?,content=?,summaryTour=?,departureDate=?,price=?,discount=?,id_place=?," +
                "id_cate=?,id_img=?,totalMember=? WHERE id_tour=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tour.getNameTour());
            ps.setString(2, tour.getContent());
            ps.setString(3, tour.getSummaryTour());
            ps.setString(4,  tour.getDepartureDate());
            ps.setDouble(5, tour.getPrice());
            ps.setDouble(6, tour.getDiscount());
            ps.setInt(7, tour.getId_place());
            ps.setInt(8, tour.getId_cate());
            ps.setInt(9, tour.getId_img());
            ps.setInt(10,tour.getTotalMember());
            ps.setInt(11, tour.getId_tour());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Tour WHERE id_tour=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int count() {
        String sql ="SELECT COUNT(*) as 'SUM' FROM Tour \n" +
                "join Place on Tour.id_place = Place.id_place \n" +
                "join Category on Tour.id_cate = Category.id_cate\n" +
                "join Images on Tour.id_img = Images.id_img; ";
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
    public List<Tour> search(Tour tour) {
        List<Tour> list = new ArrayList<>();

        String sql = "select Tour.id_tour,Tour.totalMember, Tour.nameTour,Tour.content,Tour.summaryTour,Tour.departureDate,Tour.price,Tour.discount,Place.namePlace,Category.nameCate,Images.nameImages \n" +
                "from Tour \n" +
                "join Place on Tour.id_place = Place.id_place \n" +
                "join Category on Tour.id_cate = Category.id_cate\n" +
                "join Images on Tour.id_img = Images.id_img where Tour.nameTour like ? and date_format(Tour.departureDate,'%d/%m/%Y')=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"%" + tour.getNameTour() + "%");
            ps.setString(2, tour.getDepartureDate());

            ResultSet rs = ps.executeQuery();
//            if(rs.next()){
                while (rs.next()) {
                    Tour tour1 = new Tour();
                    tour1.setId_tour(rs.getInt("id_tour"));
                    tour1.setNameTour(rs.getString("nameTour"));
                    tour1.setTotalMember(rs.getInt("totalMember"));
                    tour1.setContent(rs.getString("content"));
                    tour1.setSummaryTour(rs.getString("summaryTour"));
                    tour1.setDepartureDate(rs.getString("departureDate"));
                    tour1.setPrice(rs.getDouble("price"));
                    tour1.setDiscount(rs.getDouble("discount"));
                    tour1.setPlace(new Place(rs.getString("namePlace")));
                    tour1.setCategory(new Category(rs.getString("nameCate")));
                    tour1.setImages(new Images(rs.getString("nameImages")));
                    list.add(tour1);
                }
//            }else {
//                System.out.println("data not found");
//            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        TourModel model = new TourModel();
        Tour tourr = new Tour();
        Place place = new Place();
        tourr.setNameTour("ww");
        tourr.setDepartureDate("2005-12-01");

//        tour.setContent("Thả ga nhảy múa bơi lội tại địa điểm có một không hai");
//        tour.setSummaryTour("Hè này bạn đã biết đi đâu ăn ch chưa?");
//        tour.setDepartureDate("2019-10-03");
//        tour.setPrice(400.32);
//        tour.setDiscount(0.1);
//        tour.setId_place(1);
//        tour.setId_cate(1);
//        tour.setId_img(1);
//        tour.setId_tour(1);
//        model.update(tour);
            int count = model.search(tourr).size();
        System.out.println(count);
        if (count==0){
            System.out.println("Data not found");
        }else { for (Tour tour: model.search(tourr)
            ) {
                    System.out.println(tour.getNameTour());

            }
        }



    }
}

