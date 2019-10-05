package Controller;

import DTO.*;
import Model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes({"account","shoppingCart"})
public class HomeController {
    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    MemberModel memberModel = new MemberModel();
    TourModel tourModel = new TourModel();
    OrderModel orderModel = new OrderModel();
    OrderDetailsModel orderDetailsModel = new OrderDetailsModel();
    CategoryModel categoryModel = new CategoryModel();
    PlaceModel placeModel = new PlaceModel();
    ContactModel contactModel = new ContactModel();
    @RequestMapping("/")
    public String Home(Model model){
       model.addAttribute("tour",tourModel.getAll(6,0));
       model.addAttribute("cate",categoryModel.getAll());
       model.addAttribute("place",placeModel.getAll(6,0));
        return "home";
    }
    @RequestMapping("/report")
    public String report(Model model){
        Calendar cal = Calendar.getInstance();
        ReportModel reportModel = new ReportModel();
        model.addAttribute("report",reportModel.getAllReport(cal.get(Calendar.MONTH)+1));
        model.addAttribute("month",cal.get(Calendar.MONTH)+1);
        model.addAttribute("year",cal.get(Calendar.YEAR));
        return "admin/index";
    }
    @RequestMapping("/admin")
    public String Admin(Model model){
        return "redirect:/report";
    }
    @RequestMapping("/AllTour")
    public String allTour(Model model,@RequestParam(value = "page",required = false) Integer page){
        int offset=0;
        int limit =6;
        if(page!=null){
            offset=(page-1)*limit;
        }else {
            model.addAttribute("tour",tourModel.getAll(limit,offset));
        }
        model.addAttribute("cate",categoryModel.getAll());
        return "AllTour";
    }
    @RequestMapping("/AllTourVN")
    public String allTourVN(Model model,@RequestParam(value = "page",required = false) Integer page){
        int offset=0;
        int limit =3;
        if(page!=null){
            offset=(page-1)*limit;
        }else {
            model.addAttribute("tour",tourModel.getAllByCateVN(limit,offset));
        }
        model.addAttribute("cate",categoryModel.getAll());
        return "VNtour";
    }
    @RequestMapping("/AllTourInt")
    public String allTourInt(Model model,@RequestParam(value = "page",required = false) Integer page){
        int offset=0;
        int limit =3;
        if(page!=null){
            offset=(page-1)*limit;
        }else {
            model.addAttribute("tour",tourModel.getAllByCateInt(limit,offset));
        }
        model.addAttribute("cate",categoryModel.getAll());
        return "InterTour";
    }

    @RequestMapping("/TourDetails")
    public String tourDetails(@RequestParam("id") int id, Model model){
            Tour tour = new TourModel().getById(id);
            model.addAttribute("details",tour);
            model.addAttribute("tour",tourModel.getAll(6,0));
            model.addAttribute("place",placeModel.getAll(6,0));
             model.addAttribute("cate",categoryModel.getAll());
            return "TourDetails";
    }
    @RequestMapping("/AllPlace")
    public String allPlace(Model model,@RequestParam(value = "page",required = false) Integer page){
        int offset=0;
        int limit =6;
        if(page!=null){
            offset=(page-1)*limit;
        }else {
            model.addAttribute("place",placeModel.getAll(limit,offset));
        }
        model.addAttribute("cate",categoryModel.getAll());
        return "AllPlace";
    }
    @RequestMapping("/PlaceDetails")
    public String placeDetails(@RequestParam("id") int id,Model model){
        Place place = new PlaceModel().getById(id);
        model.addAttribute("detailsPlace",place);
        model.addAttribute("tour",tourModel.getByIdPlace(id));
        model.addAttribute("place",placeModel.getAll(6,0));
        model.addAttribute("cate",categoryModel.getAll());
        return "PlaceDetails";
    }
    @RequestMapping("/cart")
    public String Cart(Model model){
        model.addAttribute("cate",categoryModel.getAll());
        return "cart";
    }
    @RequestMapping("/thanks")
    public String Thanks(Model model){
        model.addAttribute("cate",categoryModel.getAll());
        return "Thanks";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("/book")
    public String addToCart(@RequestParam("id") int id,HttpServletRequest req,Model model){
        HttpSession session = req.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("shoppingCart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        cart.add(new Item(tourModel.getById(id),tourModel.getById(id).getTotalMember()));
        model.addAttribute("shoppingCart",cart);
        return "redirect:/cart";
    }
    @SuppressWarnings("unchecked")
    @RequestMapping("/checkoutCart")
    public String checkOutCart(HttpServletRequest req,Model model,SessionStatus status){
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("account");
        if(name != null){
            Order order = new Order();
            order.setId_member(memberModel.getIdByAccount(name).getId_member());
            orderModel.Add(order);
            Order id = orderModel.getIdByMember(memberModel.getIdByAccount(name).getId_member());
            List<Item> cart = (List<Item>) session.getAttribute("shoppingCart");
            for (Item item: cart
                 ) {
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setId_order(id.getId_order());
                orderDetails.setId_tour(item.getTour().getId_tour());
                orderDetails.setTotalPrice(item.getTour().getPrice()-(item.getTour().getPrice()*item.getTour().getDiscount()));
                orderDetails.setTotalUser(item.getTotalMember());
                orderDetailsModel.Add(orderDetails);
            }
            model.addAttribute("shoppingCart","");

        }else{
            return "redirect:/loginUser";
        }
        return "redirect:/thanks";
    }
    @SuppressWarnings("unchecked")
    @RequestMapping("/updateCart")
    public String update(@RequestParam("totalUser") int[] totalUser,HttpServletRequest req,Model model){
        HttpSession session = req.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("shoppingCart");
        for (int i=0;i<cart.size();i++){
            cart.get(i).setTotalMember(totalUser[i]);
        }
        model.addAttribute("shoppingCart",cart);
        return "redirect:/cart";
    }
    @SuppressWarnings("unchecked")
    @RequestMapping("/removeItem")
    public String removeItem(@RequestParam("id") int id,HttpServletRequest req,Model model){
        HttpSession session = req.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("shoppingCart");
        cart.remove(id);
        model.addAttribute("shoppingCart",cart);
        return "redirect:/cart";
    }
    @RequestMapping("/checkout")
    public String addOrderDetails(Model model,@RequestParam("id") int id){
        OrderDetails orderDetails = new OrderDetails();
        Tour tour = new TourModel().getById(id);
        model.addAttribute("details",tour);
        model.addAttribute("addOrder",orderDetails);
        model.addAttribute("cate",categoryModel.getAll());
        return "checkout";
    }

    @RequestMapping("/saveOrderDetails")
    public String saveOderDetails(HttpServletRequest req,OrderDetails orderDetails,Model model,SessionStatus status){
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("account");
        if(name != null){
            Order order = new Order();
            order.setId_member(memberModel.getIdByAccount(name).getId_member());
            orderModel.Add(order);
            Order id = orderModel.getIdByMember(memberModel.getIdByAccount(name).getId_member());
            orderDetails.setId_order(id.getId_order());
            int id_tour = Integer.parseInt(req.getParameter("id_tour"));
            double totalPrice = Double.parseDouble(req.getParameter("totalPrice"));
            int totalUser = Integer.parseInt(req.getParameter("totalUser"));
            orderDetailsModel.Add(orderDetails);
            return "redirect:/thanks";
        }else{
            return "redirect:/loginUser";
        }

    }
    @RequestMapping("/loginUser")
    public String login(Model model){
        Member member = new Member();
        model.addAttribute("loginForm",member);
        model.addAttribute("cate",categoryModel.getAll());
        return "login";
    }
    @RequestMapping("/loggingUser")
    public String login(@ModelAttribute("loginForm") Member member, Model model){
        try {
            member = memberModel.checkLogin(member.getAccount(),member.getPassword());
            if(member!=null){
                model.addAttribute("account",member.getAccount());
                    return "redirect:/";
            }else {
                model.addAttribute("error","invalid account or password");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "login";
    }
    @RequestMapping("/register")
    public String register(Model model){
        Member member = new Member();
        model.addAttribute("command",member);
        model.addAttribute("cate",categoryModel.getAll());
        return "register";
    }
    @RequestMapping("/auth")
    public String authRegister(@ModelAttribute("command") Member member,Model model){
        if(memberModel.checkRegister(member)){
            memberModel.Add(member);
            model.addAttribute("success","Register success! Please come back to login");
        }else{
            model.addAttribute("fail","Account may be invalid! Please try again");
        }

        return "register";
    }
    @RequestMapping("/logoutUser")
    public String logoutUser(SessionStatus status){
        status.setComplete();
        return "redirect:/";
    }
    @RequestMapping("/category")
    public String getCategory(@RequestParam("id") int id,Model model){
        Category category = categoryModel.getById(id);
        if(id==1){
            return "redirect:/AllTourVN";
        }if(id==2){
           return "redirect:/AllTourInt";
        } else{
            return "redirect:/home";
        }
    }
    @RequestMapping("/contact")
    public String contact(Model model){
        Contact contact = new Contact();
        model.addAttribute("contact",contact);
        model.addAttribute("cate",categoryModel.getAll());
        return "Contact";
    }
    @RequestMapping("/saveContact")
    public String addContact(@ModelAttribute("contact") Contact contact,HttpServletRequest req,Model model){
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("account");
        if(name!=null){
            contact = new Contact();
            contact.setId_member(memberModel.getIdByAccount(name).getId_member());
            contact.setContent(req.getParameter("content"));
            contactModel.Add(contact);
            model.addAttribute("ok","Cảm ơn bạn đã phản hồi!");
        }else {
            return "redirect:/loginUser";
        }
        return "Contact";
    }
    @RequestMapping(value = "/Search")
    public String search(HttpServletRequest request,Model model){
        Tour tour = new Tour();
        tour.setNameTour(request.getParameter("nameTour"));
        tour.setDepartureDate(request.getParameter("date"));
        int count = tourModel.search(tour).size();
        if(count >0){
            model.addAttribute("result",tourModel.search(tour));
            return "ResutlSearch";
        }else {
            model.addAttribute("err","data not found");
        }
        model.addAttribute("cate",categoryModel.getAll());
        return "ResutlSearch";
    }
    @RequestMapping("/HistoryOrder")
    public String history(Model model,Member member,HttpServletRequest req){
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("account");
        if(name!=null){
            member.setId_member(memberModel.getIdByAccount(name).getId_member());
            int count= orderDetailsModel.historyOrder(member).size();
            if(count>0){
                model.addAttribute("history",orderDetailsModel.historyOrder(member));
            }else{
                model.addAttribute("err","Bạn chưa đặt bất kỳ tuor nào!");
            }

        }else{
            return "redirect:/loginUser";
        }
        model.addAttribute("cate",categoryModel.getAll());
        return "HistoryOrder";
    }

}
