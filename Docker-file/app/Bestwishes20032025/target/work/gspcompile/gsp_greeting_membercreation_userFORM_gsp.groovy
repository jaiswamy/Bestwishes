import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_greeting_membercreation_userFORM_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/membercreation/_userFORM.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('message','g',55,['code':("user.contactName.label"),'default':("Contact Name")],-1)
printHtmlPart(2)
if(true && (params?.action != 'adminEdit')) {
printHtmlPart(3)
invokeTag('textField','g',59,['name':("contactName"),'class':("form-control spinner input-circle styled-input"),'value':(usersInstance?.contactName),'required':("true")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(5)
expressionOut.print(usersInstance?.contactName)
printHtmlPart(6)
}
printHtmlPart(7)
invokeTag('message','g',69,['code':("user.username.label"),'default':("Username")],-1)
printHtmlPart(8)
if(true && (params?.action != 'adminEdit')) {
printHtmlPart(3)
invokeTag('textField','g',72,['name':("username"),'class':("form-control spinner input-circle styled-input"),'value':(usersInstance?.username),'required':("true")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(9)
expressionOut.print(usersInstance?.username)
printHtmlPart(6)
}
printHtmlPart(10)
invokeTag('message','g',82,['code':("user.password.label"),'default':("Password")],-1)
printHtmlPart(8)
if(true && (params?.action != 'adminEdit')) {
printHtmlPart(3)
invokeTag('passwordField','g',85,['name':("password"),'class':("form-control spinner input-circle styled-input"),'value':(usersInstance?.password),'required':("true")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(11)
expressionOut.print(usersInstance?.password)
printHtmlPart(6)
}
printHtmlPart(12)
invokeTag('message','g',95,['code':("user.contactNo.label"),'default':("Contact No.")],-1)
printHtmlPart(13)
expressionOut.print(usersInstance?.contactNo)
printHtmlPart(14)
invokeTag('message','g',104,['code':("user.dateOfBirth.label"),'default':("Date of Birth")],-1)
printHtmlPart(2)
if(true && (params?.action != 'adminEdit')) {
printHtmlPart(3)
invokeTag('datePicker','g',108,['name':("dateOfBirth"),'class':("form-control styled-input"),'value':(usersInstance?.dateOfBirth),'precision':("day"),'required':("true")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(15)
expressionOut.print(usersInstance?.dateOfBirth)
printHtmlPart(6)
}
printHtmlPart(16)
expressionOut.print(usersInstance?.maritalStatus == 'Married' ? 'selected' : '')
printHtmlPart(17)
expressionOut.print(usersInstance?.maritalStatus == 'unmarried' ? 'selected' : '')
printHtmlPart(18)
invokeTag('message','g',129,['code':("user.dateOfAnniversary.label"),'default':("Date of Anniversary")],-1)
printHtmlPart(2)
if(true && (params?.action != 'adminEdit')) {
printHtmlPart(3)
invokeTag('datePicker','g',133,['name':("dateOfAnniversary"),'class':("form-control styled-input"),'value':(usersInstance?.dateOfAnniversary),'precision':("day"),'required':("true")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(19)
expressionOut.print(formatDate(format:'dd/MM/yyyy', date:usersInstance?.dateOfAnniversary))
printHtmlPart(6)
}
printHtmlPart(20)
invokeTag('message','g',144,['code':("user.address.label"),'default':("Address")],-1)
printHtmlPart(8)
invokeTag('textField','g',146,['name':("address"),'class':("form-control spinner input-circle styled-input"),'value':(usersInstance?.address ?: ''),'required':("true")],-1)
printHtmlPart(21)
if(true && (params?.action != 'userEdit')) {
printHtmlPart(3)
invokeTag('actionSubmit','g',164,['action':("saveUser"),'class':("btn btn-primary btn-md px-5 rounded-pill shadow-sm"),'value':("Save Details")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('hiddenField','g',167,['name':("userListid"),'value':(usersInstance?.id)],-1)
printHtmlPart(3)
invokeTag('actionSubmit','g',168,['action':("updateUser"),'class':("btn btn-success btn-lg px-5 rounded-pill shadow"),'value':("Update Details")],-1)
printHtmlPart(4)
}
printHtmlPart(22)
})
invokeTag('form','g',172,['controller':("membercreation"),'enctype':("multipart/form-data"),'name':("validateip"),'class':("horizontal-form")],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1743766159408L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
