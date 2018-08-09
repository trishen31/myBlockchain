
package myblockchain;

import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class myBlockchain {

    
    public static ArrayList<Block> blockchain = new ArrayList<Block>(); 

	public static void main(String[] args) {	
		//Adding test blocks to blockchain arraylist:
		blockchain.add(new Block("Trishen Patel - Testing the first block", "0"));
		blockchain.add(new Block("COMP424 - Testing the second block",blockchain.get(blockchain.size()-1).hash)); 
		blockchain.add(new Block("August 6, 2018 - Testing the third block",blockchain.get(blockchain.size()-1).hash));
                
                //Printing out blockchain unaltered
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
		System.out.println("Blockchain Unaltered:\n" + blockchainJson + "\n\nChecking if blockchain is valid:\n" + isChainValid());
                
                //Altering data by overriding a block
                blockchain.set(1, new Block("Overriding the second block", blockchain.get(blockchain.size()-1).hash));
                
                //Checking if blockchain has been altered
		blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
		System.out.println("\n\nBlockchain Altered:\n" + blockchainJson + "\n\nChecking if blockchain is valid:");
                System.out.println(isChainValid());
	}
        
        
        public static Boolean isChainValid() {
	Block currentBlock; 
	Block previousBlock;
	
	//loop through blockchain to check hashes:
	for(int i=1; i < blockchain.size(); i++) {
		currentBlock = blockchain.get(i);
		previousBlock = blockchain.get(i-1);
		//compare registered hash and calculated hash:
		if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
			System.out.println("Current Hashes not equal");			
			return false;
		}
		//compare previous hash and registered previous hash
		if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
			System.out.println("Previous Hashes not equal for block#: " + (i+1) );
			return false;
		}
	}
	return true;
}
    
    
}
