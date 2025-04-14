import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_greeting_anniversaryListindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/anniversaryList/index.gsp" }
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
invokeTag('captureHead','sitemesh',74,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('render','g',84,['template':("/header/logo")],-1)
printHtmlPart(6)
invokeTag('render','g',100,['template':("/header/topBar")],-1)
printHtmlPart(7)
invokeTag('render','g',119,['template':("/header/leftSide"),'model':([activ:[adminssion:'start active open']])],-1)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (!anniversaryMembers?.isEmpty())) {
printHtmlPart(12)
loop:{
int i = 0
for( member in (anniversaryMembers) ) {
printHtmlPart(13)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(14)
expressionOut.print(i + 1)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: member, field: "membershipNo"))
printHtmlPart(15)
expressionOut.print(fieldValue(bean: member, field: "contactName"))
printHtmlPart(16)
invokeTag('formatDate','g',197,['format':("dd-MM-yyyy"),'date':(member.dateOfAnniversary)],-1)
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
}
else {
printHtmlPart(19)
}
printHtmlPart(20)
invokeTag('render','g',237,['template':("/header/footer")],-1)
printHtmlPart(21)
expressionOut.print(createLink(controller: 'anniversaryList', action: 'fetchTodayAnniversaries'))
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',321,['class':("page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid")],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1742968543416L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
