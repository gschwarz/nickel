package com.google.gwt.query.client.plugins.ajax;

import com.google.gwt.query.client.js.*;
import com.google.gwt.query.client.*;
import com.google.gwt.core.client.*;
import com.google.gwt.dom.client.*;

public class Ajax_Settings_JsonBuilder extends com.google.gwt.query.client.builders.JsonBuilderBase<com.google.gwt.query.client.plugins.ajax.Ajax_Settings_JsonBuilder> implements com.google.gwt.query.client.plugins.ajax.Ajax.Settings {
  public final java.lang.String getContentType() {
    return p.getStr("contenttype");
  }
  public final com.google.gwt.dom.client.Element getContext() {
    return p.getJavaScriptObject("context");
  }
  public final com.google.gwt.query.client.Properties getData() {
    return getPropertiesBase("data");
  }
  public final java.lang.String getDataString() {
    return p.getStr("datastring");
  }
  public final java.lang.String getDataType() {
    return p.getStr("datatype");
  }
  public final com.google.gwt.query.client.Function getError() {
    return null; // Unsupported return type: com.google.gwt.query.client.Function
  }
  public final com.google.gwt.query.client.Properties getHeaders() {
    return getPropertiesBase("headers");
  }
  public final java.lang.String getPassword() {
    return p.getStr("password");
  }
  public final com.google.gwt.query.client.Function getSuccess() {
    return null; // Unsupported return type: com.google.gwt.query.client.Function
  }
  public final int getTimeout() {
    return (int)p.getFloat("timeout");
  }
  public final java.lang.String getType() {
    return p.getStr("type");
  }
  public final java.lang.String getUrl() {
    return p.getStr("url");
  }
  public final java.lang.String getUsername() {
    return p.getStr("username");
  }
  public final com.google.gwt.query.client.plugins.ajax.Ajax.Settings setContentType(java.lang.String a){
    p.set("contenttype", a);
    return this;
  }
  public final com.google.gwt.query.client.plugins.ajax.Ajax.Settings setContext(com.google.gwt.dom.client.Element a){
    p.set("context", a);
    return this;
  }
  public final com.google.gwt.query.client.plugins.ajax.Ajax.Settings setData(com.google.gwt.query.client.Properties a){
    p.set("data", a);
    return this;
  }
  public final com.google.gwt.query.client.plugins.ajax.Ajax.Settings setDataString(java.lang.String a){
    p.set("datastring", a);
    return this;
  }
  public final com.google.gwt.query.client.plugins.ajax.Ajax.Settings setDataType(java.lang.String a){
    p.set("datatype", a);
    return this;
  }
  public final com.google.gwt.query.client.plugins.ajax.Ajax.Settings setError(com.google.gwt.query.client.Function a){
    p.set("error", a);
    return this;
  }
  public final com.google.gwt.query.client.plugins.ajax.Ajax.Settings setHeaders(com.google.gwt.query.client.Properties a){
    p.set("headers", a);
    return this;
  }
  public final com.google.gwt.query.client.plugins.ajax.Ajax.Settings setPassword(java.lang.String a){
    p.set("password", a);
    return this;
  }
  public final com.google.gwt.query.client.plugins.ajax.Ajax.Settings setSuccess(com.google.gwt.query.client.Function a){
    p.set("success", a);
    return this;
  }
  public final com.google.gwt.query.client.plugins.ajax.Ajax.Settings setTimeout(int a){
    p.set("timeout", a);
    return this;
  }
  public final com.google.gwt.query.client.plugins.ajax.Ajax.Settings setType(java.lang.String a){
    p.set("type", a);
    return this;
  }
  public final com.google.gwt.query.client.plugins.ajax.Ajax.Settings setUrl(java.lang.String a){
    p.set("url", a);
    return this;
  }
  public final com.google.gwt.query.client.plugins.ajax.Ajax.Settings setUsername(java.lang.String a){
    p.set("username", a);
    return this;
  }
}
