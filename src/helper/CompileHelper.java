package helper;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
	/**
	 * 获取工作目录
	 * @return 工作目录
	 */
	public String getWorkDirecoty(){return WORK_DIRECTORY;}
	/**
	 * 配置助手
	 */
	ConfHelper confHelper;
	
	public CompileHelper(ConfHelper confHelper){
		this.confHelper = confHelper;
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
		COMPILER_PATH = confHelper.getConfValue("CompilerPath");
		WORK_DIRECTORY = confHelper.getConfValue("WorkDirectory");
	}
	/**
	 * 执行编译操作
	 * @param codeFileName 代码文件路径
	 * @return 编译信息
	 */
	public CompileResult doCompile(String codeFilePath){
		System.out.println("codefile:" + codeFilePath);
		/* 检查文件存在性 */
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
			process = runtime.exec(gccCmd);// 执行编译操作
			bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));// 获取编译器输出信息
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
		CompileResult result = new CompileResult();// 创建输出结果
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
	 * 运行可执行程序
	 * @param exeFilePath 程序路径
	 * @param inputCase 输入用例
	 * @return 执行信息
	 */
	public CompileResult doExec(String exeFilePath, String inputCase){
		System.out.println("exe file:" + exeFilePath);
		/* 检查文件存在性 */
		File file = new File(exeFilePath);
		if(!file.exists()){
			System.out.println("exe file not exist in " + exeFilePath);
			return null;
		}
		/* 计算输入参数的数量 */
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
		if(process!=null)process.destroy();
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
	/**
	 * 生成C语言文件路径
	 * @param userName 用户名
	 * @param problemID 题目编号
	 * @return 文件路径
	 */
	public String genCodeFilePath(String userName, String problemID){
		return WORK_DIRECTORY + "\\" + userName + "-" + problemID + ".c";
	}
}
