package snippet;

public class Snippet {
	#Root logger option
	log=C:/logs
	log4j.rootLogger=ALL, stdout, file
	
	# Direct the log messages to the console
	log4j.appender.stdout=org.apache.log4j.ConsoleAppender
	log4j.appender.stdout.Target=System.out
	log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
	log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
	
	# Direct Log messages to file
	log4j.appender.file=org.apache.log4j.RollingFileAppender
	log4j.appender.file.File=${log}/exampleLog.log
	log4j.appender.file.MaxFileSize=10MB
	log4j.appender.file.MaxBackupIndex=10
	log4j.appender.file.layout=org.apache.log4j.PatternLayout
	log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
}

