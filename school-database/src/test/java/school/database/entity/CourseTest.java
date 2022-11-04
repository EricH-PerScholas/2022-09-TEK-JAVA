package school.database.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import school.database.dao.CourseDAO;

public class CourseTest {


	@Test
	public void testEquals() {
		Course c1 = new Course();
		c1.setId(1);
		c1.setName("c1");
		
		Course c2 = new Course();
		c2.setId(2);
		c2.setName("c2");
		
		Course c3 = new Course();
		c3.setId(1);
		c3.setName("c1");
		
		Assertions.assertNotEquals(c1, c2);
		Assertions.assertEquals(c1, c3);
	}
	
	@Test
	public void testDeptId() {
		CourseDAO courseDao = new CourseDAO();
		
		Course c = courseDao.findById(1);
		
		int a = c.getDeptId();
		int b = c.getDepartment().getId();
		
		Assertions.assertEquals(a,b);
		
	}
	
}
