import java.util.Scanner;

public class CMenu{
	
	private String[] options;
	private CMenuType type;
	private Scanner scanner;
	private boolean isRunning;
	private OptionController controller;
	
	public CMenu(){
		scanner = new Scanner(System.in);
	}
	
	public CMenu(String[] options, CMenuType type){
		scanner = new Scanner(System.in);
		this.options = options;
		this.type = type;
	}
	
	public CMenu(String[] options){
		scanner = new Scanner(System.in);
		this.options = options;
	}
	
	public CMenu(CMenuType type){
		scanner = new Scanner(System.in);
		this.type = type;
	}
	
	/**
	*Runs the Menu
	*/
	public void start(){
		isRunning = true;
		if(type == CMenuType.SUPER){
			runAsSuper();
		}else{
			runAsSub();
		}
	}
	
	/**
	* Runs the menu as a super menu
	*/
	public void runAsSuper(){
		while(isRunning){
			int selected;
			printMenuAsSuper();
			selected = getInputAsSuper();
			if(selected == options.length+1){
				isRunning = false;
			}else{
				controller.optionSelected(this, options[selected]);
			}
		}
	}
	
	/**
	* Runs the menu as a sub menu
	*/
	public void runAsSub(){
		int selected;
		printMenuAsSub();
		selected = getInputAsSub();
		controller.optionSelected(this, options[selected]);
	}
	
	/**
	* @return The users selection as an index into the array of options
	* Gets the input from the user and takes into account the Quit option
	*/
	public int getInputAsSuper(){
		String input = scanner.nextLine();
		int selection = -1;
		try{
			selection = Integer.parseInt(input);
			if(selection > options.length+1 || selection < 1){
				System.out.println(String.format("There is no option %d", selection));
				selection = -1;
			}
		}catch(Exception e){
			System.out.println("NOT VALID INPUT");
			selection = -1;
		}
		System.out.println(""+selection);
		return selection - 1;
	}
	
	/**
	* @return The users selection as an index into the array of options
	* Gets the input from the user and does NOT into account the Quit option
	*/
	public int getInputAsSub(){
		String input = scanner.nextLine();
		int selection = -1;
		try{
			selection = Integer.parseInt(input);
			if(selection > options.length || selection < 1){
				System.out.println(String.format("There is no option %d", selection));
				selection = -1;
			}
		}catch(Exception e){
			System.out.println("NOT VALID INPUT");
			selection = -1;
		}
		return selection - 1;
	}
	
	/**
	*Prints the menu WITHOUT the quit option
	*/
	public void printMenuAsSub(){
		int i;
		for(i=0; i<options.length; i++){
			System.out.println(String.format("%d> %s", i+1, options[i]));
		}
	}
	
	/**
	* Prints the menu WITH the quit option
	*/
	public void printMenuAsSuper(){
		int i;
		for(i=0; i<options.length; i++){
			System.out.println(String.format("%d> %s", i+1, options[i]));
		}
		System.out.println(String.format("%d> Quit", i+1));
	}
	
	/**
	* Sets the options String array
	*/
	public void setOptions(String[] options){
		this.options = options;
	}
	
	/**
	* Sets the type CMenuType
	*/
	public void setType(CMenuType type){
		this.type = type;
	}
	
	/**
	* Sets the controller OptionController
	*/
	public void setOptionController(OptionController controller){
		this.controller = controller;
	}
}