package Homework2;

import java.util.Random;

public class Wallet {
	private String userName;
	private float userCoin;
	
	public Wallet() {}
	public Wallet(String userName, float initCoin) {
		this.userName = userName;
		this.userCoin = initCoin;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public float getUserCoin() {
		return userCoin;
	}
	public void setUserCoin(float userCoin) {
		this.userCoin = userCoin;
	}
	
	public float getRandomCoinToSend() {
		Random random = new Random();
		float randomfloat = Math.abs(random.nextFloat());
		randomfloat += (float)(Math.abs(random.nextInt()));
		
		return randomfloat%(userCoin-1) + 1;
		
	}
	
	public void increaseCoin(float coin) {
		this.userCoin += coin;
	}
	
	public void decreaseCoin(float coin) {
		if (userCoin - coin < 0) throw new IllegalArgumentException("Sender가 충분한 코인을 가지고 있지 않습니다.\n");
		this.userCoin -= coin;
	}
	
	public String toString() {
		return String.format("======Wallet======\nUser Name : %s\nUser Coin : %.2f"
				+ "\n==================\n", userName, userCoin);
	}
}
