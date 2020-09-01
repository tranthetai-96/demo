package config;

import java.util.Locale;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import Interceptor.AuthorizeInterceptor;
import util.MailSenderUtil;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"controller", "dao"})
public class WebContextConfig implements WebMvcConfigurer
{
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResource = new InternalResourceViewResolver();
		viewResource.setPrefix("/WEB-INF/view/layout.jsp?view=/WEB-INF/view/");
		viewResource.setSuffix(".jsp");
		return viewResource;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/").setCachePeriod(0);
		registry.addResourceHandler("/css/**").addResourceLocations("/resources/themes/theme0/").setCachePeriod(0);
		registry.addResourceHandler("/upload/**").addResourceLocations("/files/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeInterceptor());
		registry.addInterceptor(new AuthorizeInterceptor()).addPathPatterns("/**").excludePathPatterns("/login.html", "/images/**","/signin.html");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	@Bean
    public LocaleChangeInterceptor localeInterceptor(){
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setDefaultEncoding("utf-8");
		messageSource.setBasenames("classpath:global", "classpath:message");
		return messageSource;
	}
	
	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("vi"));
		localeResolver.setCookieName("locale");
		localeResolver.setCookieMaxAge(43200);
		return localeResolver;
	}
	
	@Bean
	public JavaMailSenderImpl mailSender() {
		Properties mailProps = new Properties();
		mailProps.put("mail.smtps.auth", "true");
	    mailProps.put("mail.smtp.starttls.enable", "true");

		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.gmail.com");
		sender.setPort(587);
		sender.setUsername("testjavamailjava5@gmail.com");
		sender.setPassword("fpoly@123");
		sender.setJavaMailProperties(mailProps);
		return sender;
	}
	
	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
	}
	
	@Override
	public Validator getValidator() {
		return validator();
	}
	
	@Bean
	public MailSenderUtil mailSenderUtil() {
		return new MailSenderUtil();
	}
	
	public StandardServletMultipartResolver multipartResolver() {
		StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
		return multipartResolver;
	}
}
