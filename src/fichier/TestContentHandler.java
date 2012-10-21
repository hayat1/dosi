package fichier;

import java.io.File;

public class TestContentHandler  implements IContentHandler{


	static int compteurL = 0;
	static int compteurC = 0;
	public static  void main(String[] args){
		File fichier = new File("fichiertexte.txt");
		FileParser f=new FileParser();
		f.parse(fichier, new TestContentHandler());
		System.out.println("le fichier "+ fichier +" contient "+ compteurL+ " ligne(s) dont "+compteurC+ " de commentaires.");
	}
	

	
	@Override
	public void defaultLine(String content) {
		//System.out.println("nouvelle ligne : " + content);
		compteurL++;
	}



	@Override
	public void commentLine(String comment) {
		// TODO Auto-generated method stub
		
		compteurC ++;
		
	
	}

}
