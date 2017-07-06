package helper;


/**
 * ÖúÊÖ¹¤³§
 * @author Çü±ò
 *
 */
public class HelperFactory {
	public static enum HelperType{
		Database,Compiler,Configure
	}
	public static Object createHelper(HelperType type){
		Object helper = null;
		switch (type) {
		case Database:
			helper = new DBHelper();
			break;
		case Compiler:
			helper = new CompileHelper();
			break;
		case Configure:
			helper = new ConfHelper();
			break;
		default:
			break;
		}
		return helper;
	}
}
