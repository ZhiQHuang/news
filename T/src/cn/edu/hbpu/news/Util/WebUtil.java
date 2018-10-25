package cn.edu.hbpu.news.Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.hbpu.news.model.News;


public class WebUtil {
	/*request 客户端的请求对象，封装了请求的参数名和参数值
	class1 需要设置属性的对象
	根据请求的参数名将对应的值赋值对象的属性值*/
	public static <T> T fillBean(HttpServletRequest request,Class<T> class1){
		//返回对象类型必须可以匹配所有的实体类（News Newsclass NewsAdmin）
		try {
			T bean=class1.newInstance();
			BeanUtils.populate(bean, request.getParameterMap());
			return bean;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
		//注意：页面的表单元素的name属性要和对应对象的属性名一一对应
	}
	
	//将news对象的content内容里面的html标签去掉，截取新闻内容的前80个字符
	public static void removeHtml(News news){
		//1、找到content里面所有的HTML标签
		//正则表达式表示html标签
		//html标签的特点：以<开始，以>结束，中间不包含任何的>,中间有文字（英文和数字）
		String content=news.getContent();
		String str="<[^>]*>";//html标签的正则表达式
		Pattern p=Pattern.compile(str, Pattern.MULTILINE|Pattern.UNICODE_CASE);
		Matcher m=p.matcher(content);
		//2、将html标签替换成空字符串
		content=m.replaceAll("");
		int length=content.length();
		if(length>80){
			length=80;
		}
		String newContent=content.substring(0,length);
		news.setContent(newContent);
	}
	
	
	//将date日期格式化，返回格式化后的字符串
	public static String formatTime(Date date){
		SimpleDateFormat sdf=
			new SimpleDateFormat("yyyy年MM月dd日hh:mm:ss");
		return sdf.format(date);
	}

}
