package challenge2;

import javax.swing.JOptionPane;

public class Person {
	private String firstName;
	private String lastName;
	private String nationality;
	private String dream;
	
	// constructor
	public Person(String name, String nationality, String dream) {
		super();
		
		// Parameters passed treatment
		if(name == null || name == "") {
			name = "John Doe";
		}
		
		if(nationality == null || nationality == "") {
			nationality = "from nowhere";
		}
		
		if(dream == null || dream == "") {
			dream = "to have a dream";
		}
		
		
		// Spliting name in first name and last name
		String[] nameArray = name.split(" ");
		this.firstName = nameArray[0];
		this.lastName = "";
		if (nameArray.length > 1) {
			for(int i = 1; i < nameArray.length; i++) {
				this.lastName += nameArray[i];
				
				if(i < nameArray.length - 1) {
					this.lastName += " ";
				}
				
			}
		}
		this.nationality = nationality;
		this.dream = dream;
	}
	
	// Logs infos about person
	public void tellConsoleNameNationalityDream() {
		String lastN = this.lastName;
		
		if(this.lastName.length() >= 0) {
			lastN = " " + this.lastName;
		}
		
		String paragraph = "Hi, my name is " + this.firstName + lastN + 
				" and i am "+ this.nationality +
				". My biggest dream is to " + this.dream;
		System.out.println(paragraph);
	}
	
	// Show infos about person on console and app
	public void tellAppNameNationalityDream() {
		String lastN = this.lastName;
		if(this.lastName.length() >= 0) {
			lastN = " " + this.lastName;
		}
		
		String paragraph = "Hi, my name is " + this.firstName + lastN + 
				" and i am "+ this.nationality +
				". My biggest dream is to " + this.dream;
		System.out.println(paragraph);
		
		JOptionPane.showMessageDialog(null, paragraph);
	}

}
