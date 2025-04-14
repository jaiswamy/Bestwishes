import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bestWishes_anniversaryList_anniversariesTable_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/anniversaryList/_anniversariesTable.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
if(true && (!anniversaryMembers?.isEmpty())) {
printHtmlPart(0)
loop:{
int i = 0
for( member in (anniversaryMembers) ) {
printHtmlPart(1)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(2)
expressionOut.print(i + 1)
printHtmlPart(3)
expressionOut.print(fieldValue(bean: member, field: "membershipNo"))
printHtmlPart(3)
expressionOut.print(fieldValue(bean: member, field: "contactName"))
printHtmlPart(4)
invokeTag('formatDate','g',19,['format':("dd-MM-yyyy"),'date':(member.dateOfAnniversary)],-1)
printHtmlPart(5)
if(true && (member.anniversarypdfLink)) {
printHtmlPart(6)
expressionOut.print(member.anniversarypdfLink)
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(9)
i++
}
}
printHtmlPart(10)
}
else {
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(createLink(controller:'membercreation', action:'downloadCertificate2'))
printHtmlPart(13)
expressionOut.print(username)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1742459358106L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
