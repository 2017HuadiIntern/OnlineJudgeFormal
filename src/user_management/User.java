package user_management;
/**
 * �û���
 * @author ����
 *
 */
public class User {
	String UserName;
	String Password;
	public User(){
		
	}
	/**
	 * ��ȡ�û���
	 * @return �û���
	 */
	public String getUserName(){return UserName;}
	/**
	 * �����û���
	 * @param UserName �û���
	 */
	public void setUserName(String UserName){this.UserName=UserName;}
	/**
	 * ��ȡ����
	 * @return ����
	 */
	public String getPassword(){return Password;}
	/**
	 * ��������
	 * @param Password ����
	 */
	public void setPassword(String Password){this.Password=Password;}
}
