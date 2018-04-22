package tw.tony.EnglishWord;

import java.util.HashMap;

import org.bson.types.ObjectId;

import tw.tony.EnglishWord.library.domain.LibraryBean;
import tw.tony.EnglishWord.library.service.LibraryDaoMongodb;
import tw.tony.EnglishWord.library.service.LibraryService;
import tw.tony.EnglishWord.member.domain.MemberBean;
import tw.tony.EnglishWord.member.service.MemberDaoMongodb;
import tw.tony.EnglishWord.member.service.MemberService;

public class CityFinder {
	public static void main(String[] args) {
		MemberDaoMongodb text = new MemberDaoMongodb();
		LibraryDaoMongodb textLibrary = new LibraryDaoMongodb();
		LibraryService sc = new LibraryService();
//		System.out.println("exam123="+textLibrary.selectChineseExam(sc.createExam()));
//		String result = sc.selectAnswer("電腦", "Computer");
		boolean result = sc.insertExam("中文","chinese");
		System.out.println("result:"+result);
//		System.out.println("exam="+textLibrary.selectEnglishExam("computer"));
		//測試 搜尋
//		MemberService sc = new MemberService();
//		MemberBean bean = sc.selectByUserName(zxcv");
//		if(bean!=null) {
//			Object exam = bean.getExam();
//			System.out.println("exam="+exam);			
//		}
		
		//測試做題目
//		MemberService sc = new MemberService();
//		MemberBean reuslt = sc.userDoExam("Tony", "Dog", "Y");
//		System.out.println("reuslt="+reuslt);
		
//		int totalCount =textLibrary.selectCount();
//		LibraryBean bean = new LibraryBean();
//		bean.set_id(new ObjectId());
//		bean.setIdNumber(String.valueOf(totalCount+1));
//		bean.setcWord("燈光");
//		bean.seteWord("light");
//		LibraryBean newWord = textLibrary.insert(bean);
//		System.out.println("新單字="+newWord.getcWord());
		
	}
}
