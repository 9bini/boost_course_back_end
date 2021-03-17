package kr.or.connect.daoexam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDao;
import kr.or.connect.daoexam.dto.Role;

public class JDBCTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		RoleDao roleDao = ac.getBean(RoleDao.class);

		/*
		Role role = new Role();
		role.setRoleId(201);

		// role.setDescription("CEO");
		int count = roleDao.insert(role);
		System.out.println(count + "건 입력하였습니다.");

		role.setDescription("PROGRAMMER");
		count = roleDao.update(role);

		System.out.println(count + "건 입력하였습니다.");
		 */
		int deleteCount = roleDao.deleteById(500);
		System.out.println(deleteCount);
		Role resultRole2 = roleDao.selectById(500);
		System.out.println(resultRole2);
		
	}
}
