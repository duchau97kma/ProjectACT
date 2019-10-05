package Model;

import DBConnect.DBConnector;
import DTO.ItemReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReportModel {
    private Connection conn;

    public ReportModel() {
        DBConnector db = new DBConnector();
        this.conn = db.getConnection();
    }
    public List<ItemReport> getAllReport(int month){
        List<ItemReport> list = new ArrayList<>();
        String sql ="select day(orderDate) as 'ngay',sum(totalPrice) as 'tongtien'\n" +
                "from Orderr,OrderDetails\n" +
                "where Orderr.id_order = OrderDetails.id_order and month(orderDate)=?\n" +
                "group by day(orderDate)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,month);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ItemReport itemReport = new ItemReport();
                itemReport.setDate(rs.getString("ngay"));
                itemReport.setTotalPrice(rs.getDouble("tongtien"));
                list.add(itemReport);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        ReportModel reportModel = new ReportModel();
        Calendar cal = Calendar.getInstance();
        System.out.print("Tháng hiện tại là ");
        System.out.println(cal.get(Calendar.MONTH)+1);
//        for (ItemReport item: reportModel.getAllReport(10)
//             ) {
//            System.out.println(item.getTotalPrice());
//        }
    }
}
