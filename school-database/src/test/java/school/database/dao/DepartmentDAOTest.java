package school.database.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import school.database.entity.Department;

public class DepartmentDAOTest {

	@ParameterizedTest
	@CsvSource({"2,Business", "3, Culture & History"})
	public void csvTest(Integer id, String name ) {
		Department expected = new Department();
		expected.setId(id);
		expected.setName(name);
		
		DepartmentDAO ddao = new DepartmentDAO();
		Department actual = ddao.findById(id);
		
		Assertions.assertEquals(expected,actual);
	}
	
	
}
