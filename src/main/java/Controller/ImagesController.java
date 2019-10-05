package Controller;
import DTO.Images;
import Model.ImagesModel;
import Service.MyFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
public class ImagesController {
    ImagesModel imagesModel = new ImagesModel();
//    @RequestMapping("/upload")
//    public String images(Model model) {
//        int count = imagesModel.count();
//        int totalPage = 0;
//        int currentPage = 1;
//        totalPage = (int)Math.floor(count/RECORD_PER_PAGE) + (count%RECORD_PER_PAGE==0 ? 0 : 1);
//        List<Images> list = imagesModel.getLimit( RECORD_PER_PAGE, RECORD_PER_PAGE*(currentPage-1));
//        model.addAttribute("file", list);
//        model.addAttribute("count",count);
//        model.addAttribute("currentPage", currentPage);
//        model.addAttribute("totalPage", totalPage);
//        return "admin/UploadImage";
//    }
@RequestMapping("/upload")
public String images(@RequestParam(value = "page",defaultValue = "1") int page,Model model) {
    int count = imagesModel.count();
    int pages = (int) Math.floor(count / ImagesModel.ROW_PER_PAGE)+1;
    model.addAttribute("file", imagesModel.getAllMem(page));
    model.addAttribute("current", page);
    model.addAttribute("total", pages);
    return "admin/UploadImage";
}

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFile(MyFile myFile, Model model) {
        Images images = new Images();
        try {
            MultipartFile multipartFile = myFile.getMultipartFile();
            String fileName = multipartFile.getOriginalFilename();
            double size = multipartFile.getSize();
            File file = new File("/home/winter/Documents/IdeaProjects/TourACT/src/main/webapp/uploadImg", fileName);
            images.setNameImages(fileName);
            images.setSize(size);
            multipartFile.transferTo(file);
            imagesModel.Add(images);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/upload";

    }
    @RequestMapping("/imageDetails")
    public String imagesDetail(@RequestParam("id") int id,Model model){
        Images images = imagesModel.getById(id);
        model.addAttribute("img",images);
        return "admin/ImageDetails";
    }
    @RequestMapping("/deleteImage")
    public String deleteImages(@RequestParam("id") int id){
        imagesModel.delete(id);
        return "redirect:/upload";
    }
}
