package config;

import java.io.File;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	 private int maxUploadSizeInMb = 1024 * 1024; // 1 MB
     
	 private File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {ApplicationContextConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebContextConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] {new CharacterEncodingFilter("UTF-8", true)};
	}
	
	private MultipartConfigElement getMultipartConfigElement() {
        MultipartConfigElement multipartConfigElement = new
            MultipartConfigElement(uploadDirectory.getAbsolutePath(),
                maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);
        return multipartConfigElement;
    }
     
    @Override
    protected void customizeRegistration(Dynamic registration) {
        registration.setMultipartConfig(getMultipartConfigElement());
    }
    
    
}
