package Model;

import DBConnect.DBConnector;
import DTO.Member;
import DTO.Order;
import Service.IManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderModel implements IManager<Order> {
    private Connection conn;

    public OrderModel() {
        DBConnector db = new DBConnector();
        this.conn = db.getConnection();
    }
    @Override
    public List<Order> getAll() {
        String sql="SELECT Orderr.*, Member.fullname FROM Member,Orderr WHERE Member.id_member=Orderr.id_member";
        List<Order> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Order order = new Order();
                order.setId_order(rs.getInt("id_order"));
                order.setOrderDate(rs.getDate("orderDate"));
                order.setStatus(rs.getInt("status"));
                order.setMember(new Member(rs.getString("fullname")));
                list.add(order);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Order> getAllMem(int page) {
        String sql="SELECT Orderr.*, Member.fullname FROM Member,Orderr WHERE Member.id_member=Orderr.id_member LIMIT ?,?";
        List<Order> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,OrderModel.ROW_PER_PAGE * (page - 1));
            ps.setInt(2, OrderModel.ROW_PER_PAGE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Order order = new Order();
                order.setId_order(rs.getInt("id_order"));
                order.setOrderDate(rs.getDate("orderDate"));
                order.setStatus(rs.getInt("status"));
                order.setMember(new Member(rs.getString("fullname")));
                list.add(order);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public void Add(Order order) {
        String sql="INSERT INTO Orderr(id_member,status) VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,order.getId_member());
            ps.setInt(2,order.getStatus());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Order getById(int id) {
        return null;
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Orderr WHERE id_order=?";
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
        String sql ="SELECT COUNT(*) as 'SUM' FROM Member,Orderr WHERE Member.id_member=Orderr.id_member";
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
    public Order getIdByMember(int id){
        Order order =null;
        String sql ="SELECT * FROM Orderr WHERE id_member=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                order = new Order();
                order.setId_order(rs.getInt("id_order"));
                order.setId_member(id);
                order.setOrderDate(rs.getDate("orderDate"));
                order.setStatus(rs.getInt("status"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }

    public static void main(String[] args) {
    OrderModel model = new OrderModel();
//    Order order = new Order();
//    order.setId_member(1);
//    order.setStatus(0);
//    model.Add(order);
        for (Order o: model.getAll()
             ) {
            System.out.println(o.toString());
        }
    }
}
