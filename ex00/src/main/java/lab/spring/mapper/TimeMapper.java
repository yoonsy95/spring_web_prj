package lab.spring.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	@Select("SELECT SYSDATE FROM DUAL")
	public String getTime();
	
//	TimeMapper xml�� �������̽� ���
//	@Select�� ������̼� ��� ����
	public String getTime2();
}
