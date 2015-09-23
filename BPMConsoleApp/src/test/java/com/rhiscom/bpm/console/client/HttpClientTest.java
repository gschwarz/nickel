package com.rhiscom.bpm.console.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ibm.icu.util.Calendar;

public class HttpClientTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testConection() {
	HttpClient client = new DefaultHttpClient();
	HttpPost post = new HttpPost("http://127.0.0.1:8888/BPMConsoleApp/httpEventListener");
	try {

	    List<NameValuePair> nameValuePairsSTC = new ArrayList<NameValuePair>(1);
	    nameValuePairsSTC.add(new BasicNameValuePair("eventType", "STC_ATN_INIT"));
	    nameValuePairsSTC.add(new BasicNameValuePair("atnId", "128.1.175.100"));
	    nameValuePairsSTC.add(new BasicNameValuePair("code", "id=234"));
	    nameValuePairsSTC.add(new BasicNameValuePair("name", "Suite Test Case 1"));
	    nameValuePairsSTC.add(new BasicNameValuePair("statusDate", String.valueOf(Calendar.getInstance()
		    .getTime().getTime())));
	    post.setEntity(new UrlEncodedFormEntity(nameValuePairsSTC));

	    HttpResponse response = client.execute(post);
	    client = new DefaultHttpClient();
	    post = new HttpPost("http://127.0.0.1:8888/BPMConsoleApp/httpEventListener");
	    try {
		Thread.sleep(2000);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }

	    for (int i = 0; i <= 6; i++) {
		client = new DefaultHttpClient();
		post = new HttpPost("http://127.0.0.1:8888/BPMConsoleApp/httpEventListener");

		List<NameValuePair> nameValuePairsTC = new ArrayList<NameValuePair>(1);
		nameValuePairsTC.add(new BasicNameValuePair("eventType", "TC_ATN_INIT"));
		nameValuePairsTC.add(new BasicNameValuePair("atnId", "128.1.175.100"));
		nameValuePairsTC.add(new BasicNameValuePair("name", "TestCase N" + i));
		nameValuePairsTC.add(new BasicNameValuePair("code", "id=" + i + ";stc=234;status=Running"));
		nameValuePairsTC.add(new BasicNameValuePair("statusDate", String.valueOf(Calendar.getInstance()
			.getTime().getTime())));
		post.setEntity(new UrlEncodedFormEntity(nameValuePairsTC));
		HttpResponse response2 = client.execute(post);
		try {
		    Thread.sleep(3000);
		} catch (InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}

		client = new DefaultHttpClient();
		post = new HttpPost("http://127.0.0.1:8888/BPMConsoleApp/httpEventListener");

		nameValuePairsTC = new ArrayList<NameValuePair>(1);
		nameValuePairsTC.add(new BasicNameValuePair("eventType", "TC_ATN_END"));
		nameValuePairsTC.add(new BasicNameValuePair("atnId", "128.1.175.100"));
		nameValuePairsTC.add(new BasicNameValuePair("name", "TestCase N" + i));
		nameValuePairsTC.add(new BasicNameValuePair("code", "id=" + i + ";stc=234;status=OK"));
		nameValuePairsTC.add(new BasicNameValuePair("statusDate", String.valueOf(Calendar.getInstance()
			.getTime().getTime())));
		post.setEntity(new UrlEncodedFormEntity(nameValuePairsTC));

		HttpResponse response3 = client.execute(post);

	    }

	    try {
		Thread.sleep(3000);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }

	    for (int i = 6; i <= 8; i++) {
		client = new DefaultHttpClient();
		post = new HttpPost("http://127.0.0.1:8888/BPMConsoleApp/httpEventListener");

		List<NameValuePair> nameValuePairsTC = new ArrayList<NameValuePair>(1);
		nameValuePairsTC.add(new BasicNameValuePair("eventType", "TC_ATN_INIT"));
		nameValuePairsTC.add(new BasicNameValuePair("atnId", "128.1.175.100"));
		nameValuePairsTC.add(new BasicNameValuePair("name", "TestCase N" + i));
		nameValuePairsTC.add(new BasicNameValuePair("code", "id=" + i + ";stc=234;status=Running"));
		nameValuePairsTC.add(new BasicNameValuePair("statusDate", String.valueOf(Calendar.getInstance()
			.getTime().getTime())));
		post.setEntity(new UrlEncodedFormEntity(nameValuePairsTC));
		HttpResponse response2 = client.execute(post);
		try {
		    Thread.sleep(3000);
		} catch (InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}

		client = new DefaultHttpClient();
		post = new HttpPost("http://127.0.0.1:8888/BPMConsoleApp/httpEventListener");

		nameValuePairsTC = new ArrayList<NameValuePair>(1);
		nameValuePairsTC.add(new BasicNameValuePair("eventType", "TC_ATN_END"));
		nameValuePairsTC.add(new BasicNameValuePair("atnId", "128.1.175.100"));
		nameValuePairsTC.add(new BasicNameValuePair("name", "TestCase N" + i));
		nameValuePairsTC.add(new BasicNameValuePair("code", "id=" + i + ";stc=234;status=NOK"));
		nameValuePairsTC.add(new BasicNameValuePair("statusDate", String.valueOf(Calendar.getInstance()
			.getTime().getTime())));
		post.setEntity(new UrlEncodedFormEntity(nameValuePairsTC));

		HttpResponse response3 = client.execute(post);

	    }
	    try {
		Thread.sleep(3000);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }

	    for (int i = 8; i <= 9; i++) {
		client = new DefaultHttpClient();
		post = new HttpPost("http://127.0.0.1:8888/BPMConsoleApp/httpEventListener");

		List<NameValuePair> nameValuePairsTC = new ArrayList<NameValuePair>(1);
		nameValuePairsTC.add(new BasicNameValuePair("eventType", "TC_ATN_INIT"));
		nameValuePairsTC.add(new BasicNameValuePair("atnId", "128.1.175.100"));
		nameValuePairsTC.add(new BasicNameValuePair("name", "TestCase N" + i));
		nameValuePairsTC.add(new BasicNameValuePair("code", "id=" + i + ";stc=234;status=Running"));
		nameValuePairsTC.add(new BasicNameValuePair("statusDate", String.valueOf(Calendar.getInstance()
			.getTime().getTime())));
		post.setEntity(new UrlEncodedFormEntity(nameValuePairsTC));
		HttpResponse response2 = client.execute(post);
		try {
		    Thread.sleep(3000);
		} catch (InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}

		client = new DefaultHttpClient();
		post = new HttpPost("http://127.0.0.1:8888/BPMConsoleApp/httpEventListener");

		nameValuePairsTC = new ArrayList<NameValuePair>(1);
		nameValuePairsTC.add(new BasicNameValuePair("eventType", "TC_ATN_END"));
		nameValuePairsTC.add(new BasicNameValuePair("atnId", "128.1.175.100"));
		nameValuePairsTC.add(new BasicNameValuePair("name", "TestCase N" + i));
		nameValuePairsTC.add(new BasicNameValuePair("code", "id=" + i + ";stc=234;status=BLOCK"));
		nameValuePairsTC.add(new BasicNameValuePair("statusDate", String.valueOf(Calendar.getInstance()
			.getTime().getTime())));
		post.setEntity(new UrlEncodedFormEntity(nameValuePairsTC));

		HttpResponse response3 = client.execute(post);

	    }

	    try {
		Thread.sleep(2000);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    client = new DefaultHttpClient();
	    post = new HttpPost("http://127.0.0.1:8888/BPMConsoleApp/httpEventListener");

	    nameValuePairsSTC = new ArrayList<NameValuePair>(1);
	    nameValuePairsSTC.add(new BasicNameValuePair("eventType", "STC_ATN_END"));
	    nameValuePairsSTC.add(new BasicNameValuePair("atnId", "128.1.175.100"));
	    nameValuePairsSTC.add(new BasicNameValuePair("code", "id=234"));
	    nameValuePairsSTC.add(new BasicNameValuePair("name", "Suite Test Case 1"));
	    nameValuePairsSTC.add(new BasicNameValuePair("statusDate", String.valueOf(Calendar.getInstance()
		    .getTime().getTime())));
	    post.setEntity(new UrlEncodedFormEntity(nameValuePairsSTC));

	    HttpResponse response4 = client.execute(post);
	    client = new DefaultHttpClient();
	    post = new HttpPost("http://127.0.0.1:8888/BPMConsoleApp/httpEventListener");

	    /*
	     * for (int i = 0; i <= 7; i++) { List<NameValuePair>
	     * nameValuePairsTC = new ArrayList<NameValuePair>(1);
	     * nameValuePairsTC.add(new BasicNameValuePair("eventType",
	     * "TC_ATN_END")); nameValuePairsTC.add(new
	     * BasicNameValuePair("atnId", "128.1.175.100"));
	     * nameValuePairsTC.add(new BasicNameValuePair("code", "id=" + i +
	     * ";stc=234;status=OK")); nameValuePairsTC.add(new
	     * BasicNameValuePair("statusDate",
	     * String.valueOf(Calendar.getInstance() .getTime().getTime())));
	     * post.setEntity(new UrlEncodedFormEntity(nameValuePairsTC)); try {
	     * Thread.sleep(1000); } catch (InterruptedException e) { // TODO
	     * Auto-generated catch block e.printStackTrace(); } HttpResponse
	     * response2 = client.execute(post); client = new
	     * DefaultHttpClient(); post = new
	     * HttpPost("http://127.0.0.1:8888/BPMConsoleApp/httpEventListener"
	     * ); }
	     */

	    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	    String line = "";
	    while ((line = rd.readLine()) != null) {
		System.out.println(line);
	    }

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
