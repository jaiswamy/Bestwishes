import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_greetings_imageUploadindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/imageUpload/index.gsp" }
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
invokeTag('captureHead','sitemesh',53,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('render','g',63,['template':("/header/logo")],-1)
printHtmlPart(6)
invokeTag('render','g',79,['template':("/header/topBar")],-1)
printHtmlPart(7)
invokeTag('render','g',98,['template':("/header/leftSide"),'model':([activ:[adminssion:'start active open']])],-1)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('formRemote','g',136,['name':("kk"),'url':([action:'imageUploadFORM']),'update':("update1"),'class':("horizontal-form")],2)
printHtmlPart(13)
if(true && (imageList?.size() > 0)) {
printHtmlPart(14)
loop:{
int i = 0
for( image in (imageList) ) {
printHtmlPart(15)
expressionOut.print(i + 1)
printHtmlPart(16)
if(true && (image?.dobImage)) {
printHtmlPart(17)
expressionOut.print(createLink(controller: 'imageUpload', action: 'viewimg', id: image.id, params: [type: 'dob']))
printHtmlPart(18)
}
else {
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (image?.doaImage)) {
printHtmlPart(17)
expressionOut.print(createLink(controller: 'imageUpload', action: 'viewimg', id: image.id, params: [type: 'doa']))
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(20)
createClosureForHtmlPart(23, 4)
invokeTag('link','g',186,['action':("delete"),'id':(image.id),'class':("btn btn-danger"),'onclick':("return confirm('Are you sure you want to delete this image?');")],4)
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
invokeTag('render','g',214,['template':("/header/footer")],-1)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',218,['class':("page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid")],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1738739672000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
