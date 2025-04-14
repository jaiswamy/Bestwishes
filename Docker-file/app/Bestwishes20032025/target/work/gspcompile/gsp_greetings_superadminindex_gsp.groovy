import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_greetings_superadminindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/superadmin/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'charset':("utf-8")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':("width=device-width, initial-scale=1"),'name':("viewport")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':("Animate Research"),'name':("description")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':(""),'name':("author")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',53,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('render','g',60,['template':("/header/logo")],-1)
printHtmlPart(6)
invokeTag('render','g',65,['template':("/header/topBar")],-1)
printHtmlPart(7)
invokeTag('render','g',81,['template':("/header/leftSide"),'model':([activ:[adminssion:'start active open']])],-1)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
createClosureForHtmlPart(13, 3)
invokeTag('formRemote','g',134,['name':("kk"),'url':([action:'createadmin']),'update':("update1"),'class':("horizontal-form")],3)
printHtmlPart(14)
loop:{
int i = 0
for( usersInstance in (usersInstanceList?.reverse()) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
expressionOut.print(i+1)
printHtmlPart(17)
expressionOut.print(fieldValue(bean: usersInstance, field: "username"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: usersInstance, field: "password"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: usersInstance, field: "email"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: usersInstance, field: "phoneNo"))
printHtmlPart(18)
expressionOut.print(usersInstance?.address?.hsno)
printHtmlPart(20)
expressionOut.print(usersInstance?.address?.street)
printHtmlPart(21)
expressionOut.print(usersInstance?.address?.city)
printHtmlPart(22)
expressionOut.print(usersInstance?.address?.pinCode)
printHtmlPart(23)
expressionOut.print(usersInstance?.address?.state)
printHtmlPart(20)
expressionOut.print(usersInstance?.address?.country)
printHtmlPart(24)
expressionOut.print(createLink(controller:'superadmin', action:'viewimg', id:usersInstance?.id))
printHtmlPart(25)
createTagBody(4, {->
printHtmlPart(26)
invokeTag('hiddenField','g',211,['name':("userListid"),'value':(usersInstance?.id)],-1)
printHtmlPart(27)
invokeTag('submitButton','g',214,['name':("Edit"),'class':("btn btn-primary")],-1)
printHtmlPart(28)
})
invokeTag('formRemote','g',216,['name':("kk"),'url':([action:'adminEdit']),'update':("update1")],4)
printHtmlPart(29)
i++
}
}
printHtmlPart(30)
})
invokeTag('ifAnyGranted','sec',226,['roles':("ROLE_SUPERADMIN")],2)
printHtmlPart(31)
invokeTag('render','g',249,['template':("/header/footer")],-1)
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',311,['class':("page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid")],1)
printHtmlPart(33)
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
