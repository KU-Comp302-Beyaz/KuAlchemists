package domain.artifact;
import domain.Player;
import domain.Game;


public class ArtifactController {

private static ArtifactController ArtifactControllerSingleton = new ArtifactController();
	
	private ArtifactController() {	
	
	}
	
	public static ArtifactController getArtifactController() {
		return ArtifactControllerSingleton;
	}
	
	//player buys the artifact using this function
	/// if the usage of the artifact is denoted as immidiate rather than adding the artifact to the player's artifact list uses the artifact immidiately
	public void buyArtifact(Artifact artifact, Player player) {
		
		if(player.getGoldBalance() >= 3) {
			if(player.getTurnNumber() >= 1) {
				if(artifact.usage == "immidiate") {
					player.setTurnNumber(player.getTurnNumber() - 1);
					player.setGoldBalance(player.getGoldBalance() - 3);
					useArtifact(artifact, player);
				}
				
				else{
					player.setGoldBalance(player.getGoldBalance() - 3); 
					player.addArtifact(artifact);
					//update the lastUsed field of the artifact
				}
			}
		}
	}
	
	public void useArtifact(Artifact artifact, Player player){
		if(artifact.usage == "one-time") {
			// cannot do anything for this yet as there is no way to know what round the player is currently in
			artifact.setActive(true);
			Game.getGame().getCurrPlayer().addActivatedArtifacts(artifact);
			player.getArtifacts().remove(artifact.name);
		}
		else {
			artifact.applyEffect(player);
		}
	}
	
	public String displayMessage(Player player, Artifact artifact) {
		return artifact.message(player);
	}
	
}
