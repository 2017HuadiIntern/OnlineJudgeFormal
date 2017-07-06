package helper;
/**
 * 编译助手
 * @author 屈彬
 *
 */
public class CompileHelper {
	/**
	 * 编译器路径
	 */
	final String COMPILER_PATH = "D:\\MinGW\\bin\\gcc.exe";// undone
	/**
	 * 工作目录
	 */
	final String WORK_DIRECTORY = "E:\\project\\java\\";// undone
	/**
	 * 执行编译操作
	 * @param codeFilePath 代码文件路径
	 * @return 编译信息
	 */
	public String doCompile(String codeFilePath){
		// undone
		return null;
	}
	/**
	 * 运行可执行程序
	 * @param exeFilePath 程序路径
	 * @return 执行信息
	 */
	public String doExec(String exeFilePath){
		// undone
		return null;
	}
	/**
	 * 编译结果类
	 * @author 屈彬
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
	}
	/**
	 * 过程类型枚举
	 * @author 屈彬
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
