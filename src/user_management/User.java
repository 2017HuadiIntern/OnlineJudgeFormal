package user_management;
/**
 * 用户类
 * @author 屈彬
 *
 */
public class User {
	String UserName;
	String Password;
	public User(){
		
	}
	/**
	 * 获取用户名
	 * @return 用户名
	 */
	public String getUserName(){return UserName;}
	/**
	 * 设置用户名
	 * @param UserName 用户名
	 */
	public void setUserName(String UserName){this.UserName=UserName;}
	/**
	 * 获取密码
	 * @return 密码
	 */
	public String getPassword(){return Password;}
	/**
	 * 设置密码
	 * @param Password 密码
	 */
	public void setPassword(String Password){this.Password=Password;}
}
