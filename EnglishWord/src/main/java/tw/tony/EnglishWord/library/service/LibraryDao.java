package tw.tony.EnglishWord.library.service;

import tw.tony.EnglishWord.library.domain.LibraryBean;

public interface LibraryDao {

	//隨機產生題目
	LibraryBean selectByidNumber(int idNumber);

	LibraryBean insert(LibraryBean wordData);

	void updateUser(LibraryBean wordData);

	void deleteUserById(Long id);


	String selectChineseExam(String exam);

	String selectEnglishExam(String exam);


	LibraryBean insertExam(String idnumber, String ChineseWord, String EnglishWord);

}