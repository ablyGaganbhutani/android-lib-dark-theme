# android-lib-dark-theme

How to use:-

# for gradle:-

Step 1-> Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
Step 2-> Add it in your app level build.gradle file

	dependencies {
	        implementation 'com.github.ablyGaganbhutani:android-lib-dark-theme:1.0.0'
	}

# for maven:-

Step 1:-
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

Step 2: Add the below dependency:-
	<dependency>
	    <groupId>com.github.ablyGaganbhutani</groupId>
	    <artifactId>android-lib-dark-theme</artifactId>
	    <version>1.0.0</version>
	</dependency>
