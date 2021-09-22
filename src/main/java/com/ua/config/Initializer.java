package com.ua.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	//implements WebApplicationInitializer
//	public void onStartup(ServletContext servletContext)
//			throws ServletException {
//		
//		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//		ctx.register(WebAppConfig.class);
//		servletContext.addListener(new ContextLoaderListener(ctx));
//		
//		ctx.setServletContext(servletContext);
//		
//		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
//		servlet.addMapping("/");
//		servlet.setLoadOnStartup(1);
//		
//		
//	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {WebAppConfig.class}; // We dont need any special servlet config yet.
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
