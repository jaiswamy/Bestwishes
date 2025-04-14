import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bestWishes_membercreation_userFORM_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/membercreation/_userFORM.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(hasErrors(bean: usersInstance, field: 'contactName', 'error'))
printHtmlPart(2)
invokeTag('message','g',22,['code':("user.contactName.label"),'default':("Contact Name")],-1)
printHtmlPart(3)
if(true && (params?.action != 'adminEdit')) {
printHtmlPart(4)
invokeTag('textField','g',26,['name':("contactName"),'class':("form-control spinner input-circle styled-input"),'value':(usersInstance?.contactName),'required':("true"),'style':("background-color: #f9f9f9; border-width: 2px;")],-1)
printHtmlPart(5)
}
else {
printHtmlPart(6)
expressionOut.print(usersInstance?.contactName)
printHtmlPart(7)
}
printHtmlPart(8)
expressionOut.print(hasErrors(bean: usersInstance, field: 'username', 'error'))
printHtmlPart(9)
invokeTag('message','g',40,['code':("user.username.label"),'default':("Username")],-1)
printHtmlPart(10)
if(true && (params?.action !="adminEdit")) {
printHtmlPart(11)
invokeTag('textField','g',45,['name':("username"),'class':("form-control spinner input-circle styled-input"),'value':(usersInstance?.username),'required':("true"),'style':("background-color: #f9f9f9; border-width: 2px;")],-1)
printHtmlPart(12)
}
else {
printHtmlPart(13)
expressionOut.print(usersInstance?.username)
printHtmlPart(14)
}
printHtmlPart(15)
expressionOut.print(hasErrors(bean: usersInstance, field: 'password', 'error'))
printHtmlPart(16)
invokeTag('message','g',58,['code':("user.password.label"),'default':("Password")],-1)
printHtmlPart(10)
if(true && (params?.action !="adminEdit")) {
printHtmlPart(11)
invokeTag('textField','g',63,['name':("password"),'class':("form-control spinner input-circle styled-input"),'value':(usersInstance?.password),'required':("true"),'style':("background-color: #f9f9f9; border-width: 2px;")],-1)
printHtmlPart(12)
}
else {
printHtmlPart(17)
expressionOut.print(usersInstance?.password)
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(hasErrors(bean: usersInstance, field: 'contactNo', 'error'))
printHtmlPart(20)
invokeTag('message','g',75,['code':("user.contactNo.label"),'default':("Contact No.")],-1)
printHtmlPart(21)
expressionOut.print(usersInstance?.contactNo)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: usersInstance, field: 'dateOfBirth', 'error'))
printHtmlPart(23)
invokeTag('message','g',90,['code':("user.dateOfBirth.label"),'default':("Date of Birth")],-1)
printHtmlPart(24)
if(true && (params?.action != 'adminEdit')) {
printHtmlPart(25)
invokeTag('datePicker','g',93,['name':("dateOfBirth"),'class':("form-control rounded shadow-sm styled-input"),'value':(usersInstance?.dateOfBirth),'precision':("day"),'required':("true")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(26)
expressionOut.print(usersInstance?.dateOfBirth)
printHtmlPart(27)
}
printHtmlPart(28)
expressionOut.print(hasErrors(bean: usersInstance, field: 'dateOfAnniversary', 'error'))
printHtmlPart(29)
invokeTag('message','g',105,['code':("user.dateOfAnniversary.label"),'default':("Date of Anniversary")],-1)
printHtmlPart(24)
if(true && (params?.action != 'adminEdit')) {
printHtmlPart(25)
invokeTag('datePicker','g',108,['name':("dateOfAnniversary"),'class':("form-control rounded shadow-sm styled-input"),'value':(usersInstance?.dateOfAnniversary),'precision':("day"),'required':("true")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(30)
expressionOut.print(formatDate(format:'dd/MM/yyyy',date:usersInstance?.dateOfAnniversary))
printHtmlPart(27)
}
printHtmlPart(31)
expressionOut.print(hasErrors(bean: usersInstance, field: 'address', 'error'))
printHtmlPart(32)
invokeTag('message','g',119,['code':("user.address.label"),'default':("Address")],-1)
printHtmlPart(33)
invokeTag('textField','g',121,['name':("address"),'class':("form-control spinner input-circle styled-input"),'value':(usersInstance?.address ?: ''),'required':("true"),'style':("background-color: #f9f9f9; border-width: 2px;")],-1)
printHtmlPart(34)
if(true && (params?.action !="userEdit")) {
printHtmlPart(35)
invokeTag('actionSubmit','g',135,['action':("saveUser"),'class':("btn btn-primary btn-md px-5 rounded-pill shadow-sm "),'style':("margin-left: 20px;"),'value':("Save Details")],-1)
printHtmlPart(36)
}
else {
printHtmlPart(37)
invokeTag('hiddenField','g',144,['name':("userListid"),'value':(usersInstance?.id)],-1)
printHtmlPart(38)
invokeTag('actionSubmit','g',146,['action':("updateUser"),'class':("btn btn-success btn-lg px-5 rounded-pill shadow"),'value':("Update Details")],-1)
printHtmlPart(36)
}
printHtmlPart(39)
})
invokeTag('form','g',1,['controller':("membercreation"),'enctype':("multipart/form-data"),'name':("validateip"),'class':("horizontal-form")],1)
printHtmlPart(40)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1742453954418L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
