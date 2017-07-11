/**
 * 
 */
package learning.io;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/**
 * @author neverloaf
 *
 */
public class outputStreamTest {
	public outputStreamTest() {
		// TODO Auto-generated constructor stub
	}
	public  static void generateCharacters(OutputStream out) throws IOException{
		int firstPrintableCharater = 33;
		int PrintableCharacterPerLine = 72;
		int totalCharacter = 96;
		
		int start = totalCharacter;
		for (int i = start;i < start + PrintableCharacterPerLine;i++){
				out.write(((i - totalCharacter) % PrintableCharacterPerLine)+firstPrintableCharater);
		}
		out.write('\r');
		out.write('\n');
		
	
	}
	
	public  static void generateCharactersByte(OutputStream out) throws IOException{
		int firstPrintableCharater = 33;
		int PrintableCharacterPerLine = 72;
		int totalCharacter = 96;
		byte[] line = new byte[totalCharacter+1];
		
		int start = totalCharacter;
		for (int i = start;i < start + PrintableCharacterPerLine;i++){
			line[i-PrintableCharacterPerLine]=(byte) (((i - totalCharacter) % PrintableCharacterPerLine)+firstPrintableCharater);
		}
		line[line.length-2]='\r';
		line[line.length-1]='\n';
		out.write(line);
	}
	
	public static void generateFileOutput(FileOutputStream fout) throws IOException{
		String tmp = "neverloaf,learing XXXXXXXXXX";
		fout.write(tmp.getBytes());;
	}
}
