package lab.spring.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	@Select("SELECT SYSDATE FROM DUAL")
	public String getTime();
	
//	TimeMapper xml과 인터페이스 사용
//	@Select와 어노테이션 사용 안함
	public String getTime2();
}
