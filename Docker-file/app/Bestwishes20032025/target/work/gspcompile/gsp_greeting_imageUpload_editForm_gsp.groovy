import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_greeting_imageUpload_editForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/imageUpload/_editForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('hiddenField','g',9,['name':("id"),'value':(shortTermLoanInstance?.id)],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("loanSanctionYear"),'class':("form-control"),'placeholder':("Enter Loan Sanction Year"),'value':(shortTermLoanInstance?.loanSanctionYear),'required':("true")],-1)
printHtmlPart(3)
invokeTag('textField','g',31,['name':("loanAmount"),'class':("form-control"),'placeholder':("Enter Loan Amount"),'value':(shortTermLoanInstance?.loanAmount),'required':("true")],-1)
printHtmlPart(4)
invokeTag('textField','g',43,['name':("durationInMonths"),'class':("form-control"),'placeholder':("Enter Duration in Months"),'value':(shortTermLoanInstance?.durationInMonths),'required':("true")],-1)
printHtmlPart(5)
invokeTag('textField','g',55,['name':("rateOfInterest"),'class':("form-control"),'placeholder':("Enter Rate of Interest"),'value':(shortTermLoanInstance?.rateOfInterest),'required':("true")],-1)
printHtmlPart(6)
for( month in (['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']) ) {
printHtmlPart(7)
expressionOut.print(month)
printHtmlPart(8)
expressionOut.print(shortTermLoanInstance?.selectedMonth == month ? 'selected' : '')
printHtmlPart(9)
expressionOut.print(month)
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('submitButton','g',79,['name':("update"),'class':("btn btn-primary btn-lg"),'value':("Update")],-1)
printHtmlPart(12)
})
invokeTag('form','g',82,['name':("editLoanForm"),'action':("update"),'id':(shortTermLoanInstance.id),'method':("POST"),'class':("form-horizontal")],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1736750350000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
