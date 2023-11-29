package ui;

import domain.ingredients.Ingredient;

public class PotionBrewingAreaDisplayHelp {

	
	// UI ın en üst class'ı bunu içersin !!
	public void display() {
		//pba sayfası açılacak
		//direkt create edildiğinde açılmasın
	}
	
	public void close() {
		//pba sayfası kapanacak
		//direkt create edildiğinde açılmasın
	}
	//////////////////////////
	
	
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
	
	public Ingredient[] displayExperimentSetup() {
		//butonla yapılabilir
		//fotoya tıklayınca ingredient yaratacak
		//2 ingredient seçilmiş olacak
		Ingredient i1 = new Ingredient(null, null, null);
		Ingredient i2 = new Ingredient(null, null, null);
		//Eğer 2den fazla basmaya çalışırsa hata versin
		
		Ingredient[] ingredients = {i1, i2};
		return ingredients;
	}
	
	public String displayTestMethodBox() { // Student üzerinde mi kendi üzerinde mi test edilecek
		//
		
		//
		if(true) {
			return "Student";
		} else {
			return "Player";
		}
	}
	
	
}
