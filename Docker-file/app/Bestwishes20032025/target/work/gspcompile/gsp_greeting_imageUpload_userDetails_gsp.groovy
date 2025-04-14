import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_greeting_imageUpload_userDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/imageUpload/_userDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
expressionOut.print(userdet)
printHtmlPart(0)
invokeTag('textField','g',7,['name':("membershipNo"),'value':(membercreation?.membershipNo),'readonly':("true")],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: userdet, field: 'username', 'error'))
printHtmlPart(2)
invokeTag('message','g',13,['code':("user.username.label"),'default':("Username")],-1)
printHtmlPart(3)
if(true && (params?.action !="adminEdit")) {
printHtmlPart(4)
invokeTag('textField','g',18,['name':("username"),'class':("form-control spinner input-circle"),'value':(userdet?.username),'required':("true")],-1)
printHtmlPart(5)
}
else {
printHtmlPart(6)
expressionOut.print(userdet?.username)
printHtmlPart(7)
}
printHtmlPart(8)
expressionOut.print(hasErrors(bean: userdet, field: 'password', 'error'))
printHtmlPart(9)
invokeTag('message','g',31,['code':("user.password.label"),'default':("Password")],-1)
printHtmlPart(3)
if(true && (params?.action !="adminEdit")) {
printHtmlPart(4)
invokeTag('textField','g',36,['name':("password"),'class':("form-control spinner input-circle"),'value':(userdet?.password),'required':("true")],-1)
printHtmlPart(5)
}
else {
printHtmlPart(10)
expressionOut.print(userdet?.password)
printHtmlPart(7)
}
printHtmlPart(11)
expressionOut.print(hasErrors(bean: userdet, field: 'fullName', 'error'))
printHtmlPart(12)
invokeTag('message','g',48,['code':("user.fullName.label"),'default':("fullName")],-1)
printHtmlPart(3)
if(true && (params?.action !="adminEdit")) {
printHtmlPart(4)
invokeTag('textField','g',53,['name':("fullName"),'class':("form-control spinner input-circle"),'value':(userdet?.fullName),'required':("true")],-1)
printHtmlPart(5)
}
else {
printHtmlPart(13)
expressionOut.print(userdet?.fullName)
printHtmlPart(7)
}
printHtmlPart(14)
expressionOut.print(hasErrors(bean: userdet, field: 'phoneNo', 'error'))
printHtmlPart(15)
invokeTag('message','g',67,['code':("user.phoneNo.label"),'default':("Phone No")],-1)
printHtmlPart(3)
invokeTag('textField','g',73,['name':("phoneNo"),'class':("form-control spinner input-circle"),'value':(userdet?.phoneNo),'required':("true")],-1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: userdet, field: 'totalshareAmount', 'error'))
printHtmlPart(17)
invokeTag('textField','g',81,['name':("totalshareAmount"),'class':("form-control spinner input-circle"),'value':(userdet?.totalshareAmount)],-1)
printHtmlPart(18)
invokeTag('textField','g',89,['name':("monthlyshareAmount"),'value':(userdet?.monthlyshareAmount),'class':("form-control spinner input-circle")],-1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1735799542000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
