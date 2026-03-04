package ra.hunghx.controller;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.hunghx.service.UploadService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/uploads")
@CrossOrigin("*")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    /*
    B1 : Gửi file từ Client lên server
    B2 : Nhân file từ controller : @RequestParam hoặc @ModelAttribute
    B3 : Lưu vào server : ổ đĩa / ram
    B4 : lưu cloud (AWS , Cloudinary, Azure, Drive)
    B5 : trả vê response
     */
    @PostMapping
    public ResponseEntity<?> upload(@RequestParam MultipartFile file) throws IOException {
        // lấy ra vị trí cần lưu
//        String folder = "C:\\Users\\AD\\Documents\\uploads";
//
//        // lấy tên file
//        String fileName = UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
//        file.transferTo(Path.of(folder+ File.separator +fileName));

        // Lưu cloud


        return new ResponseEntity<>(ObjectUtils.asMap("url",uploadService.uploadFile(file)), HttpStatus.OK);
    }

}
