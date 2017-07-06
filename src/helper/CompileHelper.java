package helper;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * 编译助手
 * @author 屈彬
 *
 */
public class CompileHelper {
	/**
	 * 编译器路径
	 */
	String COMPILER_PATH;
	/**
	 * 工作目录
	 */
	String WORK_DIRECTORY;
	
	public CompileHelper(){
		initiatlize();
	}
	/**
	 * 初始化
	 */
	protected void initiatlize(){
		loadConfigure();
	}
	/**
	 * 加载配置
	 */
	protected void loadConfigure(){
		ConfHelper confHelper = new ConfHelper();
		COMPILER_PATH = confHelper.getConfValue("CompilerPath");
		WORK_DIRECTORY = confHelper.getConfValue("WorkDirectory");
	}
	/**
	 * 执行编译操作
	 * @param codeFileName 代码文件路径
	 * @return 编译信息
	 */
	public CompileResult doCompile(String codeFileName){
		System.out.println("codefile:" + codeFileName);
		/* 检查文件存在性 */
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
			process = runtime.exec(gccCmd);// 执行编译操作
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));// 获取编译器输出信息
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
		CompileResult result = new CompileResult();// 创建输出结果
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
	 * 运行可执行程序
	 * @param exeFilePath 程序路径
	 * @param inputCase 输入用例
	 * @return 执行信息
	 */
	public CompileResult doExec(String exeFileName, String inputCase){
		System.out.println("exe file:" + exeFileName);
		/* 检查文件存在性 */
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
			process = runtime.exec(exeCmd);// 执行编译操作
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));// 获取编译器输出信息
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
		CompileResult result = new CompileResult();// 创建输出结果
		result.setInfo(outputInfo);
		result.setSucess(true);
		return result;
	}
	/**
	 * 编译结果类
	 * @author 屈彬
	 *
	 */
	public class CompileResult{
		boolean Sucess;
		String Info;
		public CompileResult(){}
		/**
		 * 是否执行成功
		 * @return
		 */
		public boolean isSucess(){
			return Sucess;
		}
		/**
		 * 执行信息
		 * @return
		 */
		public String getInfo(){
			return Info;
		}
		/**
		 * 设置是否成功
		 * @param Sucess
		 */
		public void setSucess(boolean Sucess){this.Sucess=Sucess;}
		/**
		 * 设置输出信息
		 * @param Info 输出信息
		 */
		public void setInfo(String Info){this.Info=Info;}
	}
}
