============================================================================
Lombok is not generating getter and setter
============================================================================
1. When starting with a fresh eclipse installation you, in fact, need to "install" Lombok before being able to use it.
2. Go where you Lombok jar is (e.g. (e.g. you can find in ~/.m2/repository/org/projectlombok/lombok/1.16.10/lombok-1.16.10.jar), run it (Example: java -jar lombok-1.16.10.jar). A window should appear, browse to your eclipse.exe location.
3. Click on install.
4. Restart Eclipse

=============================================================================
Could not find an appender named [FILE-ROLLING]
=============================================================================
check <appender> name as FILE-ROLLING in logback.xml
Ref: https://howtodoinjava.com/logback/logback-console-appender/

=============================================================================
user PKRSTUDIES lacks CREATE SESSION privilege; logon denied
=============================================================================
GRANT CREATE SESSION TO <user_name>;

=============================================================================
org.hibernate.AnnotationException: No identifier specified for entity 
=============================================================================

I had the following
	import org.springframework.data.annotation.Id;
Naturally, it should be:
	import javax.persistence.Id;
	
=============================================================================	
ORA-01950: no privileges on tablespace 'USERS'
=============================================================================
ALTER USER PKRSTUDIES quota unlimited on USERS;