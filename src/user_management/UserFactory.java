package user_management;
/**
 * 用户工厂
 * @author 屈彬
 *
 */
public class UserFactory {
	/**
	 * 创建新用户
	 * @return 用户
	 */
	public static User createUser(){
		return new User();
	}
}
