package com.rhiscom.bpm.console.shared;


public class ApplicationContext {

    private static Authentication auth;

    public static Authentication getAuth() {
	return auth;
    }

    public static void setAuth(Authentication auth) {
	ApplicationContext.auth = auth;
    }

}
