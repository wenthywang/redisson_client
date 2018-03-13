/**
 * Copyright(c) Guangzhou JiaxinCloud Science & Technology Ltd. 
 */
package test;

import org.redisson.api.RCountDownLatch;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;

import constants.AppConfig;
import utils.RedisUtils;

/**
 * <pre>
 * redisson client demo。
 * </pre>
 * @author 王文辉  wangwenhui@jiaxincloud.com
 * @version 1.00.00
 * @date 2018年3月9日 
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class TopicSub {
	 
    public static void main(String[] args) {
    	testSub();
	}   
    
    /**
     * 订阅者
     */
    public static  void testSub() {  
    	RedissonClient	 client = RedisUtils.getInstance().getRedisson(AppConfig.IP, AppConfig.PORT,AppConfig.PASSWORD,AppConfig.REDIS_DATABASE);  
      RTopic<String> rTopic=RedisUtils.getInstance().getRTopic(client, "testTopic");  
      rTopic.addListener(new MessageListener<String>() {  

			@Override
			public void onMessage(String channel, String msg) {
			    // TODO Auto-generated method stub  
              System.out.println("你发布的是:"+msg);  
				
			}  
      });  
      //等待发布者发布消息  
      RCountDownLatch rCountDownLatch=RedisUtils.getInstance().getRCountDownLatch(client, "testCountDownLatch");  
      rCountDownLatch.trySetCount(1);  
      try {
		rCountDownLatch.await();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
      //链接不需要关闭
        //需要实时订阅发布者消息
//        RedisUtils.getInstance().closeRedisson(client);  
    }  
  
//      

}
