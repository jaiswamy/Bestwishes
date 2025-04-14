import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_greeting_viewerUsercreate_viewUserFORM_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/viewerUsercreate/_viewUserFORM.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(hasErrors(bean: viewerInstance, field: 'username', 'error'))
printHtmlPart(2)
invokeTag('message','g',16,['code':("user.username.label"),'default':("Username")],-1)
printHtmlPart(3)
if(true && (params?.action !="adminEdit")) {
printHtmlPart(4)
invokeTag('textField','g',21,['name':("username"),'class':("form-control spinner input-circle"),'value':(viewerInstance?.username),'required':("true")],-1)
printHtmlPart(5)
}
else {
printHtmlPart(6)
expressionOut.print(viewerInstance?.username)
printHtmlPart(7)
}
printHtmlPart(8)
expressionOut.print(hasErrors(bean: viewerInstance, field: 'password', 'error'))
printHtmlPart(9)
invokeTag('message','g',34,['code':("user.password.label"),'default':("Password")],-1)
printHtmlPart(3)
if(true && (params?.action !="adminEdit")) {
printHtmlPart(4)
invokeTag('textField','g',39,['name':("password"),'class':("form-control spinner input-circle"),'value':(viewerInstance?.password),'required':("true")],-1)
printHtmlPart(5)
}
else {
printHtmlPart(10)
expressionOut.print(viewerInstance?.password)
printHtmlPart(7)
}
printHtmlPart(11)
expressionOut.print(hasErrors(bean: viewerInstance, field: 'phoneNo', 'error'))
printHtmlPart(12)
invokeTag('message','g',53,['code':("user.phoneNo.label"),'default':("Phone No")],-1)
printHtmlPart(3)
invokeTag('textField','g',58,['name':("phoneNo"),'class':("form-control spinner input-circle"),'value':(viewerInstance?.phoneNo),'required':("true")],-1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: viewerInstance, field: 'pinCode', 'error'))
printHtmlPart(14)
invokeTag('textField','g',67,['name':("pinCode"),'class':("form-control spinner input-circle"),'value':(viewerInstance?.address?.pinCode)],-1)
printHtmlPart(15)
invokeTag('textField','g',74,['name':("hsno"),'value':(viewerInstance?.address?.hsno),'class':("form-control spinner input-circle")],-1)
printHtmlPart(16)
invokeTag('textField','g',83,['name':("street"),'value':(viewerInstance?.address?.street),'class':("form-control spinner input-circle")],-1)
printHtmlPart(17)
invokeTag('textField','g',87,['name':("city"),'value':(viewerInstance?.address?.city),'class':("form-control spinner input-circle")],-1)
printHtmlPart(18)
invokeTag('textField','g',92,['name':("state"),'value':(viewerInstance?.address?.state),'class':("form-control spinner input-circle")],-1)
printHtmlPart(19)
if(true && (params?.action !="userEdit")) {
printHtmlPart(20)
invokeTag('textField','g',100,['name':("country"),'class':("form-control spinner input-circle")],-1)
printHtmlPart(21)
invokeTag('actionSubmit','g',110,['action':("saveUser"),'class':("btn btn-primary"),'value':("Save Details")],-1)
printHtmlPart(22)
}
else {
printHtmlPart(23)
invokeTag('hiddenField','g',113,['name':("userListid"),'value':(viewerInstance?.id)],-1)
printHtmlPart(24)
invokeTag('actionSubmit','g',114,['action':("updateUser"),'class':("btn btn-primary"),'value':("Update Details")],-1)
printHtmlPart(22)
}
printHtmlPart(25)
})
invokeTag('form','g',116,['controller':("viewerUsercreate"),'enctype':("multipart/form-data"),'name':("validateip"),'class':("horizontal-form")],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1733304962000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
