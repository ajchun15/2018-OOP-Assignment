package Homework2;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestDrvier {
	
	public static void main(String[] args) {
		

		Random random = new Random();
		Scanner cli = new Scanner(System.in);
		
		//�� ����Ʈ�� ���� List<Wallet>�� �ʱ�ȭ �Ұ��Դϴ�.
		final int initCoin = 100;
		String[] userName = {"a", "b", "c", "d", "miner"};
		
		//Make Command Scheme, �̰� �������� Exception�� �����ϸ� ���Ұ��Դϴ�.
		String[] commands = {"send", "create_transaction", "block", "wallet", "create_fakeblock", "status", "flush"};
		int[] eachCommandsParameterNum = {4, 1, 1, 1, 0, 0, 0};
		ArrayList<CommandScheme> commandScheme = new ArrayList<CommandScheme>();
		for(int i=0; i< commands.length; i++) {
			commandScheme.add(new CommandScheme(commands[i], eachCommandsParameterNum[i]));
		}
		

		
		User dijkstra; //User���� Wallet�� Ledger�� ����
		Miner euler;  //Miner���� Wallet�� Ledger�� ����.
		
		Ledger blockchain; //User Node�� Miner Node�� ������ ��� 
		ArrayList<Wallet> wallet = new ArrayList<Wallet>();//User Node�� Miner Node�� ������ ����
		
		//Ledger�� �ʱ�ȭ
		blockchain = new Ledger();
		for(int i =0; i< userName.length; i++) {
			wallet.add(new Wallet(userName[i], initCoin));
		}
		//Wallet List�� �ʱ�ȭ

		dijkstra = new User(blockchain, wallet);
		euler = new Miner(blockchain, wallet, "miner");
		//Ledger�� Wallet ����Ʈ�� �ʱ�ȭ�ϰ�, �̰��� ���� user node�� miner node�� �ʱ�ȭ �ϴ� �ڵ尡 ���� ����. 
		
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
				//Ŀ�ǵ��� ��ȿ���� Ȯ���Ѵ�. 
				
				for(int i =0; i<commandScheme.size(); i++) {
					if(cmdSplited[0].equals(commandScheme.get(i).commandName)) {
						commandIdx = i;
						break;
					}
				}
				if(commandIdx == -1) throw new IllegalArgumentException("���� ��ɾ��Դϴ�.\n");
				
				if(commandIdx == 0) {
				//send ��ɾ��� ������ ����
					if(cmdSplited.length != 5)throw new IllegalArgumentException("�Ű������� ������ ���� �ʽ��ϴ�.\n");
					Wallet sender = dijkstra.findWallet(cmdSplited[1]);
					Wallet receiver = dijkstra.findWallet(cmdSplited[2]);
					float coin = Float.parseFloat(cmdSplited[3]);
					float fee = Float.parseFloat(cmdSplited[4]);
					if(fee < 0 || coin < 0) throw new IllegalArgumentException("������ ���� Ȥ�� �����ᰡ �����Դϴ�.\n");
					sender.decreaseCoin(coin + fee);
					dijkstra.sendTransaction(sender, receiver, coin, fee);		
					euler.mine(5);
					dijkstra.validateNewBlock();
				}
				else if(commandIdx == 1) {
				//create_transaction ��ɾ��� ���� �� ����
					if(cmdSplited.length != 2)throw new IllegalArgumentException("�Ű������� ������ ���� �ʽ��ϴ�.\n");
					if(Integer.parseInt(cmdSplited[1]) > 100) throw new IllegalArgumentException("�ʹ� ���� Ʈ����� ��û\n");
					
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
				//block ��ɾ��� ���� �� ����
					if(cmdSplited.length != 2)throw new IllegalArgumentException("�Ű������� ������ ���� �ʽ��ϴ�.\n");
					if(Integer.parseInt(cmdSplited[1]) >= blockchain.getBlockchain().size()) {
						throw new IllegalArgumentException("�������� �ʴ� ����Դϴ�.");
					}
					System.out.print(blockchain.getBlockchain().get(Integer.parseInt(cmdSplited[1])).toString());
				}
				else if(commandIdx == 3) {
				//wallet ��ɾ��� ���� �� ����
					if(cmdSplited.length != 2)throw new IllegalArgumentException("�Ű������� ������ ���� �ʽ��ϴ�.\n");
					System.out.print(dijkstra.findWallet(cmdSplited[1]).toString());
				}
				else if(commandIdx == 4) {
				//create_fakeblock ��ɾ��� ���� �� ����
					if(cmdSplited.length != 1)throw new IllegalArgumentException("�Ű������� ������ ���� �ʽ��ϴ�.\n");
					euler.makeFakeBlock(0);
					dijkstra.validateNewBlock();
				}
				else if(commandIdx == 5) {
				//status ��ɾ��� ����
					if(cmdSplited.length != 1)throw new IllegalArgumentException("�Ű������� ������ ���� �ʽ��ϴ�.\n");
					if(blockchain.getBlockchain().size() != 0) {
						//Current Height = ù ��° ����� 0
						System.out.printf("Current Height: %d\n==========latest block============\n", blockchain.getBlockchain().get(blockchain.getBlockchain().size()-1).getBlockHeight());
						System.out.print(blockchain.getBlockchain().get(blockchain.getBlockchain().size()-1).toString());	
					}
					System.out.println("==========wallet list==========\n");
					System.out.println(wallet);
					System.out.println("===========unconfirmed Transaction============\n");
					System.out.println(blockchain.getUnconfirmedTransaction());
					
				}
				else if(commandIdx == 6) {
				//flush ��ɾ��� ����
					if(cmdSplited.length != 1)throw new IllegalArgumentException("�Ű������� ������ ���� �ʽ��ϴ�.\n");
					euler.mine(3);
					dijkstra.validateNewBlock();
				}
				}
				catch(NumberFormatException e) {
					IllegalArgumentException b =  new IllegalArgumentException("�Ű������� Ÿ���� ���� �ʽ��ϴ�.\n");
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
