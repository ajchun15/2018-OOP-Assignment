package Homework2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Miner extends User{
	private Wallet miner;
	public Miner(Ledger ledger, ArrayList<Wallet> wallet, String minerName) {
		super(ledger, wallet);
		
		for(int i =0; i<wallet.size(); i++) {
			if(wallet.get(i).getUserName().equals(minerName)) {
				miner = wallet.get(i);
			}
			
		}
	}
	
	//채굴한다.
	

	
	public void mine(int unconfirmedTransactionSizeLimit) {
		List<Transaction> unconfirmedTransaction = this.publicLedger.getUnconfirmedTransaction();
		int numOfUnconfirmed = unconfirmedTransaction.size();
		Random random = new Random();
		String nonce;
		String prevID ="";
		String curID;
		long height = 0;
		
		
		if(numOfUnconfirmed >= 3 && numOfUnconfirmed >= unconfirmedTransactionSizeLimit ) {
			
			ArrayList<Transaction> confirmedTransactions = new ArrayList<Transaction>();
			String[] transactionHash = new String[4];
			
			Collections.sort(unconfirmedTransaction);
			confirmedTransactions.add(unconfirmedTransaction.get(0));
			confirmedTransactions.add(unconfirmedTransaction.get(1));
			confirmedTransactions.add(unconfirmedTransaction.get(2));
			Transaction reward = new Transaction(miner, 12.5F, 0);
			confirmedTransactions.add(reward);
			
			transactionHash[0] = confirmedTransactions.get(0).getTxID();
			transactionHash[1] = confirmedTransactions.get(1).getTxID();
			transactionHash[2] = confirmedTransactions.get(2).getTxID();
			transactionHash[3] = confirmedTransactions.get(3).getTxID();
			
			MerkleTree merkle = new MerkleTree(transactionHash, "");
			
			if(publicLedger.getBlockchain().size() != 0) {
				height = publicLedger.getBlockchain().size() + 1;
				System.out.println(height);
				prevID = publicLedger.getBlockchain().get((int)height - 2).getBlockID();
			}
			
			nonce = String.format("%d", Math.abs(random.nextInt()));
			Block newBlock = new Block("", miner.getUserName(), height, new Date().toString(),
					nonce, prevID,merkle.getRoot(), merkle, confirmedTransactions );
				
			
			curID = newBlock.getPreBlockID() + newBlock.getMerkleRoot() + newBlock.getNonce();
			curID = Utils.doHash(curID);
			
			newBlock.setBlockID(curID);
			publicLedger.setNewBlock(newBlock);
			publicLedger.setNewBlockCreated(true);
			unconfirmedTransaction.remove(0);
			unconfirmedTransaction.remove(0);
			unconfirmedTransaction.remove(0);
			
			System.out.println("블록 채굴 성공!");
			System.out.println("New Block Is Validated!");
		}
		else {
			//채굴 조건이 아닌 경우.
		}
	}
	
	//가짜블록 생성한다.
	public void makeFakeBlock(int unconfirmedTransactionSizeLimit) {
		List<Transaction> unconfirmedTransaction = this.publicLedger.getUnconfirmedTransaction();
		int numOfUnconfirmed = unconfirmedTransaction.size();
		Random random = new Random();
		String nonce;
		String prevID ="";
		String curID;
		long height = 0;
	
			
			ArrayList<Transaction> confirmedTransactions = new ArrayList<Transaction>();
			String[] transactionHash = new String[4];
			
			Collections.sort(unconfirmedTransaction);
			confirmedTransactions.add(new Transaction(miner, 500F, 0));
			confirmedTransactions.add(new Transaction(miner, 500F, 0));
			confirmedTransactions.add(new Transaction(miner, 500F, 0));
			Transaction reward = new Transaction(miner, 999999F, 0);
			confirmedTransactions.add(reward);
			
			transactionHash[0] = confirmedTransactions.get(0).getTxID();
			transactionHash[1] = confirmedTransactions.get(1).getTxID();
			transactionHash[2] = confirmedTransactions.get(2).getTxID();
			transactionHash[3] = confirmedTransactions.get(3).getTxID();
			
			MerkleTree merkle = new MerkleTree(transactionHash, "");
			
			if(publicLedger.getBlockchain().size() != 0) {
				height = publicLedger.getBlockchain().size() + 1;
				System.out.println(height);
				prevID = publicLedger.getBlockchain().get((int)height - 2).getBlockID();
			}
			
			nonce = String.format("%d", Math.abs(random.nextInt()));
			Block newBlock = new Block("", miner.getUserName(), height, new Date().toString(),
					nonce, prevID,merkle.getRoot(), merkle, confirmedTransactions );
				
			
			curID = newBlock.getNonce();
			curID = Utils.doHash(curID);
			
			newBlock.setBlockID(curID);
			publicLedger.setNewBlock(newBlock);
			publicLedger.setNewBlockCreated(true);

			System.out.println("블록 채굴 성공!");
			System.out.println("New Block Is Validated!");
	}

}
