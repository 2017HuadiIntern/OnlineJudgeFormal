package record_management;
/**
 * 做题记录工厂
 * @author 屈彬
 *
 */
public class RecordFactory {
	/**
	 * 创建做题记录
	 * @return 做题记录
	 */
	public static Record createRecord(){
		return new Record();
	}
}
