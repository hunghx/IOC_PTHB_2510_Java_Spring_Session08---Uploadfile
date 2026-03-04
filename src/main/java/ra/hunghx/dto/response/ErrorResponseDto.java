package ra.hunghx.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;
@Getter
@Setter
@Builder // tạo đối tượng nhanh
public class ErrorResponseDto {
    private int code; // 400
    private String message;  // thông báo lỗi
    private Object details ;
    /*
        userId : "Không đúng định dạng",
        email : ""
     */
    private LocalDateTime timestamp = LocalDateTime.now();
}
