package application;

import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===== TEST 1 DEPARTMENT FindAll =====");
		List<Department> listAll = departmentDao.findAll();
	
		for (Department obj : listAll) {
			System.out.println(obj);
		}
		System.out.println("======================================\n");
		
		System.out.println("===== TEST 2 DEPARTMENT FindById =====");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		System.out.println("======================================\n");
		
		System.out.println("===== TEST 3 DEPARTMENT Insert =====");
		Department ndep = new Department(null, "Flores");
		departmentDao.insert(ndep);
		System.out.println("Id Incluso!!!");
		System.out.println("Id:" + ndep.getId() + " - Name: " + ndep.getName());
		System.out.println("======================================\n");
		
		System.out.println("===== TEST 4 DEPARTMENT Update =====");
		dep = departmentDao.findById(1);
		dep.setName("LineArt Alterado");
		departmentDao.update(dep);
		System.out.println("Registro Alterado! "); 
		System.out.println(dep);
		System.out.println("======================================\n");
		
		System.out.println("===== TEST 5 DEPARTMENT Delete =====");
		dep = departmentDao.findById(ndep.getId());
		departmentDao.deleteById(dep.getId());
		System.out.println("Registro Excluído!!!"); 
		System.out.println(dep);
		System.out.println("======================================\n");
		
		
		DB.closeConnection();
				
		

	}

}
