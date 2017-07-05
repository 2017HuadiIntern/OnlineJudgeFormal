package user_management;

import java.util.HashMap;
/**
 * 在线用户列表
 * @author 屈彬
 *
 */
public class OnlineUserList{
	/**
	 * 在线用户列表
	 */
	HashMap<String, User> UserList;
	public OnlineUserList(){
		UserList= new HashMap<String, User>();
	}
	/**
	 * 添加在线用户
	 * @param key 用户键-默认为用户名
	 * @param user 用户
	 */
	public void addUser(String key, User user){
		UserList.put(key, user);
	}
	/**
	 * 以用户名为键添加在线用户
	 * @param user 用户
	 * @throws Exception 用户未实例化
	 */
	public void addUser(User user) throws Exception{
		if(user.UserName==null)throw new Exception("user un-realized!");
		UserList.put(user.UserName, user);
	}
	/**
	 * 使用户下线
	 * @param key 用户键
	 */
	public void removeUser(String key){
		UserList.remove(key);
	}
}
