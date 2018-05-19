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

	/**部署流程定义  **/
	ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
	
	@Test
	public void deploymentProcessDefinition() {
		Deployment deployment=processEngine.getRepositoryService()//与流程定义和部署对象相关的service
		.createDeployment()//创建一个部署对象
		.addClasspathResource("diagrams/helloworld.bpmn")//
		.addClasspathResource("diagrams/helloworld.png")
		.deploy();
		System.out.println(deployment.getId());
		System.out.println(deployment.getName());
	}
	
	/**启动流程引擎*/  
	@Test  
	public void startProcessInstance(){  
	    //获取流程启动Service  
	    RuntimeService runtimeService=processEngine.getRuntimeService();  
	    //使用流程定义的key，key对应bpmn文件对应的id，  
	    //(也是act_re_procdef表中对应的KEY_字段),默认是按照最新版本启动  
	    String processDefinitionkey="helloworld";//流程定义的key就是HelloWorld  
	    //获取流程实例对象  
	    ProcessInstance processInstance=runtimeService.startProcessInstanceByKey(processDefinitionkey);  
	    System.out.println("流程实例ID："+processInstance.getId());//流程实例ID  
	    System.out.println("流程定义ID："+processInstance.getProcessDefinitionId());//流程定义ID  
	} 
	
	
	/**查询当前的个人任务(实际就是查询act_ru_task表)*/  
	@Test  
	public void findMyPersonalTask(){  
	    String assignee="张三";  
	    //获取事务Service  
	    TaskService taskService=processEngine.getTaskService();  
	    List<Task> taskList=taskService.createTaskQuery()//创建任务查询对象  
	               .taskAssignee(assignee)//指定个人任务查询，指定办理人  
	               .list();//获取该办理人下的事务列表  
	      
	    if(taskList!=null&&taskList.size()>0){  
	        for(Task task:taskList){  
	            System.out.println("任务ID："+task.getId());  
	            System.out.println("任务名称："+task.getName());  
	            System.out.println("任务的创建时间："+task.getCreateTime());  
	            System.out.println("任务办理人："+task.getAssignee());  
	            System.out.println("流程实例ID："+task.getProcessInstanceId());  
	            System.out.println("执行对象ID："+task.getExecutionId());  
	            System.out.println("流程定义ID："+task.getProcessDefinitionId());  
	            System.out.println("#############################################");  
	        }  
	    }  
	}
	
	/**完成我的任务*/  
	@Test  
	public void completeMyPersonalTask(){  
	    String taskId="7509";//上一次我们查询的任务ID就是304  
	    TaskService taskService=processEngine.getTaskService();  
	    taskService.complete(taskId);//完成taskId对应的任务  
	    System.out.println("完成ID为"+taskId+"的任务");  
	      
	}  
	
	

	/**查询当前的个人任务(实际就是查询act_ru_task表)*/  
	@Test  
	public void findMyPersonalTask2(){  
	    String assignee="李四";  
	    //获取事务Service  
	    TaskService taskService=processEngine.getTaskService();  
	    List<Task> taskList=taskService.createTaskQuery()//创建任务查询对象  
	               .taskAssignee(assignee)//指定个人任务查询，指定办理人  
	               .list();//获取该办理人下的事务列表  
	      
	    if(taskList!=null&&taskList.size()>0){  
	        for(Task task:taskList){  
	            System.out.println("任务ID："+task.getId());  
	            System.out.println("任务名称："+task.getName());  
	            System.out.println("任务的创建时间："+task.getCreateTime());  
	            System.out.println("任务办理人："+task.getAssignee());  
	            System.out.println("流程实例ID："+task.getProcessInstanceId());  
	            System.out.println("执行对象ID："+task.getExecutionId());  
	            System.out.println("流程定义ID："+task.getProcessDefinitionId());  
	            System.out.println("#############################################");  
	        }  
	    }  
	}
	
	/**完成我的任务*/  
	@Test  
	public void completeMyPersonalTask2(){  
	    String taskId="17512";
	    TaskService taskService=processEngine.getTaskService();  
	    taskService.complete(taskId);//完成taskId对应的任务  
	    System.out.println("完成ID为"+taskId+"的任务");  
	      
	}  
	
	
	/**查询当前的个人任务(实际就是查询act_ru_task表)*/  
	@Test  
	public void findMyPersonalTask3(){  
	    String assignee="王五";  
	    //获取事务Service  
	    TaskService taskService=processEngine.getTaskService();  
	    List<Task> taskList=taskService.createTaskQuery()//创建任务查询对象  
	               .taskAssignee(assignee)//指定个人任务查询，指定办理人  
	               .list();//获取该办理人下的事务列表  
	      
	    if(taskList!=null&&taskList.size()>0){  
	        for(Task task:taskList){  
	            System.out.println("任务ID："+task.getId());  
	            System.out.println("任务名称："+task.getName());  
	            System.out.println("任务的创建时间："+task.getCreateTime());  
	            System.out.println("任务办理人："+task.getAssignee());  
	            System.out.println("流程实例ID："+task.getProcessInstanceId());  
	            System.out.println("执行对象ID："+task.getExecutionId());  
	            System.out.println("流程定义ID："+task.getProcessDefinitionId());  
	            System.out.println("#############################################");  
	        }  
	    }  
	}
	
	/**完成我的任务*/  
	@Test  
	public void completeMyPersonalTask3(){  
	    String taskId="25002";//上一次我们查询的任务ID就是304  
	    TaskService taskService=processEngine.getTaskService();  
	    taskService.complete(taskId);//完成taskId对应的任务  
	    System.out.println("完成ID为"+taskId+"的任务");  
	      
	}  
	
}
