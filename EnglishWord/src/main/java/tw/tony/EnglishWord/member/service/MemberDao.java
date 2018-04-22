package tw.tony.EnglishWord.member.service;

import tw.tony.EnglishWord.member.domain.MemberBean;

public interface MemberDao {

	MemberBean select(String UserName);

	MemberBean insert(MemberBean user);

	void updateUser(MemberBean user);

	void deleteUserById(Long id);

}