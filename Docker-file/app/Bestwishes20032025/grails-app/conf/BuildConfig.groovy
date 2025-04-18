grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.8
grails.project.source.level = 1.8
grails.server.port.http = 8080
// grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
	// Configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
	// compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

	// Configure settings for the test-app JVM, uses the daemon by default
	test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
	// Configure settings for the run-app JVM
	run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
	// Configure settings for the run-war JVM
	war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
	// Configure settings for the Console UI JVM
	console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
	// Inherit Grails' default dependencies
	inherits("global") {
		// Specify dependency exclusions here; for example, uncomment this to disable ehcache:
		// excludes 'ehcache'
	}
	log "error" // Log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
	checksums true // Whether to verify checksums on resolve
	legacyResolve false // Whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

	repositories {
		inherits true // Whether to inherit repository definitions from plugins

		grailsPlugins()
		grailsHome()
		mavenLocal()
		
		grailsCentral()
		mavenCentral()
		// Uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
		// mavenRepo "http://repository.codehaus.org"
		// mavenRepo "http://download.java.net/maven/2/"
		// mavenRepo "http://repository.jboss.com/maven2/"
	}

	dependencies {
		// Specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
		runtime 'mysql:mysql-connector-java:5.1.29'
		// runtime 'org.postgresql:postgresql:9.3-1101-jdbc41'
		test "org.grails:grails-datastore-test-support:1.0.2-grails-2.4"
        compile 'com.itextpdf:itextpdf:5.5.13.3'		
          compile 'com.lowagie:itext:2.1.7' 		// implementation 'org.apache.pdfbox:pdfbox:2.0.27' // Removed duplicate and outdated

		compile 'net.sf.ehcache:ehcache:2.10.7' // Retained the higher version
		compile 'org.hibernate:hibernate-ehcache:4.3.11.Final'
		compile 'com.fasterxml.jackson.core:jackson-databind:2.9.10'
		// Removed explicit Spring dependencies to avoid conflicts
		// compile 'org.springframework:spring-webmvc:4.1.9.RELEASE'
		// compile 'org.springframework:spring-core:4.1.9.RELEASE'
		// compile 'org.springframework:spring-beans:4.1.9.RELEASE'
		
		// Removed duplicate ehcache dependency
		// compile 'net.sf.ehcache:ehcache:2.10.6'

		// Add other dependencies as needed
	}

	plugins {
		// Plugins for the build system only
		build ":tomcat:7.0.55.2" // or ":tomcat:8.0.20"

		// Plugins for the compile step
		compile ":scaffolding:2.1.2"
		compile ':cache:1.1.8'
		compile ":asset-pipeline:2.1.5"
	  compile ':spring-security-core:2.0-RC5' // Updated to match the installed version
		compile ':quartz:1.0.1'
		compile ":mail:1.0.7"

		// Plugins needed at runtime but not for compilation
		runtime ":hibernate4:4.3.8.1" // or ":hibernate:3.6.10.18"
		runtime ":database-migration:1.4.0"
		runtime ":jquery:1.11.1"

		// Uncomment these to enable additional asset-pipeline capabilities
		// compile ":sass-asset-pipeline:1.9.0"
		// compile ":less-asset-pipeline:1.10.0"
		// compile ":coffee-asset-pipeline:1.8.0"
		// compile ":handlebars-asset-pipeline:1.3.0.3"
	}
}
