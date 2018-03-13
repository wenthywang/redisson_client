/**
 * Copyright(c) Guangzhou JiaxinCloud Science & Technology Ltd. 
 */
package test;

import org.redisson.api.RCountDownLatch;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;

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
public class TopicPub {
	 
    public static void main(String[] args) {
    	testPub();
	}  
    
  /**
   * 消息发布者
   */
    public static  void testPub() {  
    	RedissonClient	 client = RedisUtils.getInstance().getRedisson(AppConfig.IP, AppConfig.PORT,AppConfig.PASSWORD,AppConfig.REDIS_DATABASE);  
    	RTopic<String> rTopic=RedisUtils.getInstance().getRTopic(client, "testTopic");  
      System.out.println(rTopic.publish("今天是儿童节，大家儿童节快乐3,wocao"));  
      //发送完消息后 让订阅者不再等待  
      RCountDownLatch rCountDownLatch=RedisUtils.getInstance().getRCountDownLatch(client, "testCountDownLatch");  
      rCountDownLatch.countDown();  
        RedisUtils.getInstance().closeRedisson(client);  
    }  

}
