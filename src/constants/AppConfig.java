/**
 * Copyright(c) Guangzhou JiaxinCloud Science & Technology Ltd. 
 */
package constants;

/**
 * <pre>
 * 基本配置。
 * </pre>
 * 
 * @author 王文辉 wangwenhui@jiaxincloud.com
 * @version 1.00.00
 * @date 2018年3月13日
 * 
 *       <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 *       </pre>
 */
public class AppConfig {

	public static String IP = "redis://111.230.24.31"; // redis 地址
	public static String PORT = "6379"; // redis 端口
	public static String PASSWORD = "test"; // redis 密码（可不设置，安全起见还是设置密码）
	public static int REDIS_DATABASE = 0;// redis 数据库index 默认是0（有0-15） 默认有16个

}
