package cn.edu.hbpu.news.Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.hbpu.news.model.News;


public class WebUtil {
	/*request �ͻ��˵�������󣬷�װ������Ĳ������Ͳ���ֵ
	class1 ��Ҫ�������ԵĶ���
	��������Ĳ���������Ӧ��ֵ��ֵ���������ֵ*/
	public static <T> T fillBean(HttpServletRequest request,Class<T> class1){
		//���ض������ͱ������ƥ�����е�ʵ���ࣨNews Newsclass NewsAdmin��
		try {
			T bean=class1.newInstance();
			BeanUtils.populate(bean, request.getParameterMap());
			return bean;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
		//ע�⣺ҳ��ı�Ԫ�ص�name����Ҫ�Ͷ�Ӧ�����������һһ��Ӧ
	}
	
	//��news�����content���������html��ǩȥ������ȡ�������ݵ�ǰ80���ַ�
	public static void removeHtml(News news){
		//1���ҵ�content�������е�HTML��ǩ
		//������ʽ��ʾhtml��ǩ
		//html��ǩ���ص㣺��<��ʼ����>�������м䲻�����κε�>,�м������֣�Ӣ�ĺ����֣�
		String content=news.getContent();
		String str="<[^>]*>";//html��ǩ��������ʽ
		Pattern p=Pattern.compile(str, Pattern.MULTILINE|Pattern.UNICODE_CASE);
		Matcher m=p.matcher(content);
		//2����html��ǩ�滻�ɿ��ַ���
		content=m.replaceAll("");
		int length=content.length();
		if(length>80){
			length=80;
		}
		String newContent=content.substring(0,length);
		news.setContent(newContent);
	}
	
	
	//��date���ڸ�ʽ�������ظ�ʽ������ַ���
	public static String formatTime(Date date){
		SimpleDateFormat sdf=
			new SimpleDateFormat("yyyy��MM��dd��hh:mm:ss");
		return sdf.format(date);
	}

}
