package myblockchain;
import java.util.Date;

public class Block {

	public String hash;
	public String previousHash;
	private String data; //data will be in the form of a message
	private long timeStamp; //number of milliseconds

	//Block Constructor.
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
	}
        
        public String calculateHash() {
	String calculatedhash = HashUtil.applySha256( 
			previousHash +
			Long.toString(timeStamp) +
			data 
			);
	return calculatedhash;
}
         
}

