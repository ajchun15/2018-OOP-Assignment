package Homework2;

import java.util.ArrayList;
import java.util.List;



public class User {
	protected Ledger publicLedger = new Ledger();
	protected List<Wallet> wallets = new ArrayList<Wallet>();
	public User(Ledger ledger, ArrayList<Wallet> wallet) {
		this.publicLedger = ledger;
		this.wallets = wallet;
	}
	
	//Transaction 생성한다.
	public void sendTransaction(Wallet sender, Wallet reciever, float coin, float fee) {
		List<Transaction> unconfirmedTransaction = publicLedger.getUnconfirmedTransaction();
		unconfirmedTransaction.add(new Transaction(sender, reciever, coin, fee));
		publicLedger.setUnconfirmedTransaction(unconfirmedTransaction);
	}
	
	//새로 생성된 블록 검증.
	public void validateNewBlock() throws Exception  {
		String validateID;
		String blockID;
		
		if(publicLedger.isNewBlockCreated()) {
			blockID = publicLedger.getNewBlock().getBlockID();
			validateID = publicLedger.getNewBlock().getPreBlockID() +
					publicLedger.getNewBlock().getMerkleRoot() + publicLedger.getNewBlock().getNonce();
			
			if(blockID.equals(Utils.doHash(validateID))) {
				updateWallet();
			}
			else {
				publicLedger.setNewBlockCreated(false);			
				throw new IllegalArgumentException("블록 검증 실패!");
			}
		}
		
	}
	
	//새로 추가된 블록에 맞춰 각 wallet 갱신.
	protected void updateWallet() {
		Block newBlock = publicLedger.getNewBlock();
		publicLedger.getBlockchain().add(newBlock);
		publicLedger.setNewBlockCreated(false);
		Wallet receiver = null;
		Wallet miner = null;
		
		ArrayList<Transaction> confirmedTransactions = newBlock.getConfirmingTransaction();
		Transaction transaction;
		for(int i =0; i<4; i++) {
			transaction = confirmedTransactions.get(i);
			
			//보상노드 아닐때
			if(transaction.getSender() != null) {
				receiver = findWallet(transaction.getReceiver());
				miner = findWallet(newBlock.getBlockMaker());
				
				receiver.increaseCoin(transaction.getCoin());
				miner.increaseCoin(transaction.getFee());
			}
			else {
				receiver = findWallet(transaction.getReceiver());
				miner = findWallet(newBlock.getBlockMaker());
				//지갑 찾기 알고리즘
				
				receiver.increaseCoin(transaction.getCoin());
				
				
			}
			//보상노드 맞을때;
		}
	}
	
	//사용자 이름으로 지갑을 찾음.
	protected Wallet findWallet(String userName) {
		for(int i =0; i<wallets.size(); i++) {
			if(wallets.get(i).getUserName().equals(userName)) {
				return wallets.get(i);
			}
		}
		throw new IllegalArgumentException(String.format("%s는 없는 사용자입니다.\n", userName));
	}
}
