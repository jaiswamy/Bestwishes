import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_greeting_header_leftSide_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/header/_leftSide.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createClosureForHtmlPart(2, 2)
invokeTag('link','g',17,['controller':("superadmin"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(3)
createClosureForHtmlPart(4, 2)
invokeTag('link','g',21,['controller':("superadmin"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(5)
})
invokeTag('ifAnyGranted','sec',22,['roles':("ROLE_SUPERADMIN")],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createClosureForHtmlPart(8, 2)
invokeTag('link','g',34,['controller':("membercreation"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(3)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',38,['controller':("membercreation"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',50,['controller':("imageUpload"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',57,['controller':("birthdayList"),'action':("index"),'class':("nav-link")],2)
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',64,['controller':("anniversaryList"),'action':("index"),'class':("nav-link")],2)
printHtmlPart(16)
createClosureForHtmlPart(17, 2)
invokeTag('link','g',71,['controller':("monthlyCollection"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(18)
createClosureForHtmlPart(19, 2)
invokeTag('link','g',77,['controller':("monthlyCollection"),'action':("index"),'class':("nav-link")],2)
printHtmlPart(20)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',92,['controller':("report"),'action':("pending"),'class':("nav-link ")],2)
printHtmlPart(22)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',104,['controller':("report"),'action':("closed"),'class':("nav-link ")],2)
printHtmlPart(23)
})
invokeTag('ifAnyGranted','sec',105,['roles':("ROLE_ADMIN")],1)
printHtmlPart(24)
createTagBody(1, {->
printHtmlPart(25)
createClosureForHtmlPart(26, 2)
invokeTag('link','g',123,['controller':("usercreate"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(27)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',127,['controller':("usercreate"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(28)
createClosureForHtmlPart(29, 2)
invokeTag('link','g',140,['controller':("viewerUsercreate"),'action':("viewerIndex"),'class':("nav-link ")],2)
printHtmlPart(3)
createClosureForHtmlPart(30, 2)
invokeTag('link','g',144,['controller':("viewerUsercreate"),'action':("viewerIndex"),'class':("nav-link ")],2)
printHtmlPart(31)
createClosureForHtmlPart(32, 2)
invokeTag('link','g',155,['controller':("inwardform"),'action':("create"),'class':("nav-link ")],2)
printHtmlPart(3)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',159,['controller':("inwardform"),'action':("index"),'class':("nav-link ")],2)
printHtmlPart(33)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',170,['controller':("report"),'action':("approved"),'class':("nav-link ")],2)
printHtmlPart(34)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',182,['controller':("report"),'action':("pending"),'class':("nav-link ")],2)
printHtmlPart(35)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',194,['controller':("report"),'action':("closed"),'class':("nav-link ")],2)
printHtmlPart(36)
})
invokeTag('ifAnyGranted','sec',195,['roles':("ROLE_VCADMIN")],1)
printHtmlPart(37)
createTagBody(1, {->
printHtmlPart(38)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',211,['controller':("inwardform"),'action':("userlist"),'class':("nav-link ")],2)
printHtmlPart(39)
})
invokeTag('ifAnyGranted','sec',212,['roles':("ROLE_USER")],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(40)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',229,['controller':("inwardform"),'action':("viewerList"),'class':("nav-link ")],2)
printHtmlPart(41)
})
invokeTag('ifAnyGranted','sec',230,['roles':("ROLE_DUSER")],1)
printHtmlPart(42)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1744025699462L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
