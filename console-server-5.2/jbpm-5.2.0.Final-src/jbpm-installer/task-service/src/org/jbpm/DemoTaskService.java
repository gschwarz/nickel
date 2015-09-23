package org.jbpm;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jbpm.task.AccessType;
import org.jbpm.task.AllowedToDelegate;
import org.jbpm.task.Attachment;
import org.jbpm.task.BooleanExpression;
import org.jbpm.task.Comment;
import org.jbpm.task.Deadline;
import org.jbpm.task.Deadlines;
import org.jbpm.task.Delegation;
import org.jbpm.task.Escalation;
import org.jbpm.task.Group;
import org.jbpm.task.I18NText;
import org.jbpm.task.Notification;
import org.jbpm.task.OrganizationalEntity;
import org.jbpm.task.PeopleAssignments;
import org.jbpm.task.Reassignment;
import org.jbpm.task.Status;
import org.jbpm.task.Task;
import org.jbpm.task.TaskData;
import org.jbpm.task.User;
import org.jbpm.task.query.TaskSummary;
import org.jbpm.task.service.TaskService;
import org.jbpm.task.service.TaskServiceSession;
import org.jbpm.task.service.UserGroupCallbackManager;
import org.jbpm.task.service.mina.MinaTaskServer;
import org.drools.SystemEventListenerFactory;
import org.mvel2.MVEL;
import org.mvel2.ParserContext;
import org.mvel2.compiler.ExpressionCompiler;

public class DemoTaskService {
	
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.jbpm.task");
        TaskService taskService = new TaskService(emf, SystemEventListenerFactory.getSystemEventListener());
        TaskServiceSession taskSession = taskService.createSession();
        // Add users
        Map vars = new HashMap();
        InputStream usersin = DemoTaskService.class.getResourceAsStream( "LoadUsers.mvel" );
        if(usersin != null) {
        	Reader reader = new InputStreamReader( usersin );   
        	@SuppressWarnings("unchecked")
        	Map<String, User> users = ( Map<String, User> ) eval( reader, vars );   
        	for ( User user : users.values() ) {
        		taskSession.addUser( user );
        	}           
        }
        InputStream groupsin = DemoTaskService.class.getResourceAsStream( "LoadGroups.mvel" );
        if(groupsin != null) {
        	Reader reader = new InputStreamReader( groupsin );   
        	@SuppressWarnings("unchecked")
        	Map<String, Group> groups = ( Map<String, Group> ) eval( reader, vars );     
        	for ( Group group : groups.values() ) {
        		taskSession.addGroup( group );
        	}
        }
        // try to get the usergroup callback properties
        InputStream usergroupsin = DemoTaskService.class.getResourceAsStream(  "jbpm.usergroup.callback.properties" );
        if(usergroupsin != null) {
        	Reader reader = new InputStreamReader( usergroupsin );
        	Properties callbackproperties = new Properties();
        	try {
        		callbackproperties.load(reader);
        		UserGroupCallbackManager.getInstance().setCallbackFromProperties(callbackproperties);
        		System.out.println("Task service registered usergroup callback ...");
        	} catch (Exception e) {
        		System.out.println("Task service unable to register usergroup callback ...");
        	}
        }
        // start server
        MinaTaskServer server = new MinaTaskServer(taskService);
        Thread thread = new Thread(server);
        thread.start();
        taskSession.dispose();
        System.out.println("Task service started correctly!");
        System.out.println("Task service running ...");
    }

    public static Object eval(Reader reader, Map vars) {
        try {
            return eval( readerToString( reader ), vars );
        } catch ( IOException e ) {
            throw new RuntimeException( "Exception Thrown", e );
        }
    }
    
    public static String readerToString(Reader reader) throws IOException {
        int charValue = 0;
        StringBuffer sb = new StringBuffer( 1024 );
        while ( (charValue = reader.read()) != -1 ) {
            //result = result + (char) charValue;
            sb.append( (char) charValue );
        }
        return sb.toString();
    }

    public static Object eval(String str, Map vars) {
        ExpressionCompiler compiler = new ExpressionCompiler( str.trim() );

        ParserContext context = new ParserContext();
        context.addPackageImport( "org.jbpm.task" );
        context.addPackageImport( "java.util" );
        
        context.addImport( "AccessType", AccessType.class );
        context.addImport( "AllowedToDelegate", AllowedToDelegate.class );
        context.addImport( "Attachment", Attachment.class );
        context.addImport( "BooleanExpression", BooleanExpression.class );
        context.addImport( "Comment", Comment.class );
        context.addImport( "Deadline", Deadline.class );
        context.addImport( "Deadlines", Deadlines.class );
        context.addImport( "Delegation", Delegation.class );
        context.addImport( "Escalation", Escalation.class );
        context.addImport( "Group", Group.class );
        context.addImport( "I18NText", I18NText.class );
        context.addImport( "Notification", Notification.class );
        context.addImport( "OrganizationalEntity", OrganizationalEntity.class );
        context.addImport( "PeopleAssignments", PeopleAssignments.class );
        context.addImport( "Reassignment", Reassignment.class );
        context.addImport( "Status", Status.class );
        context.addImport( "Task", Task.class );
        context.addImport( "TaskData", TaskData.class );
        context.addImport( "TaskSummary", TaskSummary.class );
        context.addImport( "User", User.class );

        return MVEL.executeExpression( compiler.compile( context ), vars );
    }

}
