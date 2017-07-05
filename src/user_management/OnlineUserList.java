package user_management;

import java.util.HashMap;
/**
 * �����û��б�
 * @author ����
 *
 */
public class OnlineUserList{
	/**
	 * �����û��б�
	 */
	HashMap<String, User> UserList;
	public OnlineUserList(){
		UserList= new HashMap<String, User>();
	}
	/**
	 * ��������û�
	 * @param key �û���-Ĭ��Ϊ�û���
	 * @param user �û�
	 */
	public void addUser(String key, User user){
		UserList.put(key, user);
	}
	/**
	 * ���û���Ϊ����������û�
	 * @param user �û�
	 * @throws Exception �û�δʵ����
	 */
	public void addUser(User user) throws Exception{
		if(user.UserName==null)throw new Exception("user un-realized!");
		UserList.put(user.UserName, user);
	}
	/**
	 * ʹ�û�����
	 * @param key �û���
	 */
	public void removeUser(String key){
		UserList.remove(key);
	}
}
