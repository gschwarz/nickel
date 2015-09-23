package com.rhiscom.bpm.console.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;

public interface LocaleMessages extends Messages {
    public static final LocaleMessages LANG = GWT.create(LocaleMessages.class);

    String create();

    String save();

    String delete();

    String information();

    String businessUnitTitle();

    String businessGroupTitle();

    String refresh();

    String status();

    String businessGroup();

    String level();

    String id();

    String login();
    
    String logout();

    String accept();

    String name();

    String available();

    String assigned();

    String process();

    String task();

    String errorSearchUser();

    String systemError();

    String errorDeleteUser();

    String lastName();

    String contact();

    String createDate();

    String edit();

    String errorGetProfiles();

    String errorGetWorkGroup();

    String userNotFound();

    String errorGetUser();

    String userDeleted();

    String editUserDialog();

    String select();

    String errorSearchGroup();

    String userExist();

    String userMaintainerTitle();

    String userData();

    String middleName();

    String male();

    String female();

    String inputDataUser();

    String password();

    String userType();

    String systemUser();

    String client();

    String profile();

    String businessUnit();

    String rut();

    String email();

    String resolverGroup();

    String gender();

    String cancel();

    String groupMustHaveaName();

    String unitParentError();

    String unitAsociateParentError();

    String unitGroupExist();

    String unitGroupAddOk();

    String unitGroupEditOK();

    String userAddOk();

    String userAddNOK();

    String userEditOK();

    String userEditNOK();

    String assign();

    String taskNotAssigned();

    String taskAssigned();

    String hasNoTask();

    String errorNameUserAdd();

    String errorLastNameUserAdd();

    String errorMailUserAdd();

    String errorLoginUserAdd();

    String errorPasswordUserAdd();

    String profileCreateOK();

    String profileEditOK();

    String workGroupCreateOK();

    String workGroupEditOK();

    String businessUnitCreateOK();

    String businessUnitEditOK();

    String processID();

    String startDate();

    String endDate();

    String timeExecuted();

    String instances();

    String hour();

    String processes();

    String processHistory();

    String instancesPerProcess();

    String executionLog();

    String titleSMTPServer();

    String elapsedTime();

    String schedulerOk();

    String schedulerNOK();

    String emailConfigurationOk();

    String businessUnitEdition();

    String valid();

    String notValid();

    String businessUnitMutBeAName();

    String businessUnitMustBeACode();

    String businessUnitAlreadyExist();

    String groupMustBeAName();

    String groupAlreadyExists();

    String groupEditTitle();

    String lastModification();

    String superiorLevel();

    String all();

    String businessUnitGroup();

    String code();

    String level1();

    String level2();

    String admBusinessGroup();

    String parentLevel();

    String errorDeleteGroup();

    String errorSearchGroups();

    String admUnitBusinessGroup();

    String admResolverGroups();

    String description();

    String emailServer();

    String configEmailServer();

    String senderEmail();

    String serverEmailPort();

    String recipientsConfiguration();

    String endSuiteTestCaseEvent();

    String user();

    String search();

    String profileHaveName();

    String selectAbilities();

    String errorDeleteProfile();

    String errorGetAbilities();

    String admProfiles();

    String systemProfiles();

    String loginTitle();

    String administration();

    String caseInsert();

    String businessProcessManagement();

    String reportsMonitoring();

    String reports();

    String processMonitoring();

    String home();

    String schedulerProcess();

    String newCase();

    String insertCase();

    String myTasks();

    String taskMonitoring();

    String notAssignedTask();

    String resolverGroups();

    String businessGroups();

    String businessUnitGroups();

    String users();

    String profiles();

    String processAndTask();
    
    String errorSecondNameUserAdd();
    
    String errorPasswordSameUser();
}