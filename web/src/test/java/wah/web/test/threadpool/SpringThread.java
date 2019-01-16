package wah.web.test.threadpool;

/**
 * @Auther: DHZB
 * @Date: 2019/1/15 16:40
 * @Description:
 */
public class SpringThread extends Thread{
    private int parameter;

    public SpringThread(int parameter){
        this.parameter = parameter;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":执行了..." + parameter);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
