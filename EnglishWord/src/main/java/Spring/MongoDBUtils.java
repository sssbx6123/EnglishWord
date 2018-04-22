package Spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.DB;
import com.mongodb.DBCollection;

public class MongoDBUtils {
	private static ApplicationContext factory=null;
	private static MongoTemplate mongoTemplate = null;
	
	static {
		factory=new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
		mongoTemplate = (MongoTemplate) factory.getBean("mongoTemplate");
	}
	public static MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
}
