public class Test{
	public static void main(String[] args){
		CMenu menu = new CMenu();
		String[] options = {"hello", "there", "good", "man"};
		menu.setOptions(options);
		menu.setType(CMenuType.SUPER);
		menu.setOptionController(new Controller());
		menu.start();
	}
}