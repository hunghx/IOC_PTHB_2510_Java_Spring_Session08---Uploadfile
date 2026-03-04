package ra.hunghx.dto.response;

import java.time.LocalDateTime;

public class ResponseSuccesDto<T> {
    private int code;
    private String message;
    private T data;
    private LocalDateTime timestamp = LocalDateTime.now();

    public static void main(String[] args) {
        System.out.println(Math.round(4.5));
    }
}
