package Controller;

import DTO.Member;
import DTO.Place;
import Model.PlaceModel;
import Model.ImagesModel;
import Model.CategoryModel;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PlaceController {
    PlaceModel placeModel = new PlaceModel();
    ImagesModel imagesModel = new ImagesModel();

//    @RequestMapping("/Place")
//    public String index(Model model){
//        model.addAttribute("place",placeModel.getAll());
//        return "admin/Place";
//    }
@RequestMapping("/Place")
public String index(@RequestParam(value = "page",defaultValue = "1") int page,Model model){
    int count = placeModel.count();
    int pages = (int) Math.floor(count / placeModel.ROW_PER_PAGE)+1;
    model.addAttribute("place",placeModel.getAllMem(page));
    model.addAttribute("current", page);
    model.addAttribute("total", pages);
    return "admin/Place";
}
    @RequestMapping("/addPlace")
    public String addPlace(Model model){
        Place place = new Place();
        model.addAttribute("command",place);
        model.addAttribute("place",placeModel.getAll());
        model.addAttribute("img",imagesModel.getAll());

        return "admin/AddPlace";
    }

    @RequestMapping("/savePlace")
    public String savePlace(@ModelAttribute("command")Place place){
        placeModel.Add(place);
        return "redirect:/Place";
    }

    @RequestMapping("/EditPlace")
    public String editPlace(@RequestParam("id") int id, Model model){
        Place place = new PlaceModel().getById(id);
        model.addAttribute("place",place);
        model.addAttribute("img",imagesModel.getAll());
        return "admin/EditPlace";
    }
    @RequestMapping("/updatePlace")
    public String updatePlace(HttpServletRequest request, Place place){
        int id = Integer.parseInt(request.getParameter("id_place"));
        String namePlace = request.getParameter("namePlace");
        String summary = request.getParameter("summary");
        int id_img = Integer.parseInt(request.getParameter("id_img"));
        place = new Place(id,namePlace,summary,id_img);
        placeModel.update(place);
        return "redirect:/Place";
    }

    @RequestMapping("/DeletePlace")
    public String deletePlace(@RequestParam("id") int id){
        placeModel.delete(id);
        return "redirect:/Place";
    }
}
