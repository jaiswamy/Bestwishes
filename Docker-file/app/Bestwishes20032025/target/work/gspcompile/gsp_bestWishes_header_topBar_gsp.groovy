import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bestWishes_header_topBar_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/header/_topBar.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('getProfilePic','images',5,[:],-1)
printHtmlPart(1)
invokeTag('username','sec',6,[:],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
expressionOut.print(createLink(controller: 'logout'))
printHtmlPart(4)
})
invokeTag('ifLoggedIn','sec',21,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',25,['controller':("login"),'action':("auth")],2)
printHtmlPart(8)
})
invokeTag('ifNotLoggedIn','sec',26,[:],1)
printHtmlPart(9)
createClosureForHtmlPart(10, 1)
invokeTag('ifAnyGranted','sec',49,['roles':("ROLE_USER")],1)
printHtmlPart(11)
createClosureForHtmlPart(12, 1)
invokeTag('ifAnyGranted','sec',54,['roles':("ROLE_SUPERADMIN")],1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
expressionOut.print(createLink(controller:'superadmin', action:'viewPimg', id:userimageIstance?.id))
printHtmlPart(15)
})
invokeTag('ifAnyGranted','sec',60,['roles':("ROLE_ADMIN")],1)
printHtmlPart(16)
invokeTag('username','sec',61,[:],-1)
printHtmlPart(17)
createTagBody(1, {->
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
invokeTag('submitButton','g',70,['name':("Log Out"),'class':("btn btn-warning")],-1)
printHtmlPart(20)
})
invokeTag('form','g',72,['controller':("logout")],2)
printHtmlPart(21)
})
invokeTag('ifLoggedIn','sec',73,[:],1)
printHtmlPart(22)
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
