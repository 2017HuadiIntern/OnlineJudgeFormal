package helper;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
	/**
	 * ��ȡ����Ŀ¼
	 * @return ����Ŀ¼
	 */
	public String getWorkDirecoty(){return WORK_DIRECTORY;}
	/**
	 * ��������
	 */
	ConfHelper confHelper;
	
	public CompileHelper(ConfHelper confHelper){
		this.confHelper = confHelper;
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
		COMPILER_PATH = confHelper.getConfValue("CompilerPath");
		WORK_DIRECTORY = confHelper.getConfValue("WorkDirectory");
	}
	/**
	 * ִ�б������
	 * @param codeFileName �����ļ�·��
	 * @return ������Ϣ
	 */
	public CompileResult doCompile(String codeFilePath){
		System.out.println("codefile:" + codeFilePath);
		/* ����ļ������� */
		File codeFile = new File(codeFilePath);
		if(!codeFile.exists()){
			System.out.println("code file not exist in " + codeFilePath);
			return null;
		}
		String[] gccCmd = {COMPILER_PATH, "-o", codeFilePath + ".exe", codeFilePath};
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		BufferedReader bufferedReader = null;
		
		String outputInfo = "";
		try{
			process = runtime.exec(gccCmd);// ִ�б������
			bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));// ��ȡ�����������Ϣ
			String outputLine = "";
			while((outputLine = bufferedReader.readLine())!=null){
				System.out.println(outputLine);
				outputInfo += (outputLine + "\r\n");
			}
			if(bufferedReader!=null)bufferedReader.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
		}
		CompileResult result = new CompileResult();// ����������
		result.setSucess(false);
		if(outputInfo.isEmpty()){
			result.setSucess(true);
			result.setInfo("");
		}else{
			result.setSucess(false);
			result.setInfo(outputInfo.replace(codeFilePath, ""));
		}
		if(process!=null)process.destroy();
		return result;
	}
	/**
	 * ���п�ִ�г���
	 * @param exeFilePath ����·��
	 * @param inputCase ��������
	 * @return ִ����Ϣ
	 */
	public CompileResult doExec(String exeFilePath, String inputCase){
		System.out.println("exe file:" + exeFilePath);
		/* ����ļ������� */
		File file = new File(exeFilePath);
		if(!file.exists()){
			System.out.println("exe file not exist in " + exeFilePath);
			return null;
		}
		/* ����������������� */
		ArrayList<String> paramList = new ArrayList<String>();
		String tempStr = "";
		for(int i=0;i<inputCase.length();i++){
			if((inputCase.charAt(i) + "").equals(" ")){
				paramList.add(tempStr);
				tempStr="";
			}else{
				tempStr+=inputCase.charAt(i)+"";
			}
		}
		paramList.add(tempStr);
		String[] exeCmd = new String[paramList.size() +1];
		exeCmd[0] = exeFilePath;
		for(int i=0;i<paramList.size();i++){
			System.out.println("inputcase"+i+":"+paramList.get(i));
			exeCmd[i + 1]=paramList.get(i);
		}
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
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
		if(process!=null)process.destroy();
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
	/**
	 * ����C�����ļ�·��
	 * @param userName �û���
	 * @param problemID ��Ŀ���
	 * @return �ļ�·��
	 */
	public String genCodeFilePath(String userName, String problemID){
		return WORK_DIRECTORY + "\\" + userName + "-" + problemID + ".c";
	}
}
