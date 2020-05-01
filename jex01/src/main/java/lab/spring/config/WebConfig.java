package lab.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

//	ServletConfig Ŭ���� ���������� ���� ���Ͽ�
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

//	spring mvc �⺻ ���
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
}
