package fr.gop.demo;

public class RemoteApiTest implements RemoteApi {
	
	private final String[] words = "De l'art de troller ou SVN est il un meilleur outil de versionning que Git".split(" ");

	@Override
	public String query() throws Exception {
		int randomIndex = Double.valueOf(Math.random() * 14).intValue();
		int randomTime = Double.valueOf(Math.random() * 1000).intValue();
		Thread.sleep(randomTime);
		return words[randomIndex];
	}
}
