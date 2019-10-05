package Controller;

import DTO.Images;
import DTO.Place;
import DTO.Tour;
import Model.ImagesModel;
import Model.PlaceModel;
import Model.TourModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class API {
    @RequestMapping("/getAllTour/total")
    public int getTotal(){
    try {
        List<Tour> list = new TourModel().getAll();
        int limit =3;
        int total = list.size () % limit ==0 ? list.size()/limit : (int) Math.floor(list.size() / limit)+1;
        return total;
    }catch (Exception e){
        e.printStackTrace();
    }
    return 0;
    }
    @RequestMapping("/getAllPlace/total")
    public int getTotalPlace(){
        try {
            List<Place> list = new PlaceModel().getAll();
            int limit =3;
            int total = list.size () % limit ==0 ? list.size()/limit : (int) Math.floor(list.size() / limit)+1;
            return total;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    @RequestMapping("/getAllTour")
    public List<Tour> allTour(@RequestParam(value = "page",required = false) Integer page){
    try {
    int offset=0;
    int limit=3;
    if (page!=null){
        offset=(page-1)*limit;
    }
    return new TourModel().getAll(limit,offset);
}catch (Exception e){
    e.printStackTrace();
}
       return null;
    }
    @RequestMapping("/getAllPlace")
    public List<Place> allPlace(@RequestParam(value = "page",required = false) Integer page){
        try {
            int offset=0;
            int limit=3;
            if (page!=null){
                offset=(page-1)*limit;
            }
            return new PlaceModel().getAll(limit,offset);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/getAllTourVN")
    public List<Tour> allTourVN(@RequestParam(value = "page",required = false) Integer page){
        try {
            int offset=0;
            int limit=3;
            if (page!=null){
                offset=(page-1)*limit;
            }
            return new TourModel().getAllByCateVN(limit,offset);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/getAllTourVN/total")
    public int getTotalVN(){
        try {
            List<Tour> list = new TourModel().getAllByCateVN();
            int limit =3;
            int total = list.size () % limit ==0 ? list.size()/limit : (int) Math.floor(list.size() / limit)+1;
            return total;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    @RequestMapping("/getAllTourInt")
    public List<Tour> allTourInt(@RequestParam(value = "page",required = false) Integer page){
        try {
            int offset=0;
            int limit=3;
            if (page!=null){
                offset=(page-1)*limit;
            }
            return new TourModel().getAllByCateInt(limit,offset);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/getAllTourInt/total")
    public int getTotalInt(){
        try {
            List<Tour> list = new TourModel().getAllByCateInt();
            int limit =3;
            int total = list.size () % limit ==0 ? list.size()/limit : (int) Math.floor(list.size() / limit)+1;
            return total;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    @RequestMapping("/getAllImage")
    public List<Images> allImages(@RequestParam(value = "page",required = false) Integer page){
        try {
            int offset=0;
            int limit=3;
            if (page!=null){
                offset=(page-1)*limit;
            }
            return new ImagesModel().getAllImages(limit,offset);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/getAllImage/total")
    public int getTotalImg(){
        try {
            List<Images> list = new ImagesModel().getAll();
            int limit =3;
            int total = list.size () % limit ==0 ? list.size()/limit : (int) Math.floor(list.size() / limit)+1;
            return total;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }


}
