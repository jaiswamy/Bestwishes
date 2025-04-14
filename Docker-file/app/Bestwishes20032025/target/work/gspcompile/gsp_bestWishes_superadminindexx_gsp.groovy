import com.hiideals.io.Usercreation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bestWishes_superadminindexx_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/superadmin/indexx.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':("/"),'charset':("utf-8")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':("width=device-width, initial-scale=1"),'name':("viewport")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':("Preview page of Metronic Admin Theme #4 for statistics, charts, recent events and reports"),'name':("description")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',15,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':(""),'name':("author")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',38,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('render','g',47,['template':("/header/logo")],-1)
printHtmlPart(7)
invokeTag('render','g',60,['template':("/header/topBar")],-1)
printHtmlPart(8)
invokeTag('render','g',90,['template':("/header/leftSide"),'model':([activ:[adminssion:'start active open']])],-1)
printHtmlPart(9)
invokeTag('set','g',127,['var':("inwords"),'value':(Inwardform?.findAll())],-1)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(inwords?.size())
printHtmlPart(12)
})
invokeTag('ifAnyGranted','sec',130,['roles':("ROLE_ADMIN,ROLE_VCADMIN")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(ulist)
printHtmlPart(12)
})
invokeTag('ifAnyGranted','sec',133,['roles':("ROLE_USER")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(resultssize)
printHtmlPart(12)
})
invokeTag('ifAnyGranted','sec',136,['roles':("ROLE_DUSER")],2)
printHtmlPart(14)
invokeTag('set','g',154,['var':("outwords"),'value':(Inwardform?.findAll())],-1)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(inwords?.size())
printHtmlPart(12)
})
invokeTag('ifAnyGranted','sec',157,['roles':("ROLE_ADMIN,ROLE_VCADMIN")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(ulist)
printHtmlPart(12)
})
invokeTag('ifAnyGranted','sec',160,['roles':("ROLE_USER")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(resultssize)
printHtmlPart(12)
})
invokeTag('ifAnyGranted','sec',163,['roles':("ROLE_DUSER")],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('set','g',180,['var':("sactions"),'value':(Usercreation?.findAll())],-1)
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(11)
expressionOut.print(sactions?.size())
printHtmlPart(12)
})
invokeTag('ifAnyGranted','sec',184,['roles':("ROLE_ADMIN,ROLE_VCADMIN")],3)
printHtmlPart(19)
})
invokeTag('ifAnyGranted','sec',195,['roles':("ROLE_ADMIN,ROLE_VCADMIN")],2)
printHtmlPart(20)
invokeTag('render','g',206,['template':("/header/footer")],-1)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',294,['class':("page-container-bg-solid page-header-fixed page-sidebar-closed-hide-logo")],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1742888581485L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
