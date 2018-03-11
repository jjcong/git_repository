package cache.test;

import java.util.logging.Logger;

/**
 * @author j_cong
 * @date 2017年9月11日
 * @describe 监听失效数据并移除
 * @version V1.0.0
 */
public class CacheListener {

	Logger logger = Logger.getLogger("cacheLog");
	  private CacheManagerImpl cacheManagerImpl;
	  public CacheListener(CacheManagerImpl cacheManagerImpl) {
	    this.cacheManagerImpl = cacheManagerImpl;
	  }

	  public void startListen() {
	    new Thread(){
	      public void run() {
	        while (true) {
	          for(String key : cacheManagerImpl.getAllKeys()) {
	            if (cacheManagerImpl.isTimeOut(key)) {
	             cacheManagerImpl.clearByKey(key);
	             logger.info(key + "缓存被清除");
	           }
	          } 
	        }
	      } 
	    }.start();

	  }
}
