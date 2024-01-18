package domain.artifact;

public class ArtifactFactory {
	
	public Artifact getArtifact(String artifactType){
	      if(artifactType == null){
	         return null;
	      }		
	      if(artifactType.equalsIgnoreCase("THERIVER")){
	         return new TheRiver();
	         
	      } else if(artifactType.equalsIgnoreCase("EOI")){
	         return new ElixirOfInsight();
	         
	      } else if(artifactType.equalsIgnoreCase("MAGICMORTAR")){
	         return new MagicMortar();
	      
	      } else if(artifactType.equalsIgnoreCase("PRINTINGPRESS")){
	          return new PrintingPress();
	     
	      } else if(artifactType.equalsIgnoreCase("WISDOMIDOL")){
	          return new WisdomIdol();
		 
	      }
	      
	      return null;
	   }
	

}
