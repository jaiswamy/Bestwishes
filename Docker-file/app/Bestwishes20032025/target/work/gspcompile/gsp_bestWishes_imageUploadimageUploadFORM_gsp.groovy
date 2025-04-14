import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bestWishes_imageUploadimageUploadFORM_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/imageUpload/imageUploadFORM.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('actionSubmit','g',17,['id':("submitButton"),'action':("save"),'class':("btn btn-primary"),'value':("Submit")],-1)
printHtmlPart(2)
})
invokeTag('form','g',21,['controller':("imageUpload"),'action':("save"),'method':("post"),'enctype':("multipart/form-data"),'class':("horizontal-form")],1)
printHtmlPart(3)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1738739614000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
