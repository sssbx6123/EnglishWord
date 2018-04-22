package tw.tony.EnglishWord.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//@Component
//@ConfigurationProperties
//@RestController
//public class TextController {
//
//    @Autowired
//    private TextDao userDao;
//    
//    @RequestMapping("/insertMember")
//    public void testSaveUser() throws Exception {
//        TextBean user=new TextBean();
//        user.setId(2l);
//        user.setUserName("小明");
//        user.setPassWord("fffooo123");
//        userDao.insert(user);
//    }
//    
//    @RequestMapping(path= {"s/selectMember"},method = { RequestMethod.GET,
//			RequestMethod.POST },produces = "text/plain;charset=UTF-8")
//    public @ResponseBody String findUserByUserName(){
//    	TextBean user= userDao.select("Apple");
//       System.out.println("user is "+user.getPassWord());
//       return user.getUserName();
//    }
//
//    public void updateUser(){
//    	TextBean user=new TextBean();
//        user.setId(2l);
//        user.setUserName("天空");
//        user.setPassWord("fffxxxx");
//        userDao.updateUser(user);
//    }
//
//    public void deleteUserById(){
//        userDao.deleteUserById(1l);
//    }
//
//}
