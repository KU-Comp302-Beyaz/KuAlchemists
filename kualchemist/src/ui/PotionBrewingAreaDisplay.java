package ui;

import ingredients.Ingredient;

public class PotionBrewingAreaDisplay {

	
	
	public void display() {
		//pba sayfası açılacak
		//direkt create edildiğinde açılmasın
	}
	
	public boolean displayChoiceBox() {
		//random bir potion isteyecek
		//eğer yes'e tıklarsa true dönecek
		return true;
	}
	
	public String displayGuaranteeBox() {
		//1: Positive
		//2: Positive or neutral
		//3: No guarantee
		return "positive";
	}
	
	public Ingredient[] displayExperimentSteup() {
		//butonla yapılabilir
		//fotoya tıklayınca ingredient yaratacak
		//2 ingredient seçilmiş olacak
		Ingredient i1 = new Ingredient();
		Ingredient i2 = new Ingredient();
		//Eğer 2den fazla basmaya çalışırsa hata versin
		
		Ingredient[] ingredients = {i1, i2};
		return ingredients;
	}
}
