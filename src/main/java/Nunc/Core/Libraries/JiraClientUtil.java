package Nunc.Core.Libraries;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.CustomFieldOption;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraClientUtil {
	public JiraClient jira;
	public String project;
     public JiraClientUtil(String url,String userName,String password) {
    	 BasicCredentials creds = new BasicCredentials(userName,password);
         this.jira = new JiraClient(url, creds);
     }
	
	public void createJiraTicket(String issueType,String summary,String description,String reporterName) {	
		try {
		FluentCreate fc= jira.createIssue(project, issueType);
		fc.field(Field.SUMMARY, summary);
		fc.field(Field.DESCRIPTION, description);
		fc.field(Field.REPORTER, reporterName);
		
		Issue issue = fc.execute();
		} catch (JiraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
