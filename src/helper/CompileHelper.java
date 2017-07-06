package helper;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * ��������
 * @author ����
 *
 */
public class CompileHelper {
	/**
	 * ������·��
	 */
	String COMPILER_PATH;
	/**
	 * ����Ŀ¼
	 */
	String WORK_DIRECTORY;
	
	public CompileHelper(){
		initiatlize();
	}
	/**
	 * ��ʼ��
	 */
	protected void initiatlize(){
		loadConfigure();
	}
	/**
	 * ��������
	 */
	protected void loadConfigure(){
		ConfHelper confHelper = new ConfHelper();
		COMPILER_PATH = confHelper.getConfValue("CompilerPath");
		WORK_DIRECTORY = confHelper.getConfValue("WorkDirectory");
	}
	/**
	 * ִ�б������
	 * @param codeFileName �����ļ�·��
	 * @return ������Ϣ
	 */
	public CompileResult doCompile(String codeFileName){
		System.out.println("codefile:" + codeFileName);
		/* ����ļ������� */
		String codeFilePath = WORK_DIRECTORY + "\\" + codeFileName;
		File codeFile = new File(codeFilePath);
		if(!codeFile.exists()){
			System.out.println("code file not exist in " + codeFilePath);
			return null;
		}
		String[] gccCmd = {COMPILER_PATH, "-o", codeFilePath + ".exe", codeFilePath};
		Runtime runtime = Runtime.getRuntime();
		Process process;
		BufferedReader bufferedReader = null;
		String outputLine;
		String outputInfo = "";
		try{
			process = runtime.exec(gccCmd);// ִ�б������
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));// ��ȡ�����������Ϣ
			while((outputLine = bufferedReader.readLine())!=null){
				System.out.println(outputLine);
				outputInfo += outputLine + "\r\n";
			}
			if(bufferedReader!=null)bufferedReader.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
		}
		CompileResult result = new CompileResult();// ����������
		if(outputInfo.isEmpty()){
			result.setSucess(true);
			result.setInfo("");
		}else{
			result.setSucess(false);
			result.setInfo(outputInfo);
		}
		return result;
	}
	/**
	 * ���п�ִ�г���
	 * @param exeFilePath ����·��
	 * @param inputCase ��������
	 * @return ִ����Ϣ
	 */
	public CompileResult doExec(String exeFileName, String inputCase){
		System.out.println("exe file:" + exeFileName);
		/* ����ļ������� */
		String exeFilePath = WORK_DIRECTORY + "\\" + exeFileName;
		File file = new File(exeFilePath);
		if(!file.exists()){
			System.out.println("exe file not exist in " + exeFilePath);
			return null;
		}
		String[] exeCmd = {exeFilePath, inputCase};
		Runtime runtime = Runtime.getRuntime();
		Process process;
		BufferedReader bufferedReader = null;
		String outputLine;
		String outputInfo = "";
		try{
			process = runtime.exec(exeCmd);// ִ�б������
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));// ��ȡ�����������Ϣ
			while((outputLine = bufferedReader.readLine())!=null){
				System.out.println(outputLine);
				outputInfo += outputLine + "\r\n";
			}
			if(bufferedReader!=null)bufferedReader.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
		}
		CompileResult result = new CompileResult();// ����������
		result.setInfo(outputInfo);
		result.setSucess(true);
		return result;
	}
	/**
	 * ��������
	 * @author ����
	 *
	 */
	public class CompileResult{
		boolean Sucess;
		String Info;
		public CompileResult(){}
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
		/**
		 * �����Ƿ�ɹ�
		 * @param Sucess
		 */
		public void setSucess(boolean Sucess){this.Sucess=Sucess;}
		/**
		 * ���������Ϣ
		 * @param Info �����Ϣ
		 */
		public void setInfo(String Info){this.Info=Info;}
	}
}
