package com.privalia.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.privalia.domain.Address;
import com.privalia.domain.Student;
import com.privalia.repositories.StudentRepository;
import com.privalia.configuration.RepositoryConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RepositoryConfiguration.class}) 
public class StudentRepositoryTest { 

	@Rule
	public TestName testName = new TestName();
	
	public static final Logger LOGGER = LoggerFactory.getLogger(StudentRepositoryTest.class);
	
	private StudentRepository studentRepository;
	private Student student1 = null;
	private Student student2 = null;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Before
	public void setUp() throws Exception {
		List<Address> addresses= new ArrayList<>();
		addresses.add(new Address(1, "street 1", "1"));
		addresses.add(new Address(2, "street 2", "2"));
		
		Iterable<Address> adr = addressRepository.save(addresses);
        List<Address> listAdd = new ArrayList<>();
        adr.forEach(listAdd::add);
		
		student1 = new Student();
		student1.setName("Pepe");
		student1.setSurname("Rodriguez");
		student1.setId(1232);
		student1.setAddress(listAdd);
		studentRepository.save(student1);

		List<Address> addresses2= new ArrayList<>();
		addresses2.add(new Address(3, "street 3", "3"));
		
		Iterable<Address> adr2 = addressRepository.save(addresses2);
        List<Address> listAdd2 = new ArrayList<>();
        adr.forEach(listAdd2::add);
		
		student2 = new Student();
		student2.setName("Luis");
		student2.setSurname("Perez");
		student2.setId(1233);
		student2.setAddress(listAdd2);
		studentRepository.save(student2);
		LOGGER.info("Starter test " + testName.getMethodName());
	}

	@After
	public void after() throws Exception {
		LOGGER.info("Finished test " + testName.getMethodName());
		studentRepository.deleteAll();
	}

	@Test
	public void testSaveStudent() {
		Student student = new Student();
		student.setName("Jose");
		student.setSurname("Martin");
		student.setId(6969);
		assertNull(student.getId());
		studentRepository.save(student);
		assertNotNull(student.getId());

	}

	@Test
	public void testGetAllStudents() {
		Iterable<Student> students = studentRepository.findAll();
		long size = students.spliterator().getExactSizeIfKnown();
		assertEquals(size, 2);
	}

	@Test
	public void testModifyStudent() { 
		student1.setName("New name");
		Student updateStudent = studentRepository.save(student1);
		assertEquals(updateStudent.getName(), "New name");
	}

	@Test 
	public void testRemoveStudent() {
		studentRepository.delete(student1.getId());
		assertNull(studentRepository.findOne(student1.getId()));
	}
	
	@Test
	public void testFindByName() {
		Iterable<Student> students2 = studentRepository.findByName("Luis");
		assertNotNull(student2.getName());
	}
}