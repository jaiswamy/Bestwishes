import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_greetings_header_leftSide_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/header/_leftSide.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('link','g',14,['controller':("superadmin"),'action':("indexx"),'class':("nav-link nav-toggle")],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createClosureForHtmlPart(4, 2)
invokeTag('link','g',24,['controller':("superadmin"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',28,['controller':("superadmin"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(7)
})
invokeTag('ifAnyGranted','sec',30,['roles':("ROLE_SUPERADMIN")],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',41,['controller':("membercreation"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(5)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',45,['controller':("membercreation"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',58,['controller':("imageUpload"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',65,['controller':("birthdayList"),'action':("index"),'class':("nav-link")],2)
printHtmlPart(16)
createClosureForHtmlPart(17, 2)
invokeTag('link','g',69,['controller':("anniversaryList"),'action':("index"),'class':("nav-link")],2)
printHtmlPart(18)
createClosureForHtmlPart(19, 2)
invokeTag('link','g',79,['controller':("monthlyCollection"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(20)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',87,['controller':("monthlyCollection"),'action':("index"),'class':("nav-link")],2)
printHtmlPart(22)
createClosureForHtmlPart(23, 2)
invokeTag('link','g',100,['controller':("report"),'action':("pending"),'class':("nav-link ")],2)
printHtmlPart(24)
createClosureForHtmlPart(23, 2)
invokeTag('link','g',112,['controller':("report"),'action':("closed"),'class':("nav-link ")],2)
printHtmlPart(25)
})
invokeTag('ifAnyGranted','sec',118,['roles':("ROLE_ADMIN")],1)
printHtmlPart(26)
createTagBody(1, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 2)
invokeTag('link','g',130,['controller':("usercreate"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(29)
createClosureForHtmlPart(23, 2)
invokeTag('link','g',135,['controller':("usercreate"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(30)
createClosureForHtmlPart(31, 2)
invokeTag('link','g',147,['controller':("viewerUsercreate"),'action':("viewerIndex"),'class':("nav-link ")],2)
printHtmlPart(5)
createClosureForHtmlPart(32, 2)
invokeTag('link','g',151,['controller':("viewerUsercreate"),'action':("viewerIndex"),'class':("nav-link ")],2)
printHtmlPart(33)
createClosureForHtmlPart(34, 2)
invokeTag('link','g',162,['controller':("inwardform"),'action':("create"),'class':("nav-link ")],2)
printHtmlPart(5)
createClosureForHtmlPart(23, 2)
invokeTag('link','g',166,['controller':("inwardform"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(35)
createClosureForHtmlPart(23, 2)
invokeTag('link','g',178,['controller':("report"),'action':("approved"),'class':("nav-link ")],2)
printHtmlPart(36)
createClosureForHtmlPart(23, 2)
invokeTag('link','g',190,['controller':("report"),'action':("pending"),'class':("nav-link ")],2)
printHtmlPart(37)
createClosureForHtmlPart(23, 2)
invokeTag('link','g',202,['controller':("report"),'action':("closed"),'class':("nav-link ")],2)
printHtmlPart(38)
})
invokeTag('ifAnyGranted','sec',206,['roles':("ROLE_VCADMIN")],1)
printHtmlPart(39)
createTagBody(1, {->
printHtmlPart(40)
createClosureForHtmlPart(23, 2)
invokeTag('link','g',218,['controller':("inwardform"),'action':("userlist"),'class':("nav-link ")],2)
printHtmlPart(41)
})
invokeTag('ifAnyGranted','sec',222,['roles':("ROLE_USER")],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(42)
createClosureForHtmlPart(23, 2)
invokeTag('link','g',237,['controller':("inwardform"),'action':("viewerList"),'class':("nav-link ")],2)
printHtmlPart(43)
})
invokeTag('ifAnyGranted','sec',240,['roles':("ROLE_DUSER")],1)
printHtmlPart(44)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1742276168541L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
