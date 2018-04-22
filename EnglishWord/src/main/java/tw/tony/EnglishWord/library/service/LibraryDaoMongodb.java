package tw.tony.EnglishWord.library.service;

import java.util.HashMap;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.DBCollection;
import com.mongodb.WriteResult;

import Spring.MongoDBUtils;
import tw.tony.EnglishWord.library.domain.LibraryBean;
import tw.tony.EnglishWord.member.domain.MemberBean;

@Component
public class LibraryDaoMongodb implements LibraryDao {
	
	//查詢目前總筆數
	public int selectCount() {
		MongoOperations mongoOps = MongoDBUtils.getMongoTemplate();	
		DBCollection bean = mongoOps.getCollection("Library");
		return (int)bean.getCount();
	}
	
	//隨機產生題目
	@Override
	public LibraryBean selectByidNumber(int idNumber) {
		MongoOperations mongoOps = MongoDBUtils.getMongoTemplate();
		String idNum =String.valueOf(idNumber);
		Query query = new Query(Criteria.where("idNumber").is(idNum));		
		LibraryBean bean = mongoOps.findOne(query, LibraryBean.class);
		return bean;
	}
	
	//傳回來的題目(中文題目) 來搜尋答案(英文答案)
	@Override
	public String selectChineseExam(String exam) {
		MongoOperations mongoOps = MongoDBUtils.getMongoTemplate();
		Query query = new Query(Criteria.where("cWord").is(exam));	
		LibraryBean bean = mongoOps.findOne(query, LibraryBean.class);
		return bean.geteWord();		
	}
	
	//傳回來的題目(英文題目) 來搜尋答案(中文答案)
		@Override
		public String selectEnglishExam(String exam) {
			MongoOperations mongoOps = MongoDBUtils.getMongoTemplate();
			Query query = new Query(Criteria.where("eWord").is(exam));	
			LibraryBean bean = mongoOps.findOne(query, LibraryBean.class);
			return bean.getcWord();		
		}
	
	@Override
	public LibraryBean insert(LibraryBean wordData) {
		MongoOperations mongoOps = MongoDBUtils.getMongoTemplate();
		mongoOps.insert(wordData);
		return wordData;		
	}
	
	@Override
	public LibraryBean insertExam(String idnumber,String ChineseWord,String EnglishWord) {
		MongoOperations mongoOps = MongoDBUtils.getMongoTemplate();
		Query query = new Query(Criteria.where("eWord").is(EnglishWord));
		//setOnInsert是當insert動作執行後 才會執行這動作(設定塞進去的資料)
		Update update= new Update().setOnInsert("eWord", EnglishWord).setOnInsert("cWord", ChineseWord).setOnInsert("idNumber",idnumber);
		FindAndModifyOptions options = new FindAndModifyOptions();  
		
		//如果query有結果，執行update;如果query沒結果 就會insert一筆新的(update方法)
		options.upsert(true);   
//		MemberBean bean = mongoOps.findOne(query, MemberBean.class);
		LibraryBean bean = mongoOps.findAndModify(query, update,options, LibraryBean.class);
		return bean;	
	}
	
	
	@Override
	public void updateUser(LibraryBean wordData) {
		 MongoOperations mongoOps = MongoDBUtils.getMongoTemplate();
//	        Query query=new Query(Criteria.where("userName").is(user.getUserName()));
//	        Update update= new Update().set("userName", user.getUserName()).set("exam", user.getExam());
	        //更新查询返回结果集的第一条
//	        WriteResult updateUser =mongoOps.updateFirst(query,update,MemberBean.class);
//	        System.out.println("WriteResult="+updateUser);
	        //更新查询返回结果集的所有
	        // mongoTemplate.updateMulti(query,update,TextBean.class);
	    }

	@Override
	public void deleteUserById(Long id) {
	        Query query=new Query(Criteria.where("id").is(id));
//	        mongoTemplate.remove(query,MemberBean.class);
	    }
}
