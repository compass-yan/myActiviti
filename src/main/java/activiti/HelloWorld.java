package activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class HelloWorld {

	/**�������̶���  **/
	ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
	
	@Test
	public void deploymentProcessDefinition() {
		Deployment deployment=processEngine.getRepositoryService()//�����̶���Ͳ��������ص�service
		.createDeployment()//����һ���������
		.addClasspathResource("diagrams/helloworld.bpmn")//
		.addClasspathResource("diagrams/helloworld.png")
		.deploy();
		System.out.println(deployment.getId());
		System.out.println(deployment.getName());
	}
	
	/**������������*/  
	@Test  
	public void startProcessInstance(){  
	    //��ȡ��������Service  
	    RuntimeService runtimeService=processEngine.getRuntimeService();  
	    //ʹ�����̶����key��key��Ӧbpmn�ļ���Ӧ��id��  
	    //(Ҳ��act_re_procdef���ж�Ӧ��KEY_�ֶ�),Ĭ���ǰ������°汾����  
	    String processDefinitionkey="helloworld";//���̶����key����HelloWorld  
	    //��ȡ����ʵ������  
	    ProcessInstance processInstance=runtimeService.startProcessInstanceByKey(processDefinitionkey);  
	    System.out.println("����ʵ��ID��"+processInstance.getId());//����ʵ��ID  
	    System.out.println("���̶���ID��"+processInstance.getProcessDefinitionId());//���̶���ID  
	} 
	
	
	/**��ѯ��ǰ�ĸ�������(ʵ�ʾ��ǲ�ѯact_ru_task��)*/  
	@Test  
	public void findMyPersonalTask(){  
	    String assignee="����";  
	    //��ȡ����Service  
	    TaskService taskService=processEngine.getTaskService();  
	    List<Task> taskList=taskService.createTaskQuery()//���������ѯ����  
	               .taskAssignee(assignee)//ָ�����������ѯ��ָ��������  
	               .list();//��ȡ�ð������µ������б�  
	      
	    if(taskList!=null&&taskList.size()>0){  
	        for(Task task:taskList){  
	            System.out.println("����ID��"+task.getId());  
	            System.out.println("�������ƣ�"+task.getName());  
	            System.out.println("����Ĵ���ʱ�䣺"+task.getCreateTime());  
	            System.out.println("��������ˣ�"+task.getAssignee());  
	            System.out.println("����ʵ��ID��"+task.getProcessInstanceId());  
	            System.out.println("ִ�ж���ID��"+task.getExecutionId());  
	            System.out.println("���̶���ID��"+task.getProcessDefinitionId());  
	            System.out.println("#############################################");  
	        }  
	    }  
	}
	
	/**����ҵ�����*/  
	@Test  
	public void completeMyPersonalTask(){  
	    String taskId="7509";//��һ�����ǲ�ѯ������ID����304  
	    TaskService taskService=processEngine.getTaskService();  
	    taskService.complete(taskId);//���taskId��Ӧ������  
	    System.out.println("���IDΪ"+taskId+"������");  
	      
	}  
	
	

	/**��ѯ��ǰ�ĸ�������(ʵ�ʾ��ǲ�ѯact_ru_task��)*/  
	@Test  
	public void findMyPersonalTask2(){  
	    String assignee="����";  
	    //��ȡ����Service  
	    TaskService taskService=processEngine.getTaskService();  
	    List<Task> taskList=taskService.createTaskQuery()//���������ѯ����  
	               .taskAssignee(assignee)//ָ�����������ѯ��ָ��������  
	               .list();//��ȡ�ð������µ������б�  
	      
	    if(taskList!=null&&taskList.size()>0){  
	        for(Task task:taskList){  
	            System.out.println("����ID��"+task.getId());  
	            System.out.println("�������ƣ�"+task.getName());  
	            System.out.println("����Ĵ���ʱ�䣺"+task.getCreateTime());  
	            System.out.println("��������ˣ�"+task.getAssignee());  
	            System.out.println("����ʵ��ID��"+task.getProcessInstanceId());  
	            System.out.println("ִ�ж���ID��"+task.getExecutionId());  
	            System.out.println("���̶���ID��"+task.getProcessDefinitionId());  
	            System.out.println("#############################################");  
	        }  
	    }  
	}
	
	/**����ҵ�����*/  
	@Test  
	public void completeMyPersonalTask2(){  
	    String taskId="17512";
	    TaskService taskService=processEngine.getTaskService();  
	    taskService.complete(taskId);//���taskId��Ӧ������  
	    System.out.println("���IDΪ"+taskId+"������");  
	      
	}  
	
	
	/**��ѯ��ǰ�ĸ�������(ʵ�ʾ��ǲ�ѯact_ru_task��)*/  
	@Test  
	public void findMyPersonalTask3(){  
	    String assignee="����";  
	    //��ȡ����Service  
	    TaskService taskService=processEngine.getTaskService();  
	    List<Task> taskList=taskService.createTaskQuery()//���������ѯ����  
	               .taskAssignee(assignee)//ָ�����������ѯ��ָ��������  
	               .list();//��ȡ�ð������µ������б�  
	      
	    if(taskList!=null&&taskList.size()>0){  
	        for(Task task:taskList){  
	            System.out.println("����ID��"+task.getId());  
	            System.out.println("�������ƣ�"+task.getName());  
	            System.out.println("����Ĵ���ʱ�䣺"+task.getCreateTime());  
	            System.out.println("��������ˣ�"+task.getAssignee());  
	            System.out.println("����ʵ��ID��"+task.getProcessInstanceId());  
	            System.out.println("ִ�ж���ID��"+task.getExecutionId());  
	            System.out.println("���̶���ID��"+task.getProcessDefinitionId());  
	            System.out.println("#############################################");  
	        }  
	    }  
	}
	
	/**����ҵ�����*/  
	@Test  
	public void completeMyPersonalTask3(){  
	    String taskId="25002";//��һ�����ǲ�ѯ������ID����304  
	    TaskService taskService=processEngine.getTaskService();  
	    taskService.complete(taskId);//���taskId��Ӧ������  
	    System.out.println("���IDΪ"+taskId+"������");  
	      
	}  
	
}
