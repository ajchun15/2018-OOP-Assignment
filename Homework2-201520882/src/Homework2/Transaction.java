package Homework2;

import java.util.Date;

public class Transaction implements Comparable<Transaction>{
	private String txID;
	private String sender;
	private float coin;
	private String receiver;
	private float fee;
	private String timeStamp;
	public String getTxID() {
		return txID;
	}
	public void setTxID(String txID) {
		this.txID = txID;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public float getCoin() {
		return coin;
	}
	public void setCoin(float coin) {
		this.coin = coin;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public Transaction(Wallet sender, Wallet receiver, float coin, float f) {
		this.sender = sender.getUserName();
		this.receiver = receiver.getUserName();
		this.coin = coin;
		this.fee = f;
		this.timeStamp = new Date().toString();
		this.txID = Utils.getSHA256(this.sender + this.receiver + timeStamp + coin + f);
	}
	
	public Transaction(Wallet receiver, float coin, float f) {
		this.sender = null;
		this.receiver = receiver.getUserName();
		this.coin = coin;
		this.fee = f;
		this.timeStamp = new Date().toString();
		this.txID = Utils.getSHA256(this.receiver + timeStamp);
	}
	
	public String toString() {
		return String.format("=====================Transaction\n%s\nSender : %s\nReceiver : %s\nCoin : %f\tFee : %f\n"
				+ "TimeStamp: %s\n==========================", this.txID, this.sender, this.receiver, this.coin,
				this.fee,this.timeStamp);
	}
	
	public int compareTo(Transaction transaction) {
		if(this.fee > transaction.getFee()) {
			return -1;
		}
		else if(this.fee == transaction.getFee()) {
			return 0;
		}
		else return 1;
	}
}
