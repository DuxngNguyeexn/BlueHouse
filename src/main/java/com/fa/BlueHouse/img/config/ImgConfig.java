package com.fa.BlueHouse.img.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class ImgConfig  implements WebMvcConfigurer {
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        // Cấu hình để truy cập vào ảnh trong thư mục 
		  registry.addResourceHandler("/imagesRequest/**")
          .addResourceLocations("file:///E:/TaiLieu/Mock%20project/request/img/");
		  registry.addResourceHandler("/imagesRepair/**")
          .addResourceLocations("file:///E:/TaiLieu/Mock%20project/repair/img/");
		  registry.addResourceHandler("/imagesReport/**")
          .addResourceLocations("file:///E:/TaiLieu/Mock%20project/report/img/");
		  registry.addResourceHandler("/imagesRepair/**")
          .addResourceLocations("file:///E:/TaiLieu/Mock%20project/repair/img/");
		  registry.addResourceHandler("/imgNotification/**")
			.addResourceLocations("file:///E:/imgNoti/");
		  registry.addResourceHandler("/imgResident/**")
			.addResourceLocations("file:///D:/Spring-Boot/imgdate/");
		  }
	 
}


