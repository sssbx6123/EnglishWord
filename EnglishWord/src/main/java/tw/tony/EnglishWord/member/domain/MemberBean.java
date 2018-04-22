package tw.tony.EnglishWord.member.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Member")
public class MemberBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private ObjectId _id;
	@Indexed(unique=true)
	private String userName; 
	private Object exam;
	
	
	@Override
	public String toString() {
		return "MemberBean [_id=" + _id + ", userName=" + userName + ", exam=" + exam + "]";
	}
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Object getExam() {
		return exam;
	}
	public void setExam(Object exam) {
		this.exam = exam;
	}
	
	
}
