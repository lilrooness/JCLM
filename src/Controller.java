public class Controller implements OptionController{
	public void optionSelected(CMenu menu, String option){
		System.out.println("Called!!!");
		System.out.println(option);
	}
}