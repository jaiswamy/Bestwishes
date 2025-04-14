import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_greetings_birthdayListindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/birthdayList/index.gsp" }
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
invokeTag('captureHead','sitemesh',72,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('render','g',82,['template':("/header/logo")],-1)
printHtmlPart(6)
invokeTag('render','g',98,['template':("/header/topBar")],-1)
printHtmlPart(7)
invokeTag('render','g',117,['template':("/header/leftSide"),'model':([activ:[adminssion:'start active open']])],-1)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (!birthdayMembers?.isEmpty())) {
printHtmlPart(12)
loop:{
int i = 0
for( member in (birthdayMembers) ) {
printHtmlPart(13)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(14)
expressionOut.print(i + 1)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: member, field: "membershipNo"))
printHtmlPart(15)
expressionOut.print(fieldValue(bean: member, field: "contactName"))
printHtmlPart(16)
invokeTag('formatDate','g',197,['format':("dd-MM-yyyy"),'date':(member.dateOfBirth)],-1)
printHtmlPart(17)
if(true && (member.birthdaypdfLink)) {
printHtmlPart(18)
expressionOut.print(member.birthdaypdfLink)
printHtmlPart(19)
}
else {
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (member.pdfData)) {
printHtmlPart(18)
expressionOut.print(createLink(controller: 'birthdayList', action: 'downloadPdf', id: member.id))
printHtmlPart(22)
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
}
else {
printHtmlPart(26)
}
printHtmlPart(27)
invokeTag('render','g',244,['template':("/header/footer")],-1)
printHtmlPart(28)
expressionOut.print(resource(dir: 'assets1/global/plugins/jquery.min.js'))
printHtmlPart(29)
expressionOut.print(resource(dir: 'assets1/global/plugins/bootstrap/js/bootstrap.min.js'))
printHtmlPart(29)
expressionOut.print(resource(dir: 'assets1/global/plugins/js.cookie.min.js'))
printHtmlPart(29)
expressionOut.print(resource(dir: 'assets1/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js'))
printHtmlPart(29)
expressionOut.print(resource(dir: 'assets1/global/plugins/jquery.blockui.min.js'))
printHtmlPart(29)
expressionOut.print(resource(dir: 'assets1/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js'))
printHtmlPart(30)
expressionOut.print(resource(dir: 'assets1/global/scripts/datatable.js'))
printHtmlPart(29)
expressionOut.print(resource(dir: 'assets1/global/plugins/datatables/datatables.min.js'))
printHtmlPart(29)
expressionOut.print(resource(dir: 'assets1/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js'))
printHtmlPart(31)
expressionOut.print(resource(dir: 'assets1/global/scripts/app.min.js'))
printHtmlPart(32)
expressionOut.print(resource(dir: 'assets1/pages/scripts/table-datatables-managed.min.js'))
printHtmlPart(33)
expressionOut.print(resource(dir: 'assets1/layouts/layout4/scripts/layout.min.js'))
printHtmlPart(29)
expressionOut.print(resource(dir: 'assets1/layouts/layout4/scripts/demo.min.js'))
printHtmlPart(29)
expressionOut.print(resource(dir: 'assets1/layouts/global/scripts/quick-sidebar.min.js'))
printHtmlPart(29)
expressionOut.print(resource(dir: 'assets1/layouts/global/scripts/quick-nav.min.js'))
printHtmlPart(34)
expressionOut.print(createLink(controller: 'birthdayList', action: 'fetchTodayBirthdays'))
printHtmlPart(35)
expressionOut.print(createLink(controller:'membercreation', action:'downloadCertificate'))
printHtmlPart(36)
expressionOut.print(username)
printHtmlPart(37)
})
invokeTag('captureBody','sitemesh',319,['class':("page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid")],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1742886842708L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
