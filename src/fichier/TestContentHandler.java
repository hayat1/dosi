package fichier;

import java.io.File;

public class TestContentHandler  implements IContentHandler{


	static int compteurL = 0;
	static int compteurC = 0;
	static int empty = 0;
	
	
	public static  void main(String[] args){
		File fichier = new File("fichiertexte.txt");
		FileParser f=new FileParser();
		f.parse(fichier, new TestContentHandler());
		if (args != null
				&& (args[0].equals("-e") || args[0].equals("--empty"))) { 
		System.out.println("le fichier "+ fichier +" contient "+ (compteurL-empty) + " ligne(s)non vide dont "+compteurC+ " de commentaires et "+ empty + "ligne(s) vide.");
		}
		else {
			System.out.println("le fichier "+ fichier +" contient "+ compteurL + " ligne(s)non vide dont "+compteurC+ " de commentaires.");
		}
	}
	
	// implémentation de contentHandler qui affiche le nombre de ligne
	@Override
	public void defaultLine(String content) {
		
			if (content.trim().equals("")) {
				empty++;
			} else {
				compteurL++;
			}
		
	}
	

	@Override
	public void commentLine(String comment) {
		// TODO Auto-generated method stub
		if (comment.startsWith("#"))
		compteurC ++;
	}
}
