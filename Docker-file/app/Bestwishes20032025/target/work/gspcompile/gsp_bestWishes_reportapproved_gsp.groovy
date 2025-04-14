import com.hiideals.inwordform.Inwardform
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bestWishes_reportapproved_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/report/approved.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':("/"),'charset':("utf-8")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':("width=device-width, initial-scale=1"),'name':("viewport")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':("Animate Research"),'name':("description")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',15,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':(""),'name':("author")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',150,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('render','g',161,['template':("/header/logo")],-1)
printHtmlPart(6)
invokeTag('render','g',177,['template':("/header/topBar")],-1)
printHtmlPart(7)
invokeTag('render','g',196,['template':("/header/leftSide"),'model':([activ:[adminssion:'start active open']])],-1)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',214,['controller':("superadmin"),'action':("indexx")],2)
printHtmlPart(10)
loop:{
int i = 0
for( inwardformInstance in (inwardformInstancess) ) {
printHtmlPart(11)
expressionOut.print(i+1)
printHtmlPart(12)
expressionOut.print(inwardformInstance.sino)
printHtmlPart(12)
expressionOut.print(inwardformInstance.inwardnumber)
printHtmlPart(13)
invokeTag('formatDate','g',273,['date':(inwardformInstance.wardDate),'format':("dd-MM-yyyy")],-1)
printHtmlPart(14)
expressionOut.print(inwardformInstance.inwarsNumber)
printHtmlPart(15)
expressionOut.print(inwardformInstance.outDate)
printHtmlPart(16)
expressionOut.print(inwardformInstance.details)
printHtmlPart(12)
expressionOut.print(inwardformInstance.sectionId?.username)
printHtmlPart(17)
expressionOut.print(i)
printHtmlPart(18)
expressionOut.print(i)
printHtmlPart(19)
expressionOut.print(inwardformInstance.status)
printHtmlPart(20)
expressionOut.print(i)
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(22)
expressionOut.print(i)
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',334,['action':("edit"),'resource':(inwardformInstance),'class':("btn btn-outline btn-circle btn-sm purple")],3)
printHtmlPart(25)
expressionOut.print(i)
printHtmlPart(26)
if(true && (inwardformInstance?.uploade1?.id != null)) {
printHtmlPart(27)
expressionOut.print(createLink(controller:'inwardform', action:'viewimg', id:inwardformInstance?.uploade1?.id))
printHtmlPart(28)
expressionOut.print(createLink(controller:'inwardform', action:'viewimg', id:inwardformInstance?.uploade1?.id))
printHtmlPart(29)
}
printHtmlPart(30)
if(true && (inwardformInstance?.uploade2?.id != null)) {
printHtmlPart(27)
expressionOut.print(createLink(controller:'inwardform', action:'viewimg', id:inwardformInstance?.uploade2?.id))
printHtmlPart(28)
expressionOut.print(createLink(controller:'inwardform', action:'viewimg', id:inwardformInstance?.uploade2?.id))
printHtmlPart(31)
}
printHtmlPart(30)
if(true && (inwardformInstance?.uploade3?.id != null)) {
printHtmlPart(27)
expressionOut.print(createLink(controller:'inwardform', action:'viewimg', id:inwardformInstance?.uploade3?.id))
printHtmlPart(28)
expressionOut.print(createLink(controller:'inwardform', action:'viewimg', id:inwardformInstance?.uploade3?.id))
printHtmlPart(31)
}
printHtmlPart(30)
if(true && (inwardformInstance?.uploade4?.id != null)) {
printHtmlPart(27)
expressionOut.print(createLink(controller:'inwardform', action:'viewimg', id:inwardformInstance?.uploade4?.id))
printHtmlPart(28)
expressionOut.print(createLink(controller:'inwardform', action:'viewimg', id:inwardformInstance?.uploade4?.id))
printHtmlPart(31)
}
printHtmlPart(30)
if(true && (inwardformInstance?.uploade5?.id != null)) {
printHtmlPart(27)
expressionOut.print(createLink(controller:'inwardform', action:'viewimg', id:inwardformInstance?.uploade5?.id))
printHtmlPart(28)
expressionOut.print(createLink(controller:'inwardform', action:'viewimg', id:inwardformInstance?.uploade5?.id))
printHtmlPart(31)
}
printHtmlPart(32)
expressionOut.print(i)
printHtmlPart(33)
createTagBody(3, {->
printHtmlPart(34)
expressionOut.print(createLink(controller:'superadmin', action:'viewPimg', id:userimageIstance?.id))
printHtmlPart(35)
})
invokeTag('ifAnyGranted','sec',424,['roles':("ROLE_ADMIN")],3)
printHtmlPart(36)
loop:{
int l = 0
for( loc in (inwardformInstance?.inwardremarkes) ) {
printHtmlPart(37)
expressionOut.print(loc?.remarks)
printHtmlPart(38)
expressionOut.print(loc?.date)
printHtmlPart(39)
expressionOut.print(loc?.vcRemarks)
printHtmlPart(38)
expressionOut.print(loc?.vcDate)
printHtmlPart(40)
l++
}
}
printHtmlPart(41)
expressionOut.print(i)
printHtmlPart(42)
createClosureForHtmlPart(43, 3)
invokeTag('ifAnyGranted','sec',455,['roles':("ROLE_USER")],3)
printHtmlPart(44)
loop:{
int l = 0
for( loc in (inwardformInstance?.outwardRemarks) ) {
printHtmlPart(45)
expressionOut.print(loc?.outwardRemarks)
printHtmlPart(46)
expressionOut.print(loc?.date)
printHtmlPart(47)
l++
}
}
printHtmlPart(48)
expressionOut.print(i)
printHtmlPart(49)
if(true && (inwardformInstance?.docs)) {
printHtmlPart(50)
loop:{
int y = 0
for( dc in (inwardformInstance?.docs) ) {
printHtmlPart(51)
expressionOut.print(createLink(controller:'inwardform', action:'downloadFile', id:dc?.id))
printHtmlPart(52)
expressionOut.print(dc?.docName)
printHtmlPart(53)
y++
}
}
printHtmlPart(30)
}
printHtmlPart(54)
expressionOut.print(i)
printHtmlPart(55)
if(true && (inwardformInstance?.outwarddoc)) {
printHtmlPart(50)
loop:{
int y = 0
for( dc in (inwardformInstance?.outwarddoc) ) {
printHtmlPart(51)
expressionOut.print(createLink(controller:'inwardform', action:'downloadFile', id:dc?.id))
printHtmlPart(52)
expressionOut.print(dc?.docName)
printHtmlPart(53)
y++
}
}
printHtmlPart(30)
}
printHtmlPart(56)
i++
}
}
printHtmlPart(57)
invokeTag('render','g',529,['template':("/header/footer")],-1)
printHtmlPart(58)
})
invokeTag('captureBody','sitemesh',603,['class':("page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid")],1)
printHtmlPart(59)
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
