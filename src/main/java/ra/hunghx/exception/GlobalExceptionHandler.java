package ra.hunghx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.hunghx.dto.response.ErrorResponseDto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice  // @RestController vs @ControllerAdvice
public class GlobalExceptionHandler {
    // Lỗi người dùng : 400
    // Lỗi DB : 409  ,...
    // lỗi server : 500
    // xử lý trường hợp dữ liệu đã tồn tại : 409 ;


    // bắt và xử ly
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerArgument(MethodArgumentNotValidException ex){
        Map<String, String> details = new HashMap<>();
        ex.getFieldErrors().forEach(fieldError -> {
            details.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        ErrorResponseDto res = ErrorResponseDto.builder()
                .code(400)
                .message("ARGUMENT INVALID")
                .details(details)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
    // bắt và xử ly
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFound(ResourceNotFoundException ex){

        ErrorResponseDto res = ErrorResponseDto.builder()
                .code(404) // ko tìm thấy
                .message("NOT FOUND")
                .details(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessage(HttpMessageNotReadableException ex){
        return new ResponseEntity<>("Đã xử lý" , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleOtherException(Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
