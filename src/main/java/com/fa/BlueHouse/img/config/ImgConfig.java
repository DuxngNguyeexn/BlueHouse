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
          .addResourceLocations("file:///E:/Eclip/img/request/");
		  
		  registry.addResourceHandler("/imagesRepair/**")
          .addResourceLocations("file:///E:/Eclip/img/repair/");
		  
		  registry.addResourceHandler("/imagesReport/**")
          .addResourceLocations("file:///E:/Eclip/img/report/");
		  
		  registry.addResourceHandler("/imgNotification/**")
			.addResourceLocations("file:///E:/imgNoti/");
		  
		  registry.addResourceHandler("/imgResident/**")
			.addResourceLocations("file:///E:/Eclip/img/resident/");
		  registry.addResourceHandler("/imgEmployee/**")
			.addResourceLocations("file:///E:/Eclip/img/employee/");
		  }
	 
}


