package junit;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngine;
import org.junit.Test;

public class TestActiviti {
	
	
	@Test  
	public void createTable_2(){  
		  System.out.println("processEngine:start test!!");  
	    //��ȡ�������ĺ��Ķ���ProcessEngine����   
	    ProcessEngine processEngine =   
	            ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti-cfg.xml").buildProcessEngine();  
	    System.out.println("processEngine:"+processEngine+"Create Success!!");  
	}  
	
	
}
