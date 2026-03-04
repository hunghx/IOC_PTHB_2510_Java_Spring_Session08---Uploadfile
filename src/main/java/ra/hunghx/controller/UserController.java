package ra.hunghx.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.hunghx.dto.request.UserDtoRequest;
import ra.hunghx.exception.ResourceConflictException;
import ra.hunghx.service.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
    // api nhận dữ lệu và validate
    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<?> postUser(@Valid @RequestBody UserDtoRequest request){
        if(userService.existByEmail(request.getEmail())){
            throw new ResourceConflictException("Email is exists!!");
        }
//        HttpStatus.CONFLICT // 409
        return ResponseEntity.ok("success");

    }
}