package demo;
/**
 * 双重锁检定 ; synchronized可以锁对象，锁方法，所变量
 * @author wgf
 *
 */
public class DoubleClock {

	private static DoubleClock doubleClock;
	
	public static DoubleClock getInstance(){
		
		if(doubleClock == null){
			synchronized (DoubleClock.class) {  //DoubleClock.class获取对象;
				if(doubleClock == null){
					doubleClock = new DoubleClock();
				}
			}
		}
		
		return doubleClock;
	}
}
