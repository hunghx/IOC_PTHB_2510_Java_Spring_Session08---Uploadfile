package ra.hunghx;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UploadfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadfileApplication.class, args);
    }
    @Value("${cloudinary.cloud-name}")
    private String cloudName;
    @Value("${cloudinary.api-key}")
    private String apiKey;
    @Value("${cloudinary.secret-key}")
    private String apiSecret;
    // tạo bean của cloudinary
    @Bean
    public Cloudinary cloudinary(){
        System.out.println(cloudName);
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name",cloudName,
                "api_key",apiKey,
                "api_secret",apiSecret,
                "secure", true
        ));
    }
}
