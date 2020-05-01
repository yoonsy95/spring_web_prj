package lab.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

//	ServletConfig 클래수 정상적으로 실행 위하여
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

//	spring mvc 기본 경로
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
}
