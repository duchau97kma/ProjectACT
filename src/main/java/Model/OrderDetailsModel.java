package Model;

import DBConnect.DBConnector;
import DTO.Member;
import DTO.Order;
import DTO.OrderDetails;
import DTO.Tour;
import Service.IManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsModel implements IManager<OrderDetails> {
    private Connection conn;

    public OrderDetailsModel() {
        DBConnector db = new DBConnector();
        this.conn = db.getConnection();
    }

    @Override
    public List<OrderDetails> getAll() {
        List<OrderDetails> list = new ArrayList<>();
        String sql="SELECT OrderDetails.*,Tour.nameTour,Orderr.id_order,(Tour.price - (Tour.price*Tour.discount)) as 'price' FROM OrderDetails,Tour,Orderr " +
                "WHERE OrderDetails.id_order=Orderr.id_order and OrderDetails.id_tour = Tour.id_tour";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setOrder(new Order(rs.getInt("id_order")));
                orderDetails.setTour(new Tour(rs.getString("nameTour")));
                orderDetails.setTotalPrice(rs.getDouble("price"));
                orderDetails.setTotalUser(rs.getInt("totalUser"));
                list.add(orderDetails);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<OrderDetails> getAllMem(int page) {
        List<OrderDetails> list = new ArrayList<>();
        String sql="SELECT OrderDetails.*,Tour.nameTour,Orderr.id_order,(Tour.price - (Tour.price*Tour.discount)) as 'price' FROM OrderDetails,Tour,Orderr " +
                "WHERE OrderDetails.id_order=Orderr.id_order and OrderDetails.id_tour = Tour.id_tour LIMIT ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,OrderDetailsModel.ROW_PER_PAGE * (page - 1));
            ps.setInt(2, OrderDetailsModel.ROW_PER_PAGE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setOrder(new Order(rs.getInt("id_order")));
                orderDetails.setTour(new Tour(rs.getString("nameTour")));
                orderDetails.setTotalPrice(rs.getDouble("price"));
                orderDetails.setTotalUser(rs.getInt("totalUser"));
                list.add(orderDetails);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public void Add(OrderDetails orderDetails) {
        String sql ="INSERT INTO OrderDetails (id_order,id_tour,totalPrice,totalUser)" +
                "VALUES (?,?,?,?)";
        try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,orderDetails.getId_order());
        ps.setInt(2,orderDetails.getId_tour());
        ps.setDouble(3,orderDetails.getTotalPrice());
        ps.setInt(4,orderDetails.getTotalUser());
        ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public OrderDetails getById(int id) {
        return null;
    }

    @Override
    public void update(OrderDetails orderDetails) {

    }

    @Override
    public void delete(int id) {
        String sql="DELETE FROM OrderDetails WHERE id_order=?";
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
        String sql ="SELECT COUNT(*) as 'SUM' FROM OrderDetails,Tour,Orderr " +
                "WHERE OrderDetails.id_order=Orderr.id_order and OrderDetails.id_tour = Tour.id_tour";
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
public List<OrderDetails> historyOrder(Member member){
        List<OrderDetails> list = new ArrayList<>();
        String sql="SELECT OrderDetails.*,Tour.nameTour,Orderr.id_order,(Tour.price - (Tour.price*Tour.discount)) as 'price',Orderr.status,Orderr.id_member,Orderr.orderDate \n" +
                "FROM OrderDetails,Tour,Orderr \n" +
                "WHERE OrderDetails.id_order=Orderr.id_order and OrderDetails.id_tour = Tour.id_tour and Orderr.id_member=?";
        try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,member.getId_member());
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setId_order(rs.getInt("id_order"));
            orderDetails.setId_tour(rs.getInt("id_tour"));
            orderDetails.setTotalPrice(rs.getDouble("price"));
            orderDetails.setTotalUser(rs.getInt("totalUser"));
            orderDetails.setTour(new Tour(rs.getString("nameTour")));
            orderDetails.setOrder(new Order(rs.getInt("id_order"),rs.getInt("id_member"),rs.getDate("orderDate"),rs.getInt("status")));
            list.add(orderDetails);
        }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
}
    public List<OrderDetails> getReport(int month){
        List<OrderDetails> list = new ArrayList<>();
        String sql ="select day(orderDate) as 'ngay',sum(totalPrice) as 'tongtien'\n" +
                "from Orderr,OrderDetails\n" +
                "where Orderr.id_order = OrderDetails.id_order and month(orderDate)=?\n" +
                "group by day(orderDate)\n";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,month);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setOrder(new Order(rs.getDate("ngay")));
                orderDetails.setTotalPrice(rs.getDouble("tongtien"));
                list.add(orderDetails);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        OrderDetailsModel model = new OrderDetailsModel();
        OrderDetails od = new OrderDetails();
//        od.setId_order(1);
//        od.setId_tour(1);
//        od.setTotalPrice(843.24);
//        od.setTotalUser(10);
//        model.Add(od);
//        Member member = new Member();
//        member.setId_member(5);
        for (OrderDetails odi: model.getReport(10)
             ) {
            System.out.println(odi.toString());
        }
    }
}
