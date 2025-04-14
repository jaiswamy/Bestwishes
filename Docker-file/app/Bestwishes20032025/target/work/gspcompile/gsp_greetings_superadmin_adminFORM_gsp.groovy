import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_greetings_superadmin_adminFORM_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/superadmin/_adminFORM.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(hasErrors(bean: usersInstance, field: 'username', 'error'))
printHtmlPart(2)
invokeTag('message','g',13,['code':("user.username.label"),'default':("Username")],-1)
printHtmlPart(3)
if(true && (params?.action !="adminEdit")) {
printHtmlPart(4)
invokeTag('textField','g',18,['name':("username"),'class':("form-control spinner input-circle"),'value':(usersInstance?.username),'required':("true")],-1)
printHtmlPart(5)
}
else {
printHtmlPart(6)
expressionOut.print(usersInstance?.username)
printHtmlPart(7)
}
printHtmlPart(8)
expressionOut.print(hasErrors(bean: usersInstance, field: 'password', 'error'))
printHtmlPart(9)
invokeTag('message','g',31,['code':("user.password.label"),'default':("Password")],-1)
printHtmlPart(3)
if(true && (params?.action !="adminEdit")) {
printHtmlPart(4)
invokeTag('textField','g',36,['name':("password"),'class':("form-control spinner input-circle"),'value':(usersInstance?.password),'required':("true")],-1)
printHtmlPart(5)
}
else {
printHtmlPart(10)
expressionOut.print(usersInstance?.password)
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(hasErrors(bean: usersInstance, field: 'email', 'error'))
printHtmlPart(13)
invokeTag('message','g',48,['code':("user.email.label"),'default':("Email Id")],-1)
printHtmlPart(14)
invokeTag('textField','g',51,['name':("email"),'class':("form-control"),'value':(usersInstance?.email ? usersInstance?.email : email)],-1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: usersInstance, field: 'phoneNo', 'error'))
printHtmlPart(16)
invokeTag('message','g',59,['code':("user.phoneNo.label"),'default':("Phone No")],-1)
printHtmlPart(3)
invokeTag('textField','g',63,['name':("phoneNo"),'class':("form-control spinner input-circle"),'value':(usersInstance?.phoneNo),'required':("true")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: usersInstance, field: 'pinCode', 'error'))
printHtmlPart(18)
invokeTag('textField','g',72,['name':("pinCode"),'class':("form-control spinner input-circle"),'value':(usersInstance?.address?.pinCode)],-1)
printHtmlPart(19)
invokeTag('textField','g',83,['name':("hsno"),'value':(usersInstance?.address?.hsno),'class':("form-control spinner input-circle")],-1)
printHtmlPart(20)
invokeTag('textField','g',88,['name':("street"),'value':(usersInstance?.address?.street),'class':("form-control spinner input-circle")],-1)
printHtmlPart(21)
invokeTag('textField','g',93,['name':("city"),'value':(usersInstance?.address?.city),'class':("form-control spinner input-circle")],-1)
printHtmlPart(22)
invokeTag('textField','g',98,['name':("state"),'value':(usersInstance?.address?.state),'class':("form-control spinner input-circle")],-1)
printHtmlPart(23)
if(true && (params?.action !="adminEdit")) {
printHtmlPart(24)
invokeTag('textField','g',109,['name':("country"),'class':("form-control spinner input-circle")],-1)
printHtmlPart(25)
invokeTag('actionSubmit','g',118,['action':("SaveAdmin"),'class':("btn btn-primary"),'value':("Save Details")],-1)
printHtmlPart(26)
}
else {
printHtmlPart(27)
invokeTag('hiddenField','g',125,['name':("userListid"),'value':(usersInstance?.id)],-1)
printHtmlPart(28)
invokeTag('actionSubmit','g',127,['action':("updateAdmin"),'class':("btn btn-primary"),'value':("Update Details")],-1)
printHtmlPart(26)
}
printHtmlPart(29)
})
invokeTag('form','g',131,['controller':("superadmin"),'enctype':("multipart/form-data"),'name':("validateip"),'class':("horizontal-form")],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1741088485100L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
