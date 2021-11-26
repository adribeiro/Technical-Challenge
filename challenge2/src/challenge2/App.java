package challenge2;

import javax.swing.JOptionPane;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create a person with developer's information (myself) and logs it on console
		Person developer = new Person("Ad Nunes Ribeiro", "Brazilian", "gather information to become a specialist");		
		developer.tellConsoleNameNationalityDream();
		
		// Little app running
		boolean running = true;
		while(running) {
			// Ask the user which person he/she wants to show
			String[] options = {"The Developer", "Custom","None"};
			int x = JOptionPane.showOptionDialog(null, "Which Person do you want to show?",
	                "Click a button",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			
			switch(x) {
			  case 0:
				  // Show developer's information on screen
				 developer.tellAppNameNationalityDream();
			    break;
			  case 1:
			    // Ask information about a new person
				String name = JOptionPane.showInputDialog("What is the name of this person?");
				String nationality = JOptionPane.showInputDialog("Which is his nationality?");
				String dream = JOptionPane.showInputDialog("His biggest dream is to __");
				
				// create the person and show a brief paragraph about
				Person custom = new Person(name, nationality,dream);				
				custom.tellAppNameNationalityDream();
				
			    break;
			  case 2:
			    // Finish application
				running = false;
			    break;
			  default:
				  running = false;
			}
			
		}

	}
	
	public void tellAboutDeveloper(Person developer) {
		
	}

}
