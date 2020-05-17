import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<MemoryNode> sadList = new ArrayList<MemoryNode>();
		List<MemoryNode> happyList = new ArrayList<MemoryNode>();
		while(true) {
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Hello! How are you feeling today?");
			String stuff = sc1.nextLine();
			if(stuff.equalsIgnoreCase("end")) {
				System.out.println("Thank you");
				break;
			}
			int index = -1;
			if(stuff.contains("sad")) {
				for(int i = 0; i < sadList.size(); i++) {
					if(sadList.get(i).memory.getIncident().equalsIgnoreCase(stuff.substring(4))) {
						index = i;
						if(!sadList.get(i).preferedAction.equals("")) {
							System.out.println(sadList.get(i).preferedAction.getAction());
						}
					}
				}
			}
			if(index == -1) {
			MemoryNode sadNode = new MemoryNode(new Memory(stuff.substring(4), new Date()));
			sadList.add(sadNode);
			System.out.println("Default Action");
			}
			System.out.println("Please rate your satisfaction response on a scale of 10");
			String response = sc1.nextLine();
			if(response.equalsIgnoreCase("end")) {
				break;
			}
			double rating = Double.parseDouble(response);
			if(index==-1) {
				index = (sadList.size()-1);
				}
			if(rating < 5) {
			System.out.println("I'm Sorry What would you like me to do. I am still learning");
			String action = sc1.nextLine();
			if(action.equalsIgnoreCase("end")) {
				break;
			}
			sadList.get(index).setPreferedAction(action);			
			System.out.println("The action is saved. Thank you for helping me learn about you!");
			}
			else {
				if(sadList.get(index).getPreferedAction().getAction().equals("")) {
					sadList.get(index).setPreferedAction("Default Action");
				};
				System.out.println("I'm glad I was of help");
			}
		}
	}

}
