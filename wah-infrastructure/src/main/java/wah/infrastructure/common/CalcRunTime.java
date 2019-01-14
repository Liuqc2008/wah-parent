package wah.infrastructure.common;

public class CalcRunTime {

	 private static ThreadLocal<Long> tl = new ThreadLocal<>();
	 
	 public static void start() {
		 tl.set(System.currentTimeMillis());
	 }
	 
	 public static void finish(String methodName) {
		 long time = System.currentTimeMillis() - tl.get();
	
		 System.out.println(String.format(methodName +"方法耗时：%s%s", time, "ms"));
	 }
}
