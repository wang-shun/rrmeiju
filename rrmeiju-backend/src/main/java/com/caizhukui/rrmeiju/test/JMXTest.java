package com.caizhukui.rrmeiju.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class JMXTest {

	public static void main(String[] args) {
		String jmxURL = "service:jmx:rmi:///jndi/rmi://121.42.14.78:8999/jmxrmi";
		try {
			JMXServiceURL serviceURL = new JMXServiceURL(jmxURL);
			Map<String, String[]> map = new HashMap<String, String[]>();
			// 用户名密码，在jmxremote.password文件中查看
			String[] credentials = new String[] { "monitorRole", "caizhukui" };
			map.put("jmx.remote.credentials", credentials);
			JMXConnector connector = JMXConnectorFactory.connect(serviceURL, map);
			MBeanServerConnection mbsc = connector.getMBeanServerConnection();
			// 端口最好是动态取得
			ObjectName threadObjName = new ObjectName("Catalina:type=ThreadPool,name=http-8080");
			MBeanInfo mbInfo = mbsc.getMBeanInfo(threadObjName);
			// Tomcat的线程数对应的属性值
			String attrName = "currentThreadCount";
			MBeanAttributeInfo[] mbAttributes = mbInfo.getAttributes();
			System.out.println("currentThreadCount:" + mbsc.getAttribute(threadObjName, attrName));
			// heap
            for (int j = 0; j < mbsc.getDomains().length; j++) {
            	System.out.println("###########" + mbsc.getDomains()[j]);
            }
            Set<ObjectInstance> MBeanset = mbsc.queryMBeans(null, null);
            System.out.println("MBeanset.size() : " + MBeanset.size()); 
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MalformedObjectNameException e) {
			e.printStackTrace();
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (ReflectionException e) {
			e.printStackTrace();
		} catch (AttributeNotFoundException e) {
			e.printStackTrace();
		} catch (MBeanException e) {
			e.printStackTrace();
		}
	}
}
