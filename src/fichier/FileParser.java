package fichier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileParser {

	/**
	 * @param args
	 */
	
	public void parse(File file,String format, IContentHandler handler){
		
		try{
			Scanner f=new Scanner (new File(format));
			while(f.hasNext()){
				String l=f.nextLine();
				if (l.contains("comment"))
				{
					format=l.substring(l.indexOf("\"")+1,l.indexOf("\"",l.indexOf("\"")+1));
					
			break;
			}
			}
			InputStream ips=new FileInputStream(file); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				handler.defaultLine(ligne);
			
				if (ligne.startsWith(format)){
					
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
