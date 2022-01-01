package Homework2;

import java.util.ArrayList;

public class Block {
	private String blockID;
	private String blockMaker;
	private long blockHeight;
	private String timestamp;
	private String nonce;
	private String preBlockID;
	private String merkleRoot;
	private MerkleTree merkleTree;
	private ArrayList<Transaction> confirmingTransaction;
	public Block() {}
	public Block(String blockID, String blockMaker, long blockHeight,
			String timestamp, String Nonce, String preBlockID, String merkleRoot,
			MerkleTree merkleTree, ArrayList<Transaction> transactions) {
		this.confirmingTransaction = new ArrayList<Transaction>();
		this.blockID = blockID;
		this.blockMaker = blockMaker;
		this.blockHeight = blockHeight;
		this.timestamp = timestamp;
		this.nonce = Nonce;
		if(blockHeight == 0) this.preBlockID = "";
		else this.preBlockID = preBlockID;
		
		this.merkleTree = merkleTree;
		this.merkleRoot = merkleRoot;
		this.confirmingTransaction = transactions;
	}
	public String getBlockID() {
		return blockID;
	}
	public void setBlockID(String blockID) {
		this.blockID = blockID;
	}
	public String getBlockMaker() {
		return blockMaker;
	}
	public void setBlockMaker(String blockMaker) {
		this.blockMaker = blockMaker;
	}
	public long getBlockHeight() {
		return blockHeight;
	}
	public void setBlockHeight(long blockHeight) {
		this.blockHeight = blockHeight;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getPreBlockID() {
		return preBlockID;
	}
	public void setPreBlockID(String preBlockID) {
		this.preBlockID = preBlockID;
	}
	public String getMerkleRoot() {
		return merkleRoot;
	}
	public void setMerkleRoot(String merkleRoot) {
		this.merkleRoot = merkleRoot;
	}
	public MerkleTree getMerkleTree() {
		return merkleTree;
	}
	public void setMerkleTree(MerkleTree merkleTree) {
		this.merkleTree = merkleTree;
	}
	public ArrayList<Transaction> getConfirmingTransaction() {
		return confirmingTransaction;
	}
	public void setConfirmingTransaction(ArrayList<Transaction> confirmingTransaction) {
		this.confirmingTransaction = confirmingTransaction;
	}
	
	public String toString() {
		String head = String.format("=============Bloack Head==============\n"
				+ "Block ID %s\nBlock Maker %s\n Time Stamp : %s\nPreBlock ID : %s\n"
				+ "Merkle Root: %s\nNonce : %s\n", this.blockID, this.blockMaker, this.timestamp,
				this.preBlockID, this.merkleRoot, this.nonce);
		String body = "===================Block Body================\n[";
		for(int i =0; i<4; i++) {
			body += confirmingTransaction.get(i).toString();
		}
		body += "]\n";
		
		return head+body;
	}
}
