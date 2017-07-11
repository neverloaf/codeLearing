/**
 * 
 */
package learning.comm;
import learning.inherit.*;
/**
 * @author neverloaf
 *
 */
public class bootMain {

	/**
	 * 
	 */
	public bootMain() {
		// TODO Auto-generated constructor stub
		System.out.println("bootMain ¹¹Ôìº¯Êý");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------------");
		fatherClass father = new fatherClass();
		father.name();
		System.out.println("-----------------");
		sonClass son = new sonClass();
		son.name();
		System.out.println("-----------------");
		sonImpAbClass sonImpAbClass = new sonImpAbClass();
		sonImpAbClass.name();
		System.out.println("-----------------");
		compareSameParamInterface compareSameParamInterface = new compareSameParamInterface();
		System.out.println(compareSameParamInterface.getMaxNum());;
	}

}
