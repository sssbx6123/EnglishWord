package tw.tony.EnglishWord.library.service;

import java.util.regex.Pattern;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.DBCollection;

import Spring.MongoDBUtils;
import tw.tony.EnglishWord.library.domain.LibraryBean;

@Service
@Transactional
public class LibraryService {
	// 查詢目前總筆數
	public int selectCount() {
		LibraryDaoMongodb libraryDAO = new LibraryDaoMongodb();
		int count = libraryDAO.selectCount();
		return count;
	}

	// 隨機產生題目
	public String createExam() {
		LibraryDaoMongodb libraryDAO = new LibraryDaoMongodb();
		int count = this.selectCount();
		int numberCount = (int) (Math.random() * count) + 1;
		System.out.println("numberCount" + numberCount);
		LibraryBean result = libraryDAO.selectByidNumber(numberCount);
		int exam = (int) (Math.random() * 10) + 1;
		if (exam % 2 == 0) {
			return result.getcWord();
		} else {
			return result.geteWord();
		}
	}

	// 答案比對
	public String selectAnswer(String exam, String answer) {
		LibraryDaoMongodb libraryDAO = new LibraryDaoMongodb();
		String finalResult = "N";
		String result = null;
		if (exam != null && exam.trim().length() > 0) {
			if ((this.isChinese(exam))) {
				result = libraryDAO.selectChineseExam(exam);
				if ((result.toLowerCase()).equals(answer.toLowerCase())) {
					finalResult = "Y";
				}
			} else if (exam.matches("^[A-Za-z]+$")) {
				result = libraryDAO.selectEnglishExam(exam);
				if (result.equals(answer)) {
					finalResult = "Y";
				}
			}
		}
		return finalResult;
	}

	// 判斷是否為中文
	public boolean isChinese(String con) {
		for (int i = 0; i < con.length(); i = i + 1) {
			if (!Pattern.compile("[\u4e00-\u9fa5]").matcher(String.valueOf(con.charAt(i))).find()) {
				return false;
			}
		}
		return true;
	}
	//使用者新增題目
	public boolean insertExam(String ChineseExam,String EnglishExam) {
		LibraryDaoMongodb libraryDAO = new LibraryDaoMongodb();
		if(ChineseExam !=null && ChineseExam.trim().length()>0 && EnglishExam !=null && EnglishExam.trim().length()>0 ) {		
			libraryDAO.insertExam(String.valueOf(this.selectCount()+1), ChineseExam, EnglishExam);
			return true;
		}
		return false;		
	}
}
