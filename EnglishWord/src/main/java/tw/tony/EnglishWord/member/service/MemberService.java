package tw.tony.EnglishWord.member.service;

import java.util.HashMap;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.tony.EnglishWord.member.domain.MemberBean;

@Service
@Transactional
public class MemberService {

	// @Autowired
	// private MemberDaoMongodb memberDAO;
	// MemberDaoMongodb memberDAO = new MemberDaoMongodb();

	// 搜尋使用者名稱 如果有 就找出來;如果沒有
	public MemberBean selectByUserName(String userName) {
		MemberBean result = null;
		if (userName != null && userName.length() > 0) {
			MemberDaoMongodb memberDAO = new MemberDaoMongodb();
			result = memberDAO.select(userName);
			// String Name = result.getUserName();
			System.out.println("RESULT=" + result);
			return result;
		} else {
			return null;
		}
	}

	// 當使用者做題目時 做一次就要呼叫一次這種方法
	public MemberBean userDoExam(String userName, String exam, String result) {
		if (userName != null && userName.trim().length() > 0 && exam != null && exam.trim().length() > 0
				&& result != null && result.trim().length() > 0) {
			MemberDaoMongodb memberDAO = new MemberDaoMongodb();
			MemberBean bean = new MemberBean();
			MemberBean data = memberDAO.select(userName);
			HashMap<String, HashMap<String, Integer>> examData = (HashMap<String, HashMap<String, Integer>>) data
					.getExam();
			HashMap<String, Integer> count = new HashMap<>();
			// 判斷是否做過此題
			if (examData.containsKey(exam)) {
				// 還要判斷答對還答錯
				if (result.equals("Y")) {
					count.put("rightCount", examData.get(exam).get("rightCount") + 1);
					count.put("errorCount", examData.get(exam).get("errorCount"));
				} else {
					count.put("rightCount", examData.get(exam).get("rightCount"));
					count.put("errorCount", examData.get(exam).get("errorCount") + 1);
				}
				// 如果答錯
				// count.put("rightCount", examData.get("Zoo").get("rightCount"));
				// count.put("errorCount", examData.get("Zoo").get("errorCount")+1);
			} else {
				if (result.equals("Y")) {
					count.put("rightCount", 1);
					count.put("errorCount", 0);
				} else {
					count.put("rightCount", 0);
					count.put("errorCount", 1);
				}
			}
			examData.put(exam, count);
			bean.set_id(data.get_id());
			bean.setExam(examData);
			bean.setUserName(userName);
			memberDAO.updateUser(bean);
			return bean;
		}
		return null;
	}
}
