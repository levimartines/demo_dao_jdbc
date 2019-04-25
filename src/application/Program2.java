package application;

import java.util.ArrayList;
import java.util.List;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		List<Department> list = new ArrayList<>();
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		Department dep = new Department(1, null);

		System.out.println("--- TEST 1: department insert ---");
		depDao.insert(dep);	
		System.out.println("Inserted! Department ID = " + dep.getId());
		System.out.println();

		System.out.println("--- TEST 2: department update ---");
		dep.setName("French Fries");
		depDao.update(dep);
		System.out.println(dep);
		System.out.println();

		System.out.println("--- TEST 3: department delete ---");
		depDao.deleteById(5);
		System.out.println("Department deleted!");
		System.out.println();
		
		System.out.println("--- TEST 4: department findById ---");
		dep=depDao.findById(2);
		System.out.println(dep);
		System.out.println();
		
		System.out.println("--- TEST 5: department findAll ---");
		list=depDao.findAll();
		for(Department e:list) {
			System.out.println(e);
		}
		System.out.println();
	}
}
