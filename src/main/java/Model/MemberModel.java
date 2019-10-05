package Model;

import DBConnect.DBConnector;
import DTO.Member;
import Service.IManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberModel implements IManager<Member> {
    private Connection conn;
    public final static int ROW_PER_PAGE = 5;
    public MemberModel() {
        DBConnector db = new DBConnector();
        this.conn = db.getConnection();
    }
    @Override
    public List<Member> getAll() {
        List<Member> list = new ArrayList<>();
        String sql ="SELECT * FROM Member";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Member member = new Member();
                member.setId_member(rs.getInt("id_member"));
                member.setAccount(rs.getString("account"));
                member.setPassword(rs.getString("password"));
                member.setFullname(rs.getString("fullname"));
                member.setPhone(rs.getString("phone"));
                member.setPermission(rs.getInt("permission"));
                member.setCreate_at(rs.getDate("create_at"));
                list.add(member);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Member> getAllMem(int page) {
        List<Member> list = new ArrayList<>();
        String sql ="SELECT * FROM Member LIMIT ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,MemberModel.ROW_PER_PAGE * (page - 1));
            ps.setInt(2, MemberModel.ROW_PER_PAGE);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Member member = new Member();
                member.setId_member(resultSet.getInt("id_member"));
                member.setAccount(resultSet.getString("account"));
                member.setPassword(resultSet.getString("password"));
                member.setFullname(resultSet.getString("fullname"));
                member.setPhone(resultSet.getString("phone"));
                member.setPermission(resultSet.getInt("permission"));
                member.setCreate_at(resultSet.getDate("create_at"));
                list.add(member);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public void Add(Member member) {
        String sql ="INSERT INTO Member(account,password,fullname,phone,permission)" +
                "VALUES(?,?,?,?,?)";
        try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,member.getAccount());
        ps.setString(2,member.getPassword());
        ps.setString(3,member.getFullname());
        ps.setString(4,member.getPhone());
        ps.setInt(5,member.getPermission());
        ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Member getById(int id) {
        String sql="SELECT * FROM Member WHERE id_member=?";
        Member member = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                member = new Member();
                member.setId_member(id);
                member.setAccount(rs.getString("account"));
                member.setPassword(rs.getString("password"));
                member.setFullname(rs.getString("fullname"));
                member.setPhone(rs.getString("phone"));
                member.setPermission(rs.getInt("permission"));
                member.setCreate_at(rs.getDate("create_at"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return member;
    }

    @Override
    public void update(Member member) {
       String sql ="UPDATE Member SET account=?,password=?,fullname=?,phone=?,permission=? WHERE id_member=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,member.getAccount());
            ps.setString(2,member.getPassword());
            ps.setString(3,member.getFullname());
            ps.setString(4,member.getPhone());
            ps.setInt(5,member.getPermission());
            ps.setInt(6,member.getId_member());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql ="DELETE FROM Member WHERE id_member=?";
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
        String sql ="SELECT COUNT(*) as 'SUM' FROM Member ";
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
    public boolean checkRegister(Member member){
        String sql ="SELECT * FROM Member WHERE account=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,member.getAccount());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return false;
            }else {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Member getIdByAccount(String account){
        Member member=null;
        String sql="select * from Member where account=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,account);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                member = new Member();
                member.setId_member(rs.getInt("id_member"));
                member.setAccount(account);
                member.setPassword(rs.getString("password"));
                member.setFullname(rs.getString("fullname"));
                member.setPhone(rs.getString("phone"));
                member.setPermission(rs.getInt("permission"));
                member.setCreate_at(rs.getDate("create_at"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return member;
    }
    public Member checkLogin(String account, String password){
        String sql ="SELECT * FROM Member WHERE account =? && password=?";
        Member member =null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,account);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                member = new Member();
                member.setId_member(rs.getInt("id_member"));
                member.setAccount(rs.getString("account"));
                member.setPassword(rs.getString("password"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return member;
   }
    public boolean checkAdmin(Member member){
        String sql ="SELECT * FROM Member WHERE account =? && password=? && permission=1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,member.getAccount());
            ps.setString(2,member.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
    public static void main(String[] args) {
        MemberModel model = new MemberModel();
        Member member = new Member();
//        member.setId_member(4);
//        member.setAccount("hoang123");
//        member.setPassword("123");
//        member.setFullname("Nguyen Hoang");
//        member.setPhone("0987463526");
//        member.setPermission(2);
//        model.update(member);
//        member.setAccount("jfldsjl");
//        if(model.checkRegister(member)){
//            System.out.println("FAIL! FUCK YOU BITCH");
//        }else {
//            System.out.println("You can register");
//        }
//        member.setPassword("gsdfg");
//        if(model.checkLogin(member)){
//            if (model.checkAdmin(member)){
//                System.out.println("Manager");
//            }else {
//                System.out.println("User");
//            }
//        }else {
//            System.out.println("FAIL!!!!");
//        }
//        int count = model.count();
//        int pages = (int) Math.floor(count / model.ROW_PER_PAGE)+1;
//        System.out.println(pages);
//        for (Member m: model.getAllMem(1)
//             ) {
//            System.out.println(m.toString());
//        }
    }

}
