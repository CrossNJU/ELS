package org.cross.elsclient.ui.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.cross.elscommon.util.InfoType;
import org.cross.elscommon.util.ResultMessage;

public class InfoFormatUtil {
	private static Pattern numericPattern = Pattern.compile("^[0-9\\-]+$");
	
	public static String CheckFormat(String src,InfoType type){
		
		switch (type) {
		case NAME:
			return CheckString(src);
		case IDCARD:
			return CheckIDCardFormat(src);
		case CELLPHONE:
			return CheckCellPhoneFormat(src);
		case NUM:
			return CheckNumFormat(src);
		case PASSWORD:
			return CheckPasswordFormat(src);
		default:
			break;
		}
		
		return null;
	}
	
	public static String CheckString(String src){
		if(src.isEmpty()){
			return "信息为空";
		}else {
			return null;
		}
	}
	
	public static String CheckIDCardFormat(String src){
		
		if(CheckNumFormat(src)!=null){
			return CheckNumFormat(src);
		}else if(src.length()!=18){
				return "身份证长度错误!";
		}

		return null;
	}
	
	public static String CheckCellPhoneFormat(String src){
		
		if(CheckNumFormat(src)!=null){
			return CheckNumFormat(src);
		}else if(src.length()!=11){
				return "手机长度错误!";
		}
		return null;
	}
	
	public static String CheckPasswordFormat(String src){
		String result = "";
		
		if(!isContainUppercase(src)){
			result += "不包含大写字母 ";
		}
		if(!isContainLowwercase(src)){
			result += "不包含小写字母 ";
		}
		if(!isContainNum(src)){
			result += "不包含数字 ";
		}
		
		if(result.equals("")){
			return null;
		}else{
			return result;
		}
	}
	
	public static String CheckNumFormat(String src){
		 char c[] = src.toCharArray();
		 
		 for (char ch : c) {
			if(ch<'0'||ch>'9'){
				return "包含非数字字符";
			}
		}
		return null;
	}
	
	public static boolean isContainUppercase(String src){
		boolean result = false;
		char c[] = src.toCharArray();
		
		for (char ch : c) {
			if(ch>='A'&&ch<='Z'){
				result = true;
				break;
			}
		}
		
		return result;
	}
	public static boolean isContainLowwercase(String src){
		boolean result = false;
		char c[] = src.toCharArray();
		
		for (char ch : c) {
			if(ch>='a'&&ch<='z'){
				result = true;
				break;
			}
		}
		return result;
	}
	public static boolean isContainNum(String src){
		boolean result = false;
		char c[] = src.toCharArray();
		
		for (char ch : c) {
			if(ch>='0'&&ch<='9'){
				result = true;
				break;
			}
		}
		return result;
	}
}
