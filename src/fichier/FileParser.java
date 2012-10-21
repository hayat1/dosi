package fichier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileParser {

	/**
	 * @param args
	 */
	
	public void parse(File file, IContentHandler handler){
		
		try{
			InputStream ips=new FileInputStream(file); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				handler.defaultLine(ligne);
			
				if (ligne.startsWith("#")){
					
					handler.commentLine(ligne);
					
				}	
				
			}
			br.close(); 
			
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	
	
	}

}
