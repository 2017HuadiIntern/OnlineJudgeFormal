package helper;
/**
 * ��������
 * @author ����
 *
 */
public class CompileHelper {
	/**
	 * ������·��
	 */
	final String COMPILER_PATH = "D:\\MinGW\\bin\\gcc.exe";// undone
	/**
	 * ����Ŀ¼
	 */
	final String WORK_DIRECTORY = "E:\\project\\java\\";// undone
	/**
	 * ִ�б������
	 * @param codeFilePath �����ļ�·��
	 * @return ������Ϣ
	 */
	public String doCompile(String codeFilePath){
		// undone
		return null;
	}
	/**
	 * ���п�ִ�г���
	 * @param exeFilePath ����·��
	 * @return ִ����Ϣ
	 */
	public String doExec(String exeFilePath){
		// undone
		return null;
	}
	/**
	 * ��������
	 * @author ����
	 *
	 */
	public class CompileResult{
		boolean Sucess;
		String Info;
		public CompileResult(boolean Sucess, String Info){
			this.Sucess=Sucess;
			this.Info=Info;
		}
		/**
		 * �Ƿ�ִ�гɹ�
		 * @return
		 */
		public boolean isSucess(){
			return Sucess;
		}
		/**
		 * ִ����Ϣ
		 * @return
		 */
		public String getInfo(){
			return Info;
		}
	}
	/**
	 * ��������ö��
	 * @author ����
	 *
	 */
	public enum ProcessType{
		PROCESS_COMPILE, PROCESS_EXEC
	}
	public CompileResult genRecord(String filePath, ProcessType type){
		switch (type) {
		case PROCESS_COMPILE:
			
			break;
		case PROCESS_EXEC:
			break;
		default:
			break;
		}
		// undone
		return new CompileResult(false, null);
	}
}
