package tw.tony.EnglishWord.library.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Library")
public class LibraryBean {
	private static final long serialVersionUID = 1L;
	@Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	private ObjectId _id; 
	@Indexed(unique=true)
	private String idNumber; 
	private String cWord;
	@Indexed(unique=true)
	private String eWord;
	
	@Override
	public String toString() {
		return "LibraryBean [_id=" + _id + ", idNumber=" + idNumber + ", cWord=" + cWord + ", eWord=" + eWord + "]";
	}
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getcWord() {
		return cWord;
	}
	public void setcWord(String cWord) {
		this.cWord = cWord;
	}
	public String geteWord() {
		return eWord;
	}
	public void seteWord(String eWord) {
		this.eWord = eWord;
	}
	
	
}
