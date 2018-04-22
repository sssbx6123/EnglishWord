package tw.tony.EnglishWord.member.service;

import java.util.HashMap;

import org.bson.Document;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.WriteResult;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;

import Spring.MongoDBUtils;
import tw.tony.EnglishWord.member.domain.MemberBean;

@Component
public class MemberDaoMongodb implements MemberDao {
//	@Autowired
//    private MongoTemplate mongoTemplate;
//	MongoTemplate
//	@Autowired
//	private MongoDBUtils ongoDBUtils;

//    @Autowired
//    public TextDaoMongodb(MongoTemplate mongoTemplate) {
//        this.mongoTemplate = mongoTemplate;
//    }
	
	@Override
	public MemberBean select(String userName) {
			MongoOperations mongoOps = MongoDBUtils.getMongoTemplate();	
			Query query = new Query(Criteria.where("userName").is(userName));
			HashMap<String,HashMap<String, Integer>> exam = new HashMap<>();
			//setOnInsert是當insert動作執行後 才會執行這動作(設定塞進去的資料)
			Update update= new Update().setOnInsert("userName", userName).setOnInsert("exam", exam);
			FindAndModifyOptions options = new FindAndModifyOptions();  
			
			//如果query有結果，執行update;如果query沒結果 就會insert一筆新的(update方法)
			options.upsert(true);   
//			MemberBean bean = mongoOps.findOne(query, MemberBean.class);
			MemberBean bean = mongoOps.findAndModify(query, update,options, MemberBean.class);
			return bean;
	}

	//新增使用者
	@Override
	public MemberBean insert(MemberBean user) {

		MongoOperations mongoOps = MongoDBUtils.getMongoTemplate();
			System.out.println("USER="+user);
			mongoOps.insert(user);
		return user;
	}
	 @Override
	public void updateUser(MemberBean user) {
		 MongoOperations mongoOps = MongoDBUtils.getMongoTemplate();
	        Query query=new Query(Criteria.where("userName").is(user.getUserName()));
	        Update update= new Update().set("userName", user.getUserName()).set("exam", user.getExam());
	        //更新查询返回结果集的第一条
	        WriteResult updateUser =mongoOps.updateFirst(query,update,MemberBean.class);
	        System.out.println("WriteResult="+updateUser);
	        //更新查询返回结果集的所有
	        // mongoTemplate.updateMulti(query,update,TextBean.class);
	    }

	  @Override
	public void deleteUserById(Long id) {
	        Query query=new Query(Criteria.where("id").is(id));
//	        mongoTemplate.remove(query,MemberBean.class);
	    }
}
