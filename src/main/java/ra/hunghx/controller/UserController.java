package ra.hunghx.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.hunghx.dto.response.UserDtoRequest;
import ra.hunghx.exception.ResouceConfitch;
import ra.hunghx.service.UserServiceImpl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    // api nhận dữ lệu và validate
    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<?> postUser(@Valid @RequestBody UserDtoRequest request){
        if(userService.existByEmail(request.getEmail())){
            throw new ResouceConfitch("Email is exists!!");
        }
//        HttpStatus.CONFLICT // 409
        return ResponseEntity.ok("success");

    }
}