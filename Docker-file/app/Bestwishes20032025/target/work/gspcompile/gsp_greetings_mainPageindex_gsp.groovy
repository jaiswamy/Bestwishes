import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_greetings_mainPageindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mainPage/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',18,['gsp_sm_xmlClosingForEmptyTag':("/"),'charset':("utf-8")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',19,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',19,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',100,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('username','sec',115,[:],-1)
printHtmlPart(6)
invokeTag('render','g',115,['template':("/shared/staticheader")],-1)
printHtmlPart(7)
if(true && (flash.email)) {
printHtmlPart(8)
expressionOut.print(flash.email)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (flash.emailverify)) {
printHtmlPart(11)
expressionOut.print(flash.emailverify)
printHtmlPart(9)
}
printHtmlPart(12)
expressionOut.print(userInstance?.password)
printHtmlPart(13)
expressionOut.print(userInstance?.confirmpassword)
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',211,['controller':("login"),'action':("auth"),'style':("color:white")],2)
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',407,['class':("c-layout-header-fixed c-layout-header-mobile-fixed")],1)
printHtmlPart(17)
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
