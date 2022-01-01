package Homework2;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestDrvier {
	
	public static void main(String[] args) {
		

		Random random = new Random();
		Scanner cli = new Scanner(System.in);
		
		//이 리스트를 통해 List<Wallet>을 초기화 할것입니다.
		final int initCoin = 100;
		String[] userName = {"a", "b", "c", "d", "miner"};
		
		//Make Command Scheme, 이걸 기준으로 Exception을 생성하면 편할것입니다.
		String[] commands = {"send", "create_transaction", "block", "wallet", "create_fakeblock", "status", "flush"};
		int[] eachCommandsParameterNum = {4, 1, 1, 1, 0, 0, 0};
		ArrayList<CommandScheme> commandScheme = new ArrayList<CommandScheme>();
		for(int i=0; i< commands.length; i++) {
			commandScheme.add(new CommandScheme(commands[i], eachCommandsParameterNum[i]));
		}
		

		
		User dijkstra; //User에는 Wallet과 Ledger가 들어갈것
		Miner euler;  //Miner에도 Wallet과 Ledger가 들어갈것.
		
		Ledger blockchain; //User Node와 Miner Node가 공유할 장부 
		ArrayList<Wallet> wallet = new ArrayList<Wallet>();//User Node와 Miner Node가 공유할 지갑
		
		//Ledger를 초기화
		blockchain = new Ledger();
		for(int i =0; i< userName.length; i++) {
			wallet.add(new Wallet(userName[i], initCoin));
		}
		//Wallet List를 초기화

		dijkstra = new User(blockchain, wallet);
		euler = new Miner(blockchain, wallet, "miner");
		//Ledger와 Wallet 리스트를 초기화하고, 이것을 통해 user node와 miner node를 초기화 하는 코드가 여기 들어간다. 
		
		String cmd = "";
		String[] cmdSplited;
		int commandIdx = -1;
		while(true){
			try {
				try {
				commandIdx = -1;
				System.out.print(">");
				System.out.flush();
				cmd = cli.nextLine();
				cmdSplited = cmd.split(" ");
				//커맨드의 유효성을 확인한다. 
				
				for(int i =0; i<commandScheme.size(); i++) {
					if(cmdSplited[0].equals(commandScheme.get(i).commandName)) {
						commandIdx = i;
						break;
					}
				}
				if(commandIdx == -1) throw new IllegalArgumentException("없는 명령어입니다.\n");
				
				if(commandIdx == 0) {
				//send 명령어의 검증및 실행
					if(cmdSplited.length != 5)throw new IllegalArgumentException("매개변수의 갯수가 맞지 않습니다.\n");
					Wallet sender = dijkstra.findWallet(cmdSplited[1]);
					Wallet receiver = dijkstra.findWallet(cmdSplited[2]);
					float coin = Float.parseFloat(cmdSplited[3]);
					float fee = Float.parseFloat(cmdSplited[4]);
					if(fee < 0 || coin < 0) throw new IllegalArgumentException("보내는 코인 혹은 수수료가 음수입니다.\n");
					sender.decreaseCoin(coin + fee);
					dijkstra.sendTransaction(sender, receiver, coin, fee);		
					euler.mine(5);
					dijkstra.validateNewBlock();
				}
				else if(commandIdx == 1) {
				//create_transaction 명령어의 검증 및 실행
					if(cmdSplited.length != 2)throw new IllegalArgumentException("매개변수의 갯수가 맞지 않습니다.\n");
					if(Integer.parseInt(cmdSplited[1]) > 100) throw new IllegalArgumentException("너무 많은 트랙잭션 요청\n");
					
					for(int i =0; i< Integer.parseInt(cmdSplited[1]); i++) {
						Wallet sender = wallet.get(Math.abs(random.nextInt())%wallet.size());
						Wallet receiver = wallet.get(Math.abs(random.nextInt())%wallet.size());
						float sendCoin;
						float fee;
						
						if(sender.getUserCoin() < 3) {
							sendCoin = 0;
							fee = 0F;
						}
						else {
							sendCoin = sender.getRandomCoinToSend();
							
							fee = (sendCoin/(float)11);
							sendCoin = (float)(sendCoin*10/11);
							
						}
						
						sender.decreaseCoin(sendCoin + fee);
						dijkstra.sendTransaction(sender, receiver, sendCoin, fee);				
						euler.mine(5);
						dijkstra.validateNewBlock();
						}
				}
				else if(commandIdx == 2) {
				//block 명령어의 검증 및 실행
					if(cmdSplited.length != 2)throw new IllegalArgumentException("매개변수의 갯수가 맞지 않습니다.\n");
					if(Integer.parseInt(cmdSplited[1]) >= blockchain.getBlockchain().size()) {
						throw new IllegalArgumentException("존재하지 않는 블록입니다.");
					}
					System.out.print(blockchain.getBlockchain().get(Integer.parseInt(cmdSplited[1])).toString());
				}
				else if(commandIdx == 3) {
				//wallet 명령어의 검증 및 실행
					if(cmdSplited.length != 2)throw new IllegalArgumentException("매개변수의 갯수가 맞지 않습니다.\n");
					System.out.print(dijkstra.findWallet(cmdSplited[1]).toString());
				}
				else if(commandIdx == 4) {
				//create_fakeblock 명령어의 검증 및 실행
					if(cmdSplited.length != 1)throw new IllegalArgumentException("매개변수의 갯수가 맞지 않습니다.\n");
					euler.makeFakeBlock(0);
					dijkstra.validateNewBlock();
				}
				else if(commandIdx == 5) {
				//status 명령어의 실행
					if(cmdSplited.length != 1)throw new IllegalArgumentException("매개변수의 갯수가 맞지 않습니다.\n");
					if(blockchain.getBlockchain().size() != 0) {
						//Current Height = 첫 번째 블록이 0
						System.out.printf("Current Height: %d\n==========latest block============\n", blockchain.getBlockchain().get(blockchain.getBlockchain().size()-1).getBlockHeight());
						System.out.print(blockchain.getBlockchain().get(blockchain.getBlockchain().size()-1).toString());	
					}
					System.out.println("==========wallet list==========\n");
					System.out.println(wallet);
					System.out.println("===========unconfirmed Transaction============\n");
					System.out.println(blockchain.getUnconfirmedTransaction());
					
				}
				else if(commandIdx == 6) {
				//flush 명령어의 실행
					if(cmdSplited.length != 1)throw new IllegalArgumentException("매개변수의 갯수가 맞지 않습니다.\n");
					euler.mine(3);
					dijkstra.validateNewBlock();
				}
				}
				catch(NumberFormatException e) {
					IllegalArgumentException b =  new IllegalArgumentException("매개변수의 타입이 맞지 않습니다.\n");
					b.setStackTrace(e.getStackTrace());
					throw b;
				}
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}


				
		
		}
			
	}
}
