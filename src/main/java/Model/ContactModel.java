package Model;

import DBConnect.DBConnector;
import DTO.Contact;
import DTO.Member;
import Service.IManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactModel implements IManager<Contact> {
    private Connection conn;

    public ContactModel() {
        DBConnector db = new DBConnector();
        this.conn = db.getConnection();
    }

    @Override
    public List<Contact> getAll() {
        String sql ="select Contact.id_contact,Contact.content, Member.fullname From Member, Contact where Member.id_member = Contact.id_member;";
        List<Contact> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Contact contact = new Contact();
                contact.setId_contact(rs.getInt("id_contact"));
                contact.setMember(new Member(rs.getString("fullname")));
                contact.setContent(rs.getString("content"));

                list.add(contact);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Contact> getAllMem(int page) {
        String sql ="select Contact.id_contact,Contact.content, Member.fullname From Member, Contact " +
                "where Member.id_member = Contact.id_member LIMIT ?,?";
        List<Contact> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,ContactModel.ROW_PER_PAGE * (page - 1));
            ps.setInt(2, ContactModel.ROW_PER_PAGE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Contact contact = new Contact();
                contact.setId_contact(rs.getInt("id_contact"));
                contact.setMember(new Member(rs.getString("fullname")));
                contact.setContent(rs.getString("content"));
                list.add(contact);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public void Add(Contact contact) {
        String sql ="INSERT INTO Contact(id_member,content) VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,contact.getId_member());
            ps.setString(2,contact.getContent());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Contact getById(int id) {
        String sql="SELECT * FROM Contact WHERE id_contact=?";
        Contact contact =null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String content = rs.getString("content");
                int id_member = rs.getInt("id_member");
                contact = new Contact(id,id_member,content);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return contact;
    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void delete(int id) {
    String sql = "DELETE FROM Contact WHERE id_contact=?";
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
        String sql ="SELECT COUNT(*) as 'SUM' FROM Contact";
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
        ContactModel model = new ContactModel();
        for (Contact c: model.getAll()
             ) {
            System.out.println(c.toString());
        }
    }
}
