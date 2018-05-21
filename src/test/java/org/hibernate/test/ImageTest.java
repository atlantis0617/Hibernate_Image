package org.hibernate.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ImageTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void before() {
		Configuration config = new Configuration().configure();// 创建配置对象
		sessionFactory = config.buildSessionFactory();// 创建SessionFactory对象
		session = sessionFactory.openSession();// 创建session对象
		transaction = session.beginTransaction(); // 开启事务
	}
	
	@After
	public void after() {
		transaction.commit();// 提交事务
		session.close();// 关闭session
		sessionFactory.close();// 关闭SessionFactory
	}
	
	
	@Test
	public void saveStudentWithImage() throws Exception {
		// 获取图片文件
		File file = new File("E:\\Program Files (x86)\\Chm\\前端\\5000个extjs小图标\\ExtJS icons\\anchor.png");
		// 获取图片文件的输入流
		InputStream is = new FileInputStream(file);
		// 创建一个Blob对象
		Blob image = Hibernate.getLobCreator(session).createBlob(is, is.available());
		// 创建Student对象
		Student s = new Student("张三", "男", new Date(), "北京市", image);
		// 保存对象
		session.save(s);
	}
	
	@Test
	public void readImage() throws Exception {
		Student s = session.get(Student.class, 1L);
		// 获取图片的Blob对象
		Blob image = s.getImage();
		// 获取照片的输入流
		InputStream is = image.getBinaryStream();
		// 创建输出文件
		File file = new File("C:\\Users\\atlantis0617\\Desktop\\test.jpg");
		// 获取输出流
		OutputStream os = new FileOutputStream(file);
		// 创建缓存区
		byte[] buff = new byte[is.available()];
		// 将输入流读入到缓存中
		is.read(buff);
		// 将缓存区数据写到输出流中
		os.write(buff);
		// 关闭输入流
		is.close();
		// 关闭输出流
		os.close();
	}
	
}
