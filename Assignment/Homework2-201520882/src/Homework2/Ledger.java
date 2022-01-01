package Homework2;

import java.util.ArrayList;
import java.util.List;

public class Ledger {
	private List<Block> blockchain;
	private List<Transaction> unconfirmedTransaction;
	private Block newBlock;
	private boolean isNewBlockCreated;
	public Ledger() {
		newBlock = null;
		isNewBlockCreated = false;
		unconfirmedTransaction = new ArrayList<Transaction>();
		blockchain = new ArrayList<Block>();
	}
	
	public Block findBlock(long blockHeight) {
		return blockchain.get((int)blockHeight);
	}

	public List<Block> getBlockchain() {
		return blockchain;
	}

	public void setBlockchain(List<Block> blockchain) {
		this.blockchain = blockchain;
	}

	public List<Transaction> getUnconfirmedTransaction() {
		return unconfirmedTransaction;
	}

	public void setUnconfirmedTransaction(List<Transaction> unconfirmedTransaction) {
		this.unconfirmedTransaction = unconfirmedTransaction;
	}

	public Block getNewBlock() {
		return newBlock;
	}

	public void setNewBlock(Block newBlock) {
		this.newBlock = newBlock;
	}

	public boolean isNewBlockCreated() {
		return isNewBlockCreated;
	}

	public void setNewBlockCreated(boolean isNewBlockCreated) {
		this.isNewBlockCreated = isNewBlockCreated;
	}
	
	
}
