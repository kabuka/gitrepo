package test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Test {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		
		System.out.println(URLDecoder.decode("%e4%b8%ad%e5%8d%8e%e4%ba%ba%e6%b0%91%e5%85%b1%e5%92%8c%e5%9b%bd", "UTF-8"));
		
		
		String type = "1";
		String subplace = "0";
		String userId  = "abc";
		StringBuffer sqlBuff = new StringBuffer();
		sqlBuff.append(" select * from ");
		sqlBuff.append("table");
		
		if("1".equals(type)) {
			sqlBuff.append(" where (type = " + type);
			
			if ("0".equals(subplace)) {
				sqlBuff.append(" and user_id is null) or user_id = '" + userId+"'");
			} 
			else if (subplace != null && subplace.indexOf(",") > 0) {
				if (subplace.lastIndexOf(",") == subplace.length()-1) {
					subplace = subplace.substring(0, subplace.length() -1);
				}
				sqlBuff.append(") and subplace in( " + subplace).append(")");
				if (userId != null && !userId.isEmpty()) {
					sqlBuff.append(" and user_id='" + userId + "'");
				}
			}
			else {
				sqlBuff.append(") and subplace = " + subplace);
				if (userId != null && !userId.isEmpty()) {
					sqlBuff.append(" and user_id='" + userId + "'");
				}
			}
		} else {
			sqlBuff.append(" where type=2");	

		}
		
		System.out.println(sqlBuff.toString());
	}

}
